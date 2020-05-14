package learn.java.constraintlayoutlab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroupGender;
    RadioButton radioButtonGender;
    String selectedGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroupGender = findViewById(R.id.radioGroup_gender);
    }

    public void selectGender(View v){

        /*
        OPCAO 1
        Quando queremos identificar o RadioButton selecionado e acessar suas propriedades.
         */
//        int selectedRadioButtonId = radioGroupGender.getCheckedRadioButtonId();
//        radioButtonGender = findViewById(selectedRadioButtonId);
//        selectedGender = radioButtonGender.getText().toString();
//        Toast.makeText(this, "Radio Button: " + radioButtonGender.getText().toString(), Toast.LENGTH_SHORT).show();

        /*
        OPCAO 2
        Quando queremos configurar ações diferentes para cada RadioButton.
         */
        switch (v.getId()){
            case R.id.radioButton_male:
                selectedGender = ((RadioButton) v).getText().toString();
                break;
            case R.id.radioButton_female:
                selectedGender = ((RadioButton) v).getText().toString();
                break;
            case R.id.radioButton_other:
                selectedGender = ((RadioButton) v).getText().toString();
                break;
        }

        Toast.makeText(this, selectedGender, Toast.LENGTH_SHORT).show();
    }
}
