(function() {
    'use strict';

    angular
        .module('kukulkancraftsmanApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
            .state('tree', {
            parent: 'entity',
            url: '/tree',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'kukulkancraftsmanApp.state.home.title',
            },
            params: {branch: null},
            views: {
                'content@': {
                    templateUrl: 'app/entities/tree/tree-data.html',
                    controller: 'TreeController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('tree');
                    return $translate.refresh();
                }]
            }
            })
            .state('tree.delete', {
                url: '/delete',
                data: {
                    authorities: ['ROLE_ADMIN']
                },
                params: {'branch':null, 'parent':null},
                onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                    $uibModal.open({
                        templateUrl: 'app/entities/tree/tree-data-delete-dialog.html',
                        controller: 'TreeDeleteController',
                        controllerAs: 'vm',
                        size: 'sm'
                    })
                    .result.then(function() {
                        $state.go('tree', null, { reload: false });
                    }, function() {
                        $state.go('^');
                    });
                }]
            });
    }

})();
