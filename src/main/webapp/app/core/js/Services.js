(function () {
    'use strict';

    angular
        .module('hackathonACApp')

        .service('LoginService', LoginService)

        .service('PontoService', PontoService)

        .service('LolizacaoService', LolizacaoService)

    ;

    function LoginService($resource, BASE_REST_URL) {
        return $resource(BASE_REST_URL + '/usuario/login', {}, {});
    }

    function PontoService($resource, BASE_REST_URL) {
        return $resource(BASE_REST_URL + '/usuario/apontar', {}, {});
    }

    function LolizacaoService($resource) {
        return $resource('https://geoip-db.com/json/', {}, {});
    }

})();
