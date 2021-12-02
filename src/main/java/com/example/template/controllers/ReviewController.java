package com.example.template.controllers;

import com.example.template.dtos.AssetUpdateDto;
import com.example.template.dtos.ReviewDto;
import com.example.template.models.Reviews;
import com.example.template.payload.ApiResponse;
import com.example.template.services.AssetService;
import com.example.template.services.ReviewService;
import com.example.template.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api/v1/")
public class ReviewController {
    @Autowired
    private AssetService assetService;
    @Autowired
    private UserService userService;
    @Autowired
    private ReviewService reviewService;
    @PutMapping("/addreview/{id}")
    public ResponseEntity<ApiResponse> AddReview(@PathVariable("id") int id, @RequestBody ReviewDto reviewDto){
        Reviews review = reviewService.AddReview(reviewDto,id,userService.getLoggedInUser().getId());
        return ResponseEntity.ok(new ApiResponse(true," Asset reviewed",assetService.AddReview(id,review)));
    }
    @GetMapping("/assetreviews/{id}")
    public ResponseEntity<ApiResponse> getAssetReviews(@PathVariable("id") int id){
        return ResponseEntity.ok(new ApiResponse(true,"List of reviews on assets ",reviewService.ReviewsOnAsset(id)));
    }
    @GetMapping("/myreviews/")
    public ResponseEntity<ApiResponse> getMyReviews(){
        return ResponseEntity.ok(new ApiResponse(true,"List of my reviews ",reviewService.getMyReviews(userService.getLoggedInUser().getId())));
    }
    @DeleteMapping("/deletereview/{id}")
    public ResponseEntity<ApiResponse> DeleteReview(@PathVariable("id") int id){
        return ResponseEntity.ok(new ApiResponse(true,"Review Deleted ",reviewService.DeleteReview(id)));
    }
    @PutMapping("/editreview/{id}")
    public ResponseEntity<ApiResponse> UpdateReview(@PathVariable("id") int id,@RequestBody ReviewDto reviewDto){
        return ResponseEntity.ok(new ApiResponse(true,"Edited Review",reviewService.UpdateReview(id,reviewDto)));
    }
}
