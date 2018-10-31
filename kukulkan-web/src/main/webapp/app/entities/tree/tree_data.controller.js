(function () {
    'use strict';

    angular
        .module('kukulkancraftsmanApp')
        .controller('TreeController', TreeController);

    TreeController.$inject = ['$scope', '$timeout', 'LoginService', '$state', 'TreeService','$sce'];

    function TreeController($scope, $timeout, LoginService, $state, TreeService, $sce) {
        var vm = this;

        vm.tree = null;
        vm.treeData = [];
        vm.data = null
        vm.addBranch = addBranch;
        vm.my_tree_handler = my_tree_handler;

        onInit();
        function onInit() {
            TreeService.getTree().then(function(response) {
                vm.treeData = response;
            });
        }

        function my_tree_handler(branch) {
            var _ref;
            $scope.output = "Seleccionó: " + branch.name;
            if ((_ref = branch.data) != null ? _ref.description : void 0) {
                 return $scope.output += '(' + branch.data.description + ')';
             }
        };

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
    }
  })();
