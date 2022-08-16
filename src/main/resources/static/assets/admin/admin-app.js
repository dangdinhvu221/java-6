app = angular.module("admin-app", ["ngRoute"]);
app.controller("my-ctrl", function ($scope, $http) {});
app.config(function ($routeProvider) {
  $routeProvider
    .when("/manufacturer", {
      templateUrl: "/assets/admin/manufacturer/index.html",
      controller: "manufacturer-ctrl",
    })
    .when("/users", {
      templateUrl: "/assets/admin/users/index.html",
      controller: "users-ctrl",
    })
    .when("/product", {
      templateUrl: "/assets/admin/product/index.html",
      controller: "product-ctrl",
    })
    .when("/orders", {
      templateUrl: "/assets/admin/orders/index.html",
      controller: "orders-ctrl",
    })
    .otherwise({
      template: "<h1 class='text-center'>FPT Admin</h1>",
    });
});
