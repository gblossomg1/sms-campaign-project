'use strict';
var app = angular.module('smsCampaignApp');

app.controller('accountInfosCtrl', function ($scope, $http, creditInfosService) {
  console.log("Enter account infos ctrl");

  var creditPromise = creditInfosService.findCreditInformations();

  creditPromise.then(function (creditInformations) {
    $scope.remainingCredit = creditInformations.credit
    $scope.remainingSMSQuantity = creditInformations.remainingSMSQuantity
  }, function () {
    alert('credit promise ko: ');
  }, function(update){
    console.log(update)
  })

});

app.service("creditInfosService", function ($http, $q) {

  this.findCreditInformations = function () {

    var deferred = $q.defer()

    deferred.notify('About to GET credit...')

    var creditHttpPromise = $http({
      url: window.config.basePath + '/sms/credit',
      method: 'GET',
      headers: {
        'Accept': 'application/json',
      }
    }).then(function successCallback(response) {
      console.log("GET credit success")
      console.log("request success : " + response.data)
      deferred.resolve(response.data);
    }, function errorCallback(response) {
      console.log("GET credit error")
    });

    return deferred.promise;

  }
});
