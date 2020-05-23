package learn.java.showusersonfragment;

import java.io.Serializable;

public class User implements Serializable {

    private int id;
    private String name;
    private String nickName;

    public User(int id, String name, String nickName) {
        this.id = id;
        this.name = name;
        this.nickName = nickName;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getNickName() {
        return nickName;
    }
}
