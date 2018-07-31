(function () {
  'use strict';

  angular
    .module('kukulkancraftsmanApp')
    .controller('UserHandsontableController', UserHandsontableController);

  UserHandsontableController.$inject = ['$scope', 'hotRegisterer', 'UserHandsontable'];

  function UserHandsontableController($scope, hotRegisterer, UserHandsontable) {
    var vm = this;

    vm.settings = {
      rowHeaders: true,
      colHeaders: true
    }

    $scope.$on('$viewContentLoaded', function () {
      var hotInstance = hotRegisterer.getInstance('my-handsontable');

      UserHandsontable.query({}, function (data) {
        hotInstance.updateSettings(data);
      }, function () {
        console.log("ERROR");
      });
    });
  }
})();
