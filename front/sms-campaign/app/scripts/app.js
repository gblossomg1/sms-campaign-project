'use strict';

/**
 * @ngdoc overview
 * @name smsCampaignApp
 * @description
 * # smsCampaignApp
 *
 * Main module of the application.
 */

angular
  .module('smsCampaignApp', ['ui.router'])
  .config(function ($stateProvider, $urlRouterProvider) {

    $urlRouterProvider.otherwise('/');

    $stateProvider
      .state('home', {
        url: '/',
        templateUrl: 'views/home.html',
        controller: 'homeCtrl'
      })

      /**
       * EXTERNAL DATA
       */
      .state('external-data', {
        abstract: 'true',
        url: '/external-data',
        templateUrl: 'views/external-data/external-data.html',
      })
      .state('external-data.import', {
        url: '/import',
        templateUrl: 'views/external-data/import.html',
        controller: 'datasImportCtrl'
      })
      .state('external-data.search', {
        url: '/search',
        templateUrl: 'views/external-data/external-data-search.html',
        controller: 'externalDataSearchCtrl'
      })
      .state('external-data.list', {
        url: '/list',
        templateUrl: 'views/external-data/external-data-list.html',
        controller: 'externalDataListCtrl',
        params: {
          externalDataList: {
            value: ['default'],
            array: true
          }
        }
      })
      .state('external-data.show', {
        url: '/show/{sourceId}',
        templateUrl: 'views/external-data/external-data-show.html',
        controller: 'externalDataShowCtrl',
        params: {
          source: {
            value: {}
          }
        }
      })

      /**
       * ACCOUNT
       */
      .state('account', {
        abstract: 'true',
        url: '/account',
        templateUrl: 'views/account/account.html',
      })
      .state('account.infos', {
        url: '/infos',
        templateUrl: 'views/account/account-infos.html',
        controller: 'accountInfosCtrl'
      })

      /**
       * CAMPAIGNS
       */
      .state('campaigns', {
        abstract: 'true',
        url: '/campaigns',
        templateUrl: 'views/campaigns/campaigns.html'
        //controller: 'campaignsCtrl'
      })

      .state('campaigns.create', {
        url: '/create',
        templateUrl: 'views/campaigns/campaigns-create.html',
        controller: 'campaignsCreateCtrl'
      })

      .state('campaigns.search', {
        url: '/search',
        templateUrl: 'views/campaigns/campaigns-search.html',
        controller: 'campaignsSearchCtrl'
      })

      .state('campaigns.list', {
        url: '/list',
        templateUrl: 'views/campaigns/campaigns-list.html',
        controller: 'campaignsListCtrl',
        params: {
          campaigns: {
            value: ['default'],
            array: true
          }
        }
      })

      .state('campaigns.details', {
        url: '/details',
        templateUrl: 'views/campaigns/campaigns-details.html',
        controller: 'campaignsDetailsCtrl',
        params: {
          campaign: {
            value: {}
          }
        }
      })
      .state('campaigns.edit', {
        url: '/edit',
        templateUrl: 'views/campaigns/campaigns-edit.html',
        controller: 'campaignsEditCtrl',
        params: {
          campaign: {
            value: {}
          }
        }
      })

      /**
       * LOGIN
       */
      .state('sign-in', {
        url: '/sign-in',
        templateUrl: 'views/login.html',
        controller: 'loginCtrl'
      })

      /**
       * USERS
       */
      .state('users', {
        abstract: 'true',
        url: '/users',
        templateUrl: 'views/users/users.html'
      })
      .state('users.search', {
        url: '/search',
        templateUrl: 'views/users/users-search.html',
        controller: 'usersSearchCtrl'
      })
      .state('users.add', {
        url: '/add',
        templateUrl: 'views/users/users-add.html',
        controller: 'usersAddCtrl'
      })
      .state('users.list', {
        url: '/list',
        templateUrl: 'views/users/users-list.html',
        controller: 'usersListCtrl',
        params: {
          users: {
            value: ['default'],
            array: true
          }
        }
      })
      .state('users.details', {
        url: '/details',
        templateUrl: 'views/users/users-details.html',
        controller: 'userDetailsCtrl',
        params: {
          user: {
            value: {}
          }
        }
      })

      .state('users.edit', {
        url: '/edit',
        templateUrl: 'views/users/users-edit',
        controller: 'usersEditCtrl'
      })
  });

var app = angular.module('smsCampaignApp');

app.factory('usersMockFactory', function () {
  var users = [
    {
      'login': 'foo',
      'password': 'foopass',
      'name': 'M.Foo',
      'age': '25'
    },
    {
      'login': 'bar@live.fr',
      'password': 'barpass',
      'name': 'M.Bar',
      'age': '35'
    }
  ]

  return {
    getAllUsers: users
  }

})



