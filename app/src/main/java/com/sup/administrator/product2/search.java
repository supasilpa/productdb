package com.sup.administrator.product2;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class search extends AppCompatActivity {
EditText e,e1,e2,e3,e4,e5,e6;
    Button b;
    String s,s1,s2,s3,s4,s5,s6,s7;
    TextView t1,t2,t3,t4,t5,t6;
    pddb p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        e=(EditText)findViewById(R.id.cod);
        e1=(EditText)findViewById(R.id.m);
        e2=(EditText)findViewById(R.id.n);
        e3=(EditText)findViewById(R.id.o);
        e4=(EditText)findViewById(R.id.p);
        e5=(EditText)findViewById(R.id.q);
        e6=(EditText)findViewById(R.id.r);
       t1=(TextView) findViewById(R.id.t1);
        t2=(TextView) findViewById(R.id.t2);
        t3=(TextView) findViewById(R.id.t3);
        t4=(TextView) findViewById(R.id.t4);
        t5=(TextView) findViewById(R.id.t5);
        t6=(TextView) findViewById(R.id.t6);
        b=(Button)findViewById(R.id.sear);
        p=new pddb(this);
        p.getWritableDatabase();
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s=e.getText().toString();
                Cursor cur=p.search(s);
                if (cur.getCount()==0)
                {
                    Toast.makeText(getApplicationContext(),"no data found",Toast.LENGTH_LONG).show();
                }
                else
                {
                    while (cur.moveToNext())
                    {
                        s1=cur.getString(1);
//                        s2=cur.getString(2);
                        s3=cur.getString(3);
                        s4=cur.getString(4);
                        s5=cur.getString(5);
                        s6=cur.getString(6);
                        s7=cur.getString(7);
                        t1.setVisibility(View.VISIBLE);

                        e1.setVisibility(View.VISIBLE);
                        e1.setText(s1);
                        t2.setVisibility(View.VISIBLE);
                        e2.setVisibility(View.VISIBLE);
                        e2.setText(s3);
                        t3.setVisibility(View.VISIBLE);
                        e3.setVisibility(View.VISIBLE);
                        e3.setText(s4);
                        t4.setVisibility(View.VISIBLE);
                        e4.setVisibility(View.VISIBLE);
                        e4.setText(s5);
                        t5.setVisibility(View.VISIBLE);
                        e5.setVisibility(View.VISIBLE);
                        e5.setText(s6);
                        t6.setVisibility(View.VISIBLE);
                        e6.setVisibility(View.VISIBLE);
                        e6.setText(s7);

//                        Toast.makeText(getApplicationContext(),s1,Toast.LENGTH_LONG).show();







                    }
                }
            }
        });
    }
}
