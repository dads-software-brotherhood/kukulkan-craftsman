(function() {
    'use strict';

    angular
        .module('kukulkancraftsmanApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
            .state('handsontable', {
            parent: 'entity',
            url: '/handsontable',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'kukulkancraftsmanApp.state.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/handsontable/handsontable.html',
                    controller: 'HandsontableController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        });
    }

})();
