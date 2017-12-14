(function() {
    'use strict';

    angular
        .module('kukulkanmongoApp')
        .controller('DireccionDialogController', DireccionDialogController);

    DireccionDialogController.$inject = ['$timeout', '$scope', '$stateParams', '$uibModalInstance', 'DataUtils', 'entity', 'Direccion'];

    function DireccionDialogController ($timeout, $scope, $stateParams, $uibModalInstance, DataUtils, entity, Direccion) {
        var vm = this;

        vm.direccion = entity;
        vm.clear = clear;
        vm.datePickerOpenStatus = {};
        vm.openCalendar = openCalendar;
        vm.byteSize = DataUtils.byteSize;
        vm.openFile = DataUtils.openFile;
        vm.save = save;
          
        vm.datePickerOpenStatus.fechaLocalDate = false;
        vm.datePickerOpenStatus.fechaZoneDateTime = false;
        vm.datePickerOpenStatus.instante = false;

        $timeout(function (){
            angular.element('.form-group:eq(1)>input').focus();
        });

        function clear () {
            $uibModalInstance.dismiss('cancel');
        }

        function save () {
            vm.isSaving = true;
            if (vm.direccion.id !== null) {
                Direccion.update(vm.direccion, onSaveSuccess, onSaveError);
            } else {
                Direccion.save(vm.direccion, onSaveSuccess, onSaveError);
            }
        }

        function onSaveSuccess (result) {
            $scope.$emit('kukulkanmongoApp:direccionUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        }

        function onSaveError () {
            vm.isSaving = false;
        }
        
        vm.setImagen = function ($file, direccion) {
            if ($file) {
                DataUtils.toBase64($file, function(base64Data) {
                    $scope.$apply(function() {
                        direccion.imagen = base64Data;
                        direccion.imagenContentType = $file.type;
                    });
                });
            }
        };
        vm.setImagenAnyBlob = function ($file, direccion) {
            if ($file) {
                DataUtils.toBase64($file, function(base64Data) {
                    $scope.$apply(function() {
                        direccion.imagenAnyBlob = base64Data;
                        direccion.imagenAnyBlobContentType = $file.type;
                    });
                });
            }
        };
        vm.setImagenBlob = function ($file, direccion) {
            if ($file) {
                DataUtils.toBase64($file, function(base64Data) {
                    $scope.$apply(function() {
                        direccion.imagenBlob = base64Data;
                        direccion.imagenBlobContentType = $file.type;
                    });
                });
            }
        };
        vm.setDesc = function ($file, direccion) {
            if ($file) {
                DataUtils.toBase64($file, function(base64Data) {
                    $scope.$apply(function() {
                        direccion.desc = base64Data;
                        direccion.descContentType = $file.type;
                    });
                });
            }
        };

        function openCalendar (date) {
            vm.datePickerOpenStatus[date] = true;
        }
    }
})();
