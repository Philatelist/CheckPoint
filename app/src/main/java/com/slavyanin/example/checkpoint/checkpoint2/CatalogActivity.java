package com.slavyanin.example.checkpoint.checkpoint2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.slavyanin.example.checkpoint.R;

import java.util.ArrayList;


public class CatalogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.catalog_activity);

        ListView lView = (ListView) findViewById(R.id.listView_catalog);
        Button toMenu = (Button) findViewById(R.id.button_returnToMenuFromCatalog);

        final ArrayList<AutoEntity> arrayAuto = new ArrayList<>();

        ArrayAdapter<AutoEntity> adapter = new Adapter(this);
        lView.setAdapter(adapter);

        toMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CatalogActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }



}
