(function() {
    'use strict';
    angular
        .module('kukulkancraftsmanApp')
        .factory('UserHandsontable', ['$http',  function ($http) {

            return {
                getData: getData
            };

            function getData() {
                return $http.get('app/entities/user-handsontable/data.json');
            }

        }]);
})();

