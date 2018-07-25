(function () {
  'use strict';

  angular
    .module('kukulkancraftsmanApp')
    .controller('UserHandsontableController', UserHandsontableController);

  UserHandsontableController.$inject = ['$scope', 'hotRegisterer', 'UserHandsontable'];

  function UserHandsontableController($scope, hotRegisterer, UserHandsontable) {
    var vm = this;

    $scope.$on('$viewContentLoaded', function () {
      var hotInstance = hotRegisterer.getInstance('my-handsontable');

      UserHandsontable.getData().then(function (response) {
        hotInstance.updateSettings({
          colHeaders: response.data.colHeaders,
          rowHeaders: true,
          afterChange: true,
          dropdownMenu: true,
          filters: true,
          height: 440,
          contextMenu: true,
          minSpareRows: true,
          columnSorting: true,
          colWidths: 146,
          rowHeights: 25,
          filters: true,
          minRows: 20,
          autoRowSize: true,
          manualColumnMove: true,
          manualRowMove: true,
          fillHandle: {
            autoInsertRow: false,
          }
        });
      });
    });
  }
})();
