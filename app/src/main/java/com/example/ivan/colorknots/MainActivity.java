package com.example.ivan.colorknots;

import android.content.Intent;
//import android.content.SharedPreferences;
import android.os.Bundle;
//import android.preference.PreferenceManager;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private EditText editText_trybok_v_kose;
    private EditText editText_dlina_kosbI;
    private EditText editText_skidka;
    int dlina_blije_k_vbIbr_kose;
    double osnovanie;
    double chislo;
    double ccc;
    double skidka;
    double skidka_rezylbtat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // back button pressed
            }
        });

        dlina_blije_k_vbIbr_kose = 1;
        Button tvName =  findViewById(R.id.button2);
        editText_trybok_v_kose =  findViewById(R.id.editText_trybok_v_kose);
        editText_dlina_kosbI =  findViewById(R.id.editText_dlina_kosbI);
        editText_skidka =  findViewById(R.id.editText_skidka);

        tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    skidka = 0;
                    if (!editText_skidka.getText().toString().equals("")){
                        skidka = Integer.parseInt(editText_skidka.getText().toString());
                    }

                    chislo = Integer.parseInt(editText_dlina_kosbI.getText().toString())*Integer.parseInt(editText_trybok_v_kose.getText().toString());
                    osnovanie = 5008;
                    ccc = (2.48178 - Math.log(chislo*100)/Math.log(osnovanie))*chislo;
                    String ggg = new DecimalFormat("#0.00").format(ccc) + " грн";
                    TextView textView =  findViewById(R.id.textView_rezylbtat);
                    textView.setText(ggg);
                    skidka_rezylbtat = ccc*(100-skidka)/100;
                    String ggg1 = new DecimalFormat("#0.00").format(skidka_rezylbtat) + " грн";
                    TextView textView_skidka =  findViewById(R.id.textView_skidka_rezylbtat);
                    textView_skidka.setText(ggg1);

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id) {

            case R.id.cenacos_raund:
                cenacosroundfynk();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
    //ЗАПУСК АКТИВИТИ НАСТРОЙКИ
//    private void nastroikifynk() {
//        Intent intent = new Intent(this, PrefActivity.class);
//        startActivity(intent);
//    }
    private void cenacosroundfynk() {
        Intent intent = new Intent(this, CenacosRound.class);
        startActivity(intent);
    }
    /*private void fotocosfynk() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }*/
}