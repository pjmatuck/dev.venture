package learn.java.showusersonfragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class UserDetailFragment extends Fragment {

    TextView textViewId, textViewName, textViewNickName;

    public static final String USER_ARGUMENT = "USER_ARG";

    public UserDetailFragment() {
        // Required empty public constructor
    }

    public static UserDetailFragment newInstance(User user){
        UserDetailFragment userDetailFragment = new UserDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(USER_ARGUMENT, user);
        userDetailFragment.setArguments(bundle);
        return userDetailFragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_user_detail, container,
                false);

        textViewId = v.findViewById(R.id.textView_user_id);
        textViewName = v.findViewById(R.id.textView_user_name);
        textViewNickName = v.findViewById(R.id.textView_user_nickname);

        if(getArguments() != null){
            User user = (User)getArguments().getSerializable(USER_ARGUMENT);
            textViewId.setText(String.valueOf(user.getId()));
            textViewName.setText(user.getName());
            textViewNickName.setText(user.getNickName());
        }

        return v;
    }
}
