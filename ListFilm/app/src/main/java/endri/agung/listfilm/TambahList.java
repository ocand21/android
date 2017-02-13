package endri.agung.listfilm;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class TambahList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        String [] rating={"5.5","6.0","6.5","7.0","7.5","8.0","8.5","9.0","9.5"};
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tambah_list);

        Spinner spinner = (Spinner) findViewById(R.id.pilihrating);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                                            android.R.layout.simple_spinner_item, rating);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);



    }
    public void formadd(View view)
    {
        String title = ((EditText) findViewById(R.id.inpjudul)).getText().toString();
        int year = Integer.parseInt(((EditText) findViewById(R.id.inpyear)).getText().toString());
        double rating = Double.parseDouble(((Spinner) findViewById(R.id.pilihrating)).getSelectedItem().toString());
        String description = ((EditText) findViewById(R.id.inpdeskripsi)).getText().toString();

        Movie movie =new Movie(title,description,rating,year);

        Intent intent =new Intent();
        intent.putExtra("endri.agung.listfilm", movie);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }


}
