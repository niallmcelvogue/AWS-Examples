## Create a bucket
```sh
aws s3 mb s3://class-fun-nmce-1234
```

## Create a file
```sh
echo "Hello World" > hello.txt
aws s3 cp hello.txt s3://class-fun-nmce-1234 --storage-class="STANDARD_IA"
```