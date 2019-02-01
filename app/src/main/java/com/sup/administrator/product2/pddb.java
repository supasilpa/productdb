package com.sup.administrator.product2;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 1/30/2019.
 */
public class pddb extends SQLiteOpenHelper {
    public static final String dbname="product.db";
    public static final String tablename="product";
    public static final String col1="id";
    public static final String col2="mod";
    public static final String col3="cod";
    public static final String col4="nam";
    public static final String col5="sel";
    public static final String col6="pri";
    public static final String col7="oname";
    public static final String col8="mob";
    public pddb(Context context) {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
 String query="create table "+tablename+"("+col1+ " integer primary key autoincrement, "+col2+ " text, "+col3+ " text, "+col4+ " text, "+col5+ " text, "+col6+ " text, "+col7+ " text, "+col8+ " text )";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String query="drop table if exists "+tablename;
        sqLiteDatabase.execSQL(query);
        onCreate(sqLiteDatabase);

    }
    public boolean insert(String mod,String  cod,String nam,String sel,String pri,String oname,String mob)
    {
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(col2,mod);
        cv.put(col3,cod);
        cv.put(col4,nam);
        cv.put(col5,sel);
        cv.put(col6,pri);
        cv.put(col7,oname);
        cv.put(col8,mob);
        Long status=sqLiteDatabase.insert(tablename,null,cv);
        if(status==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    public Cursor search(String code)
    {
        SQLiteDatabase sq=this.getWritableDatabase();
        Cursor cur=sq.rawQuery("SELECT * FROM "+tablename+" WHERE "+col3+"='"+code+"'",null);
        return cur;
    }
    public boolean update(String id,String model,String name,String sellername,String price,String ownername,String mobileno){
        SQLiteDatabase sq=this.getWritableDatabase();
        ContentValues cv=new ContentValues();
        cv.put(col2,model);
        cv.put(col4,name);
        cv.put(col5,sellername);
        cv.put(col6,price);
        cv.put(col7,ownername);
        cv.put(col8,mobileno);
        long status=sq.update(tablename,cv,col1 + "=" +id,null);
        if(status==-1)
        {
            return false;

        }
        else
        {
            return true;
        }
    }
    public boolean delete(String id)
    {
        SQLiteDatabase sq=this.getWritableDatabase();
        long status=sq.delete(tablename,col1+"="+id,null);
        if(status==-1)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

}
