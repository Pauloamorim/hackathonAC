(function () {
  'use strict';

  angular
    .module('hackathonACApp')
    .controller('PontoController', PontoController);

  function PontoController($q, $scope, PontoService, ToastFactory, $cookieStore) {
    var vm = this;
    vm.location = {};
    vm.myLocation;
    var locations = [];
    var mapCanvas = document.getElementById('map');
    vm.lat = "";
    vm.long = "";
    
    vm.apontar = apontar;

    var geocoder, deferred;

    geocoder = new google.maps.Geocoder();

    if (navigator.geolocation) {
      deferred = $q.defer();
      //vm.promise = deferred.promise;
      navigator.geolocation.getCurrentPosition(successFunction, errorFunction);
    }

    vm.ponto = {};

    function apontar(){

      vm.promise = codeLatLng(vm.lat, vm.long);

    }

    function addToMap(map){
      var markers = [];

      for (var i = 0; i < locations.length; i++) {
        var marker = new google.maps.Marker({
          position: locations[i],
          map: map,
          title: "LOCALIZACAO"
        });
        markers.push(marker);
      }
    }


    function setLocation(lat, longi) {
      var myLatlng = new google.maps.LatLng(lat, longi);

      var mapOptions = {
        center: myLatlng,
        zoom: 13
      }

      locations.push(myLatlng);

      var map = new google.maps.Map(mapCanvas, mapOptions);

      addToMap(map);

    }

    function codeLatLng(lat, lng) {
      var latlng = new google.maps.LatLng(lat, lng);
      geocoder.geocode({'latLng': latlng}, function(results, status) {
        if (status == google.maps.GeocoderStatus.OK) {
          console.log(results);
          if (results[1]) {
            //formatted address
            //alert(results[0].formatted_address);
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
            //alert(city.short_name + " " + city.long_name)

            vm.ponto.localidade = {nome: city.short_name};

          } else {
            alert("No results found");
          }
        } else {
          alert("Geocoder failed due to: " + status);
        }

        vm.promise = deferred.resolve();
        $scope.$apply();
        salvar();
      });

      return deferred.promise;
    }

    //Get the latitude and the longitude;
    function successFunction(position) {
      var lat = position.coords.latitude;
      var lng = position.coords.longitude;
      setLocation(lat, lng);
      vm.lat = lat;
      vm.long = lng;
      //vm.promise = codeLatLng(lat, lng)
    }

    function errorFunction(){
      alert("Geocoder failed");
    }

    function salvar(){
      vm.ponto.data = moment(new Date()).format("DD-MM-YYYY HH:mm");
      vm.ponto.usuario = $cookieStore.get("usuario");

      vm.promise = PontoService.save(vm.ponto, function(){
        ToastFactory.showSuccessToast("Ponto registrado com sucesso!");
      }, function(){
        ToastFactory.showErrorToast("ERRO INESPERADO!");
      })
    }

  }



})();
