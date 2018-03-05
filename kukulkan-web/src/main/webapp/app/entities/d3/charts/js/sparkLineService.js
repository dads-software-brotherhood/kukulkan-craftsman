(function () {
    'use strict';
    angular
        .module('kukulkancraftsmanApp')
        .factory('sparkLine', ['$http', function ($http) {
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
                        type: 'sparklinePlus',
                        height: 450,
                        x: function (d, i) { return i; },
                        
                        duration: 250
                    }
                };
            }
            function data() {
                return volatileChart(130.0, 0.02);
                //$scope.data = volatileChart(25.0, 0.09,30);
            }
                /* Random Data Generator (took from nvd3.org) */
                function sine() {
                    var sin = [];
                    var now = +new Date();

                    for (var i = 0; i < 100; i++) {
                        sin.push({ x: now + i * 1000 * 60 * 60 * 24, y: Math.sin(i / 10) });
                    }

                    return sin;
                }

                function volatileChart(startPrice, volatility, numPoints) {
                    var rval = [];
                    var now = +new Date();
                    numPoints = numPoints || 100;
                    for (var i = 1; i < numPoints; i++) {

                        rval.push({ x: now + i * 1000 * 60 * 60 * 24, y: startPrice });
                        var rnd = Math.random();
                        var changePct = 2 * volatility * rnd;
                        if (changePct > volatility) {
                            changePct -= (2 * volatility);
                        }
                        startPrice = startPrice + startPrice * changePct;
                    }
                    return rval;
                }

        }]);
})();

