(function () {
    'use strict';

    angular
        .module('hackathonACApp')

        .service('LoginService', LoginService)

        .service('UsuarioService', UsuarioService)

        .service('PontoService', PontoService)

        .service('RegraService', RegraService)

        .service('LocalidadeService', LocalidadeService)

        .service('PerfilRegraService', PerfilRegraService)

        .service('PerfilService', PerfilService)

        .service('RelatorioService', RelatorioService)

    ;

    function LoginService($resource, BASE_REST_URL) {
        return $resource(BASE_REST_URL + 'usuario/login', {}, {});
    }

    function UsuarioService($resource, BASE_REST_URL) {
        return $resource(BASE_REST_URL + 'usuario', {}, {});
    }

    function PontoService($resource, BASE_REST_URL) {
        return $resource(BASE_REST_URL + 'ponto/registrar', {}, {});
    }

    function RegraService($resource, BASE_REST_URL) {
        return $resource(BASE_REST_URL + 'regra', {}, {});
    }

    function LocalidadeService($resource, BASE_REST_URL) {
        return $resource(BASE_REST_URL + 'localidade', {}, {});
    }

    function PerfilRegraService($resource, BASE_REST_URL) {
        return $resource(BASE_REST_URL + 'vinculo', {}, {});
    }

    function PerfilService($resource, BASE_REST_URL) {
        return $resource(BASE_REST_URL + 'perfil', {}, {});
    }

    function RelatorioService($resource, BASE_REST_URL) {
        return $resource(BASE_REST_URL + 'relatorio', {}, {});
    }


})();
