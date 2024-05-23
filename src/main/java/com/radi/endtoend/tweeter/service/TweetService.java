package com.radi.endtoend.tweeter.service;

import com.radi.endtoend.tweeter.exception.TweetNotFoundException;
import com.radi.endtoend.tweeter.model.Tweet;
import com.radi.endtoend.tweeter.repository.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TweetService {
    @Autowired
    TweetRepository tweetRepository;

    public Tweet findByid(Integer id) {
        if(id <= 0) {
            throw new IllegalArgumentException("Id is not valid, Please pass valid Id");
        }
        Optional<Tweet> response = tweetRepository.findById(id);

        if(!response.isPresent()){
            throw new TweetNotFoundException("Tweet not found with id"+id);
        }

        return response.get();

    }


    public Integer saveTweet(Tweet tweet){
        return tweetRepository.save(tweet).getId();
    }

}
