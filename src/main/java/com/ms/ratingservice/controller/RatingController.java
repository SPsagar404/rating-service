package com.ms.ratingservice.controller;

import com.ms.ratingservice.entity.Rating;
import com.ms.ratingservice.service.IRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating-service/api/ratings")
public class RatingController {

    @Autowired
    private IRatingService ratingService;

    @PostMapping("/rating")
    public ResponseEntity<String> saveRating(@RequestBody Rating rating){
        String responseMsg="";
        boolean isSaved = ratingService.saveRating(rating);
        if(isSaved)
            responseMsg="Rating saved ....";
        else
            responseMsg="Rating not saved ....";

        return ResponseEntity.status(HttpStatus.CREATED).body(responseMsg);
    }

    @GetMapping("/")
    public ResponseEntity<List<Rating>> ratings(){
        List<Rating> allRatings = ratingService.getAllRatings();
        if(!allRatings.isEmpty())
            return ResponseEntity.ok(allRatings);
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/rating/{ratingId}")
    public ResponseEntity<Rating> viewRating(@PathVariable Long ratingId){
        Rating ratingById = ratingService.getRatingById(ratingId);
        return ResponseEntity.ok(ratingById);
    }

    @DeleteMapping("/rating/{ratingId}")
    public ResponseEntity<String> deleteRating(@PathVariable Long ratingId){
        String responseMsg="";
        boolean isDeleted = ratingService.deleteRatingById(ratingId);
        if(isDeleted)
            responseMsg="Rating deleted .....";
        else
            responseMsg="Rating not deleted ....";
        return ResponseEntity.ok(responseMsg);
    }

    @PutMapping("/rating/{ratingId}")
    public ResponseEntity<String> updateRating(@PathVariable Long ratingId,@RequestBody Rating rating){
        String responseMsg="";
        boolean isUpdated = ratingService.updateRating(ratingId, rating);
        if(isUpdated)
            responseMsg="Rating updated ....";
        else
            responseMsg="Rating not updated ....";
        return ResponseEntity.ok(responseMsg);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Rating>> ratingsByUserId(@PathVariable Long userId){
        List<Rating> allRatings = ratingService.getRatingsByUserId(userId);
        if(!allRatings.isEmpty())
            return ResponseEntity.ok(allRatings);
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/hotel/{hotelId}")
    public ResponseEntity<List<Rating>> ratingsByHotelId(@PathVariable Long hotelId){
        List<Rating> allRatings = ratingService.getRatingsByHotelId(hotelId);
        if(!allRatings.isEmpty())
            return ResponseEntity.ok(allRatings);
        return ResponseEntity.notFound().build();
    }

}
