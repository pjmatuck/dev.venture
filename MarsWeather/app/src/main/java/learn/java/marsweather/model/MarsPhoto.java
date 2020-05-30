package learn.java.marsweather.model;

import java.util.ArrayList;
import java.util.List;

public class MarsPhoto {

    List<Photo> photos = new ArrayList<>();

    public MarsPhoto() {}

    public List<Photo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<Photo> photos) {
        this.photos = photos;
    }

    public class Photo {

        private int id;
        private String img_src;

        public Photo() {}

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getImg_src() {
            return img_src;
        }

        public void setImg_src(String img_src) {
            this.img_src = img_src;
        }
    }

}
