(function () {
  'use strict';

  angular
    .module('hackathonACApp')
    .controller('RegraController', RegraController);

  function RegraController(RegraService, ToastFactory) {
    var vm = this;

    vm.promise = RegraService.query({}, function(data){
      vm.regras = data;
    }, function(){
      ToastFactory.showErrorToast("ERRO INESPERADO!");
    })

  }



})();
