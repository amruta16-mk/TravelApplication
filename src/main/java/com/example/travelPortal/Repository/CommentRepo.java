package com.example.travelPortal.Repository;

import com.example.travelPortal.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment,Long> {
}
