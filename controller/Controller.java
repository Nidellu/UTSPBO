package UTSPBO.controller;

import java.util.ArrayList;
import UTSPBO.model.*;
import UTSPBO.view.DialogView;
import java.time.LocalTime;

public class Controller {

    public static ArrayList inputDummy() {
        ArrayList<User> dummyUser = new ArrayList<>();
        ArrayList<Reel> dummyReel = new ArrayList<>();
        ArrayList<Post> dummyPost = new ArrayList<>();
        ArrayList<Feed> dummyFeed = new ArrayList<>();
        ArrayList<Story> dummyStory = new ArrayList<>();
        ArrayList<Comment> dummyComment = new ArrayList<>();

        User user1 = new User("user1", "Hai", "user1_pass", "HH",dummyPost);
        User user2 = new User("user2", "Hello", "user2_pass", "Hehe", dummyPost);
        dummyUser.add(user1);
        dummyUser.add(user2);

        Post post1 = new Post("post1", ContentState.SHOWED, LocalTime.now(), ContentType.PICTURE, dummyComment);
        Post post2 = new Post("post2", ContentState.ARCHIVED, LocalTime.now(), ContentType.VIDEO, dummyComment);
        dummyPost.add(post1);
        dummyPost.add(post2);

        return dummyUser;
    }

    public String printPost(ArrayList<Post> tempPost, int j) {
        if (tempPost.get(j) instanceof Reel) {
            Reel tempReel = (Reel) tempPost.get(j);
            return "\nPlayed Counted: " + tempReel.getPlayedCount();
        } else if (tempPost.get(j) instanceof Story) {
            Story tempStory = (Story) tempPost.get(j);
            return "\nTotal Views: " + tempStory.getViews();
        } else if (tempPost.get(j) instanceof Feed) {
            Feed tempFeed = (Feed) tempPost.get(j);
            return "\nTotal Likes: " + tempFeed.getLikes();
        } else {
            return "";
        }
    }

    public int cariPost(String postId, ArrayList<Post> listPost) {
        int index = -1;

        for (int i = 0; i < listPost.size(); i++) {
            Post tempPost = listPost.get(i);
            if (tempPost.getPostId().equalsIgnoreCase(postId)) {
                index = i;
                break;
            }
        }
        return index;
    }

    //NO 1
    public String showUserPost(ArrayList<User> listUser) {
        String postPinned = "";
        String postShowed = "";
        String postArchived = "";
        int postDeleted = 0;

        for (int i = 0; i < listUser.size(); i++) {
            ArrayList<Post> tempPost = listUser.get(i).getListPost();
            for (int j = 0; j < tempPost.size(); j++) {
                if (tempPost.get(j).getStatus().equals(ContentState.PINNED)) {
                    postPinned += "Pinned " + printPost(tempPost, j) + "\n";
                } else if (tempPost.get(j).getStatus().equals(ContentState.SHOWED)) {
                    postPinned += "Showed " + printPost(tempPost, j) + "\n";
                } else if (tempPost.get(j).getStatus().equals(ContentState.ARCHIVED)) {
                    postPinned += "Archived " + printPost(tempPost, j) + "\n";
                } else if (tempPost.get(j).getStatus().equals(ContentState.DELETED)) {
                    postDeleted++;
                }
            }
        }

        String hasil = postPinned + postShowed + postArchived;

        hasil += "\n\n=========================================="
                + "\nJumlah Post yang di Delete: "
                + postDeleted
                + "\n===========================================";
        return hasil;
    }

    //NO 2
    public String showPost(int indexUser, int indexPost, ArrayList<User> listUser) {
        ArrayList<Post> tempPost = listUser.get(indexUser).getListPost();
        Post foundPost = (Post) tempPost.get(indexPost);

        String hasil = "";

        hasil += "PostId: " + foundPost.getPostId();
        hasil += "Status: " + foundPost.getStatus();
        hasil += "Time Upload: " + foundPost.getTimeUpload();
        hasil += "PostType: " + foundPost.getPostType();

        if (foundPost instanceof Reel) {
            Reel tempReel = (Reel) foundPost;
            hasil += "\nDuration: " + tempReel.getDuration();
            hasil += "\nPlayed Counted: " + tempReel.getPlayedCount();
        } else if (foundPost instanceof Story) {
            Story tempStory = (Story) foundPost;
            hasil += "\nDuration: " + tempStory.getDuration();
            hasil += "\nTotal Views: " + tempStory.getViews();
        } else if (foundPost instanceof Feed) {
            Feed tempFeed = (Feed) foundPost;
            hasil += "\nCaption: " + tempFeed.getCaption();
            hasil += "\nTotal Likes: " + tempFeed.getLikes();
        }

        hasil += "\n========================================================";

        for (int i = 0; i < tempPost.size(); i++) {
            ArrayList<Comment> tempComment = tempPost.get(i).getListComment();
            for (int j = 0; j < tempComment.size(); j++) {
                Comment listComment = (Comment) tempComment.get(j);
                hasil += "CommentID: " + listComment.getCommentId();
                hasil += "Comment: " + listComment.getText();
                hasil += "Status: " + listComment.getStatus();
                hasil += "\n===========================================";
            }
        }

        return hasil;
    }
    
    //NO 3
    public String changePostState(int indexUser, int indexPost, ArrayList<User> listUser) {
        ArrayList<Post> tempPost = listUser.get(indexUser).getListPost();
        Post foundPost = (Post) tempPost.get(indexPost);
        
        if (foundPost.getStatus().equals(ContentState.ARCHIVED)){
            String tanya = """
                           Post ini Di Archived, Diubah ke?
                           1. Deleted
                           2. Showed
                           0. Tidak ingin
                           """;
            String jawab = DialogView.showInputDialog(tanya);
            if(jawab.equals("1")){
               foundPost.setStatus(ContentState.DELETED);
               return "Post di deleted";
            } else if(jawab.equals("2")){
               foundPost.setStatus(ContentState.SHOWED);
               return "Post di showed";
            } else {
                return "Tidak Jadi ya :(";
            }
        } else if (foundPost.getStatus().equals(ContentState.SHOWED)){
            String tanya = """
                           Post ini Di Showed, Diubah ke?
                           1. Pinned
                           2. Archived
                           0. Tidak ingin
                           """;
            String jawab = DialogView.showInputDialog(tanya);
            if(jawab.equals("1")){
               foundPost.setStatus(ContentState.PINNED);
               return "Post di pinned";
            } else if(jawab.equals("2")){
               foundPost.setStatus(ContentState.ARCHIVED);
               return "Post di archive";
            } else {
                return "Tidak Jadi ya :(";
            }  
        } else if (foundPost.getStatus().equals(ContentState.PINNED)){
            String tanya = """
                           Post ini Di Archived, Diubah ke?
                           1. Showed
                           0. Tidak ingin
                           """;
            String jawab = DialogView.showInputDialog(tanya);
            if(jawab.equals("1")){
               foundPost.setStatus(ContentState.SHOWED);
               return "Post di showed";
            } else {
                return "Tidak Jadi ya :(";
            }
        } else {
            return "Maaf post ga ada";
        }
            
    }
    
    public static ArrayList<User> listUser = inputDummy();

    public static void main(String[] args) {
    }

}
