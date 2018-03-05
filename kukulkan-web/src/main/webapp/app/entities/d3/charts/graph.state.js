(function () {
    'use strict';

    angular
        .module('kukulkancraftsmanApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
            .state('viewGraph', {
                parent: 'entity',
                url: '/viewGraph/{type}',
                data: {
                    authorities: ['ROLE_USER'],
                    pageTitle: 'kukulkancraftsmanApp.state.home.title'
                },
                views: {
                    'content@': {
                        templateUrl: 'app/entities/d3/charts/graph.html',
                        controller: 'ViewGraphController',
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

