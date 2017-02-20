package oki.candra.aplikasipendataanmahasiswa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        Data data = (Data) intent.getSerializableExtra("data.detail");

        ((TextView)findViewById(R.id.det_nama)).setText(data.nama);
        ((TextView)findViewById(R.id.det_jurusan)).setText(data.getJurusan());
        ((TextView)findViewById(R.id.det_nilai)).setText(Float.toString(data.nilai));
        ((TextView)findViewById(R.id.det_nim)).setText(data.nim);
    }

    public void  deleteData(View view)
    {
        TextView detNim = (TextView) findViewById(R.id.det_nim);
        DataHelper dbHelper = new DataHelper(this);
        String nim = detNim.getText().toString();
        dbHelper.deleteData(nim);

        finish();

    }



}
