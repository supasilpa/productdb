package com.sup.administrator.product2;

import android.app.Dialog;
import android.content.DialogInterface;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class search extends AppCompatActivity {
EditText e,e1,e2,e3,e4,e5,e6;
    Button b,b1,b2;
    String s,s1,s2,s3,s4,s5,s6,s7,u1,u2,u3,u4,u5,u6,getid;
    TextView t1,t2,t3,t4,t5,t6;
    pddb p;
AlertDialog.Builder build;
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
        b2=(Button)findViewById(R.id.delete);
     build = new AlertDialog.Builder(this);
        build.setTitle("Confirm");
        build.setMessage("are you sure want to delete");
        build.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                boolean status=p.delete(getid);
                if(status==true)
                {
                    Toast.makeText(getApplicationContext(),"deleted",Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();
                }
                Toast.makeText(getApplicationContext(),"yes clicked",Toast.LENGTH_LONG).show();
                dialogInterface.dismiss();
            }
        });
        build.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(),"No clicked",Toast.LENGTH_LONG).show();
                dialogInterface.dismiss();

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                boolean status=p.delete(getid);
//                if(status==true)
//                {
//                    Toast.makeText(getApplicationContext(),"deleted",Toast.LENGTH_LONG).show();
//                }
//                else
//                {
//                    Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_LONG).show();
//                }
                AlertDialog alert=build.create();
                alert.show();
            }
        });
        b1=(Button)findViewById(R.id.update);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              u1=e1.getText().toString() ;
                u2=e2.getText().toString() ;
                u3=e3.getText().toString()  ;
                u4=e4.getText().toString()  ;
                u5=e5.getText().toString()  ;
                u6=e6.getText().toString()  ;
//                Toast.makeText(getApplicationContext(),u1,Toast.LENGTH_LONG).show();
                boolean status=p.update(getid,u1,u2,u3,u4,u5,u6);
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
                        getid=cur.getString(0);
                        Toast.makeText(getApplicationContext(),getid,Toast.LENGTH_LONG).show();

//                        Toast.makeText(getApplicationContext(),s1,Toast.LENGTH_LONG).show();
                        b1.setVisibility(View.VISIBLE);
                        b2.setVisibility(View.VISIBLE);






                    }
                }
            }
        });
    }
}
