package learn.java.fakemessenger;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_ID = MainActivity.class.getSimpleName() + ".MESSAGE";
    public static final int REQUEST_ANSWER = 1;

    private EditText editTextMessage;
    private TextView textViewAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextMessage = findViewById(R.id.edittext_message);
        textViewAnswer = findViewById(R.id.textview_answer);

        if(savedInstanceState == null) {
            Toast.makeText(this, "Instance Bundle null", Toast.LENGTH_LONG).show();
        } else {
            textViewAnswer.setText(savedInstanceState.getString("savedtext"));
        }
    }

    public void callNewActivity(View view) {

        Intent intent = new Intent(this, NewActivity.class);
        intent.putExtra(EXTRA_ID, editTextMessage.getText().toString());
        editTextMessage.getText().clear();
        startActivity(intent);
    }

    public void callNewActivityForResult(View view) {

        Intent intent = new Intent(this, NewActivity.class);
        intent.putExtra(EXTRA_ID, editTextMessage.getText().toString());
        editTextMessage.getText().clear();
        startActivityForResult(intent, REQUEST_ANSWER);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_ANSWER){
            switch (resultCode){
                case RESULT_OK:
                    String receivedAnswer = data.getStringExtra(NewActivity.ANSWER_ID);
                    textViewAnswer.setText(receivedAnswer);
                    break;
                case RESULT_CANCELED:

                    break;
                default:
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        if(!textViewAnswer.getText().toString().isEmpty()){
            outState.putString("savedtext", textViewAnswer.getText().toString());
        }
    }
}
