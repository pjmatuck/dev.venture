package learn.java.meuperfil;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final int CAMERA_REQUEST = 1;

    EditText editTextName, editTextCompany, editTextEmail;
    TextView textViewName, textViewCompany, textViewEmail;
    ImageView imageViewCapture, imageViewCard;

    Bitmap photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextName = findViewById(R.id.editTextName);
        editTextCompany = findViewById(R.id.editTextCompany);
        editTextEmail = findViewById(R.id.editTextEmail);

        textViewName = findViewById(R.id.textViewName);
        textViewCompany = findViewById(R.id.textViewCompany);
        textViewEmail = findViewById(R.id.textViewEmail);

        imageViewCapture = findViewById(R.id.imageViewCapture);
        imageViewCard = findViewById(R.id.imageViewCard);
    }

    public void captureImage(View v){
        Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(cameraIntent, CAMERA_REQUEST);
    }

    public void createCard(View v){
        imageViewCard.setImageBitmap(photo);
        textViewName.setText(editTextName.getText());
        textViewCompany.setText(editTextCompany.getText());
        textViewEmail.setText(editTextEmail.getText());
        setWidgetsVisible();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK && requestCode == CAMERA_REQUEST){
            photo = (Bitmap) data.getExtras().get("data");
            imageViewCapture.setImageBitmap(photo);
            imageViewCapture.setScaleType(ImageView.ScaleType.CENTER_CROP);
        }
    }

    private void setWidgetsVisible(){
        imageViewCard.setVisibility(View.VISIBLE);
        textViewName.setVisibility(View.VISIBLE);
        textViewCompany.setVisibility(View.VISIBLE);
        textViewEmail.setVisibility(View.VISIBLE);
    }


}
