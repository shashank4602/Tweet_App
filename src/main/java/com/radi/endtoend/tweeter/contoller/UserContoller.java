package com.radi.endtoend.tweeter.contoller;

import com.radi.endtoend.tweeter.model.Tweet;
import com.radi.endtoend.tweeter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.Set;

@RestController
@RequestMapping("/user")
public class UserContoller {

    @Autowired
    UserService userService;

    @PostMapping("/tweet")
    public Set<Tweet> addTweet(@RequestBody Tweet tweet, Principal principal){
        User currentUser = (User) ((Authentication) principal).getPrincipal();
        System.out.println("Logged in user is : "+currentUser.getUsername());

        com.radi.endtoend.tweeter.model.User user=userService.saveTweet(tweet,currentUser.getUsername());

        return user.getTweets();
    }

    @GetMapping("/tweet")
    public Set<Tweet> getTweets(Principal principal) {
        User currentUser = (User) ((Authentication) principal).getPrincipal();
        System.out.println("Logged in user is : "+currentUser.getUsername());
        return userService.getTweets(currentUser.getUsername());
    }


    @PostMapping("/follow")
    public Integer follow(@RequestParam String tofollow, Principal principal){
        User currentUser = (User) ((Authentication) principal).getPrincipal();
    return userService.followUser(currentUser.getUsername(),tofollow).getFollowers().size();
    }

    }
