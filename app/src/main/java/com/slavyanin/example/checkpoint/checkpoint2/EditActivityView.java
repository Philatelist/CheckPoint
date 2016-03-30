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

public class EditActivityView extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editview_activity);

        ListView lView = (ListView) findViewById(R.id.listView_edit);
        Button toMenu = (Button) findViewById(R.id.button_returnToMenuFromEditView);

        ArrayAdapter<AutoEntity> adapter = new Adapter(this);
        lView.setAdapter(adapter);

        toMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditActivityView.this, MainActivity.class);
                startActivity(intent);
            }
        });

        lView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                final AutoEntity entity = (AutoEntity) parent.getItemAtPosition(position);
                Adapter adapter = new Adapter(EditActivityView.this);
//                adapter.remove(position);
//                adapter.remove(entity);
                adapter.notifyDataSetChanged();
                view.setAlpha(1);

//                EditActivityEdit edit = new EditActivityEdit(adapter.getName(position), adapter.getNumber(position), position);
//                EditActivityEdit edit = new EditActivityEdit(adapter.getName(position), adapter.getNumber(position), position);
//                edit.setName("Name");
//                edit.setNumber("Number");
//                edit.setPosition(0);
                Intent intent = new Intent(EditActivityView.this, EditActivityEdit.class);
                intent.putExtra("name", adapter.getName(position));
                intent.putExtra("number", adapter.getNumber(position));
                intent.putExtra("position", position);
                startActivity(intent);
            }
        });
    }



}
