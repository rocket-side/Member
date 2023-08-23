package com.rocket.memberapi.repository.custom;

import java.util.List;

public interface PreferenceRepositoryCustom {

    List<String> getPreference(Long memberSeq);

    void registerPreference(Long memberSeq, Long preferenceSeq);

    void deletePreference(Long memberSeq, Long preferenceSeq);
}
