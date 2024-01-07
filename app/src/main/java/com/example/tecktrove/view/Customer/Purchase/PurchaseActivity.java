package com.example.tecktrove.view.Customer.Purchase;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import com.example.tecktrove.R;
import com.example.tecktrove.domain.Customer;
import com.example.tecktrove.domain.Employer;
import com.example.tecktrove.domain.User;
import com.example.tecktrove.memorydao.MemoryInitializer;
import com.example.tecktrove.view.Authentication.LogIn.LogInActivity;
import com.example.tecktrove.view.Authentication.SignUp.SignUpActivity;
import com.example.tecktrove.view.Authentication.SignUp.SignUpPresenter;
import com.example.tecktrove.view.SharedViewModel;

public class PurchaseActivity extends AppCompatActivity implements PurchaseView {
    PurchasePresenter presenter;
    MemoryInitializer init;
    private SharedViewModel sharedViewModel;


    /**
     * Initializes the classes attributes
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.Base_Theme_TeckTrove);
        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_purchase);

        init = new MemoryInitializer();
        presenter = new PurchasePresenter(this, init.getOrderDAO(), init.getCustomerDAO());

        sharedViewModel = new ViewModelProvider(this).get(SharedViewModel.class);
    }

    /**
     * Starts when the screen is touched
     */
    @Override
    public void onStart(){
        super.onStart();
        findViewById(R.id.btnPurchase).setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                presenter.check_values();
            }
        });
    }

    /**
     * Gets the full name
     *
     * @return the full name as a String
     */
    @Override
    public String getFullName() {
        return ((EditText)findViewById(R.id.PurchaseFullName)).getText().toString().trim();
    }

    /**
     * Gets the email
     *
     * @return the email as a String
     */
    @Override
    public String getEmail() {
        return ((EditText)findViewById(R.id.PurchaseEmail)).getText().toString().trim();
    }

    /**
     * Gets the telephone
     *
     * @return the telephone as a String
     */
    @Override
    public String getTelephone() {
        return ((EditText)findViewById(R.id.edtPurchaseMobile)).getText().toString().trim();
    }

    /**
     * Gets the address
     *
     * @return the address a String
     */
    @Override
    public String getAddress() {
        return ((EditText)findViewById(R.id.PurchaseAddress)).getText().toString().trim();
    }

    /**
     * Gets the card number
     *
     * @return the card number as a String
     */
    @Override
    public String getCardNumber() {
        return ((EditText)findViewById(R.id.edtPurchaseCardNumber)).getText().toString().trim();
    }


    /**
     * Gets the month a card expires
     *
     * @return the month a card expires as a String
     */
    @Override
    public String getCardMonth() {
        return ((EditText)findViewById(R.id.edtPurchaseCardMonth)).getText().toString().trim();
    }

    /**
     * Gets the year a card expires
     *
     * @return the year a card expires as a String
     */
    @Override
    public String getCardYear() {
        return ((EditText)findViewById(R.id.edtPurchaseCardYear)).getText().toString().trim();
    }

    /**
     * Gets the cvv of a card
     *
     * @return the cvv of a card as a String
     */
    @Override
    public String getCardCvv() {
        return ((EditText)findViewById(R.id.edtPurchaseCardCvv)).getText().toString().trim();
    }

    /**
     * Shows a pop up window with a customized message
     *
     * @param title the title of the window
     * @param msg   the text of the window
     */
    public void showMessage(String title, String msg) {
        new AlertDialog.Builder(PurchaseActivity.this)
                .setCancelable(true)
                .setTitle(title)
                .setMessage(msg)
                .setPositiveButton(R.string.ok, null).create().show();
    }

    /**
     * Stores and presents the order details
     *
     * @param customer
     */
    @Override
    public void placeOrder(Customer customer){

    }
}