package learn.java.fragments;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FirstFragment.OnFragmentMessageChange {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    FirstFragment firstFragment;
    SecondFragment secondFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firstFragment = FirstFragment.newInstance("Este é um novo fragment!");
        secondFragment = SecondFragment.newInstance("Segunda Fragment");

        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment1_container, firstFragment)
                .add(R.id.fragment2_container, secondFragment)
                .commit();
    }

    @Override
    public void onMessageChanged(String message) {
        updateFragment2(message);
    }

    private void updateFragment2(String message){
        SecondFragment secondFragment = SecondFragment.newInstance(message);
        getSupportFragmentManager()
                .beginTransaction()
                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                .replace(R.id.fragment2_container, secondFragment)
                .commit();
    }

}
