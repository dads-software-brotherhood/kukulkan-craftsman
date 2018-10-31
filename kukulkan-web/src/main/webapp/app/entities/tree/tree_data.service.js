(function() {
    'use strict';
    angular
        .module('kukulkancraftsmanApp')
        .factory('TreeService', ['$http','$q',  function ($http, $q) {
            return {
                getTree: getTree
            };
            function getTree() {
                 return $http.get('app/entities/tree/data.json').then(function(response) {
                    if (typeof response.data === 'object') {
                        return response.data;
                    } else {
                        return $q.reject(response.data);
                    }
                 }, function(response) {
                    return $q.reject(response.data);
                });
            }
        }]);
})();

