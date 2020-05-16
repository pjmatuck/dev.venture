package learn.java.recyclerviewlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    ListAdapter listAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        listAdapter = new ListAdapter(populateList());
        recyclerView.setAdapter(listAdapter);
    }

    private List<Contact> populateList(){
        List<Contact> contactList = new ArrayList<Contact>();

        Contact contact1 = new Contact("Robert DeNiro", "Actor", R.drawable.ic_android);
        Contact contact2 = new Contact("Bill Gates", "Programmer", R.drawable.ic_child_care);
        Contact contact3 = new Contact("Zeta Jones", "Actress", R.drawable.ic_person);
        Contact contact4 = new Contact("Robert DeNiro", "Actor", R.drawable.ic_android);
        Contact contact5 = new Contact("Bill Gates", "Programmer", R.drawable.ic_child_care);
        Contact contact6 = new Contact("Zeta Jones", "Actress", R.drawable.ic_person);
        Contact contact7 = new Contact("Robert DeNiro", "Actor", R.drawable.ic_android);
        Contact contact8 = new Contact("Bill Gates", "Programmer", R.drawable.ic_child_care);
        Contact contact9 = new Contact("Zeta Jones", "Actress", R.drawable.ic_person);

        contactList.add(contact1);
        contactList.add(contact2);
        contactList.add(contact3);
        contactList.add(contact4);
        contactList.add(contact5);
        contactList.add(contact6);
        contactList.add(contact7);
        contactList.add(contact8);
        contactList.add(contact9);

        return contactList;
    }
}
