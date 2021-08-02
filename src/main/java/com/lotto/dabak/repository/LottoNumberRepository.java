package com.lotto.dabak.repository;

import com.lotto.dabak.entity.LottoNumber;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LottoNumberRepository extends JpaRepository<LottoNumber, Long> {
}
