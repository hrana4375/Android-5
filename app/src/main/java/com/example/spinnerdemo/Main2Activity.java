package com.example.spinnerdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView name,email,pwd;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        pwd = findViewById(R.id.password);

        button = findViewById(R.id.edit);


        Bundle getBundle = this.getIntent().getExtras();

        name.setText(getBundle.getString("Name"));
        email.setText(getBundle.getString("Email"));
        pwd.setText(getBundle.getString("Password"));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Main2Activity.this,MainActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("Name_1",name.getText().toString());
                bundle.putString("Email_1",email.getText().toString());
                bundle.putString("Password_1",pwd.getText().toString());

                intent.putExtras(bundle);

                startActivity(intent);
            }
        });

    }
}
