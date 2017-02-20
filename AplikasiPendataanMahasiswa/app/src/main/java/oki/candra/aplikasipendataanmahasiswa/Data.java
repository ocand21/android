package oki.candra.aplikasipendataanmahasiswa;

import android.provider.BaseColumns;

import java.io.Serializable;

/**
 * Created by Ochand on 15/02/2017.
 */
public class Data implements BaseColumns, Serializable {

    public String nama;
    public String nim;
    public int jurusan; // 1 = S2, 2 = S1, 3 = D4, 4 = D3
    public float nilai;

    public Data(String nama, String nim, int jurusan, float nilai)
    {
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
        this.nilai = nilai;
    }

    public String getJurusan()
    {
        if (this.jurusan==1)
        {
            return "S2-TI";
        }
        else if (this.jurusan==2)
        {
            return "S1-TI";
        }
        else if (this.jurusan==3)
        {
            return "D4-TI";
        }
        else if (this.jurusan==4)
        {
            return "D3-TI";
        }

        return "S1-TI";

    }

    public String toString() { return this.nama+": "+this.nilai;}

    public static final String TABLE_NAME = "mahasiswa";
    public static final String COL_NAMA = "namemhs";
    public static final String COL_NIM  = "nimmhs";
    public static final String COL_JUR = "jurusanmhs";
    public static final String COL_NILAI = "nilaimhs";

    public static final String SQL_CREATE = "create table "+TABLE_NAME
            +" ("+_ID+" integer primary_key,"
            +" "+COL_NAMA+" text,"
            +" "+COL_NIM+" text,"
            +" "+COL_JUR+" integer,"
            +" "+COL_NILAI+" float)";
    public static final String SQL_DELETE = "drop table if exist "+TABLE_NAME;




}
