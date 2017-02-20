package oki.candra.aplikasipendataanmahasiswa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    protected void onResume()
    {
        super.onResume();

        ListView ListData = (ListView) findViewById(R.id.list_data);

        DataHelper dbHelper = new DataHelper(this);
        final List<Data> ListDataMhs = dbHelper.getData();

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ListDataMhs);
        ListData.setAdapter(adapter);

        float ipkavg = 0;
        for (int i=0;i<ListDataMhs.size();i++)
        {
                ipkavg+= ListDataMhs.get(i).nilai;
        }
        ipkavg = ipkavg/ListDataMhs.size();

        float sumipk = 0;
        for (int k=0;k<ListDataMhs.size();k++)
        {
            sumipk+= ListDataMhs.get(k).nilai;
        }


        for (int x=0;x<ListDataMhs.size();x++)
        {

            Data maxipk;
            maxipk = ListDataMhs.get(x);
            for (int j=0;j<ListDataMhs.size();j++)
            {
                if (ListDataMhs.get(j).nilai>maxipk.nilai)
                {
                    maxipk = ListDataMhs.get(j);
                }
            }
            TextView txtMaxIpk = (TextView) findViewById(R.id.txt_maxipk);
            txtMaxIpk.setText("Ipk Tertinggi :"+Float.toString(maxipk.nilai));

        }

        for (int z=0;z<ListDataMhs.size();z++)
        {
            Data minipk;
            minipk = ListDataMhs.get(z);
            for (int l=0;l<ListDataMhs.size();l++)
            {
                if (ListDataMhs.get(l).nilai<minipk.nilai)
                {
                    minipk = ListDataMhs.get(l);
                }
            }
            TextView txtMinIpk = (TextView) findViewById(R.id.txt_minipk);
            txtMinIpk.setText("Ipk Terendah  :"+Float.toString(minipk.nilai));
        }

















        TextView txtIpkAvg = (TextView) findViewById(R.id.txt_avgipk);
        TextView txtIpkSum = (TextView) findViewById(R.id.txt_sumipk);

        txtIpkAvg.setText("Rata-Rata IPK : "+Float.toString(ipkavg));
        txtIpkSum.setText("Total IPK : "+Float.toString(sumipk));



        ListData.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Data data = ListDataMhs.get(position);
                Intent intent = new Intent(parent.getContext(),DetailActivity.class);
                intent.putExtra("data.detail", data);
                startActivity(intent);

            }
        });
    }

    public void addData(View view)
    {
        Intent intent = new Intent(this, FormActivity.class);
        startActivity(intent);
    }
}
