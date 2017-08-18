(function() {
    'use strict';

    angular
        .module('${projectName}App')
        .config(stateConfig);

    stateConfig.$inject = ['$stateProvider'];

    function stateConfig($stateProvider) {
        $stateProvider
        .state('usuario', {
            parent: 'entity',
            url: '/usuario?page&sort&search',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'atlasApp.usuario.home.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/usuario/usuarios.html',
                    controller: 'UsuarioController',
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
                    $translatePartialLoader.addPart('usuario');
                    $translatePartialLoader.addPart('global');
                    return $translate.refresh();
                }]
            }
        })
        .state('usuario-detail', {
            parent: 'usuario',
            url: '/usuario/{id}',
            data: {
                authorities: ['ROLE_USER'],
                pageTitle: 'atlasApp.usuario.detail.title'
            },
            views: {
                'content@': {
                    templateUrl: 'app/entities/usuario/usuario-detail.html',
                    controller: 'UsuarioDetailController',
                    controllerAs: 'vm'
                }
            },
            resolve: {
                translatePartialLoader: ['$translate', '$translatePartialLoader', function ($translate, $translatePartialLoader) {
                    $translatePartialLoader.addPart('usuario');
                    return $translate.refresh();
                }],
                entity: ['$stateParams', 'Usuario', function($stateParams, Usuario) {
                    return Usuario.get({id : $stateParams.id}).$promise;
                }],
                previousState: ["$state", function ($state) {
                    var currentStateData = {
                        name: $state.current.name || 'usuario',
                        params: $state.params,
                        url: $state.href($state.current.name, $state.params)
                    };
                    return currentStateData;
                }]
            }
        })
        .state('usuario-detail.edit', {
            parent: 'usuario-detail',
            url: '/detail/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/usuario/usuario-dialog.html',
                    controller: 'UsuarioDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['Usuario', function(Usuario) {
                            return Usuario.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('^', {}, { reload: false });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('usuario.new', {
            parent: 'usuario',
            url: '/new',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/usuario/usuario-dialog.html',
                    controller: 'UsuarioDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: function () {
                            return {
                                cadena: null,
                                entero: null,
                                tLong: null,
                                tBigDecimal: null,
                                tFloat: null,
                                tDouble: null,
                                tActivo: null,
                                tLocalDate: null,
                                tZonedDateTime: null,
                                tBlob: null,
                                tBlobContentType: null,
                                tAnyBlob: null,
                                tAnyBlobContentType: null,
                                tImageBlob: null,
                                tImageBlobContentType: null,
                                tTextBlob: null,
                                tInstant: null,
                                id: null
                            };
                        }
                    }
                }).result.then(function() {
                    $state.go('usuario', null, { reload: 'usuario' });
                }, function() {
                    $state.go('usuario');
                });
            }]
        })
        .state('usuario.edit', {
            parent: 'usuario',
            url: '/{id}/edit',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/usuario/usuario-dialog.html',
                    controller: 'UsuarioDialogController',
                    controllerAs: 'vm',
                    backdrop: 'static',
                    size: 'lg',
                    resolve: {
                        entity: ['Usuario', function(Usuario) {
                            return Usuario.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('usuario', null, { reload: 'usuario' });
                }, function() {
                    $state.go('^');
                });
            }]
        })
        .state('usuario.delete', {
            parent: 'usuario',
            url: '/{id}/delete',
            data: {
                authorities: ['ROLE_USER']
            },
            onEnter: ['$stateParams', '$state', '$uibModal', function($stateParams, $state, $uibModal) {
                $uibModal.open({
                    templateUrl: 'app/entities/usuario/usuario-delete-dialog.html',
                    controller: 'UsuarioDeleteController',
                    controllerAs: 'vm',
                    size: 'md',
                    resolve: {
                        entity: ['Usuario', function(Usuario) {
                            return Usuario.get({id : $stateParams.id}).$promise;
                        }]
                    }
                }).result.then(function() {
                    $state.go('usuario', null, { reload: 'usuario' });
                }, function() {
                    $state.go('^');
                });
            }]
        });
    }

})();