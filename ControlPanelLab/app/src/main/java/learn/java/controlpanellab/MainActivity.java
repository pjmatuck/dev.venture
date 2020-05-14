package learn.java.controlpanellab;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    /*
    ToolBar com compatibilidade (Suporte a versões antigas da API)
    Não esquecer de mudar o Tema (android:theme) no arquivo Manifest.
    android:theme="@style/Theme.AppCompat.Light.NoActionBar"
    */
    //Toolbar toolbar;
    ConstraintLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //toolbar = findViewById(R.id.new_toolbar);
        //setSupportActionBar(toolbar);
        mainLayout = findViewById(R.id.main_layout);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.menu_help:
                //Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                Snackbar.make(mainLayout, item.getTitle(), Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.menu_refresh:
                //Toast.makeText(this, item.getTitle(), Toast.LENGTH_SHORT).show();
                Snackbar.make(mainLayout, item.getTitle(), Snackbar.LENGTH_SHORT).show();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
