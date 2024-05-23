package com.radi.endtoend.tweeter.contoller;

import com.radi.endtoend.tweeter.model.Tweet;
import com.radi.endtoend.tweeter.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tweet")
public class TweetController {

    @Autowired
    TweetService tweetService;

    @GetMapping("/{id}")
    public Tweet getTweet(@PathVariable Integer id){
       return tweetService.findByid(id);
    }

    @PostMapping
    public Integer saveTweet(@RequestBody Tweet tweet){
        return tweetService.saveTweet(tweet);
    }


}
