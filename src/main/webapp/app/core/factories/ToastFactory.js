(function () {
  'use strict';

  angular
    .module('hackathonACApp')
    .factory('ToastFactory', ToastFactory);

  function ToastFactory($mdToast) {
      return {
          showErrorToast: function (message, position, delay) {
            var mess = message ? message : "Erro inesperado. Contate o administrador do sistema";
            var pos = position ? position : 'top right';
            var del = delay ? delay : 3000;
            $mdToast.show(
              $mdToast.simple()
                .textContent(mess)
                .position(pos)
                .hideDelay(del)
            );
          },
        showSuccessToast: function (message, position, delay) {
          var mess = message ? message : "Registro salvo com Sucesso!";
          var pos = position ? position : 'top right';
          var del = delay ? delay : 3000;
          $mdToast.show(
            $mdToast.simple()
              .textContent(mess)
              .position(pos)
              .hideDelay(del)
          );
        },
        showRemoveToast: function (message, position, delay) {
          var mess = message ? message : "Registro excluído com Sucesso!";
          var pos = position ? position : 'top right';
          var del = delay ? delay : 3000;
          $mdToast.show(
            $mdToast.simple()
              .textContent(mess)
              .position(pos)
              .hideDelay(del)
          );
        }
      }
  }
})();
