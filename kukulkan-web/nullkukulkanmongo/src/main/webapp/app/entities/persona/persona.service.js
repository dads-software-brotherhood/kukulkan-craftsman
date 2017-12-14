(function() {
    'use strict';
    angular
        .module('kukulkanmongoApp')
        .factory('Persona', Persona);

    Persona.$inject = ['$resource', 'DateUtils'];

    function Persona ($resource, DateUtils) {
        var resourceUrl = 'api/personas/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
						data.fechaLocalDate = DateUtils.convertLocalDateFromServer(data.fechaLocalDate);
				        data.fechaZoneDateTime = DateUtils.convertDateTimeFromServer(data.fechaZoneDateTime);
                    }
                    return data;
                }
            },
            'update': {
                method: 'PUT',
                transformRequest: function (data) {
                    var copy = angular.copy(data);
				    copy.fechaLocalDate = DateUtils.convertLocalDateToServer(copy.fechaLocalDate);
        		return angular.toJson(copy);
                }
            },
            'save': {
                method: 'POST',
                transformRequest: function (data) {
                    var copy = angular.copy(data);
				    copy.fechaLocalDate = DateUtils.convertLocalDateToServer(copy.fechaLocalDate);
                    return angular.toJson(copy);
                }
            }
        });
    }
})();