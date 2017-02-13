package endri.agung.shoprecipt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;

import java.sql.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void printRecipt(View view){
        //int [] num_barang = new int [5];
        String [] barang = new String [5];
        ArrayList<Integer> num_barang =new ArrayList<>();

        barang[0] = ((EditText) findViewById(R.id.meja_num)).getText().toString();
        barang[1] = ((EditText) findViewById(R.id.kursi_num)).getText().toString();
        barang[2] = ((EditText) findViewById(R.id.lemari_num)).getText().toString();
        barang[3] = ((EditText) findViewById(R.id.bipet_num)).getText().toString();
        barang[4] = ((EditText) findViewById(R.id.gucci_num)).getText().toString();

        num_barang.add(Integer.parseInt(barang[0]));
       num_barang.add(Integer.parseInt(barang[1]));
       num_barang.add(Integer.parseInt(barang[2]));
        num_barang.add(Integer.parseInt(barang[3]));
       num_barang.add(Integer.parseInt(barang[4]));



        //num_barang [0] = Integer.parseInt((barang[0]));
        //num_barang [1] = Integer.parseInt((barang[1]));
        //num_barang [2] = Integer.parseInt((barang[2]));
        //num_barang [3] = Integer.parseInt((barang[3]));
        //num_barang [4] = Integer.parseInt((barang[4]));

        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("main.barang.num", num_barang);

        //intent.putExtra("main.kursi.num", num_barang[1]);
        //intent.putExtra("main.lemari.num", num_barang[2]);
        //intent.putExtra("main.bipet.num", num_barang[3]);
        //intent.putExtra("main.gucci.num", num_barang[4]);

        startActivity(intent);

    }
}
