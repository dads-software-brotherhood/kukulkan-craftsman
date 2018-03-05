(function () {
    'use strict';

    angular
        .module('kukulkancraftsmanApp')
        .controller('GraphsController', GraphsController);

    GraphsController.$inject = ['$scope', 'Principal', 'LoginService', '$state', 'Graphs'];

    function GraphsController($scope, Principal, LoginService, $state, Graphs) {
        var vm = this;

        vm.account = null;
        vm.isAuthenticated = null;
        vm.login = LoginService.open;
        vm.register = register;
        $scope.$on('authenticationSuccess', function () {
            getAccount();
        });

        getAccount();

        function getAccount() {
            Principal.identity().then(function (account) {
                vm.account = account;
                vm.isAuthenticated = Principal.isAuthenticated;
            });
        }
        function register() {
            $state.go('register');
        }

        Graphs.getCharts().then(function (response) {
            vm.charts = response.data.charts;
        });
       
    }
})();
