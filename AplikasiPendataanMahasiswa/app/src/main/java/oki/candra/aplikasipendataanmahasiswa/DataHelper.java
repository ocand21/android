package oki.candra.aplikasipendataanmahasiswa;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ochand on 15/02/2017.
 */
public class DataHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "mahasiswa.db";
    public static final int DB_VERSION = 2;

    SQLiteDatabase db;


    public DataHelper(Context context) { super(context, DB_NAME, null, DB_VERSION);}

    public void onCreate(SQLiteDatabase db) { db.execSQL(Data.SQL_CREATE);}

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL(Data.SQL_DELETE);
        onCreate(db);
    }

    public void insertData(String nama, String nim, int jurusan, float nilai)
    {
        db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Data.COL_NAMA, nama);
        values.put(Data.COL_NIM, nim);
        values.put(Data.COL_JUR, jurusan);
        values.put(Data.COL_NILAI, nilai);

        db.insert(Data.TABLE_NAME, null, values);
    }

    public void updateData(String nama, String nim, int jurusan, float nilai)
    {
        db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Data.COL_NAMA, nama);
        values.put(Data.COL_NIM, nim);
        values.put(Data.COL_JUR, jurusan);
        values.put(Data.COL_NILAI, nilai);

        db.update(Data.TABLE_NAME, values, "Data._ID=" + Data._ID, null);
    }

    public void deleteData(String nim)
    {
        db = getWritableDatabase();
        db.delete(Data.TABLE_NAME, Data.COL_NIM + "='" + nim+"' ;", null);
    }




    public List<Data> getData()
    {
        db = getReadableDatabase();
        List<Data> data = new ArrayList<>();
        String [] projection = {Data._ID, Data.COL_NAMA, Data.COL_NIM, Data.COL_JUR, Data.COL_NILAI};
        String sortOrder = Data._ID;

        Cursor cursor = db.query(Data.TABLE_NAME, projection, null, null, null, null, sortOrder);

        Data newData;
        while (cursor.moveToNext())
        {
            newData = new Data(
                    cursor.getString(cursor.getColumnIndex(Data.COL_NAMA)),
                    cursor.getString(cursor.getColumnIndex(Data.COL_NIM)),
                    cursor.getInt(cursor.getColumnIndex(Data.COL_JUR)),
                    cursor.getFloat(cursor.getColumnIndex(Data.COL_NILAI))

            );
            data.add(newData);
        }
        cursor.close();

        return data;
    }






}
