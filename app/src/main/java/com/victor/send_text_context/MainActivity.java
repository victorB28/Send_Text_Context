package com.victor.send_text_context;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText edtxtTo;
    EditText edtxtSubject;
    EditText edTxtText;

    String addressee;
    String subject;
    String message;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtxtTo = (EditText)findViewById(R.id.edtxtTo);
        edtxtSubject = (EditText)findViewById(R.id.edtxtSubject);
        edTxtText = (EditText)findViewById(R.id.edtxtText);
    }

    public void sendBundleData(View v){

        addressee = edtxtTo.getText().toString();
        subject = edtxtSubject.getText().toString();
        message = edTxtText.getText().toString();

        Intent email = new Intent(Intent.ACTION_SEND);
        email.putExtra(Intent.EXTRA_EMAIL, new String[]{ addressee});
        email.putExtra(Intent.EXTRA_SUBJECT, subject);
        email.putExtra(Intent.EXTRA_TEXT, message);

        //need this to prompts email client only
        email.setType("message/rfc822");

        startActivity(Intent.createChooser(email, "Choose an Email client :"));

    }
}
