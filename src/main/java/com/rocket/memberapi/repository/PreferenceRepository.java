package com.rocket.memberapi.repository;

import com.rocket.memberapi.entity.Preference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreferenceRepository extends JpaRepository<Preference, Long> {
}
