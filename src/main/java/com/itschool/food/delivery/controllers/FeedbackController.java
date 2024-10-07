package com.itschool.food.delivery.controllers;

import com.itschool.food.delivery.models.dtos.FeedbackDTO;
import com.itschool.food.delivery.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    @Autowired
    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    // Endpoint pentru trimiterea unui feedback
    @PostMapping("/submit")
    public ResponseEntity<String> submitFeedback(@RequestBody FeedbackDTO feedbackDTO) {
        feedbackService.submitFeedback(feedbackDTO);
        return ResponseEntity.ok("Feedback submitted successfully");
    }

    // Endpoint pentru vizualizarea feedback-urilor pentru un restaurant
    @GetMapping("/restaurant/{restaurantId}")
    public ResponseEntity<List<FeedbackDTO>> getRestaurantFeedback(@PathVariable String restaurantId) {
        List<FeedbackDTO> feedbackList = feedbackService.getFeedbackForRestaurant(restaurantId);
        return ResponseEntity.ok(feedbackList);
    }
}