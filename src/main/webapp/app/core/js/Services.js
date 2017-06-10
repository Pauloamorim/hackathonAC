(function () {
    'use strict';

    angular
        .module('hackathonACApp')

        .service('LoginService', LoginService)

        .service('PontoService', PontoService)

        .service('BuscarRegrasService', BuscarRegrasService)

        .service('RegraService', RegraService)

    ;

    function LoginService($resource, BASE_REST_URL) {
        return $resource(BASE_REST_URL + 'usuario/login', {}, {});
    }

    function PontoService($resource, BASE_REST_URL) {
        return $resource(BASE_REST_URL + 'ponto/registrar', {}, {});
    }

    function BuscarRegrasService($resource, BASE_REST_URL) {
        return $resource(BASE_REST_URL + 'regras', {}, {});
    }

    function RegraService($resource, BASE_REST_URL) {
        return $resource(BASE_REST_URL + 'regras', {}, {});
    }


})();
