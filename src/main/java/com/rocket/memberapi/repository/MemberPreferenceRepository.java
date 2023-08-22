package com.rocket.memberapi.repository;

import com.rocket.memberapi.entity.MemberPreference;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberPreferenceRepository extends JpaRepository<MemberPreference, MemberPreference.PK> {
}
