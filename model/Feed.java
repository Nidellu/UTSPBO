package UTSPBO.model;


import java.time.LocalTime;
import java.util.ArrayList;

public class Feed extends Post {
    private String caption;
    private int likes;

    public Feed(String caption, int likes, String postId, ContentState status, LocalTime timeUpload, ContentType postType, ArrayList<Comment> listComment) {
        super(postId, status, timeUpload, postType, listComment);
        this.caption = caption;
        this.likes = likes;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }
    
    
}
