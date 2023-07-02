package com.ms.ratingservice.service.impl;

import com.ms.ratingservice.entity.Rating;
import com.ms.ratingservice.exception.ResourceNotFoundException;
import com.ms.ratingservice.repository.IRatingRepository;
import com.ms.ratingservice.service.IRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingServiceImpl implements IRatingService {

    @Autowired
    private IRatingRepository ratingRepository;


    @Override
    public boolean saveRating(Rating rating) {
        Rating saved = ratingRepository.save(rating);
        return saved.getRatingId() != null;
    }

    @Override
    public List<Rating> getAllRatings() {
        List<Rating> allRating = ratingRepository.findAll();
        return allRating;
    }

    @Override
    public Rating getRatingById(Long ratingId) {
        Optional<Rating> byId = ratingRepository.findById(ratingId);
        if(byId.isPresent())
            return byId.get();
        return null;
    }

    @Override
    public boolean updateRating(Long id, Rating updateRating) {
        Optional<Rating> byId = ratingRepository.findById(id);
        if(byId.isPresent()){
            Rating rating = byId.get();
            rating.setRating(updateRating.getRating());
            rating.setFeedback(updateRating.getFeedback());
            rating.setUserId(updateRating.getUserId());
            rating.setHotelId(updateRating.getHotelId());
            ratingRepository.save(rating);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteRatingById(Long ratingId) {
        boolean status = false;
        Optional<Rating> byId = ratingRepository.findById(ratingId);
        try{
            if(byId.isPresent()){
                ratingRepository.deleteById(ratingId);
                status = true;
            }else
                throw new ResourceNotFoundException("Rating not found with given id :: "+ratingId);
        }catch (Exception e){
            e.printStackTrace();
        }
        return status;
    }

    @Override
    public List<Rating> getRatingsByUserId(Long userId) {
        List<Rating> byUserId = ratingRepository.findByUserId(userId);
        if(!byUserId.isEmpty())
            return byUserId;
        else
            throw new ResourceNotFoundException("Ratings not found with given user id :: " + userId);
    }

    @Override
    public List<Rating> getRatingsByHotelId(Long hotelId) {
        List<Rating> byHotelId = ratingRepository.findByHotelId(hotelId);
        if (!byHotelId.isEmpty())
            return byHotelId;
        else
            throw new ResourceNotFoundException("Ratings not found with given hotel id :: " + hotelId);
    }
}
