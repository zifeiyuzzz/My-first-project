package com.example.health;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class report extends AppCompatActivity {

    private TextView bmipj;
    private TextView jrlpf;
    private TextView jrlpj;
    private TextView sflpf;
    private TextView sflpj;
    private TextView gzpf;
    private TextView gzpj;
    private TextView dxpf;
    private TextView dxpj;
    private TextView BMIpf;
    private String bmi;
    private String jiroulv;
    private String shuifenlv;
    private String guzhi;
    private String daixie;
    private String bmIpf1;
    private String jrlpf1;
    private String sflpf1;
    private String gzpf1;
    private String dxpf1;
    private String xb;
    private Button bt_return2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.report);


        BMIpf = (TextView)findViewById(R.id.BMIpf);
        bmipj = (TextView)findViewById(R.id.BMIpj);
        jrlpf = (TextView)findViewById(R.id.jrlpf);
        jrlpj = (TextView)findViewById(R.id.jrlpj);
        sflpf = (TextView)findViewById(R.id.sflpf);
        sflpj = (TextView)findViewById(R.id.sflpj);
        gzpf = (TextView)findViewById(R.id.gzpf);
        gzpj = (TextView)findViewById(R.id.gzpj);
        dxpf = (TextView)findViewById(R.id.dxpf);
        dxpj = (TextView)findViewById(R.id.dxpj);

        Intent intent = getIntent();

        bmi = intent.getStringExtra("bmi");
        jiroulv = intent.getStringExtra("jiroulv");
        shuifenlv = intent.getStringExtra("shuifenlv");
        guzhi = intent.getStringExtra("guzhi");
        daixie = intent.getStringExtra("daixie");
        bmIpf1 = intent.getStringExtra("BMIpf");
        jrlpf1 = intent.getStringExtra("jrlpf");
        sflpf1 = intent.getStringExtra("sflpf");
        gzpf1 = intent.getStringExtra("gzpf");
        dxpf1 = intent.getStringExtra("dxpf");
        xb = intent.getStringExtra("xb");


        double BMI1,jiroulv1,shuifenlv1,guzhi1,daixie1;

        BMI1 = Double.parseDouble(bmi);
        jiroulv1 = Double.parseDouble(jiroulv);
        shuifenlv1 = Double.parseDouble(shuifenlv);
        guzhi1 = Double.parseDouble(guzhi);
        daixie1 = Double.parseDouble(daixie);


        BMIpf.setText(bmIpf1);
        jrlpf.setText(jrlpf1);
        sflpf.setText(sflpf1);
        gzpf.setText(gzpf1);
        dxpf.setText(dxpf1);

        if (xb.equals("男")){
            if (jiroulv1 <= 60) {
                jrlpj.setText("应多加锻炼");
            }
            else if(jiroulv1 >60 && jiroulv1 <= 65) {
                jrlpj.setText("应继续努力");
            }
            else if(jiroulv1 > 65 && jiroulv1 <= 70) {
                jrlpj.setText("应继续保持");
            }
            else return;


            if(daixie1 < 1300) {
                dxpj.setText("应多运动");
            }
            else if (daixie1 >= 1300 && daixie1 <= 1900) {
                dxpj.setText("继续保持");
            }
            else {
                dxpj.setText("应减少食量");
            }
        }
        else {
            if (jiroulv1 <= 55) {
                jrlpj.setText("应多运动");
            }
            else if(jiroulv1 >55 && jiroulv1 <= 60) {
                jrlpj.setText("应继续努力");
            }
            else if(jiroulv1 > 60 && jiroulv1 <= 65) {
                jrlpj.setText("应继续保持");
            }
            else return;


            if(daixie1 < 1100) {
                dxpj.setText("应多运动");
            }
            else if (daixie1 >= 1100 && daixie1 <= 1500) {
                dxpj.setText("继续保持");
            }
            else {
                dxpj.setText("应减少食量");
            }
        }
        if(BMI1 >= 10 && BMI1 <= 18.5) {
            bmipj.setText("应增加食量");
        }
        else if (BMI1 <= 24 && BMI1 > 18.5) {
            bmipj.setText("继续保持");
        }
        else if (BMI1 > 24 && BMI1<=28) {
            bmipj.setText("应减少食量");
        }
        else if (BMI1 > 28 && BMI1 <= 38) {
            bmipj.setText("应该注意，减少食量，多运动");
        }
        else return;
        if (shuifenlv1 < 70) {
            sflpj.setText("应增加摄水量");
        }
        else if(shuifenlv1 >= 70 && shuifenlv1 <= 80) {
            sflpj.setText("继续保持");
        }
        else{
            sflpj.setText("应减少摄水量");
        }

        if(guzhi1 < -4) {
            gzpj.setText("尤其注意不要磕碰");
        }
        else if (guzhi1 >= -4 && guzhi1 <= -1) {
            gzpj.setText("注意不要磕碰");
        }
        else {
            gzpj.setText("较为安全");
        }
        bt_return2 = (Button)findViewById(R.id.bt_return2);
        bt_return2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(report.this,input.class);
                startActivity(intent);
            }
        });
    }
}