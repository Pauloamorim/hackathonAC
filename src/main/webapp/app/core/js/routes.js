(function () {
  'use strict';

  angular
    .module('hackathonACApp')
    .config(['$stateProvider', '$urlRouterProvider', routerConfig]);

  function routerConfig($stateProvider, $urlRouterProvider) {
    $stateProvider
      .state('main', {
        url: '/',
        templateUrl: 'app/modules/main/main.html',
        controller: 'MainController',
        controllerAs: 'vm'
      })
        .state('apontar', {
          url: '/apontar',
          templateUrl: 'app/modules/ponto/apontar.html',
          controller: 'PontoController',
          controllerAs: 'vm'
        })
    
    ;

    $urlRouterProvider.otherwise('/');
  }

})();
