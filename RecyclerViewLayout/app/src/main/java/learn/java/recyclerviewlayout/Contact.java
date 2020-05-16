package learn.java.recyclerviewlayout;

public class Contact {

    private String name;
    private String job;
    private int imageResource;

    public Contact(String name, String job, int imageResource) {
        this.name = name;
        this.job = job;
        this.imageResource = imageResource;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }

    public int getImageResource() {
        return imageResource;
    }
}
