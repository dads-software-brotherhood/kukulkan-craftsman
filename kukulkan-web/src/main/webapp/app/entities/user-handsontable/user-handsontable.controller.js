(function () {
  'use strict';

  angular
    .module('kukulkancraftsmanApp')
    .controller('UserHandsontableController', UserHandsontableController);

  UserHandsontableController.$inject = ['$scope', 'hotRegisterer', 'UserHandsontable', 'AlertService'];

  function UserHandsontableController($scope, hotRegisterer, UserHandsontable, AlertService) {
    var vm = this;

    vm.settings = {
      rowHeaders: true,
      colHeaders: true
    }

    $scope.$on('$viewContentLoaded', function () {
      var hotInstance = hotRegisterer.getInstance('my-handsontable');
      UserHandsontable.query({}, onSuccess, onError);
      function onSuccess(settings) {
        hotInstance.updateSettings(settings);
      }
      function onError(error) {
        AlertService.error(error.data.message);
      }
    });
  }
})();
