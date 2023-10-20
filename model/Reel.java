package UTSPBO.model;

import java.time.LocalTime;
import java.util.ArrayList;

public class Reel extends Post {
    private int duration;
    private int playedCount;

    public Reel(int duration, int playedCount, String postId, ContentState status, LocalTime timeUpload, ContentType postType, ArrayList<Comment> listComment) {
        super(postId, status, timeUpload, postType, listComment);
        this.duration = duration;
        this.playedCount = playedCount;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getPlayedCount() {
        return playedCount;
    }

    public void setPlayedCount(int playedCount) {
        this.playedCount = playedCount;
    }
    
}
