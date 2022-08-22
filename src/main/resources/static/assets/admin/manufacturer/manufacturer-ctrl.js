app.controller("manufacturer-ctrl", function ($scope, $http) {
  $scope.items = [];
  $scope.form = {};

  $scope.initialize = function () {
    $http.get("/rest/manufacturer/admin").then((resp) => {
      $scope.items = resp.data;
      $scope.items.forEach((item) => {
        item.createDate = new Date(item.createDate);
      });
    });
  };

  $scope.initialize();

  $scope.reset = function () {
    $scope.form = {
      createDate: new Date(),
      image: "",
      available: true,
    };
  };

  $scope.edit = function (item) {
    console.log(item);
    $scope.form = angular.copy(item);
    $(".nav-tabs button:eq(0)").tab("show");
  };

  $scope.create = function () {
    var item = angular.copy($scope.form);
    $http
      .post(`/rest/manufacturer`, item)
      .then((resp) => {
        resp.data.createDate = new Date(resp.data.createDate);
        $scope.items.push(resp.data);
        $scope.reset();
        Swal.fire({
          icon: "success",
          title: "Thêm thành công !",
          showConfirmButton: false,
          timer: 1500,
        });
      })
      .catch((error) => {
        Swal.fire({
          icon: "error",
          title: "Error...",
          text: error,
          footer: '<a href="">Why do I have this issue?</a>',
        });
      });
  };
  $scope.delete = function (item) {
    $http
      .delete(`/rest/manufacturer/${item.id}`)
      .then((resp) => {
        Swal.fire({
          title: "Are you sure?",
          text: "You won't be able to revert this!",
          icon: "warning",
          showCancelButton: true,
          confirmButtonColor: "#3085d6",
          cancelButtonColor: "#d33",
          confirmButtonText: "Yes, delete it!",
        }).then((result) => {
          if (result.isConfirmed) {
            var index = $scope.items.findIndex((p) => p.id === item.id);
            $scope.items.splice(index, 1);
            Swal.fire("Deleted!", "Your file has been deleted.", "success");
          }
        });
        $scope.reset();
      })
      .catch((error) => {
        Swal.fire({
            icon: "error",
            title: "Error...",
            text: error,
            footer: '<a href="">Why do I have this issue?</a>',
          });
      });
  };
  $scope.update = function () {
    var item = angular.copy($scope.form);
    $http
      .put(`/rest/manufacturer/${item.id}`, item)
      .then((resp) => {
        var index = $scope.items.findIndex((p) => p.id === item.id);
        $scope.items[index] = item;
        Swal.fire({
            icon: "success",
            title: "Cập nhật thành công !",
            showConfirmButton: false,
            timer: 1500,
          });
      })
      .catch((error) => {
        Swal.fire({
            icon: "error",
            title: "Error...",
            text: error,
            footer: '<a href="">Why do I have this issue?</a>',
          });
      });
  };

  $scope.imageChanged = function (files) {
    var data = new FormData();
    data.append("file", files[0]);
    $http
      .post("/rest/upload/images", data, {
        transformRequest: angular.identity,
        headers: { "Content-Type": undefined },
      })
      .then((resp) => {
        $scope.form.image = resp.data.name;
      })
      .catch((error) => {
        alert("error upload");
        console.log(error);
      });
  };

  $scope.pager = {
    page: 0,
    size: 5,
    get items() {
      var start = this.page * this.size;
      return $scope.items.slice(start, start + this.size);
    },
    get count() {
      return Math.ceil((1.0 * $scope.items.length) / this.size);
    },
    first() {
      this.page = 0;
    },
    prev() {
      this.page--;
      if (this.page < 0) {
        this.last();
      }
    },
    next() {
      this.page++;
      if (this.page >= this.count) {
        this.first();
      }
    },
    last() {
      this.page = this.count - 1;
    },
  };
});
