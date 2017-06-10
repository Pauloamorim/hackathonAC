(function () {
  'use strict';

  angular
    .module('hackathonACApp')
    .controller('RelatorioController', RelatorioController);

  function RelatorioController(RelatorioService, UsuarioService, ToastFactory) {
    var vm = this;
    vm.pesquisar = pesquisar;

    vm.meses = [
      {description: 'Janeiro', value: 1},
      {description: 'Fevereiro', value: 2},
      {description: 'Marco', value: 3},
      {description: 'Abril', value: 4},
      {description: 'Maio', value: 5},
      {description: 'Junho', value: 6},
      {description: 'Julho', value: 7},
      {description: 'Agosto', value: 8},
      {description: 'Setembro', value: 9},
      {description: 'Outubro', value: 10},
      {description: 'Novembro', value: 11},
      {description: 'Dezembro', value: 12}
    ];

    vm.promise = UsuarioService.query({}, function(data){
      vm.usuarios = data;
    }, function(){
      ToastFactory.showErrorToast("ERRO INESPERADO!");
    })

    function pesquisar(){
      
    }
    

  }



})();
