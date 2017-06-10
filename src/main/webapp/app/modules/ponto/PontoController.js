(function () {
  'use strict';

  angular
    .module('hackathonACApp')
    .controller('PontoController', PontoController);

  function PontoController($q, $scope) {
    var vm = this;
    
    vm.apontar = apontar;

    var geocoder, deferred;

    function apontar(){

      geocoder = new google.maps.Geocoder();

      if (navigator.geolocation) {
          deferred = $q.defer();
          navigator.geolocation.getCurrentPosition(successFunction, errorFunction);
      }

    }

    function codeLatLng(lat, lng) {

      var latlng = new google.maps.LatLng(lat, lng);
      geocoder.geocode({'latLng': latlng}, function(results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
          console.log(results)
          if (results[1]) {
            //formatted address
            alert(results[0].formatted_address);
            //find country name
            for (var i=0; i<results[0].address_components.length; i++) {
              for (var b=0;b<results[0].address_components[i].types.length;b++) {

                //there are different types that might hold a city admin_area_lvl_1 usually does in come cases looking for sublocality type will be more appropriate
                if (results[0].address_components[i].types[b] == "locality") {
                  //this is the object you are looking for
                  var city= results[0].address_components[i];
                  break;
                }
              }
            }
            //city data
            alert(city.short_name + " " + city.long_name)


          } else {
            alert("No results found");
          }
        } else {
          alert("Geocoder failed due to: " + status);
        }

        vm.promise = deferred.resolve();
        $scope.$apply();
      });

      return deferred.promise;
    }

    //Get the latitude and the longitude;
    function successFunction(position) {
      var lat = position.coords.latitude;
      var lng = position.coords.longitude;
      vm.promise = codeLatLng(lat, lng)
      $scope.$apply();
    }

    function errorFunction(){
      alert("Geocoder failed");
    }

    function initialize() {

    }

  }



})();
