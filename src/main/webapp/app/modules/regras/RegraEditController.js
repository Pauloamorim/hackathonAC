(function () {
  'use strict';

  angular
    .module('hackathonACApp')
    .controller('RegraEditController', RegraEditController);

  function RegraEditController() {

    var vm = this;

    vm.diasSemanas = [{nome: "Segunda", value: "SEGUNDA"},
      {nome: "Terca-Feira", value: "TERCA"},
      {nome: "Quarta-Feira", value: "QUARTA"},
      {nome: "Quinta-Feira", value: "QUINTA"},
      {nome: "Sexta-Feira", value: "SEXTA"},
      {nome: "Sabado", value: "SABADO"},
      {nome: "Domingo", value: "DOMINGO"},
      {nome: "Todos", value: "TODOS"}]


  }



})();
