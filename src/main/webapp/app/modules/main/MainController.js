(function () {
  'use strict';

  angular
    .module('hackathonACApp')
    .controller('MainController', MainController);

  function MainController(LoginService) {
    var vm = this;
    
    vm.logar = logar;
    
    vm.logar = function(){

      LoginService.save(vm.usuario, function(data){
        alert("ok");
      }, function(data){
        alert("erro");
      });
      
      
      
    }

  }



})();
