package com.example.travelPortal.Service;

import com.example.travelPortal.Repository.CommentRepo;
import com.example.travelPortal.Repository.LocationRepo;
import com.example.travelPortal.Repository.UserRepo;
import com.example.travelPortal.entity.Comment;
import com.example.travelPortal.entity.Location;
import com.example.travelPortal.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommentService {

    @Autowired
    private CommentRepo commentRepo;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private LocationRepo locationRepo;

    public Comment getComById(Long id){
        return commentRepo.findById(id).orElseThrow(()-> new RuntimeException("Given id not found"));
    }

    public List<Comment> getAllComment(){
        return commentRepo.findAll();
    }

    public Comment addComment(Comment comment) {
        // Log incoming request
        System.out.println("Received comment: " + comment);

        // Fetch and validate user from the cmt obj
        User user = userRepo.findById(comment.getUser().getUser_id())
                .orElseThrow(() -> new RuntimeException("User not found"));
        // Fetch and validate location
        Location location = locationRepo.findById(comment.getLocation().getLoc_id()).orElseThrow(()->new RuntimeException("Location not found"));
        // Set relationships
        comment.setUser(user);
        comment.setLocation(location);

        // Save comment
        return commentRepo.save(comment);
    }


    public Comment updateComment(Long id, Comment updatedComment) {
       // fetch existing comment from id
        Comment existingComment = commentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));

        // Check if the user trying to update the comment is the one who created it
        if (!(existingComment.getUser().getUser_id().equals(updatedComment.getUser().getUser_id())&& (existingComment.getLocation().getLoc_id().equals(updatedComment.getLocation().getLoc_id())))) {
            throw new RuntimeException("You can only update your own comments");
        }

        // Update the comment text
        existingComment.setCmt_text(updatedComment.getCmt_text());
        return commentRepo.save(existingComment);
    }

    public void deleteComment(Long id, Comment deleteComment) {
        Comment existingComment = commentRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Comment not found"));

        // Check if the user trying to update the comment is the one who created it
        if (!(existingComment.getUser().getUser_id().equals(deleteComment.getUser().getUser_id()) && (existingComment.getLocation().getLoc_id().equals(deleteComment.getLocation().getLoc_id())))) {
            throw new RuntimeException("You can only update your own comments");
        }

        // Delete the comment
        commentRepo.delete(existingComment);
    }


}
