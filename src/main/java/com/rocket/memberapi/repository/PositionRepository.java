package com.rocket.memberapi.repository;

import com.rocket.memberapi.entity.Position;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PositionRepository extends JpaRepository<Position, Long> {
}
