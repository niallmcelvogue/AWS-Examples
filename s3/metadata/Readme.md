## Create our bucket
```sh
aws s3 mb s3://metadata-fun-nmce-1234
```

## Create a new file

```sh
echo "Hello Mars" > hello.txt
```

## Upload file with metadata

```sh
aws s3api put-object --bucket="metadata-fun-nmce-1234" --key="hello.txt" --metadata Planet=Mars --body="hello.txt"
```

## Get metadata through head object
```sh
aws s3api head-object --bucket="metadata-fun-nmce-1234" --key hello.txt
```

