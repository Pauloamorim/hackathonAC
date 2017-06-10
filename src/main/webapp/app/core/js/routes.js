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
    
    ;

    $urlRouterProvider.otherwise('/');
  }

})();
