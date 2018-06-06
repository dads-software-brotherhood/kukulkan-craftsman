(function() {
    'use strict';
    angular
        .module('kukulkancraftsmanApp')
        .factory('Handsontable', ['$http',  function ($http) {

            return {
                getData: getData
            };

            function getData() {
                return $http.get('app/entities/handsontable/data.json');
            }

        }]);
})();

