(function () {
  'use strict';

  angular
      .module('kukulkancraftsmanApp')
      .controller('HandsontableController', HandsontableController);

      HandsontableController.$inject = ['$scope','$state','hotRegisterer','Handsontable'];

  function HandsontableController($scope,$state,hotRegisterer,Handsontable) {
      var vm = this;

      vm.settings = {
        rowHeaders: true,
        colHeaders: true,
        afterChange: true,
        dropdownMenu: true,
        filters: true,
        height:440,
        contextMenu: true,
        minSpareRows:true,
        columnSorting:true,
        colWidths:125,
        rowHeights: 25,
        minRows:20
      };

      Handsontable.getData().then(function (response) {
        vm.items = response.data;
      });

      $scope.$on('$viewContentLoaded', function() {

        var hotInstance = hotRegisterer.getInstance('my-handsontable');
        var rowsCount = hotRegisterer.getInstance('my-handsontable').countRows();
        hotInstance.updateSettings({
          cells: function(row, column) {
            var cellMeta = {};

            if (column === 1) {
              cellMeta.type = 'dropdown';
              cellMeta.source = [
                'Ben',
                'Chris',
                'Jessica',
                'Kate',
                'Michael',
                'Monica',
                'Omar',
                'Paul',
                'Samuel',
              ];

            } else if (column === 2) {
              cellMeta.readOnly = true;
              cellMeta.type = 'text';
              cellMeta.renderer = function(hotInstance, td, row, col, prop, value) {
                var colors = {
                  Red: '#c72626d1',
                  Green: '#4fad01',
                  Blue: '#00a7fe',
                  Purple: '#4e1badb8',
                  Orange: '#de7000eb',
                  Yellow: '#af9a02',
                };
                var backgrounds = {
                  Red: '#ff70708f',
                  Green: '#9eff9c9e',
                  Blue: '#00a7fe6b',
                  Purple: '#8b54f154',
                  Orange: '#ffa74cb3',
                  Yellow: '#ffe00052',
                };

                td.style.color = colors[value];
                td.style.background = backgrounds[value];
                td.textContent = value;
              };

            } else if (column === 3) {
              cellMeta.type = 'dropdown';
              cellMeta.source = [
                'New',
                'Accepted',
                'Rejected',
                'In progress',
                'Completed',
              ];

            }  else if (column === 6) {
              var isChecked = this.instance.getDataAtCell(this.instance.toVisualRow(row), column);

              cellMeta.type = 'checkbox';
              cellMeta.className = 'htCenter';

            } else if (column === 7) {
              cellMeta.width = 150;
              cellMeta.renderer = function(hotInstance, td, row, col, prop, value, cellProperties) {
                var progressBar = document.createElement('progress');

                value = parseInt(value, 10);

                progressBar.max = 100;
                progressBar.value = isNaN(value) ? 0 : value;

                td.textContent = '';
                td.appendChild(progressBar);
              };
            }

            return cellMeta;
          },
          // Create virtual column data ("Team" column)
          modifyData: function(row, column, valueHolder, ioMode) {
            if (this.toPhysicalColumn(column) === 2 && ioMode === 'get') {
              valueHolder.value = getOwnerTeam(this.getDataAtCell(this.toVisualRow(row), this.toVisualColumn(1)));
            }
          }
        });

        function getOwnerTeam(owner) {
          var teamOwners = {
            Red: ['Michael', 'Ben'],
            Green: ['Omar', 'Samuel'],
            Blue: ['Kate', 'Monica'],
            Purple: ['Chris'],
            Orange: ['Paul'],
            Yellow: ['Jessica'],
          };

          return Object.keys(teamOwners).reduce(function(acc, team) {
            return teamOwners[team].indexOf(owner) !== -1 ? team : acc;
          }, null);
        }
      });

  }
})();
