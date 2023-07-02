package com.ms.ratingservice.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;

@Entity
@Table(name = "RATING_MASTER")
@Data
public class Rating {

    @Id
    @GeneratedValue
    @Column(name = "ID")
    private Long ratingId;

    @Column(name = "USER_ID")
    private Long userId;

    @Column(name = "HOTEL_ID")
    private Long hotelId;

    @Column(name = "RATING_COUNT")
    private Integer rating;

    @Column(name = "FEEDBACK")
    private String feedback;

    @Column(name = "CREATED_DATE",updatable = false)
    @CreationTimestamp
    private LocalDate createData;

    @Column(name = "UPDATED_DATE",insertable = false)
    @UpdateTimestamp
    private LocalDate updateDate;
}