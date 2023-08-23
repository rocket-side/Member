package com.rocket.memberapi.repository;

import com.rocket.memberapi.entity.Preference;
import com.rocket.memberapi.repository.custom.PreferenceRepositoryCustom;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PreferenceRepository extends JpaRepository<Preference, Long>, PreferenceRepositoryCustom {
}
