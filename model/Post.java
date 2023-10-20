package UTSPBO.model;

import java.time.LocalTime;
import java.util.ArrayList;

public class Post {

    private String postId;
    private ContentState status;
    private LocalTime timeUpload;
    private ContentType postType;
    private ArrayList<Comment> listComment;

    public Post(String postId, ContentState status, LocalTime timeUpload, ContentType postType, ArrayList<Comment> listComment) {
        this.postId = postId;
        this.status = status;
        this.timeUpload = timeUpload;
        this.postType = postType;
        this.listComment = listComment;
    }

    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public ContentState getStatus() {
        return status;
    }

    public void setStatus(ContentState status) {
        this.status = status;
    }

    public LocalTime getTimeUpload() {
        return timeUpload;
    }

    public void setTimeUpload(LocalTime timeUpload) {
        this.timeUpload = timeUpload;
    }

    public ContentType getPostType() {
        return postType;
    }

    public void setPostType(ContentType postType) {
        this.postType = postType;
    }

    public ArrayList<Comment> getListComment() {
        return listComment;
    }

    public void setListComment(ArrayList<Comment> listComment) {
        this.listComment = listComment;
    }
    
    
}
