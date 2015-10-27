package com.example.kapitandupa.myapplication.com.example.kapitandupa.shinning;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.TelephonyManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.kapitandupa.myapplication.R;

/**
 * Created by Kapitan Dupa on 2015-10-22.
 *
 * Pobiera numer telefonu i tworzy na jego podstawie uzytkownika
 *
 */
public class CreateAccount extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);

        //IO
        showID();
        display();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public String getMyPhoneNumber(){
        return ((TelephonyManager) getSystemService(TELEPHONY_SERVICE)).getLine1Number();
    }

    /* pokazuje numer telefonu */
    public void showID(){
        TextView text = (TextView) findViewById(R.id.textView3);
        text.setText(getMyPhoneNumber());
    }

    /* brak polaczenia z internetm */
    public boolean checkInternetConnection(){
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo =  cm.getActiveNetworkInfo();

        return netInfo != null && netInfo.isConnectedOrConnecting();
    }

    public void display(){
        TextView txt = (TextView) findViewById(R.id.textView4);
        if(checkInternetConnection()){
            txt.setText("OK");
        }else{
            txt.setText("no");
        }
    }




}