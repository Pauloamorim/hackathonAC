(function () {
  'use strict';

  angular
    .module('hackathonACApp')
    .controller('PerfilRegraController', PerfilRegraController);

  function PerfilRegraController(RegraService, ToastFactory, PerfilRegraService, PerfilService) {
    var vm = this;

    vm.salvar = salvar;
    vm.selecionados = [];
    vm.vinculo = {listaRegras: []};

    vm.promise = RegraService.query({}, function(data){
      vm.regras = data;
    }, function(){
      ToastFactory.showErrorToast("ERRO INESPERADO!");
    })

    vm.promise = PerfilService.query({}, function(data){
      vm.perfis = data;
    }, function(){
      ToastFactory.showErrorToast("ERRO INESPERADO!");
    })

    function salvar() {
      getRegras();
      if(vm.vinculo.listaRegras.length === 0){
        ToastFactory.showErrorToast("Selecione pelo menos uma regra!");
        return;
      }
      vm.promise = PerfilRegraService.save(vm.vinculo, function(data){
        ToastFactory.showSuccessToast("Registro vinculado com sucesso!");
      }, function(){
        ToastFactory.showErrorToast("ERRO INESPERADO!");
      })
    }

    function getRegras(){
      vm.regras.forEach(function(val){
        if(val.selected){
          vm.vinculo.listaRegras.push({id:val.id});
        }
      })
    }

  }



})();
