app.controller("product-ctrl", function ($scope, $http) {
    $scope.items = [];
    $scope.form = {};
    $scope.manufacturer = [];


    $scope.initialize = function () {
        $http.get("/rest/earPhones/admin").then(resp => {
            $scope.items = resp.data;
            $scope.items.forEach(item => {
                item.createDate = new Date(item.createDate)
            })
        })

        $http.get("/rest/manufacturer").then(resp => {
            $scope.manufacturer = resp.data;
        })
    }

    $scope.initialize();
    

    $scope.reset = function () {
        $scope.form = {
            createDate: new Date(),
            image: '',
            available: true
        }
    }

    $scope.edit = function (item) {
        console.log(item);
        $scope.form = angular.copy(item);
        $(".nav-tabs button:eq(0)").tab('show')
    }

    $scope.create = function () {
        var item = angular.copy($scope.form);
        $http.post(`/rest/earPhones`, item).then(
            resp => {
                resp.data.createDate = new Date(resp.data.createDate)
                $scope.items.push(resp.data);
                $scope.reset();
                alert("Them moi thanh cong");
            }
        ).catch(error => {
            alert("Loi Them Moi San Pham")
            console.log(error);
        })
    }
    $scope.delete = function (item) {
        $http.delete(`/rest/earPhones/${item.id}`).then(
            resp => {
                var index = $scope.items.findIndex(p => p.id === item.id);
                $scope.items.splice(index, 1);
                $scope.reset();
                alert("Xoa thanh cong");
            }
        ).catch(error => {
            alert("Loi Xoa San Pham")
            console.log(error);
        })
    }
    $scope.update = function () {
        var item = angular.copy($scope.form);
        $http.put(`/rest/earPhones/${item.id}`, item).then(
            resp => {
                var index = $scope.items.findIndex(p => p.id === item.id);
                $scope.items[index] = item;
                alert("Update thanh cong");
            }
        ).catch(error => {
            alert("Loi update San Pham")
            console.log(error);
        })
    }

    $scope.imageChanged = function (files) {
        var data = new FormData();
        data.append('file', files[0]);
        $http.post('/rest/upload/images', data, {
            transformRequest: angular.identity,
            headers: {'Content-Type': undefined}
        }).then(resp => {
            $scope.form.image = resp.data.name;
        }).catch(error => {
            alert("error upload")
            console.log(error)
        })
    }

    $scope.pager = {
        page: 0,
        size: 5,
        get items() {
            var start = this.page * this.size;
            return $scope.items.slice(start, start + this.size);
        },
        get count() {
            return Math.ceil(1.0 * $scope.items.length / this.size);
        },
        first(){
            this.page = 0;
        },
        prev(){
            this.page--;
            if(this.page < 0){
                this.last();
            }
        },
        next(){
            this.page++;
            if(this.page >= this.count){
                this.first();
            }
        },
        last(){
            this.page = this.count - 1;
        }
    }
})