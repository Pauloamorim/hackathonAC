(function () {
  'use strict';

  angular
    .module('hackathonACApp')
    .controller('RegraEditController', RegraEditController);

  function RegraEditController(LocalidadeService, RegraService, ToastFactory, $state) {

    var vm = this;
    vm.salvar = salvar;

    vm.diasSemanas = [{nome: "Segunda", value: "SEGUNDA"},
      {nome: "Terca-Feira", value: "TERCA"},
      {nome: "Quarta-Feira", value: "QUARTA"},
      {nome: "Quinta-Feira", value: "QUINTA"},
      {nome: "Sexta-Feira", value: "SEXTA"},
      {nome: "Sabado", value: "SABADO"},
      {nome: "Domingo", value: "DOMINGO"},
      {nome: "Todos", value: "TODOS"}]

    vm.promise = LocalidadeService.query({}, function(data){
      vm.localidades = data;
    }, function(){
      ToastFactory.showErrorToast("ERRO INESPERADO!");
    })

    function salvar(){
     vm.promise = RegraService.save(vm.regra, function(){
       $state.go("regra")
        ToastFactory.showErrorToast("Registro salvo com sucesso!");
      }, function(){
        ToastFactory.showErrorToast("ERRO INESPERADO!");
      })

    }

  }



})();
