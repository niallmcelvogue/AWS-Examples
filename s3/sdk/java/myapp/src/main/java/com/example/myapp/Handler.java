package com.example.myapp;

import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.*;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Random;
import java.util.UUID;

/**
 * Lambda function entry point. You can change to use other pojo type or implement
 * a different RequestHandler.
 *
 * @see <a href=https://docs.aws.amazon.com/lambda/latest/dg/java-handler.html>Lambda Java Handler</a> for more information
 */
public class Handler {
    private final S3Client s3Client;
    private final String bucketName;

    public Handler(String bucketName) {
        // Initialize the SDK client outside of the handler method so that it can be reused for subsequent invocations.
        // It is initialized when the class is loaded.
        this.bucketName = bucketName;
        s3Client = DependencyFactory.s3Client();
        // Consider invoking a simple api here to pre-warm up the application, eg: dynamodb#listTables
    }

    public void sendRequest() {
        createBucket();
        populateBucket();
    }

    public void createBucket() {
        try {
            s3Client.createBucket(CreateBucketRequest
                    .builder()
                    .bucket(bucketName)
                    .build());
            System.out.println("Creating bucket: " + bucketName);
            s3Client.waiter().waitUntilBucketExists(HeadBucketRequest.builder()
                    .bucket(bucketName)
                    .build());
            System.out.println(bucketName + " is ready.");
            System.out.printf("%n");
        } catch (S3Exception e) {
            System.err.println(e.awsErrorDetails().errorMessage());
            System.exit(1);
        }
    }

    public void populateBucket() {
        try {
            Path tmpDirPath = Files.createTempDirectory("s3JavaFiles");
            int numOfFiles = new Random().nextInt(6) + 1;

            for (int i = 0; i < numOfFiles; i++) {
                String fileName = "myFile" + i + ".txt";
                Path filePath = tmpDirPath.resolve(fileName);
                Files.write(filePath, ("Hello World" + UUID.randomUUID()).getBytes(StandardCharsets.UTF_8));

                s3Client.putObject(PutObjectRequest.builder()
                        .bucket(bucketName)
                        .key(fileName)
                        .build(),
                        filePath);

                System.out.println(fileName + " uploaded.");
            }
        } catch (IOException e) {
            System.err.println("Error populating bucket: " + e.getMessage());
        }
    }
}