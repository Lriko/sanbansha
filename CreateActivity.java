package com.example.administrator.activitytest;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;
import java.util.Set;

public class CreateActivity extends AppCompatActivity {
    HashMap<CheckBox,String> shen=new HashMap<CheckBox, String>();
    ArrayList<String> peizhi=new ArrayList<String>();
    ArrayList<String> peizhi1=new ArrayList<String>();
    CheckBox yuyanjia=null;
    CheckBox nvwu=null;
    CheckBox lieren=null;
    CheckBox baichi=null;
    CheckBox chuidizhe=null;
    CheckBox qiubite=null;
    CheckBox hunhun=null;
    CheckBox shouwei=null;
    CheckBox zhanglao=null;
    CheckBox bailangwang=null;
    EditText langren=null;
    EditText pingmin=null;
    Button  chuangjian=null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("                 创建游戏");
        setSupportActionBar(toolbar);
        toolbar.setNavigationIcon(R.mipmap.back);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        yuyanjia=(CheckBox)findViewById(R.id.checkBox);
        nvwu=(CheckBox)findViewById(R.id.checkBox2);
        lieren=(CheckBox)findViewById(R.id.checkBox3);
        baichi=(CheckBox)findViewById(R.id.checkBox4);
        chuidizhe=(CheckBox)findViewById(R.id.checkBox5);
        qiubite=(CheckBox)findViewById(R.id.checkBox7);
        hunhun=(CheckBox)findViewById(R.id.checkBox8);
        shouwei=(CheckBox)findViewById(R.id.checkBox6);
        zhanglao=(CheckBox)findViewById(R.id.checkBox9);
        bailangwang=(CheckBox)findViewById(R.id.checkBox10);
        langren=(EditText)findViewById(R.id.editText1);
        pingmin=(EditText)findViewById(R.id.editText2);
        chuangjian=(Button)findViewById(R.id.button3);
        shen.put(yuyanjia,"预言家");
        shen.put(nvwu,"女巫");
        shen.put(lieren,"猎人");
        shen.put(baichi,"白痴");
        shen.put(chuidizhe,"吹笛者");
        shen.put(qiubite,"丘比特");
        shen.put(hunhun,"混混");
        shen.put(shouwei,"守卫");
        shen.put(zhanglao,"长老");
        shen.put(bailangwang,"白狼王");
        Set<CheckBox>checkBoxes=shen.keySet();
        for(final CheckBox checkBox: checkBoxes)
        {
            checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    if(b)
                    {
                        peizhi.add(shen.get(checkBox));

                    }
                    else
                    {
                        peizhi.remove(shen.get(checkBox));
                    }
                }
            });
        }


     chuangjian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                AlertDialog.Builder dialog3=new AlertDialog.Builder(CreateActivity.this);
                dialog3.setTitle("法官");
                dialog3.setMessage("准备开始游戏吗?");
                dialog3.setPositiveButton("开始", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent=new Intent(CreateActivity.this,GameActivity.class);
                        intent.putStringArrayListExtra("peizhi",peizhi1);
                        startActivity(intent);
                    }
                });
                dialog3.show();
                for(int i=0;i<Integer.parseInt(langren.getText().toString());i++)
        {
            peizhi.add("狼人");
        }
        for(int i=0;i<Integer.parseInt(pingmin.getText().toString());i++)
        {
            peizhi.add("平民");
        }
                Random ran=new Random();

                while(peizhi.size()>0)
                {
                    int i=ran.nextInt(peizhi.size());
                    peizhi1.add(peizhi.get(i));
                    peizhi.remove(i);
                }

                for(int i=peizhi1.size()-1;i>=0;i--)
                {

                    AlertDialog.Builder dialog1=new AlertDialog.Builder(CreateActivity.this);
                    dialog1.setTitle("你的身份是:");
                    dialog1.setMessage(peizhi1.get(i));
                    dialog1.setPositiveButton("我认了",null);
                    dialog1.show();
                    AlertDialog.Builder dialog=new AlertDialog.Builder(CreateActivity.this);
                    dialog.setTitle("第"+(i+1)+"位玩家");
                    dialog.setMessage("准备好了吗?");
                    dialog.setPositiveButton("查看身份",null);
                    dialog.show();

                }



            }
        });
    }

}
