package com.radi.endtoend.tweeter.repository;


import com.radi.endtoend.tweeter.model.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface  TweetRepository extends JpaRepository<Tweet, Integer> {

     Tweet save(Tweet s);

     Optional<Tweet> findById(Integer integer);
}
