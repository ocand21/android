package syukron.habib.multifunctionapps;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA = "syukron.habib.multifunctionapps.Main"; //--> Contant

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showMessage(View view){
        //penggunaan explicit intent
        Intent intent = new Intent(this, ShowMessage.class);
        TextView txtMessage = (TextView) findViewById(R.id.txt_message);
        intent.putExtra(EXTRA ,txtMessage.getText().toString());
        startActivity(intent);
    }
    public void openBrowser(View view){
        //membuka activity yang akan mengeksekusi implicit intent
        Intent intent = new Intent(this, IntentExecutor.class);
        intent.putExtra(EXTRA, "browse");
        startActivity(intent);
    }
    public void openPhone(View view){
        //membuka activity yang akan mengeksekusi implicit intent
        Intent intent = new Intent(this, IntentExecutor.class);
        intent.putExtra(EXTRA, "phone");
        startActivity(intent);
    }
    public void openMap(View view){
        //membuka activity yang akan mengeksekusi implicit intent
        Intent intent = new Intent(this, IntentExecutor.class);
        intent.putExtra(EXTRA, "map");
        startActivity(intent);
    }
}
