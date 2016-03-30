package com.slavyanin.example.checkpoint.checkpoint2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.slavyanin.example.checkpoint.R;

public class RemoveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.remove_activity);

        ListView lView = (ListView) findViewById(R.id.listView_remove);
        Button toMenu = (Button) findViewById(R.id.button_returnToMenuFromRemove);

        ArrayAdapter<AutoEntity> adapter = new Adapter(this);
        lView.setAdapter(adapter);

        toMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RemoveActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final AutoEntity entity = (AutoEntity) parent.getItemAtPosition(position);
                Adapter adapter = new Adapter(RemoveActivity.this);
                adapter.remove(position);
                adapter.remove(entity);
                adapter.notifyDataSetChanged();
                view.setAlpha(1);
                Intent intent = new Intent(RemoveActivity.this, RemoveActivity.class);
                startActivity(intent);
            }
        });

    }



}
