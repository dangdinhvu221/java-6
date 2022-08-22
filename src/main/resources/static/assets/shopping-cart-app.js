const app = angular.module("shopping-cart-app", []);

app.controller("cart-controller", function ($scope, $http, $rootScope) {
  $scope.quantity = 1;
  $scope.cart = {
    items: [],
    // Them san pham vao gio hang
    add(id) {
      var item = this.items.find((item) => item.id == id);
      if (item) {
        item.qty++;
        this.saveLocalStorage();
       
      } else {
        $http.get(`/rest/earPhones/${id}`).then((resp) => {
          resp.data.qty = $scope.quantity;
          this.items.push(resp.data);
          this.saveLocalStorage();
        });
      }
      Swal.fire({
        icon: 'success',
        title: 'Đã thêm vào giỏ hàng!',
        showConfirmButton: false,
        timer: 1500
      })
      console.log(this.items);
    },
    // Xoa san pham trong gio hang
    remove(id) {
      var index = this.items.findIndex((item) => item.id == id);
      this.items.splice(index, 1);
      this.saveLocalStorage();
    },
    // Xoa sach cac mat hang ben trong gio hang
    clear(id) {
      this.items = [];
      this.saveLocalStorage();
    },
    // Tinh thanh tien cua 1 san pham
    amt_of(item) {},
    // Tinh tong so luong cac mat hang trong gio hang
    get count() {
      return this.items
        .map((item) => item.qty)
        .reduce((total, qty) => (total += qty), 0);
    },
    // Tong thanh tien cac mat hang trong gio
    get amount() {
      return this.items
        .map((item) => item.qty * item.price)
        .reduce((total, qty) => (total += qty), 0);
    },
    // Luu gio hang vao localStorage
    saveLocalStorage() {
      var json = JSON.stringify(angular.copy(this.items));
      localStorage.setItem("cart", json);
    },
    //Doc gio hang tu LocalStorage
    loadFromLocalStorage() {
      var json = localStorage.getItem("cart");
      this.items = json ? JSON.parse(json) : [];
    },
  };

  $scope.cart.loadFromLocalStorage();

  $scope.order = {
    created: new Date(),
    address1: "",
    address2: "",
    usersByUserId: { username: $("#username").val() },
    total: ($scope.cart.amount * 1.1).toFixed(2),

    get orderDetails() {
      return $scope.cart.items.map((i) => {
        return {
          earPhoneByEarPhoneId: { id: i.id },
          quantity: i.qty,
          price: i.price,
        };
      });
    },

    purchase() {
      var order = angular.copy(this);
      let id = $("#idOrder").val();
      let quantitySell = $("#quantitySell").val();
      $http
        .post(`/rest/orders/${id}/${quantitySell}`, order)
        .then((resp) => {
          console.log($("#idOrder").text());
          console.log($("#quantitySell").val());
          Swal.fire({
            icon: 'success',
            title: 'Đặt hàng thành công!',
            showConfirmButton: false,
            timer: 1500
          })

          $http
            .delete(`/rest/orders/${id}/${quantitySell}`)
            .then((resp) => {
              // alert("Delete succsesfully!!");
            })
            .catch((err) => {
              console.log(err);
            });
          $scope.cart.clear();
          location.href = "/order/detail/" + resp.data.id;
        })
        .catch((error) => {
          Swal.fire({
            icon: "error",
            title: "Error...",
            text: error,
            footer: '<a href="">Why do I have this issue?</a>',
          });
        });
    },
  };
});
