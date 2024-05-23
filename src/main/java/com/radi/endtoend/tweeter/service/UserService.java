package com.radi.endtoend.tweeter.service;

import com.radi.endtoend.tweeter.model.Tweet;
import com.radi.endtoend.tweeter.model.User;
import com.radi.endtoend.tweeter.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User saveTweet(Tweet tweet, String username){
        User user = userRepository.findByUsername(username);
        user.getTweets().add(tweet);
        return userRepository.save(user);
    }

    public Set<Tweet> getTweets(String username){
        User user = userRepository.findByUsername(username);
        return user.getTweets();
    }

    public User followUser(String username, String follwerName){
        User user = userRepository.findByUsername(username);
        User following = userRepository.findByUsername(follwerName);
        user.getFollowers().add(following);
       return userRepository.save(user);

    }
}
