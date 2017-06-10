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
    .state('regra', {
        url: '/regra',
        templateUrl: 'app/modules/regras/regra.html',
        controller: 'RegraController',
        controllerAs: 'vm'
    })
    .state('regraEdit', {
        url: '/regra-editar',
        templateUrl: 'app/modules/regras/regra-edit.html',
        controller: 'RegraEditController',
        controllerAs: 'vm'
    })
    
    ;

    $urlRouterProvider.otherwise('/');
  }

})();
