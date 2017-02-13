package syukron.habib.multifunctionapps;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SendEmailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_email);

    }

    public void SendEmail(View view)
    {
        EditText txtPenerima = (EditText) findViewById(R.id.penerima);
        EditText txtJudul    = (EditText) findViewById(R.id.judul);
        EditText txtKonten   = (EditText) findViewById(R.id.konten);

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);

        emailIntent.setData(Uri.parse("mailto:"+txtPenerima.getText().toString()));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, "okicandra21@gmail.com");
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, txtJudul.getText().toString());
        emailIntent.putExtra(Intent.EXTRA_TEXT, txtKonten.getText().toString());

        startActivity(emailIntent);

        //try {
        //    startActivity(Intent.createChooser(emailIntent, "Send mail ...."));
        //    finish();
        //}
        //catch (android.content.ActivityNotFoundException ex)
        //{
        //    Toast.makeText(SendEmailActivity.this,
        //            "There is no email client Installed", Toast.LENGTH_SHORT).show();
        //}


    }
}
