package com.example.travelPortal.Repository;

import com.example.travelPortal.entity.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepo extends JpaRepository<Location,Long> {
}
