(function() {
    'use strict';

    angular
        .module('kukulkanmongoApp')
        .factory('DireccionSearch', DireccionSearch);

    DireccionSearch.$inject = ['$resource'];

    function DireccionSearch($resource) {
        var resourceUrl =  'api/_search/direccions/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true}
        });
    }
})();
