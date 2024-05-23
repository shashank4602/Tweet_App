package com.radi.endtoend.tweeter.exception;

public class TweetNotFoundException extends RuntimeException {
    public TweetNotFoundException(String s) {
        super(s);
    }
}
