(function () {
  'use strict';

  angular
    .module('hackathonACApp')
    .controller('MainController', MainController);

  function MainController(LoginService, ToastFactory, $state) {
    var vm = this;

    vm.logar = logar;

    function logar(){

      vm.promise = LoginService.save(vm.usuario, function(data){
        $state.go("apontar");
        ToastFactory.showSuccessToast("Usuario logado com sucesso!");
      }, function(data){
        ToastFactory.showErrorToast("Usuario nao encontrado!");
      });



    }

  }



})();
