package com.example.health;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class input extends AppCompatActivity {

    private EditText shengao;
    private EditText tizhong;
    private EditText nianling;
    private EditText xingbie;
    private  Button bt_report;
    private Button begin;
    private String bmIpf1;
    private String tzlpf1;
    private String jrlpf1;
    private String sflpf1;
    private String dxpf1;
    private String gzpf1;
    private String bmi1;
    private String jiroulv1;
    private String shuifenlv1;
    private String guzhi1;
    private String daixie1;
    private double tizhilv;
    private double jiroulv;
    private double daixie;
    private double shuifenlv;
    private double bmi;
    private int bmipf;
    private int tzlpf;
    private int sflpf;
    private int jrlpf;
    private int dxpf;
    private int gzpf;
    private String nsg;
    private String ntz;
    private String nnl;
    private String nxb;
    private double guzhi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.input);
        begin = findViewById(R.id.begin);
        bt_report = findViewById(R.id.bt_report);
        shengao = findViewById(R.id.shengao);
        tizhong =findViewById(R.id.tizhong);
        nianling = findViewById(R.id.nianling);
        xingbie = findViewById(R.id.xingbie);

        begin.setOnClickListener(new View.OnClickListener() {

            private double jiroulv;
            private double tizhilv;
            private int nl;
            private int tz;
            private int sg;
            private String namesg;
            private String nametz;
            private String namenl;
            private String namexb;

            @Override
            public void onClick(View v) {

                if (shengao.length() == 0 || tizhong.length() == 0 || nianling.length() == 0 || xingbie.length() == 0)
                    Toast.makeText(input.this, "请输入实际数值", Toast.LENGTH_SHORT).show();
                else {
                    nsg = shengao.getText().toString();
                    ntz = tizhong.getText().toString();
                    nnl = nianling.getText().toString();
                    nxb = xingbie.getText().toString();

                    sg = Integer.parseInt(nsg);
                    tz = Integer.parseInt(ntz);
                    nl = Integer.parseInt(nnl);


                    bmi = (double) tz / (((double) sg / 100.0) * ((double) sg / 100.0));
                    guzhi =  ((tz - nl) * 0.2);

                    namexb = xingbie.getText().toString();
                    namesg = shengao.getText().toString();
                    nametz = tizhong.getText().toString();
                    namenl = nianling.getText().toString();

                    Log.d("mlj", "身高" + namesg + "体重" + nametz + "年龄" + namenl + "性别" + namexb);

                    sg = Integer.parseInt(shengao.getText().toString());
                    tz = Integer.parseInt(tizhong.getText().toString());
                    nl = Integer.parseInt(nianling.getText().toString());

                    double bmi = tz / ((sg * sg) / 10000.0);

                    Log.d("mlj", "bmi" + bmi);

                    if (namexb.equals("男")) {
                        tizhilv = 1.2 * bmi + 0.23 * nl - 5.4 - 10.8;
                        jiroulv = 78.0 / ((double) tz * 2.0);
                        jiroulv *= 100;

                        Log.d("mlj", "体脂率" + tizhilv + "肌肉率" + jiroulv);

                        if (tizhilv <= 8 || tizhilv > 35 || bmi < 10 || bmi > 35 || jiroulv < 60 || jiroulv > 70)
                            Toast.makeText(input.this, "请输入实际数值", Toast.LENGTH_SHORT).show();
                        else {
                            Intent intent = new Intent(input.this, result.class);
                            intent.putExtra("sg", namesg);
                            intent.putExtra("tz", nametz);
                            intent.putExtra("nl", namenl);
                            intent.putExtra("xb", namexb);
                            startActivity(intent);
                        }
                    } else if (namexb.equals("女")) {
                        tizhilv = 1.2 * bmi + 0.23 * nl - 5.4;
                        jiroulv = 56 / ((double) tz * 2);
                        if (tizhilv <= 8 || tizhilv > 35 || bmi < 10 || bmi > 35 || jiroulv < 60 || jiroulv > 70 || "".equals(namenl) || "".equals(namesg) || "".equals(nametz) || "".equals(namexb))
                            Toast.makeText(input.this, "请输入实际数值", Toast.LENGTH_SHORT).show();
                        else {
                            Intent intent = new Intent(input.this, result.class);
                            intent.putExtra("sg", namesg);
                            intent.putExtra("tz", nametz);
                            intent.putExtra("nl", namenl);
                            intent.putExtra("xb", namexb);
                            startActivity(intent);
                        }
                    } else Toast.makeText(input.this, "请输入实际数值", Toast.LENGTH_SHORT).show();
                }
            }
        });

        bt_report.setOnClickListener(new View.OnClickListener() {
            private int nl;
            private int tz;
            private int sg;

            @Override
            public void onClick(View v) {

                nsg = shengao.getText().toString();
                ntz = tizhong.getText().toString();
                nnl = nianling.getText().toString();
                nxb = xingbie.getText().toString();






                if(shengao.length() == 0 || tizhong.length() == 0 || nianling.length() == 0 || xingbie.length() == 0 )
                    Toast.makeText(input.this, "请输入实际数值", Toast.LENGTH_SHORT).show();

                sg = Integer.parseInt(nsg);
                tz = Integer.parseInt(ntz);
                nl = Integer.parseInt(nnl);

                bmi = (double) tz / (((double) sg / 100.0) * ((double) sg / 100.0));
                if (nxb.equals("男")) {
                    tizhilv = 1.2 * bmi + 0.23 * nl - 5.4 - 10.8;
                    jiroulv = 78/((double) tz * 2);
                    jiroulv *= 100;
                    daixie = 13.7 * tz + 5.0 * sg - 6.8 * nl + 66;
                    shuifenlv = jiroulv * 1.2;
                    if (tizhilv > 8 && tizhilv <= 15){
                        tzlpf = 70;
                    }
                    else if (tizhilv > 15 && tizhilv <= 25) {
                        tzlpf = 100;
                    }
                    else if (tizhilv > 25 && tizhilv <=35) {
                        tzlpf = 70;
                    }
                    else{
                        Toast.makeText(input.this, "请输入实际数值", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (jiroulv <= 60) {
                        jrlpf = 60;
                    }
                    else if(jiroulv >60 && jiroulv <= 65) {
                        jrlpf = 80;
                    }
                    else if(jiroulv > 65 && jiroulv <= 70) {
                        jrlpf = 100;
                    }
                    else{
                        Toast.makeText(input.this, "请输入实际数值", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if(daixie < 1300) {
                        dxpf = 70;
                    }
                    else if (daixie >= 1300 && daixie <= 1900) {
                        dxpf = 100;
                    }
                    else {
                        dxpf = 70;
                    }
                }
                else {
                    tizhilv = 1.2 * bmi + 0.23 * nl - 5.4;
                    jiroulv = 56/((double) tz * 2);
                    jiroulv *= 100;
                    shuifenlv = jiroulv * 1.3;
                    daixie = 9.6 * tz + 1.8 * sg - 4.7 * nl +655;

                    if (tizhilv > 10 && tizhilv <= 20) {
                        tzlpf = 70;
                    }
                    else if (tizhilv > 20 && tizhilv <= 30) {
                        tzlpf = 100;
                    }
                    else if (tizhilv > 30 && tizhilv <= 45) {
                        tzlpf = 70;
                    }
                    else {
                        Toast.makeText(input.this, "请输入实际数值", Toast.LENGTH_SHORT).show();
                        return;
                    }


                    if (jiroulv <= 55) {
                        jrlpf = 60;
                    }
                    else if(jiroulv >55 && jiroulv <= 60) {
                        jrlpf = 80;
                    }
                    else if(jiroulv > 60 && jiroulv <= 65) {
                        jrlpf = 100;
                    }
                    else {
                        Toast.makeText(input.this, "请输入实际数值", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if(daixie < 1100) {
                        dxpf = 70;
                    }
                    else if (daixie >= 1100 && daixie <= 1500) { ;
                        dxpf = 100;
                    }
                    else {
                        dxpf = 70;
                    }
                }
                if(bmi >= 10 && bmi <= 18.5) {
                    bmipf = 75;
                }
                else if (bmi <= 24 && bmi > 18.5) {
                    bmipf = 100;
                }
                else if (bmi > 24 && bmi <=28) {
                    bmipf = 80;
                }
                else if (bmi > 28 && bmi <= 38) {
                    bmipf = 60;
                }
                else {
                    Toast.makeText(input.this, "请输入实际数值", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (shuifenlv < 70) {
                    sflpf = 70;
                }
                else if(shuifenlv >= 70 && shuifenlv <= 80) {
                    sflpf = 100;
                }
                else{
                    sflpf = 70;
                }

                if(guzhi < -4) {
                    gzpf = 50;
                }
                else if (guzhi >= -4 && guzhi <= -1) {
                    gzpf = 70;
                }
                else {
                    gzpf = 100;
                }
                bmIpf1 = String.valueOf(bmipf);
                tzlpf1 = String.valueOf(tzlpf);
                jrlpf1 = String.valueOf(jrlpf);
                sflpf1 = String.valueOf(sflpf);
                dxpf1 = String.valueOf(dxpf);
                gzpf1 = String.valueOf(gzpf);
                bmi1 = String.valueOf(bmi);
                jiroulv1 = String.valueOf(jiroulv);
                shuifenlv1 = String.valueOf(shuifenlv);
                guzhi1 = String.valueOf(guzhi);
                daixie1 = String.valueOf(daixie);

                if(tizhilv <= 8 || tizhilv > 35 || bmi < 10 || bmi > 35 || jiroulv < 60 || jiroulv > 70 )
                    Toast.makeText(input.this,"请输入实际数值",Toast.LENGTH_SHORT).show();
                else {
                    Intent intent = new Intent(input.this, report.class);
                    intent.putExtra("BMIpf", bmIpf1);
                    intent.putExtra("tzlpf", tzlpf1);
                    intent.putExtra("jrlpf", jrlpf1);
                    intent.putExtra("sflpf", sflpf1);
                    intent.putExtra("gzpf", gzpf1);
                    intent.putExtra("dxpf", dxpf1);
                    intent.putExtra("bmi", bmi1);
                    intent.putExtra("jiroulv", jiroulv1);
                    intent.putExtra("shuifenlv", shuifenlv1);
                    intent.putExtra("guzhi", guzhi1);
                    intent.putExtra("daixie", daixie1);
                    intent.putExtra("xb", nxb);
                    startActivity(intent);
                }
            }
        });
    }

}
