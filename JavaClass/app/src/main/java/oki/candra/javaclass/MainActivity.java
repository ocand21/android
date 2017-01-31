package oki.candra.javaclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public String showString;
    public TextView showText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showText = (TextView) findViewById(R.id.show_text);
        showString = "Manipulasi class Java Android";
        addSeparator();
        showText.setText(showString);
    }

    public void addSeparator()
    {
        showString += "\n------------------------------------------\n";
    }
}
