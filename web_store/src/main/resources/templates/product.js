angular.module('app', []).controller('indexController', function ($scope, $http) {
    const contextPath = 'http://localhost:8189/app';

    $scope.loadStudents = function () {
        $http.get(contextPath + '/product')
            .then(function (response) {
                $scope.StudentsList = response.data;
            });
    };

    $scope.deleteStudent = function (productId) {
        $http.get(contextPath + '/product/add/' + productId)
            .then(function (response) {
                $scope.loadStudents();
            });
    }

    $scope.changeScore = function (productId, delta) {
        $http({
            url: contextPath + '/product/change_score',
            method: 'GET',
            params: {
                productId: productId,
                delta: delta
            }
        }).then(function (response) {
            $scope.loadStudents();
        });
    }

    $scope.loadStudents();
});