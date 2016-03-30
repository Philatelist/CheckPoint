package com.slavyanin.example.checkpoint.checkpoint2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.slavyanin.example.checkpoint.R;


public class AddActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_activity);

        final EditText addName = (EditText) findViewById(R.id.editText_addName);
        final EditText addSurname = (EditText) findViewById(R.id.editText_addSurname);
        final EditText addNumber = (EditText) findViewById(R.id.editText_addNumberAuto);
        Button addAuto = (Button) findViewById(R.id.button_addAuto);
        Button returnToMenu = (Button) findViewById(R.id.button_returnToMenuFromAdd);

        addAuto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (addName.getText().toString().equals("") || addSurname.getText().toString().equals("") || addNumber.getText().toString().equals("")) {
                    Toast.makeText(AddActivity.this, "Есть незаполненные поля", Toast.LENGTH_LONG).show();
                    return;
                }
                String nameOwner = addName.getText().toString() + " " + addSurname.getText().toString();
                String numberAuto = addNumber.getText().toString();

                AutoEntity auto = new AutoEntity(R.mipmap.ic_launcher, nameOwner, numberAuto);
                Adapter adapter = new Adapter(AddActivity.this);
                adapter.add(auto);

                addName.setText("");
                addSurname.setText("");
                addNumber.setText("");
            }
        });

        returnToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });




    }



}
