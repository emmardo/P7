package com.nhk.springboot.p7.repositories;

import com.nhk.springboot.p7.domain.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Integer> {

}
