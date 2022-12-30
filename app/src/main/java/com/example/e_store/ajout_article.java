package com.example.e_store;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class ajout_article extends AppCompatActivity {
    EditText programName, programDt;
    Button ajouter;
    RadioGroup type;
    RadioButton Pc, Smartphone, TV, Autre;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajout_article);
        programName = findViewById(R.id.programName);
        programDt = findViewById(R.id.programDt);
        type = findViewById(R.id.type);
        Pc = findViewById(R.id.Pc);
        Smartphone = findViewById(R.id.Smartphone);
        TV = findViewById(R.id.TV);
        Autre = findViewById(R.id.Autre);
        ajouter = findViewById(R.id.ajouter);
        ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int x = type.getCheckedRadioButtonId();
                if (findViewById(x) == Pc){
                    Intent intent = new Intent(ajout_article.this,pcportable.class);
                    intent.putExtra("programName", programName.getText().toString());
                    intent.putExtra("programDt", programDt.getText().toString());
                    startActivity(intent);
                } else if (findViewById(x) == Smartphone){
                    Intent intent = new Intent(ajout_article.this,smartphone.class);
                    intent.putExtra("programName", programName.getText().toString());
                    intent.putExtra("programDt", programDt.getText().toString());
                    startActivity(intent);
                }else if (findViewById(x) == TV){
                    Intent intent = new Intent(ajout_article.this,smartTv.class);
                    intent.putExtra("programName", programName.getText().toString());
                    intent.putExtra("programDt", programDt.getText().toString());
                    startActivity(intent);
                }else if (findViewById(x) == Autre){
                    Intent intent = new Intent(ajout_article.this,autreEquipement.class);
                    intent.putExtra("programName", programName.getText().toString());
                    intent.putExtra("programDt", programDt.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.o2:
                Intent intent = new Intent(ajout_article.this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.o3:
                Intent intent1 = new Intent(ajout_article.this,pcportable.class);
                startActivity(intent1);
                break;
            case R.id.o4: {
                Intent intent2 = new Intent(ajout_article.this,smartphone.class);
                startActivity(intent2);
            }
            break;
            case R.id.o5: {
                Intent intent2 = new Intent(ajout_article.this,smartTv.class);
                startActivity(intent2);
            }
            break;
            case R.id.o6: {
                Intent intent2 = new Intent(ajout_article.this,ajout_article.class);
                startActivity(intent2);
            }
            break;
        }
        return true;
    }
}