'use strict';
var app = angular.module('smsCampaignApp');

app.controller('externalDataSearchCtrl', function ($scope, $http, $state) {
  console.log("Enter external data search ctrl");

  $scope.search = function () {

    var externalData = {
      'id': $scope.id,
      'format': $scope.format,
      'businessEntity': $scope.businessEntity,
      'dataModel': $scope.dataModelType,
      'importDate': $scope.importDate
    }

    $http({
      url: window.config.basePath + '/external-data/search',
      method: 'POST',
      data: externalData,
      headers: {
        'Content-Type': 'application/json',
        'Accept': 'application/json',
      }
    }).then(function successCallback(response) {
      if (response.status == 200) {

        var externalDatas = response.data.entity;

        for (var c in externalDatas) {
          console.log("External data id  :" + externalDatas[c].id)
        }
        $scope.externalDatas = externalDatas;

        $state.go('external-data.list', {
          externalDataList: externalDatas
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
app.controller('externalDataListCtrl', function ($scope, $http, $stateParams) {

  console.log("Enter external data list ctrl");
  $scope.externalDataList = $stateParams.externalDataList
  var externalDataList = $stateParams.externalDataList

  if (externalDataList && externalDataList.length == 0) {
    $scope.empty = true
  }
})

/**
 * SHOW
 */
app.controller('externalDataShowCtrl', function($scope, $http, $stateParams) {
  console.log("Enter external data show ctrl");
  $scope.sourceId = $stateParams.sourceId



})
