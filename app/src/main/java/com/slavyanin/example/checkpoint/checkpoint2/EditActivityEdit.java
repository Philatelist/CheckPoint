package com.slavyanin.example.checkpoint.checkpoint2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.slavyanin.example.checkpoint.R;


public class EditActivityEdit extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView oldName = (TextView) findViewById(R.id.textView_old_name);
        final EditText addNameAndSurname = (EditText) findViewById(R.id.editText_addNewName);
        final EditText addNewNumber = (EditText) findViewById(R.id.editText_addNewNumber);
        Button editAuto = (Button) findViewById(R.id.button_editAuto);
        Button returnToMenu = (Button) findViewById(R.id.button_returnToMenuFromEdit);


        final Intent intent = getIntent();

        String numberAuto = intent.getStringExtra("number");
        String nameOwner = intent.getStringExtra("name");
        final int position = intent.getIntExtra("position", 0);
//        oldName.setText(nameOwner + " " + numberAuto);

        editAuto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Adapter adapter = new Adapter(EditActivityEdit.this);


                if (!addNameAndSurname.getText().toString().equals("")) {
                    String newNameOwner = addNameAndSurname.getText().toString();
                    adapter.setName(position, newNameOwner);
                }
                if (!addNewNumber.getText().toString().equals("")) {
                    String newNumberAuto = addNewNumber.getText().toString();
                    adapter.setNumber(position, newNumberAuto);
                }

//                AutoEntity auto = new AutoEntity(R.mipmap.ic_launcher, nameOwner, numberAuto);

                addNameAndSurname.setText("");
                addNewNumber.setText("");
            }
        });

        returnToMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditActivityEdit.this, MainActivity.class);
                startActivity(intent);
            }
        });


    }


}
