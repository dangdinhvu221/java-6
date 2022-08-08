package poly.edu.com.demo.service;


import poly.edu.com.demo.entity.Carts;

public interface CartService {
    Carts getCart();

    void addToCart(Long earPhoneId, Integer quantity);

    void changeEarPhoneQuantityPlus(Long earPhoneId);

    void changeEarPhoneQuantityMinus(Long earPhoneId);


    void removeEarPhone(Long earPhoneId);

    void removeEarPhones();
}
