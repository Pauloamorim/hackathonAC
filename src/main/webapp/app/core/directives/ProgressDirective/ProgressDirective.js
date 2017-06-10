(function () {
  'use strict';

  angular
    .module('hackathonACApp')
    .directive('progressDirective', progressDirective);

  function progressDirective() {
      return {
          restrict: 'EA',
          templateUrl: 'app/core/directives/ProgressDirective/progress-directive.html',
          scope: {
              promise:'='
          }
      }
  }
})();
