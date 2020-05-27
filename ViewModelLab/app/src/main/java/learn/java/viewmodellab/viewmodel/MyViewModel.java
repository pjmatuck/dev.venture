package learn.java.viewmodellab.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MyViewModel extends ViewModel {

    private MutableLiveData<String> name;

    public MutableLiveData<String> getName(){
        if(name == null){
            name = new MutableLiveData<String>();
            updateName();
        }
        return name;
    }

    private void updateName(){
        name.setValue("Dev Venture");
    }
}
