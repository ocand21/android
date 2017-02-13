package endri.agung.shoprecipt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent =getIntent();
        //int [] num_barang =new int [5];
        ArrayList<Integer> num_barang =new ArrayList<>();
        num_barang= (ArrayList<Integer>) intent.getSerializableExtra("main.barang.num");

        //num_barang[0] = intent.getIntExtra("main.meja.num", 0);
        //num_barang[1] = intent.getIntExtra("main.kursi.num", 0);
        //num_barang[2] = intent.getIntExtra("main.lemari.num", 0);
        //num_barang[3] = intent.getIntExtra("main.bipet.num", 0);
        //num_barang[4] = intent.getIntExtra("main.gucci.num", 0);

        int[] harga_barang = new int[5];
        harga_barang[0] = 300000;
        harga_barang[1] = 300000;
        harga_barang[2] = 300000;
        harga_barang[3] = 300000;
        harga_barang[4] = 300000;

        int [] id_num = {R.id.meja_num, R.id.kursi_num,R.id.lemari_num,R.id.bipet_num,R.id.gucci_num};
        int [] id_total = {R.id.meja_total, R.id.kursi_total, R.id.lemari_total, R.id.bipet_total, R.id.gucci_total};

        int total =0;
        for (int i = 0; i<5; i ++){
            total += harga_barang[i] *num_barang.get(i);
            ((TextView) findViewById(id_num[i])).setText(Integer.toString(num_barang.get(i)));
            ((TextView) findViewById(id_total[i])).setText(Integer.toString(num_barang.get(i) * harga_barang[i]));

        }

        ((TextView) findViewById(R.id.grand_total)).setText(Integer.toString(total));
  }

}
