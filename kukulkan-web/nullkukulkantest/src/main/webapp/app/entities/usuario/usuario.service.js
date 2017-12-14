(function() {
    'use strict';
    angular
        .module('kukulkantestApp')
        .factory('Usuario', Usuario);

    Usuario.$inject = ['$resource', 'DateUtils'];

    function Usuario ($resource, DateUtils) {
        var resourceUrl = 'api/usuarios/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
						data.fechaLocalDate = DateUtils.convertLocalDateFromServer(data.fechaLocalDate);
				        data.fechaZoneDateTime = DateUtils.convertDateTimeFromServer(data.fechaZoneDateTime);
				        data.instante = DateUtils.convertDateTimeFromServer(data.instante);
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