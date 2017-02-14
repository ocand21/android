package oki.candra.aplikasikeuangan;

import android.content.Intent;
import android.support.annotation.IntegerRes;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    String strShow = "";
    TextView txtShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    protected void onResume()
    {
        super.onResume();

        ListView ListTransaksi = (ListView) findViewById(R.id.list_transaksi);


        TransaksiHelper dbHelper = new TransaksiHelper(this);
        final List<Transaksi> ListTrans = dbHelper.getTransaksi();

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ListTrans);
        ListTransaksi.setAdapter(adapter);

        int saldo = 0;
        for (int i=0;i<ListTrans.size();i++){
            if(ListTrans.get(i).jenis==1){
                saldo += ListTrans.get(i).jumlah;
            } else {
                saldo += ListTrans.get(i).jumlah;
            }

        }

        TextView txtSaldo = (TextView) findViewById(R.id.txt_saldo);
        txtSaldo.setText("Saldo tersisa : "+ Integer.toString(saldo));

        ListTransaksi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Transaksi transaksi = ListTrans.get(position);
                Intent intent = new Intent(parent.getContext(),DetailActivity.class);
                intent.putExtra("transaksi.detail", transaksi);
                startActivity(intent);

            }
        });




        //for (int i =0; i<ListTrans.size();i++){
          //  Transaksi trans = ListTrans.get(i);
            //strShow += " =====================================\n";
            //strShow += trans.nama+" ["+trans.getJenis()+"] : "+trans.jumlah
              //      +"\n"+trans.keterangan;

        //}
        //txtShow.setText(strShow);
    }

    public void addTransaksi(View view){
        Intent intent = new Intent(this, FormActivity.class);
        startActivity(intent);
    }
}
