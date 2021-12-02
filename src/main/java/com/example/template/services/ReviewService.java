package com.example.template.services;

import com.example.template.dtos.ReviewDto;
import com.example.template.models.Assets;
import com.example.template.models.Reviews;
import com.example.template.models.User;
import com.example.template.repository.AssetsRepository;
import com.example.template.repository.ReviewRepository;
import com.example.template.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewService {
    @Autowired
    private ReviewRepository reviewRepository;
    @Autowired
    private AssetsRepository assetsRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Reviews> ReviewsOnAsset(int id){
        Optional<Assets> asset = assetsRepository.findById(id);
        return asset.map(assets -> reviewRepository.findByAssets(assets)).orElse(null);
    }
    public Reviews DeleteReview(int id){
        Optional<Reviews> review = reviewRepository.findById(id);
        if (review.isPresent()){
            reviewRepository.delete(review.get());
            return review.get();
        }
        return  null;
    }
    public  Reviews UpdateReview(int id, ReviewDto reviewDto){
    Optional<Reviews> reviews = reviewRepository.findById(id);
    if (reviews.isPresent()){
        reviews.get().setReview(reviewDto.getMessage());
        return reviewRepository.save(reviews.get());
    }
    return  null;
    }
    public Reviews AddReview(ReviewDto reviewDto,int Assetid,int senderId){
        Optional<Assets> asset= assetsRepository.findById(Assetid);
        Optional<User> user = userRepository.findById(senderId);
        if (asset.isPresent()&& user.isPresent()){
           Reviews review = new Reviews();
           review.setReview(reviewDto.getMessage());
           review.setAssets(asset.get());
           review.setSentBy(user.get());
           return reviewRepository.save(review);
        }
        return null;
    }
    public List<Reviews>getMyReviews(int id){
        Optional<User> user = userRepository.findById(id);
        return user.map(value -> reviewRepository.findBySentBy(value)).orElse(null);
    }
}
