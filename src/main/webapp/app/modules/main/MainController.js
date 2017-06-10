(function () {
  'use strict';

  angular
    .module('hackathonACApp')
    .controller('MainController', MainController);

  function MainController(LoginService, ToastFactory, $state, $timeout, $mdSidenav, $cookieStore) {
    var vm = this;

    vm.logar = logar;

    function logar(){

      vm.promise = LoginService.save(vm.usuario, function(data){
        $cookieStore.put('usuario', data);
        $state.go("apontar");
        ToastFactory.showSuccessToast("Usuario logado com sucesso!");
      }, function(data){
        ToastFactory.showErrorToast("Usuario nao encontrado!");
      });
    }

    vm.toggleLeft = buildDelayedToggler('left');

    vm.menu = {
      items: [
        {name: "Apontamento", url: 'apontar', icon: 'event_note'},
        {name: "Regras", url: 'regra', icon: 'event_note'},
        {name: "Vinculo", url: 'vinculo', icon: 'event_note'}
      ]
    };

    function debounce(func, wait) {
      var timer;
      return function debounced() {
        var context = vm,
            args = Array.prototype.slice.call(arguments);
        $timeout.cancel(timer);
        timer = $timeout(function () {
          timer = undefined;
          func.apply(context, args);
        }, wait || 10);
      };
    }

    function buildDelayedToggler(navID) {
      return debounce(function () {
        $mdSidenav(navID).toggle();
      }, 200);
    }

  }



})();
