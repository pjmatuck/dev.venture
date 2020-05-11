package learn.java.implicitintentsreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewIntentReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewIntentReceiver = findViewById(R.id.textView_intent_receiver);

        Intent intent = getIntent();
        Uri uri = intent.getData();
        if (uri != null){
            textViewIntentReceiver.setText(uri.toString());
        }
    }
}
