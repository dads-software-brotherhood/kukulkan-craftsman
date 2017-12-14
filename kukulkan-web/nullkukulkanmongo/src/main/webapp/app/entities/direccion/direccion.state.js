(function() {
    'use strict';

    angular
        .module('kukulkanmongoApp')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('direccion', {
            parent: 'entity',
            url: '/direccions?page&sort&search',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'kukulkanmongoApp.direccion.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/direccion/direccions.html',
                    controller: 'DireccionController',
                    controllerAs: 'vm'
                }
            },
            params: {
                page: {
                    value: '1',
                    squash: true
                },
                sort: {
                    value: 'id,asc',
                    squash: true
                },
                search: null
            },
            resolve: {
                pagingParams: ['$stateParams', 'PaginationUtil', function ($stateParams, PaginationUtil) {
                    return {
                        page: PaginationUtil.parsePage($stateParams.page),
                        sort: $stateParams.sort,
                        predicate: PaginationUtil.parsePredicate($stateParams.sort),
                        ascending: PaginationUtil.parseAscending($stateParams.sort),
                        search: $stateParams.search
                    };
                }],
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('direccion');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('direccion-detail', {
            parent: 'direccion',
            url: '/direccions/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'kukulkanmongoApp.direccion.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/direccion/direccion-detail.html',
                    controller: 'DireccionDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('direccion');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'Direccion', function($stateParams, Direccion) {
                    return Direccion.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'direccion',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('direccion-detail.edit', {
            parent: 'direccion-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/direccion/direccion-dialog.html',
                    controller: 'DireccionDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['Direccion', function(Direccion) {
                            return Direccion.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('direccion.new', {
            parent: 'direccion',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/direccion/direccion-dialog.html',
                    controller: 'DireccionDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                            	id: null,
                                nombre: null, 
                                edad: null, 
                                numeroCredencial: null, 
                                sueldo: null, 
                                impuesto: null, 
                                impuestoDetalle: null, 
                                activo: null, 
                                fechaLocalDate: null, 
                                fechaZoneDateTime: null, 
                                imagen: null, 
                                imagenContentType: null, 
                                imagenAnyBlob: null, 
                                imagenAnyBlobContentType: null, 
                                imagenBlob: null, 
                                imagenBlobContentType: null, 
                                desc: null, 
                                instante: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('direccion', null, { reload: 'direccion' });
                }, function() {
                    $state.go('direccion');
                });
            }]
        })
        .state('direccion.edit', {
            parent: 'direccion',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/direccion/direccion-dialog.html',
                    controller: 'DireccionDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['Direccion', function(Direccion) {
                            return Direccion.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('direccion', null, { reload: 'direccion' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('direccion.delete', {
            parent: 'direccion',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/direccion/direccion-delete-dialog.html',
                    controller: 'DireccionDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['Direccion', function(Direccion) {
                            return Direccion.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('direccion', null, { reload: 'direccion' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();
