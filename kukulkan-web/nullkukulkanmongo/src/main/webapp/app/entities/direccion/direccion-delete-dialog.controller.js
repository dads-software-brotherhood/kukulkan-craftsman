(function() {
    'use strict';

    angular
        .module('kukulkanmongoApp')
        .controller('DireccionDeleteController',DireccionDeleteController);

    DireccionDeleteController.$inject = ['$uibModalInstance', 'entity', 'Direccion'];

    function DireccionDeleteController($uibModalInstance, entity, Direccion) {
        var vm = this;

        vm.direccion = entity;
        vm.clear = clear;
        vm.confirmDelete = confirmDelete;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete (id) {
            Direccion.delete({id: id},
                function () {
                    $uibModalInstance.close(true);
                });
        }
    }
})();
