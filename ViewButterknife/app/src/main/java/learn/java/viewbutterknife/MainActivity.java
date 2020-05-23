package learn.java.viewbutterknife;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.textView1)
    TextView textView1;

    @BindView(R.id.textView2)
    TextView textView2;

    @BindView(R.id.editText)
    EditText editText;

    @BindView(R.id.button)
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Caso estiver utilizando o Butterknife em uma Fragment,
        // passe um objeto View como argumento do Butterknife.bind(view)
        ButterKnife.bind(this);

        textView1.setText("Este é o texto 1");
        textView2.setText("Este é o último elemento");
        editText.setText("Olá, sou um Edittext!");
        button.setText("Clique em mim!");

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
