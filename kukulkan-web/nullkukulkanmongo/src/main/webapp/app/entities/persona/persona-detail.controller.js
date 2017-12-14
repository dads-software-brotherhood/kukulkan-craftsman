(function() {
    'use strict';

    angular
        .module('kukulkanmongoApp')
        .controller('PersonaDetailController', PersonaDetailController);

    PersonaDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'DataUtils', 'entity', 'Persona'];

    function PersonaDetailController($scope, $rootScope, $stateParams, previousState, DataUtils, entity, Persona) {
        var vm = this;

        vm.persona= entity;
        vm.previousState = previousState.name;
        vm.byteSize = DataUtils.byteSize;
        vm.openFile = DataUtils.openFile;

        var unsubscribe = $rootScope.$on('kukulkanmongoApp:personaUpdate', function(event, result) {
            vm.persona= result;
        });
        $scope.$on('$destroy', unsubscribe);
    }
})();
