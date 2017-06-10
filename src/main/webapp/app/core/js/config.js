(function () {
  'use strict';

  angular
    .module('hotmartApp')
    .config(themeConfiguration)
    ;

  function themeConfiguration($mdThemingProvider) {

    $mdThemingProvider.theme('default')
      .primaryPalette('black', {
        'default': '500'
      }).accentPalette('indigo', {
      'default': '900'
    });

  }

  

})();
