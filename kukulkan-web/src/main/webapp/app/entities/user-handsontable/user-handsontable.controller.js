(function () {
  'use strict';

  angular
      .module('kukulkancraftsmanApp')
      .controller('UserHandsontableController', UserHandsontableController);

      UserHandsontableController.$inject = ['$scope','$state','hotRegisterer','UserHandsontable'];

  function UserHandsontableController($scope,$state,hotRegisterer,UserHandsontable) {
      var vm = this;

        var hotInstance = hotRegisterer.getInstance('persona-handsontable');


//        loadAll();
//
//        function loadAll() {
//            UserHandsontable.query({}, onSuccess, onError);
//            function onSuccess(data, headers) {
//                vm.totalItems = headers('X-Total-Count');
//                vm.queryCount = vm.totalItems;
//                //Directly passing Handsontable settings form back-end
//                hotInstance.updateSettings(vm.data);
//            }
//            function onError(error) {
//                AlertService.error(error.data.message);
//            }
//        }


      UserHandsontable.getData().then(function (response) {
        vm.items = response.data;
      });

      $scope.$on('$viewContentLoaded', function() {

        var hotInstance = hotRegisterer.getInstance('my-handsontable');
        var rowsCount = hotRegisterer.getInstance('my-handsontable').countRows();
            hotInstance.updateSettings({
            data: vm.items,
            rowHeaders: true,
            afterChange: true,
            dropdownMenu: true,
            filters: true,
            height:440,
            contextMenu: true,
            minSpareRows:true,
            columnSorting:true,
            colWidths:146,
            rowHeights: 25,
            filters:true,
            minRows:20,
            autoRowSize: true,
            manualColumnMove: true,
            manualRowMove: true,
            fillHandle: {
              autoInsertRow: false,
              }
        });

      });


  }
})();
