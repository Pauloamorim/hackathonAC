(function () {
  'use strict';

  angular
    .module('hackathonACApp')
    .controller('RegraEditController', RegraEditController);

  function RegraEditController() {

    var vm = this;

    vm.diasSemanas = [{nome: "Segunda", value: "SEGUNDA"},
      {nome: "Terça-Feira", value: "TERCA"},
      {nome: "Quarta-Feira", value: "QUARTA"},
      {nome: "Quinta-Feira", value: "QUINTA"},
      {nome: "Sexta-Feira", value: "SEXTA"},
      {nome: "Sábado-Feira", value: "SABADO"},
      {nome: "Domingo-Feira", value: "DOMINGO"},
      {nome: "Todos", value: "TODOS"}]


  }



})();
