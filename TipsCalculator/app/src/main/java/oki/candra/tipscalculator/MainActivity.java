package oki.candra.tipscalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculate(View view)
    {
        EditText tagihan = (EditText) findViewById(R.id.tagihan);
        EditText persentip = (EditText) findViewById(R.id.persentip);
        EditText jmlorg = (EditText) findViewById(R.id.jmlorg);
        TextView result = (TextView) findViewById(R.id.result);

        double angtagihan, angpersen, angjml;
        String hasil = "";
        angtagihan = Double.parseDouble(tagihan.getText().toString());
        angpersen  = Double.parseDouble(persentip.getText().toString());
        angjml     = Double.parseDouble(jmlorg.getText().toString());

        hasil = "Tips       : "+(angtagihan*(angpersen/100))+"\n";
        hasil += "Total     : "+(angtagihan+(angtagihan*(angpersen/100)))+"\n";
        hasil += "Perorang  : "+((angtagihan+(angtagihan*(angpersen)/100))/angjml)+"\n";

        result.setText(hasil);



    }


}
