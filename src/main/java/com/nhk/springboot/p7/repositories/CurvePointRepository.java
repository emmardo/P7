package com.nhk.springboot.p7.repositories;

import com.nhk.springboot.p7.domain.CurvePoint;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CurvePointRepository extends JpaRepository<CurvePoint, Integer> {

}
