(function () {
    'use strict';
    angular
        .module('kukulkancraftsmanApp')
        .factory('UserHandsontable', UserHandsontable);

    UserHandsontable.$inject = ['$resource'];

    function UserHandsontable($resource) {
        var resourceUrl = 'api/users/handsontable';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: false },
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                    }
                    return data;
                }
            }
        });
    }
})();

