(function () {
    'use strict';

    angular
        .module('kukulkancraftsmanApp')
        .controller('TreeController', TreeController);

    TreeController.$inject = ['$stateParams','TreeService'];

    function TreeController($stateParams,TreeService) {
        var vm = this;

        vm.tree = null;
        vm.treeData = [];
        vm.addBranch = addBranch;
        vm.deleteBranch = deleteBranch;
        vm.branch = $stateParams.branch;
        vm.parent = $stateParams.parent;

        onInit();

        function onInit() {
            TreeService.getTree().then(function(response) {
                vm.treeData = response;
                if(vm.branch){
                    vm.deleteBranch();
               }
            });
        }

        vm.myTree = vm.tree = {};

        function addBranch() {
           vm.b = null;
           vm.b = vm.tree.get_selected_branch();
           vm.path = (vm.b == null) ? '/' : vm.b.path;
           vm.txtBranch = vm.txtBranch ? vm.txtBranch : 'New Branch';
           vm.tree.add_branch(vm.b, {
             name: vm.txtBranch,
             path: vm.path,
             type: 'directory'
           });
           vm.txtBranch = null;
           console.log($scope.my_data);
         };

         function deleteBranch() {
            vm.tree.remove_branch(vm.branch, vm.parent);
            vm.branch = null;
          };
    }
  })();
