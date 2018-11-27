(function() {
    'use strict';

    angular
        .module('kukulkancraftsmanApp')
        .controller('TreeDeleteController', TreeDeleteController);

    TreeDeleteController.$inject = ['$uibModalInstance','$stateParams','$state'];

    function TreeDeleteController ($uibModalInstance,$stateParams,$state) {
        var vm = this;

        vm.clear = clear;
        vm.confirmDelete = confirmDelete;
        vm.branch = $stateParams.branch;
        vm.parent = $stateParams.parent;

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function confirmDelete () {
            $state.go('tree', {'branch': vm.branch, 'parent': vm.parent});
            $uibModalInstance.close(true);
        }
    }
})();
