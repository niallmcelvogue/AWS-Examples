package com.example.myapp;

public class Main {

    public static void main(String[] args) {

        if(args.length < 1) {
            throw new RuntimeException("Bucket name must be provided");
        }
        String bucketName = args[0];
        Handler handler = new Handler(bucketName);
        handler.sendRequest();
    }
}
