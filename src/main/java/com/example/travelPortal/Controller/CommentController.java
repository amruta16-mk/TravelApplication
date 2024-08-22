package com.example.travelPortal.Controller;

import com.example.travelPortal.Service.CommentService;
import com.example.travelPortal.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    public CommentService commentService;

    @GetMapping("/{id}")
    public Comment getCommentById(@PathVariable Long id) {
        return commentService.getComById(id);
    }


    @GetMapping
    public List<Comment> getAllComment(){
        return commentService.getAllComment();
    }

    @PostMapping
    public Comment addComment(@RequestBody Comment comment){
        return commentService.addComment(comment);
    }

    @PutMapping("/{id}")
    public Comment updateComment(@PathVariable Long id,@RequestBody Comment comment){
       return commentService.updateComment(id,comment);
    }

    @DeleteMapping("{id}")
    public void deleteComment(@PathVariable Long id, @RequestBody Comment comment){
         commentService.deleteComment(id,comment);
    }
}
