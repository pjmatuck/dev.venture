package learn.java.showusersonfragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class SelectUserFragment extends Fragment implements View.OnClickListener {

    OnSelectUserListener listener;

    Button button1, button2, button3;

    public SelectUserFragment() {
        // Required empty public constructor
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                listener.onUserSelected(1);
                break;
            case R.id.button2:
                listener.onUserSelected(2);
                break;
            case R.id.button3:
                listener.onUserSelected(3);
        }
    }

    public interface OnSelectUserListener {
        public void onUserSelected(int id);
    }

    public static SelectUserFragment newInstance() {
        SelectUserFragment fragment = new SelectUserFragment();
        //Caso houver parâmetros deverão ser colocados dentro de um objeto Bundle
        //e passado através do método fragment.setArguments(Bundle)
        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (context instanceof OnSelectUserListener) {
            listener = (OnSelectUserListener) context;
        } else {
            throw new ClassCastException("Zebra! Contexto não implementa a interface OnSelectUserListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_select_user, container, false);

        button1 = view.findViewById(R.id.button1);
        button2 = view.findViewById(R.id.button2);
        button3 = view.findViewById(R.id.button3);

        button1.setOnClickListener(this);

        button2.setOnClickListener(this);

        button3.setOnClickListener(this);

        //Caso existirem argumentos devê-se utilizar o getArguments()
        //if(getArguments() != null)

        return view;
    }

    /*public View.OnClickListener selectUserOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.button1:
                    listener.onUserSelected(1);
                    break;
                case R.id.button2:
                    listener.onUserSelected(2);
                    break;
                case R.id.button3:
                    listener.onUserSelected(3);
            }
        }
    };*/
}
