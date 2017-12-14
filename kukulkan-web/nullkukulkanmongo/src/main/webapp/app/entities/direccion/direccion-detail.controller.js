(function() {
    'use strict';

    angular
        .module('kukulkanmongoApp')
        .controller('DireccionDetailController', DireccionDetailController);

    DireccionDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'DataUtils', 'entity', 'Direccion'];

    function DireccionDetailController($scope, $rootScope, $stateParams, previousState, DataUtils, entity, Direccion) {
        var vm = this;

        vm.direccion= entity;
        vm.previousState = previousState.name;
        vm.byteSize = DataUtils.byteSize;
        vm.openFile = DataUtils.openFile;

        var unsubscribe = $rootScope.$on('kukulkanmongoApp:direccionUpdate', function(event, result) {
            vm.direccion= result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
