package learn.java.viewmodellab.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import learn.java.viewmodellab.R;
import learn.java.viewmodellab.viewmodel.MyViewModel;

public class MainActivity extends AppCompatActivity {

    MyViewModel viewModel;
    TextView textView;
    Button buttonNewName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.textView);
        buttonNewName = findViewById(R.id.buttonNewName);

        viewModel = new ViewModelProvider(this).get(MyViewModel.class);

        viewModel.getName().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String s) {
                textView.setText(s);
            }
        });

        buttonNewName.setOnClickListener(v -> {
            viewModel.getName().setValue("New DEV Venture class!");
        });
    }
}
