(function () {
  'use strict';

  angular
    .module('hackathonACApp')

    .service('LoginService', LoginService)
    
  ;

  function LoginService($resource, BASE_REST_URL) {
    return $resource(BASE_REST_URL + '/usuario/login', {}, {
    });
  }
  
})();
