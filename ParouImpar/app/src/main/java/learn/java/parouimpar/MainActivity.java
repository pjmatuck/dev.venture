package learn.java.parouimpar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int numberPicked, playerScore, machineScore;
    boolean isNumberChoosed;
    boolean isOdd, isOddOrEvenChoosed;

    TextView textViewWinOrLooseMessage;
    TextView textViewMachineNumber;
    TextView textViewplayerScore;
    TextView textViewMachineScore;
    TextView textViewNumberGuess;
    TextView textViewoddOrEvenGuess;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewWinOrLooseMessage = findViewById(R.id.win_lose_message);
        textViewMachineNumber = findViewById(R.id.machine_choosed_number);
        textViewplayerScore = findViewById(R.id.player_score_value);
        textViewMachineScore = findViewById(R.id.machine_score_value);
        textViewoddOrEvenGuess = findViewById(R.id.odd_or_even_guess);
        textViewNumberGuess = findViewById(R.id.number_guess);

        restart();
    }

    public void onClickOddOrEven(View view){
        if(view.getId() == R.id.button_odd){
            isOdd = true;
        } else {
            isOdd = false;
        }
        textViewoddOrEvenGuess.setText(isOdd ? "Ímpar" : "Par");
        isOddOrEvenChoosed = true;
    }

    public void onClickNumberPick(View view){
        switch (view.getId()){
            case R.id.button_number_1:
                numberPicked = 1;
                break;
            case R.id.button_number_2:
                numberPicked = 2;
                break;
            case R.id.button_number_3:
                numberPicked = 3;
                break;
            case R.id.button_number_4:
                numberPicked = 4;
                break;
            case R.id.button_number_5:
                numberPicked = 5;
                break;
        }
        textViewNumberGuess.setText(numberPicked+"");
        isNumberChoosed = true;
        validateGame();
    }

    private int generateMachineNumber(){
        int number = new Random().nextInt(5) + 1;
        textViewMachineNumber.setText(String.valueOf(number));
        return number;
    }

    private void validateGame(){
        boolean winner = false;
        if(isNumberChoosed  && isOddOrEvenChoosed){
            if((numberPicked + generateMachineNumber()) % 2 == 1){
                if(isOdd) {
                    winner = true;
                    playerScore++;
                }
                else {
                    winner = false;
                    machineScore++;
                }
            } else {
                if(isOdd) {
                    winner = false;
                    machineScore++;
                }
                else {
                    winner = true;
                    playerScore ++;
                }
            }
        } else {
            Toast.makeText(this, "Por favor, escolha par ou ímpar E um número.", Toast.LENGTH_LONG).show();
            return;
        }

        textViewWinOrLooseMessage.setText(winner ? R.string.win_message : R.string.loose_message);
        textViewWinOrLooseMessage.setTextColor(winner ? Color.BLUE : Color.RED);
        textViewplayerScore.setText(String.valueOf(playerScore));
        textViewMachineScore.setText(String.valueOf(machineScore));

        isOddOrEvenChoosed = false;
        isNumberChoosed = false;
    }

    public void restart(){
        isOddOrEvenChoosed = false;
        isNumberChoosed = false;
        playerScore = 0;
        machineScore = 0;
        textViewplayerScore.setText(String.valueOf(playerScore));
        textViewMachineScore.setText(String.valueOf(machineScore));
        textViewMachineNumber.setText("");
        textViewWinOrLooseMessage.setText("");
        textViewoddOrEvenGuess.setText("");
        textViewNumberGuess.setText("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menu_restart){
            restart();
        }
        return super.onOptionsItemSelected(item);
    }
}
