package learn.java.implicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextWebAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextWebAddress = findViewById(R.id.editText_web_address);
    }

    public void accessWebSite(View view){
        String url = editTextWebAddress.getText().toString();
        Uri uri = Uri.parse(url);
        Intent webIntent = new Intent(Intent.ACTION_VIEW, uri);

        checkAppsForIntent(webIntent);
    }

    public void setAlarm(View view){
        Intent alarmIntent = new Intent(AlarmClock.ACTION_SET_ALARM);
        alarmIntent.putExtra(AlarmClock.EXTRA_MESSAGE, "Alarm Dev Venture");
        alarmIntent.putExtra(AlarmClock.EXTRA_HOUR, 9);
        alarmIntent.putExtra(AlarmClock.EXTRA_MINUTES, 30);

        checkAppsForIntent(alarmIntent);
    }

    private void checkAppsForIntent(Intent intent){
        if(intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        } else {
            Toast.makeText(this, "There's not app available.", Toast.LENGTH_SHORT).show();
        }
    }
}
