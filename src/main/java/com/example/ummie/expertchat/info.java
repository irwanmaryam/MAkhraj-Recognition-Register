package com.example.ummie.expertchat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by UmiIrwanMaryam on 12-Dec-17.
 */

public class info extends AppCompatActivity {

    private Button navi;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.info);

        navi = (Button) findViewById(R.id.navi);
        navi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(info.this, register.class);
                startActivity(intent);
            }
        });

    }

}
