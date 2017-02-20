package oki.candra.aplikasipendataanmahasiswa;

import android.support.annotation.StringRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    private String [] jurusanStr = {"S2-TI","S1-TI","D4-TI","D3-TI"};
    private EditText edtNama, edtNim, edtNilai;
    private Spinner spnJurusan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        spnJurusan = (Spinner) findViewById(R.id.spn_jurusan);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, jurusanStr);
        spnJurusan.setAdapter(adapter);

        edtNama = (EditText) findViewById(R.id.edt_nama);
        edtNim = (EditText) findViewById(R.id.edt_nim);
        edtNilai = (EditText) findViewById(R.id.edt_nilai);
    }

    public void saveData(View view)
    {
        DataHelper dbHelper = new DataHelper(this);
        String nama = edtNama.getText().toString();
        String nim = edtNim.getText().toString();
        int jurusan = spnJurusan.getSelectedItemPosition()+1;
        float nilai = Float.parseFloat(edtNilai.getText().toString());

        dbHelper.insertData(nama, nim, jurusan, nilai);
        Log.d("form mahasiswa", nama+" - "+nim+" - "+Integer.toString(jurusan)+" - "+Float.toString(nilai));

        Toast.makeText(this, "Data "+nama+" berhasil disimpan", Toast.LENGTH_SHORT).show();

        finish();
    }


}
