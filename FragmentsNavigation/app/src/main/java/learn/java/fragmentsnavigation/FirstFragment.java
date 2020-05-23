package learn.java.fragmentsnavigation;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;

import learn.java.fragmentsnavigation.databinding.FragmentFirstBinding;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    public static final String EDIT_TEXT_KEY = "edit_text_key";
    public static final String SWITCH1_KEY = "switch1_key";
    public static final String SWITCH2_KEY = "switch2_key";
    public static final String SEEKBAR_KEY = "seekbar_key";

    Activity activity;

    SharedPreferences sharedPreferences;
    String sharedPrefFileName = "sharedfile";

//    Button buttonNavigate;
//    EditText editText;
//    Switch switch1;
//    Switch switch2;
//    SeekBar seekBar;
//    Button buttonReset;

    public FirstFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

//        View v = inflater.inflate(R.layout.fragment_first, container, false);
//        buttonNavigate = v.findViewById(R.id.buttonNavigate);
//        editText = v.findViewById(R.id.editText);
//        switch1 = v.findViewById(R.id.switch1);
//        switch2 = v.findViewById(R.id.switch2);
//        seekBar = v.findViewById(R.id.seekBar);
//        buttonReset = v.findViewById(R.id.buttonReset);

        activity = this.getActivity();
        sharedPreferences = activity.getSharedPreferences(sharedPrefFileName, Context.MODE_PRIVATE);

        binding.editText.setText(sharedPreferences.getString(EDIT_TEXT_KEY, "Não encontrado"));
        binding.switch1.setChecked(sharedPreferences.getBoolean(SWITCH1_KEY, true));
        binding.switch2.setChecked(sharedPreferences.getBoolean(SWITCH2_KEY, true));
        binding.seekBar.setProgress(sharedPreferences.getInt(SEEKBAR_KEY, 4));
        
        binding.buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetSharedPreferences();
            }
        });

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.buttonNavigate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavDirections action = FirstFragmentDirections.actionToSecondFragment(10);
                Navigation.findNavController(v).navigate(action);
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        SharedPreferences.Editor sharedEditor = sharedPreferences.edit();

        sharedEditor.putString(EDIT_TEXT_KEY,   binding.editText.getText().toString());
        sharedEditor.putBoolean(SWITCH1_KEY,    binding.switch1.isChecked());
        sharedEditor.putBoolean(SWITCH2_KEY,    binding.switch2.isChecked());
        sharedEditor.putInt(SEEKBAR_KEY,        binding.seekBar.getProgress());

        sharedEditor.apply();
    }

    private void resetSharedPreferences(){
        binding.editText.setText("");
        binding.switch1.setChecked(false);
        binding.switch2.setChecked(false);
        binding.seekBar.setProgress(0);

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}
