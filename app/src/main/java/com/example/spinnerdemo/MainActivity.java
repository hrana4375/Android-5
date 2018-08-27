package com.example.spinnerdemo;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  {
    EditText name,email,password;
    Spinner states,cities;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        password = findViewById(R.id.password);
        email = findViewById(R.id.email);

        states = findViewById(R.id.state);
        cities = findViewById(R.id.city);
        button = findViewById(R.id.button);


        ArrayAdapter<CharSequence> spinnerAdapter = ArrayAdapter.createFromResource(this,
                R.array.States_Names,android.R.layout.simple_spinner_item);

        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        states.setAdapter(spinnerAdapter);

        states.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, "Clicked", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //Do Nothing
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);

                Bundle bundle = new Bundle();
                bundle.putString("Name",name.getText().toString());
                bundle.putString("Password",password.getText().toString());
                bundle.putString("Email",email.getText().toString());

                intent.putExtras(bundle);
                startActivity(intent);

            }
        });

        Bundle getBundle1 = new Bundle();

        if(!getBundle1.isEmpty()) {
            name.setText(getBundle1.getString("Name_1"));
            email.setText(getBundle1.getString("Email_1"));
            password.setText(getBundle1.getString("Password_1"));
        }

        }
}

