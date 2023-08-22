package com.rocket.memberapi.repository;

import com.rocket.memberapi.entity.Level;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LevelRepository extends JpaRepository<Level, Long> {
}
