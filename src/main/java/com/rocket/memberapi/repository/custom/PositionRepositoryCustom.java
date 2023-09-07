package com.rocket.memberapi.repository.custom;

import java.util.List;

public interface PositionRepositoryCustom {

    List<String> getPosition(Long memberSeq);

    void registerPosition(Long memberSeq, Long positionSeq);

    void deletePosition(Long memberSeq, Long positionSeq);
}
