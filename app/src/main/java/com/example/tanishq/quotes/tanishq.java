package com.example.tanishq.quotes;

import android.content.ActivityNotFoundException;
import android.content.Intent;import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class tanishq extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); // Call super.onCreate first
        setContentView(R.layout.activity_tanishq);

        TextView instagram = findViewById(R.id.insta);
        TextView left = findViewById(R.id.back);
        instagram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openInstagramProfile("tanishqsharma_893");
            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(tanishq.this,MainActivity2.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private void openInstagramProfile(String username) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        try{
            intent.setPackage("com.instagram.android");
            intent.setData(Uri.parse("https://www.instagram.com/tanishqsharma_893?igsh=MXVrcG80emR5ZWpmcQ==" + username));
            startActivity(intent);
        } catch (ActivityNotFoundException e) {
            intent.setData(Uri.parse("http://instagram.com/" + username));
            startActivity(intent);
        }
    }

}