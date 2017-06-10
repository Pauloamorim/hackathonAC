(function () {
  'use strict';

  angular
    .module('hackathonACApp')
    .config(themeConfiguration)
    ;

  function themeConfiguration($mdThemingProvider) {

    $mdThemingProvider.theme('default')
      .primaryPalette('blue', {
        'default': '500'
      }).accentPalette('indigo', {
      'default': '900'
    });

  }

  

})();
