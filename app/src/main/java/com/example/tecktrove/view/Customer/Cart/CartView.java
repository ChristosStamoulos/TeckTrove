package com.example.tecktrove.view.Customer.Cart;

public interface CartView {

    /**
     * Navigates the user to the home screen
     */
    void home();

    /**
     * Navigates the user to the cart
     */
    void cart();

    /**
     * Shows the total price of the cart
     */
    void ShowTotal();

    /**
     * Navigates the user to purchase of the cart
     */
    void Purchase();

    /**
     * Navigates the app to the my saved screen
     */
    void Saved();

    /**
     * Navigates the app to my account screen
     */
    void Myacount();
}
