package UTSPBO.model;

import java.time.LocalTime;
import java.util.ArrayList;

public class Story extends Post{
    private int duration;
    private int views;

    public Story(int duration, int views, String postId, ContentState status, LocalTime timeUpload, ContentType postType, ArrayList<Comment> listComment) {
        super(postId, status, timeUpload, postType, listComment);
        this.duration = duration;
        this.views = views;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }
    
    
}
