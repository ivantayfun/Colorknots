package com.example.ivan.colorknots;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.text.DecimalFormat;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class CenacosRound extends AppCompatActivity {
    EditText editText_trybok_v_kose;
    EditText editText_dlina_ovala;
    EditText editText_shirina_ovala;
    EditText editText_skidka;

    int dlina_blije_k_vbIbr_kose;
    double dlina_cosu;
    double skidka;
    double chislo;
    double osnovanie;
    double ccc;
    double skidka_rezylbtat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cenacosround);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        dlina_blije_k_vbIbr_kose = 1;
        Button tvName =  findViewById(R.id.button2);
        editText_trybok_v_kose =  findViewById(R.id.editText_trybok_v_kose);
        editText_dlina_ovala =  findViewById(R.id.editText_dlina_ovala);
        editText_shirina_ovala =  findViewById(R.id.editText_shirina_ovala);
        editText_skidka =  findViewById(R.id.editText_skidka);
        tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                skidka = 0;
                if (!editText_skidka.getText().toString().equals("")){
                    skidka = Integer.parseInt(editText_skidka.getText().toString());
                }
                if (Integer.parseInt(editText_dlina_ovala.getText().toString())<Integer.parseInt(editText_shirina_ovala.getText().toString()))
                {
                    dlina_cosu = Integer.parseInt(editText_dlina_ovala.getText().toString()) * 3.14 + (Integer.parseInt(editText_shirina_ovala.getText().toString())-Integer.parseInt(editText_dlina_ovala.getText().toString())) * 2;

                } else {
                    dlina_cosu = Integer.parseInt(editText_shirina_ovala.getText().toString()) * 3.14 + (Integer.parseInt(editText_dlina_ovala.getText().toString())-Integer.parseInt(editText_shirina_ovala.getText().toString())) * 2;
                }
                //master
                String ggg_dlina = dlina_cosu + " см";
                TextView textView1 =  findViewById(R.id.textView_rezylbtat_dlina);
                textView1.setText(ggg_dlina);
                chislo = dlina_cosu*Integer.parseInt(editText_trybok_v_kose.getText().toString());
                osnovanie = 5008;
                ccc = (2.48178 - Math.log(chislo*100)/Math.log(osnovanie))*chislo;
                String ggg = new DecimalFormat("#0.00").format(ccc) + " грн";
                TextView textView =  findViewById(R.id.textView_rezylbtat);
                textView.setText(ggg);
                skidka_rezylbtat = ccc*(100-skidka)/100;
                String ggg2 = new DecimalFormat("#0.00").format(skidka_rezylbtat) + " грн";
                TextView textView_skidka =  findViewById(R.id.textView_skidka_rezylbtat);
                textView_skidka.setText(ggg2);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_cenacosround, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        switch (id) {
            case R.id.glavnaya:
                mainactivityfynk();
                break;
            case 11:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
    //ЗАПУСК АКТИВИТИ НАСТРОЙКИ
    /*private void nastroikifynk() {
        Intent intent = new Intent(this, PrefActivity.class);
        startActivity(intent);
        finish();

    }*/
    private void mainactivityfynk() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
