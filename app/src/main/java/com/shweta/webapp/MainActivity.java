package com.shweta.webapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.SearchManager;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void callMyFriend(View view){
        EditText ed = (EditText) findViewById(R.id.et1);
        String phoneno = ed.getText().toString();

        if (view!=null){

            Intent in = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneno));
            try {
                startActivity(in);
            }catch (android.content.ActivityNotFoundException ex){
                Toast.makeText(MainActivity.this, "Dialer not found", Toast.LENGTH_SHORT).show();
            }
        }
    }

    public void googleSearch(View view){

        EditText ed1 = (EditText) findViewById(R.id.e2);
        String q = ed1.getText().toString();

        Intent in1 = new Intent(Intent.ACTION_WEB_SEARCH);
        in1.putExtra(SearchManager.QUERY,q);
        startActivity(in1);
    }


    public void emailSender(View view){
        EditText ed2 = (EditText) findViewById(R.id.et3);
        String em = ed2.getText().toString();

        Intent in = new Intent(Intent.ACTION_SENDTO);
        in.setData(Uri.parse("mailto:"));
        in.putExtra(Intent.EXTRA_EMAIL, new String[] {em});
        in.putExtra(Intent.EXTRA_SUBJECT,"Testing Email Subject");
        in.putExtra(Intent.EXTRA_TEXT,"Please dont respond to this test email");

        if (in.resolveActivity(getPackageManager())!=null){
            startActivity(in);
        }
    }

    public void share(View view){
        Intent in2 = new Intent(Intent.ACTION_SEND);
        in2.setType("text/plain");
        in2.putExtra(Intent.EXTRA_TEXT,"hello there! how are you!");
        startActivity(in2);
    }

}