package com.sup.administrator.product2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText e1,e2,e3,e4,e5,e6,e7;

    Button b,b1;
    String s1,s2,s3,s4,s5,s6,s7;
    pddb p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.mod);
        e2=(EditText)findViewById(R.id.cod);
        e3=(EditText)findViewById(R.id.nam);
        e4=(EditText)findViewById(R.id.sel);
        e5=(EditText)findViewById(R.id.pri);
        e6=(EditText)findViewById(R.id.oname);
        e7=(EditText)findViewById(R.id.mob);
        b=(Button)findViewById(R.id.sub);
        b1=(Button)findViewById(R.id.sea);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),search.class);
                startActivity(i);
            }
        });

        p=new pddb(this);
        p.getWritableDatabase();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                s3=e3.getText().toString();
                s4=e4.getText().toString();
                s5=e5.getText().toString();
                s6=e6.getText().toString();
                s7=e7.getText().toString();
                Log.d("mod",s1);
                Log.d("cod",s2);
                Log.d("nam",s3);
                Log.d("sel",s4);
                Log.d("pri",s5);
                Log.d("on",s6);
                Log.d("mob",s7);
                boolean status=p.insert(s1,s2,s3,s4,s5,s6,s7);
                if(status==true)
                {
                    Toast.makeText(getApplicationContext(),"success",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
