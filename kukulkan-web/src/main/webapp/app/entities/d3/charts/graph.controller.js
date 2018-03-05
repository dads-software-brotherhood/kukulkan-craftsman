(function () {
    'use strict';

    angular
        .module('kukulkancraftsmanApp')
        .controller('ViewGraphController', ViewGraphController);

    ViewGraphController.$inject = ['$stateParams','$scope','Principal','LoginService','$state',
        'lineChart','cumulativeLine','stackedArea','multiBar','bullet','discreteBar',
        'historicalBar','multiBarHorizontal','pieChart','scatter','lineFocus','scatterLine',
        'lineBar','donutChart','sparkLine','paralell','multiChart','candlestick',
        'sunburst','ohcl','boxPlot','forceDirected'];

    function ViewGraphController($stateParams, $scope, Principal, LoginService, $state, lineChart,
        cumulativeLine, stackedArea, multiBar, bullet, discreteBar, historicalBar, multiBarHorizontal, pieChart,
        scatter, lineFocus, scatterLine, lineBar, donutChart, sparkLine, paralell, multiChart, candlestick,
        sunburst, ohcl, boxPlot, forceDirected) {
        var vm = this;

        vm.account = null;
        vm.isAuthenticated = null;
        vm.login = LoginService.open;
        vm.register = register;
        vm.type = $stateParams.type;
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

        switch (vm.type) {
            case 'lineChart':
                $scope.options = lineChart.options();
                $scope.data = lineChart.data();
                break;
            case 'cumulativeLine':
                $scope.options = cumulativeLine.options();
                $scope.data = cumulativeLine.data();
                break;
            case 'stackedArea':
                $scope.options = stackedArea.options();
                $scope.data = stackedArea.data();
                break;
            case 'multiBar':
                $scope.options = multiBar.options();
                $scope.data = multiBar.data();
                break;
            case 'bullet':
                $scope.options = bullet.options();
                $scope.data = bullet.data();
                $scope.data1 = bullet.data1();
                $scope.data2 = bullet.data2();
                break;
            case 'discreteBar':
                $scope.options = discreteBar.options();
                $scope.data = discreteBar.data();
                break;
            case 'historicalBar':
                $scope.options = historicalBar.options();
                $scope.data = historicalBar.data();
                break;
            case 'multiBarHorizontal':
                $scope.options = multiBarHorizontal.options();
                $scope.data = multiBarHorizontal.data();
                break;
            case 'pieChart':
                $scope.options = pieChart.options();
                $scope.data = pieChart.data();
                break;
            case 'scatter':
                $scope.options = scatter.options();
                $scope.data = scatter.data();
                break;
            case 'lineFocus':
                $scope.options = lineFocus.options();
                $scope.data = lineFocus.data();
                break;
            case 'scatterLine':
                $scope.options = scatterLine.options();
                $scope.data = scatterLine.data();
                break;
            case 'lineBar':
                $scope.options = lineBar.options();
                $scope.data = lineBar.data();
                break;
            case 'donutChart':
                $scope.options = donutChart.options();
                $scope.data = donutChart.data();
                break;
            case 'sparkLine':
                $scope.options = sparkLine.options();
                $scope.data = sparkLine.data();
                break;
            case 'paralell':
                $scope.options = paralell.options();
                $scope.data = paralell.data();
                break;
            case 'multiChart':
                $scope.options = multiChart.options();
                $scope.data = multiChart.data();
                break;
            case 'candlestick':
                $scope.options = candlestick.options();
                $scope.data = candlestick.data();
                break;
            case 'sunburst':
                $scope.options = sunburst.options();
                $scope.data = sunburst.data();
                break;
            case 'ohcl':
                $scope.options = ohcl.options();
                $scope.data = ohcl.data();
                break;
            case 'boxPlot':
                $scope.options = boxPlot.options();
                $scope.data = boxPlot.data();
                break;
            case 'forceDirected':
                $scope.options = forceDirected.options();
                $scope.data = forceDirected.data();
                break;
            default:

        }
        
    }
})();
