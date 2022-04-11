package com.android.s19110175;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE =  "com.example.android.s19110175.extra.MESSAGE";
    private String[] mOrderMessage = {"", "", "", "", ""};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mOrderMessage[0] = "Toppings :";
    }

    public void displayToast(View view) {

        String message = "";
        int count = 0;

        for (int i = 0; i < mOrderMessage.length; i++){
            if(mOrderMessage[i] == ""){
                count++;
            }else {
                message += mOrderMessage[i] + " ";
            }
        }

        if(count == 4){
            Toast.makeText(getApplicationContext(), "Please order !", Toast.LENGTH_SHORT).show();
        }else {
            Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
        }
    }

    public void delete(String[] mOrderMessage, String message){

        for (int i = 0; i < mOrderMessage.length; i++){
            if(mOrderMessage[i] == message){
                mOrderMessage[i] = "";
            }
        }

    }

    public void check(String[] mOrderMessage, String message){

        boolean c = false;

        for(int i = 0; i < mOrderMessage.length; i++){
            if (mOrderMessage[i] == message){
                c = true;
                break;
            }
        }

        if(!c){
            for(int i = 0; i < mOrderMessage.length; i++){
                if (mOrderMessage[i] == ""){
                    mOrderMessage[i] = message;
                    break;
                }
            }
        }

    }

    public void onCheckBoxClicked(View view) {

        boolean checked = ((CheckBox) view).isChecked();

        switch (view.getId()) {
            case R.id.cherries:
                if (checked)
                    check(mOrderMessage, getString(R.string.cherries));
                else
                    delete(mOrderMessage, getString(R.string.cherries));
                break;
            case R.id.orio:
                if (checked)
                    check(mOrderMessage, getString(R.string.orio));
                else
                    delete(mOrderMessage, getString(R.string.orio));
                break;
            case R.id.sprinkles:
                if (checked)
                    check(mOrderMessage, getString(R.string.sprinkles));
                else
                    delete(mOrderMessage, getString(R.string.sprinkles));
                break;
            case R.id.chocolates:
                if (checked)
                    check(mOrderMessage, getString(R.string.chocolate_syrup));
                else
                    delete(mOrderMessage, getString(R.string.chocolate_syrup));
                break;
            case R.id.crushed:
                if (checked)
                    check(mOrderMessage, getString(R.string.crushed_nuts));
                else
                    delete(mOrderMessage, getString(R.string.crushed_nuts));
                break;
            default:
                break;
        }

    }

    public void onClick(View view){

    }
}