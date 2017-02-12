'use strict';
var app = angular.module('smsCampaignApp');

app.controller('campaignsCreateCtrl', function ($scope, $http) {
  console.log("Enter campaigns create ctrl");

  $scope.customerName = "NOM CLIENT";

  $scope.createCampaign = function () {

    console.log("Creating campaign..")

    var campaign = {
      'name': $scope.name,
      'customerName': 'ENTITY_NAME',
      'smsContent': $scope.smsContent,
      'prospectQuantity': '' + $scope.prospectQuantity
    }

    $http({
      url: window.config.basePath + '/campaigns/create',
      method: 'POST',
      data: campaign,
      headers: {
        'Content-Type': 'application/json',
        'Accept': 'application/json',
      }
    }).then(function successCallback(response) {
      console.log("Post campaign success")
      var location = response.headers('Location')
      console.log("request success : " + response.data)
      console.log("Location is : " + location)
      alert("La campagne SMS a bien été crée. Reference de l'annonce : "+location)
    }, function errorCallback(response) {
      console.log("Post campaign error")
    });
  }

})

app.controller('campaignsSearchCtrl', function ($scope, $http, $state) {
  console.log("Enter campaigns search ctrl");

  $scope.search = function () {

    var campaign = {
      'reference': $scope.campaignId,
      'name': $scope.campaignName,
      'customerName': $scope.clientName,
      'prospectQuantity': $scope.prospectQuantity
      //'creationDate': $scope.campaignCreationDate
    }

    $http({
      url: window.config.basePath + '/campaigns/search',
      method: 'POST',
      data: campaign,
      headers: {
        'Content-Type': 'application/json',
        'Accept': 'application/json',
      }
    }).then(function successCallback(response) {
      if (response.status == 200) {

        var campaigns = response.data.entity;

        for (var c in campaigns) {
          console.log("Nom de la campagne :" + campaigns[c].name)
        }
        $scope.campaigns = campaigns;

        $state.go('campaigns.list', {
          campaigns: campaigns
        })
      }
    }, function errorCallBack(response) {
      console.log("Error while retrieving campaigns");
    })
  }
})

/**
 * LIST
 */
app.controller('campaignsListCtrl', function ($scope, $http, $stateParams) {

  console.log("Enter campaigns list ctrl");
  $scope.campaigns = $stateParams.campaigns
  var campaigns = $stateParams.campaigns
  if (campaigns && campaigns.length == 0) {
    $scope.empty = true
  }
})

/**
 * DETAILS
 */
app.controller('campaignsDetailsCtrl', function ($scope, $http, $stateParams, $state) {
  console.log("Enter campaigns details ctrl");

  $scope.campaign = $stateParams.campaign;

  var campaign = $scope.campaign;

  $scope.send = function () {
    $http({
      url: window.config.basePath + '/campaigns/' + campaign.reference + '/send',
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'Accept': 'application/json',
      }
    }).then(function successCallback(response) {

      if(response.status == '200') {
        console.log("Sms campaign well sent")

        var sendReponse = response.data;
        console.log(sendReponse);
        alert("La campagne SMS a bien été envoyée.")
      }

    }, function errorCallback(response) {

    })
  }

  $scope.edit = function () {

    var campaign = {
      'name': $scope.name,
      'customerName': 'ENTITY_NAME',
      'smsContent': $scope.smsContent,
      'prospectQuantity': '' + $scope.prospectQuantity
    }


    $state.go('campaigns.edit', {
      'campaign': $scope.campaign
    })
  }

  $scope.delete = function () {
    $http({
      url: window.config.basePath + '/campaigns/' + campaign.reference + '/delete',
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
        'Accept': 'application/json',
      }
    }).then(function successCallback(response) {

      if(response.status == '200') {
        console.log("Sms campaign well sent")

        var sendReponse = response.data;
        console.log(sendReponse);
      }

    }, function errorCallback(response) {

    })
  }

})

/**
 * EDIT
 */
app.controller('campaignsEditCtrl', function ($scope, $http, $stateParams) {
  console.log("Enter campaigns edit ctrl");

  $scope.campaign = $stateParams.campaign
  $scope.name = $scope.campaign.name;
  $scope.smsContent = $scope.campaign.smsContent;
  $scope.prospectQuantity = $scope.campaign.prospectQuantity;


  $scope.applyChanges = function () {

    console.log("Editing campaign..")

    var campaign = {
      'name': $scope.name,
      'customerName': 'ENTITY_NAME',
      'smsContent': $scope.smsContent,
      'prospectQuantity': '' + $scope.prospectQuantity
    }

    $http({
      url: window.config.basePath + '/campaigns/' + $scope.campaign.reference +'/edit',
      method: 'POST',
      data: campaign,
      headers: {
        'Content-Type': 'application/json',
        'Accept': 'application/json',
      }
    }).then(function successCallback(response) {
      console.log("Post campaign success")
      var location = response.headers('Location')
      console.log("request success : " + response.data)
      console.log("Location is : " + location);
    }, function errorCallback(response) {
      console.log("Post campaign error")
    });
  }


})




