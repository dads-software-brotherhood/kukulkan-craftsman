(function() {
    'use strict';

    angular
        .module('kukulkantestApp')
        .controller('UsuarioDetailController', UsuarioDetailController);

    UsuarioDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'DataUtils', 'entity', 'Usuario'];

    function UsuarioDetailController($scope, $rootScope, $stateParams, previousState, DataUtils, entity, Usuario) {
        var vm = this;

        vm.usuario= entity;
        vm.previousState = previousState.name;
        vm.byteSize = DataUtils.byteSize;
        vm.openFile = DataUtils.openFile;

        var unsubscribe = $rootScope.$on('kukulkantestApp:usuarioUpdate', function(event, result) {
            vm.usuario= result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
