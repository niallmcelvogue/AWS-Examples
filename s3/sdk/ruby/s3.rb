require 'aws-sdk-s3'   # Require the AWS SDK for S3 to interact with S3 services
require 'pry'          # Require Pry for debugging (optional, used for development)
require 'securerandom' # Require SecureRandom for generating random hexadecimal strings

# Fetch the S3 bucket name from environment variables
bucket_name = ENV['BUCKET_NAME']

# Define the AWS region where the S3 bucket will be created
region = 'eu-north-1'

# Create an S3 client to interact with the S3 service
client = Aws::S3::Client.new(region: 'eu-north-1')

# Create a new S3 bucket with the specified name and region
resp = client.create_bucket({
    bucket: bucket_name,
    create_bucket_configuration: {
        location_constraint: region,  # Set the region where the bucket will be created
    }
})

# Generate a random number of files between 1 and 6
number_of_files = 1 + rand(6)
puts "number_of_files: #{number_of_files}"  # Output the number of files to be created

# Loop through the number of files and create each one
number_of_files.times.each do |i| 
    puts "i: #{i}"  # Output the current iteration number
    
    # Define a unique filename for each file
    filename = "file_#{i}.txt"
    output_path = "/tmp/#{filename}"  # Define the output path for the file

    # Create and write content to the file with a random hexadecimal string
    File.open(output_path,  "w") do |f|
        f.write("Hello, World! #{SecureRandom.hex(10)}")
    end
    
    # Open the file in binary mode and upload it to the S3 bucket
    File.open(output_path, "rb") do |f| 
        client.put_object(
            bucket: bucket_name, 
            key: filename,   # Use the filename as the key in the S3 bucket
            body: f          # Set the file content as the body of the S3 object
        )
    end
end
