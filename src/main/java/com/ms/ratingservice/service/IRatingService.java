package com.ms.ratingservice.service;

import com.ms.ratingservice.entity.Rating;

import java.util.List;

public interface IRatingService {

    public boolean saveRating(Rating rating);

    public List<Rating> getAllRatings();

    public Rating getRatingById(Long ratingId);

    public boolean updateRating(Long id,Rating rating);

    public boolean deleteRatingById(Long ratingId);

    public List<Rating> getRatingsByUserId(Long userId);

    public  List<Rating> getRatingsByHotelId(Long hotelId);
}
