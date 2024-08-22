package com.example.travelPortal.Repository;

import com.example.travelPortal.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
