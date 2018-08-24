package com.example.ivan.colorknots;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;



import android.preference.PreferenceManager;
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
    EditText editText_trybok_v_kose;
    EditText editText_dlina_kosbI;
    EditText editText_skidka;
    SharedPreferences sp;
    String Parser_DATA;
    String cena_blije_k_vbIbr_kose;
    int dlina_blije_k_vbIbr_kose;
    double fff;
    double skidka;
    double skidka_rezylbtat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        dlina_blije_k_vbIbr_kose = 1;
        Button tvName =  findViewById(R.id.button2);
        editText_trybok_v_kose =  findViewById(R.id.editText_trybok_v_kose);
        editText_dlina_kosbI =  findViewById(R.id.editText_dlina_kosbI);
        editText_skidka =  findViewById(R.id.editText_skidka);
        saveText("edit_text_cenakos_3_120", "450");
        saveText("edit_text_cenakos_3_180", "600");
        saveText("edit_text_cenakos_3_240", "785");
        saveText("edit_text_cenakos_3_360", "1175");
        saveText("edit_text_cenakos_4_120", "540");
        saveText("edit_text_cenakos_4_180", "740");
        saveText("edit_text_cenakos_4_240", "1090");
        saveText("edit_text_cenakos_4_360", "1490");
        tvName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    skidka = 0;
                    if (!editText_skidka.getText().toString().equals("")){
                        skidka = Integer.parseInt(editText_skidka.getText().toString());
                    }

                    if (Integer.parseInt(editText_trybok_v_kose.getText().toString())==3){
                        if (Integer.parseInt(editText_dlina_kosbI.getText().toString())==120){
                            cena_blije_k_vbIbr_kose = loadText("edit_text_cenakos_3_120");
                            dlina_blije_k_vbIbr_kose = 120;
                        }else if (Integer.parseInt(editText_dlina_kosbI.getText().toString())>=120&Integer.parseInt(editText_dlina_kosbI.getText().toString())<180){
                            cena_blije_k_vbIbr_kose = loadText("edit_text_cenakos_3_120");
                            dlina_blije_k_vbIbr_kose = 120;
                        }else if (Integer.parseInt(editText_dlina_kosbI.getText().toString())>=180&Integer.parseInt(editText_dlina_kosbI.getText().toString())<240){
                            cena_blije_k_vbIbr_kose = loadText("edit_text_cenakos_3_180");
                            dlina_blije_k_vbIbr_kose = 180;
                        }else if (Integer.parseInt(editText_dlina_kosbI.getText().toString())>=240&Integer.parseInt(editText_dlina_kosbI.getText().toString())<360){
                            cena_blije_k_vbIbr_kose = loadText("edit_text_cenakos_3_240");
                            dlina_blije_k_vbIbr_kose = 240;
                        }else if (Integer.parseInt(editText_dlina_kosbI.getText().toString())>=360){
                            cena_blije_k_vbIbr_kose = loadText("edit_text_cenakos_3_360");
                            dlina_blije_k_vbIbr_kose = 360;
                        }

                    }

                    else if (Integer.parseInt(editText_trybok_v_kose.getText().toString())==4){
                        if (Integer.parseInt(editText_dlina_kosbI.getText().toString())<120){
                            cena_blije_k_vbIbr_kose = loadText("edit_text_cenakos_4_120");
                            dlina_blije_k_vbIbr_kose = 120;
                        }
                        if (Integer.parseInt(editText_dlina_kosbI.getText().toString())>=120&Integer.parseInt(editText_dlina_kosbI.getText().toString())<180){
                            cena_blije_k_vbIbr_kose = loadText("edit_text_cenakos_4_120");
                            dlina_blije_k_vbIbr_kose = 120;
                        }
                        if (Integer.parseInt(editText_dlina_kosbI.getText().toString())>=180&Integer.parseInt(editText_dlina_kosbI.getText().toString())<240){
                            cena_blije_k_vbIbr_kose = loadText("edit_text_cenakos_4_180");
                            dlina_blije_k_vbIbr_kose = 180;
                        }
                        if (Integer.parseInt(editText_dlina_kosbI.getText().toString())>=240&Integer.parseInt(editText_dlina_kosbI.getText().toString())<360){
                            cena_blije_k_vbIbr_kose = loadText("edit_text_cenakos_4_240");
                            dlina_blije_k_vbIbr_kose = 240;
                        }
                        if (Integer.parseInt(editText_dlina_kosbI.getText().toString())>=360){
                            cena_blije_k_vbIbr_kose = loadText("edit_text_cenakos_4_360");
                            dlina_blije_k_vbIbr_kose = 360;
                        }

                    }
                    else if (Integer.parseInt(editText_trybok_v_kose.getText().toString())>4){
                        if (Integer.parseInt(editText_dlina_kosbI.getText().toString())<120){
                            cena_blije_k_vbIbr_kose = loadText("edit_text_cenakos_4_120");
                            dlina_blije_k_vbIbr_kose = 120*4/Integer.parseInt(editText_trybok_v_kose.getText().toString());
                        }
                        if (Integer.parseInt(editText_dlina_kosbI.getText().toString())>=120&Integer.parseInt(editText_dlina_kosbI.getText().toString())<180){
                            cena_blije_k_vbIbr_kose = loadText("edit_text_cenakos_4_120");
                            dlina_blije_k_vbIbr_kose = 120*4/Integer.parseInt(editText_trybok_v_kose.getText().toString());
                        }
                        if (Integer.parseInt(editText_dlina_kosbI.getText().toString())>=180&Integer.parseInt(editText_dlina_kosbI.getText().toString())<240){
                            cena_blije_k_vbIbr_kose = loadText("edit_text_cenakos_4_180");
                            dlina_blije_k_vbIbr_kose = 180*4/Integer.parseInt(editText_trybok_v_kose.getText().toString());
                        }
                        if (Integer.parseInt(editText_dlina_kosbI.getText().toString())>=240&Integer.parseInt(editText_dlina_kosbI.getText().toString())<360){
                            cena_blije_k_vbIbr_kose = loadText("edit_text_cenakos_4_240");
                            dlina_blije_k_vbIbr_kose = 240*4/Integer.parseInt(editText_trybok_v_kose.getText().toString());
                        }
                        if (Integer.parseInt(editText_dlina_kosbI.getText().toString())>=360){
                            cena_blije_k_vbIbr_kose = loadText("edit_text_cenakos_4_360");
                            dlina_blije_k_vbIbr_kose = 360*4/Integer.parseInt(editText_trybok_v_kose.getText().toString());
                        }

                    }





                    fff = Integer.parseInt(cena_blije_k_vbIbr_kose)*Integer.parseInt(editText_dlina_kosbI.getText().toString())/dlina_blije_k_vbIbr_kose;
                    //String ggg = Double.toString(fff) + " грн";
                    String ggg = new DecimalFormat("#0.00").format(fff) + " грн";
                    TextView textView =  findViewById(R.id.textView_rezylbtat);
                    textView.setText(ggg);
                    skidka_rezylbtat = fff*(100-skidka)/100;
                    String ggg1 = new DecimalFormat("#0.00").format(skidka_rezylbtat) + " грн";
                    TextView textView_skidka =  findViewById(R.id.textView_skidka_rezylbtat);
                    textView_skidka.setText(ggg1);

            }
        });
    }
    private void saveText(String nidname, String nidname_text) {
        sp = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor ed = sp.edit();
        ed.putString(nidname, nidname_text);
        ed.commit();
    }
    private String loadText(String nidname) {
        sp = PreferenceManager.getDefaultSharedPreferences(this);
        Parser_DATA = sp.getString(nidname, "");
        return Parser_DATA;
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
            /*case R.id.menu_cena_kos:
                cenakosfynk();
                break;*/
            case R.id.nastroiki:
                nastroikifynk();
                break;
            case R.id.cenacos_raund:
                cenacosroundfynk();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
    //ЗАПУСК АКТИВИТИ НАСТРОЙКИ
    private void nastroikifynk() {
        Intent intent = new Intent(this, PrefActivity.class);
        startActivity(intent);

    }
    private void cenacosroundfynk() {
        Intent intent = new Intent(this, CenacosRound.class);
        startActivity(intent);

    }
    //ЗАПУСК АКТИВИТИ НАСТРОЙКИ
    /*private void cenakosfynk() {
        Intent intent = new Intent(this, CenakosActivity.class);
        startActivity(intent);
        finish();
    }*/
}
