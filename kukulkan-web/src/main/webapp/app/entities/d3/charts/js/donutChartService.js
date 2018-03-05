(function () {
    'use strict';
    angular
        .module('kukulkancraftsmanApp')
        .factory('donutChart', ['$http', function ($http) {
            return {
                options: options,
                data: data
            };


            /**
             *  Data & Options Generators
             */
            function options() {
                return {
                    chart: {
                        type: 'pieChart',
                        height: 450,
                        donut: true,
                        x: function (d) { return d.key; },
                        y: function (d) { return d.y; },
                        showLabels: true,

                        pie: {
                            startAngle: function (d) { return d.startAngle / 2 - Math.PI / 2 },
                            endAngle: function (d) { return d.endAngle / 2 - Math.PI / 2 }
                        },
                        duration: 500,
                        legend: {
                            margin: {
                                top: 5,
                                right: 140,
                                bottom: 5,
                                left: 0
                            }
                        }
                    }
                };
            }
            function data() {
                return [
                    {
                        key: "One",
                        y: 5
                    },
                    {
                        key: "Two",
                        y: 2
                    },
                    {
                        key: "Three",
                        y: 9
                    },
                    {
                        key: "Four",
                        y: 7
                    },
                    {
                        key: "Five",
                        y: 4
                    },
                    {
                        key: "Six",
                        y: 3
                    },
                    {
                        key: "Seven",
                        y: .5
                    }
                ];
            }

        }]);
})();

