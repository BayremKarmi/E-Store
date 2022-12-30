package com.example.e_store;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;


import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;

public class pcportable extends AppCompatActivity {
    ListView lvPc;
    String programName, programDt;
    HashMap<String,String> map;
    int[] programImage = {R.drawable.laptop1, R.drawable.laptop2, R.drawable.laptop3};
    ProgramAdapter programAdapter = new ProgramAdapter(pcportable.this,programImage);
    int position;
    SearchView searchView;
    SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pcportable);
        lvPc = findViewById(R.id.lvPc);
        Bundle extra = getIntent().getExtras();
        if (extra != null){
            programName = extra.getString("programName");
            programDt = extra.getString("programDt");
            map = new HashMap<String,String>();
            map.put("programName", programName);
            map.put("programDt", programDt);
            programAdapter.values.add(map);
        }
        adapter = new SimpleAdapter(pcportable.this, programAdapter.values, R.layout.single_item,
                new String[]{"programName", "programDt"},
                new int[]{R.id.programName, R.id.programDt}
        );
        lvPc.setAdapter(adapter);
        lvPc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (programDt.isEmpty()){
                    dialog("No data!!");
                } else dialog(programDt);
            }
        });

        lvPc.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {
                position = i;
                return false;
            }
        });

        lvPc.setOnCreateContextMenuListener(this);
        searchView = findViewById(R.id.search_bar);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                pcportable.this.adapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                pcportable.this.adapter.getFilter().filter(newText);

                return false;
            }
        });

    }

    public void onCreateContextMenu(ContextMenu menu_con, View v, ContextMenu.ContextMenuInfo menuInfo){
        super.onCreateContextMenu(menu_con, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_con,menu_con);
    }

    @Override
    public boolean onContextItemSelected( MenuItem item) {
        switch (item.getItemId()){
            case R.id.supprimer: {
                programAdapter.values.remove(position);
                Intent i = new Intent(getApplicationContext(),pcportable.class);
                startActivity(i);
                finish();
            }
        }
        return false;
    }

    public void dialog (String message){
        AlertDialog dialog = new AlertDialog.Builder(pcportable.this)
                .setTitle("Details")
                .setMessage(message)
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .create();
        dialog.show();
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.o1:
                Intent intent = new Intent(pcportable.this,ajout_article.class);
                startActivity(intent);
                break;
            case R.id.o2:
                Intent intent1 = new Intent(pcportable.this,MainActivity.class);
                startActivity(intent1);
                break;
            case R.id.o4: {
                Intent intent2 = new Intent(pcportable.this,smartphone.class);
                startActivity(intent2);
            }
            break;
            case R.id.o5: {
                Intent intent2 = new Intent(pcportable.this,smartTv.class);
                startActivity(intent2);
            }
            break;
            case R.id.o6: {
                Intent intent2 = new Intent(pcportable.this,ajout_article.class);
                startActivity(intent2);
            }
            break;
        }
        return true;
    }
}