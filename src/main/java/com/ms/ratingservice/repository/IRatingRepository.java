package com.ms.ratingservice.repository;

import com.ms.ratingservice.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRatingRepository extends JpaRepository<Rating,Long> {

    public List<Rating> findByUserId(Long userId);

    public List<Rating> findByHotelId(Long hotelId);
}
