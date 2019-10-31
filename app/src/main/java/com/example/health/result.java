package com.example.health;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.text.DecimalFormat;

public class result extends AppCompatActivity {

    private TextView shengao;
    private TextView tizhong;
    private TextView BMI;
    private TextView tizhilv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        int sg1,tz1,nl1,BMIpf,tzlpf,jrlpf,sflpf,gzpf,dxpf;
        double bmi,tizhilv1,shuifenlv1,jiroulv1,guzhi1,daixie1,biaozhuntizhong,fenshu1;

        String tizhilv2,shuifenlv2,jiroulv2,guzhi2,daixie2,fenshu2,bmi2;
        shengao = findViewById(R.id.shengao);
        tizhong = (TextView)findViewById(R.id.tizhong);
        BMI = (TextView)findViewById(R.id.BMI);
        tizhilv = (TextView)findViewById(R.id.tizhilv);
        TextView shuifenlv = (TextView)findViewById(R.id.shuifenlv);
        TextView jiroulv = (TextView)findViewById(R.id.jiroulv);
        TextView guzhi = (TextView)findViewById(R.id.guzhi);
        TextView daixie = (TextView)findViewById(R.id.daixie);
        TextView tzlpj = (TextView)findViewById(R.id.tzlpj);
        TextView sflpj = (TextView)findViewById(R.id.sflpj);
        TextView jrlpj = (TextView)findViewById(R.id.jrlpj);
        TextView gzpj = (TextView)findViewById(R.id.gzpj);
        TextView dxpj = (TextView)findViewById(R.id.dxpj);
        TextView fenshu = (TextView)findViewById(R.id.fenshu);
        TextView sgpj = (TextView)findViewById(R.id.sgpj);
        TextView tzpj = (TextView)findViewById(R.id.tzpj);
        TextView BMIpj = (TextView)findViewById(R.id.BMIpj);

        Intent intent = getIntent();
        String sg = intent.getStringExtra("sg");
        String tz = intent.getStringExtra("tz");
        String nl = intent.getStringExtra("nl");
        String xb = intent.getStringExtra("xb");

        shengao.setText(sg);
        tizhong.setText(tz);

        sg1 = Integer.parseInt(sg);
        tz1 = Integer.parseInt(tz);
        nl1 = Integer.parseInt(nl);

        Log.d("mlj","身高"+sg1+"体重"+tz1+"年龄"+nl1);

        bmi = (double) tz1 / (((double)sg1/100.0) * ((double)sg1/100.0));
        guzhi1 = (tz1 - nl1)*0.2;
        if (xb.equals("男")) {
            tizhilv1 = 1.2 * bmi + 0.23 * nl1 - 5.4 - 10.8;
            jiroulv1 = 78/((double)tz1 * 2);
            jiroulv1 *= 100;
            shuifenlv1 = jiroulv1 * 1.2;
            daixie1 = 13.7 * tz1 + 5.0 * sg1 - 6.8 * nl1 + 66;
            biaozhuntizhong = (sg1 - 80) * 0.7;
            if(sg1 < 160)
                sgpj.setText("偏低");
            else
                sgpj.setText("标准");

            if (tizhilv1 > 8 && tizhilv1 <= 15){
                tzlpj.setText("过瘦");
                tzlpf = 70;
            }
            else if (tizhilv1 > 15 && tizhilv1 <= 25) {
                tzlpj.setText("正常");
                tzlpf = 100;
            }
            else if (tizhilv1 > 25 && tizhilv1 <=35) {
                    tzlpj.setText("超重");
                    tzlpf = 70;
            }
            else return;



            if (jiroulv1 <= 60) {
                jrlpj.setText("偏低");
                jrlpf = 60;
            }
            else if(jiroulv1 >60 && jiroulv1 <= 65) {
                jrlpj.setText("正常");
                jrlpf = 80;
            }
            else if(jiroulv1 > 65 && jiroulv1 <= 70) {
                jrlpj.setText("优秀");
                jrlpf = 100;
            }
            else return;


            if(daixie1 < 1300) {
                dxpj.setText("偏低");
                dxpf = 70;
            }
            else if (daixie1 >= 1300 && daixie1 <= 1900) {
                dxpj.setText("正常");
                dxpf = 100;
            }
            else {
                dxpj.setText("偏高");
                dxpf = 70;
            }
        }
        else {
            tizhilv1 = 1.2 * bmi + 0.23 * nl1 - 5.4;
            jiroulv1 = 56/((double)tz1 * 2);
            jiroulv1 *= 100;
            shuifenlv1 = jiroulv1 * 1.3;
            daixie1 = 9.6 * tz1 + 1.8 * sg1 - 4.7 * nl1 +655;
            biaozhuntizhong = (sg1 - 70) * 0.6;
            if(sg1 < 150)
                sgpj.setText("偏低");
            else
                sgpj.setText("标准");

            if (tizhilv1 > 10 && tizhilv1 <= 20) {
                tzlpj.setText("过瘦");
                tzlpf = 70;
            }
            else if (tizhilv1 > 20 && tizhilv1 <= 30) {
                tzlpj.setText("正常");
                tzlpf = 100;
            }
            else if (tizhilv1 > 30 && tizhilv1 <= 45) {
                tzlpj.setText("超重");
                tzlpf = 70;
            }
            else return;


            if (jiroulv1 <= 55) {
                jrlpj.setText("偏低");
                jrlpf = 60;
            }
            else if(jiroulv1 >55 && jiroulv1 <= 60) {
                jrlpj.setText("正常");
                jrlpf = 80;
            }
            else if(jiroulv1 > 60 && jiroulv1 <= 65) {
                jrlpj.setText("优秀");
                jrlpf = 100;
            }
            else return;


            if(daixie1 < 1100) {
                dxpj.setText("偏低");
                dxpf = 70;
            }
            else if (daixie1 >= 1100 && daixie1 <= 1500) {
                dxpj.setText("正常");
                dxpf = 100;
            }
            else {
                dxpj.setText("偏高");
                dxpf = 70;
            }
        }

        if (tz1 > biaozhuntizhong*(1 - 0.1) && tz1 < biaozhuntizhong * (1 + 0.1))
            tzpj.setText("正常");
        else if ((tz1 > biaozhuntizhong*(1 - 0.2) && tz1 < biaozhuntizhong * (1 - 0.1)))
            tzlpj.setText("偏轻");
        else if (tz1 > biaozhuntizhong*(1 + 0.1) && tz1 < biaozhuntizhong * (1 + 0.2))
            tzlpj.setText("偏重");
        else if(tz1 < biaozhuntizhong * (1 - 0.2))
            tzpj.setText("营养不良");
        else
            tzpj.setText("肥胖");

        if(bmi >= 10 && bmi <= 18.5) {
            BMIpj.setText("过轻");
            BMIpf = 75;
        }
        else if (bmi <= 24 && bmi > 18.5) {
            BMIpj.setText("正常");
            BMIpf = 100;
        }
        else if (bmi > 24 && bmi<=28) {
            BMIpj.setText("超重");
            BMIpf = 80;
        }
        else if (bmi > 28 && bmi <= 38) {
            BMIpj.setText("肥胖");
            BMIpf = 60;
        }
        else return;
        if (shuifenlv1 < 70) {
            sflpj.setText("偏低");
            sflpf = 70;
        }
        else if(shuifenlv1 >= 70 && shuifenlv1 <= 80) {
            sflpj.setText("正常");
            sflpf = 100;
        }
        else{
            sflpj.setText("偏高");
            sflpf = 70;
        }

        if(guzhi1 < -4) {
            gzpj.setText("风险高");
            gzpf = 50;
        }
        else if (guzhi1 >= -4 && guzhi1 <= -1) {
            gzpj.setText("中度风险");
            gzpf = 70;
        }
        else {
            gzpj.setText("风险低");
            gzpf = 100;
        }

        fenshu1 = (BMIpf * 0.5 + tzlpf * 0.1 + sflpf * 0.1 + jrlpf * 0.1 + gzpf * 0.1 + dxpf * 0.1);

        String bmi1 = String.valueOf(bmi);
        DecimalFormat df   = new DecimalFormat("######0.0");
        tizhilv2 = df.format(tizhilv1);
        shuifenlv2 = df.format(shuifenlv1);
        jiroulv2 = df.format(jiroulv1);
        guzhi2 = df.format(guzhi1);
        daixie2 = df.format(daixie1);
        fenshu2 = df.format(fenshu1);
        bmi2 = df.format(bmi);

        BMI.setText(bmi2);
        tizhilv.setText(tizhilv2+"%");
        jiroulv.setText(jiroulv2+"%");
        shuifenlv.setText(shuifenlv2+"%");
        guzhi.setText(guzhi2);
        daixie.setText(daixie2);
        fenshu.setText(fenshu2);
        Button next=(Button)findViewById(R.id.bt_return1);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(result.this,input.class);
                startActivity(intent);
            }
        });
    }
}
