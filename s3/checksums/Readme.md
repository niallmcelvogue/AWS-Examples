## Create a new s3 bucket

```md
aws s3 mb s3://checksums-examples-nmce-1234
```

## Create a file that we will do a checksum on

```md
echo "Hello Mars!" >> myfile.txt
```

## Get a checksum of a file for md5

```md
md5sum myfile.txt
```

## Upload our file to s3 and look at its etag

```
aws s3 cp myfile.txt s3://checksums-examples-nmce-1234
aws s3api head-object --bucket checksums-examples-nmce-1234 --key myfile.txt
```

## Lets upload a file with a different kind of checksum

```md
ruby crc.rb

aws s3api put-object \
--bucket="checksums-examples-nmce-1234" \
--key="myfilesha1.txt" \
--body="myfile.txt" \
--checksum-algorithm="SHA256" \
--checksum-sha256="Hs2vviD6ownALQ5gG6YghSQ+BKsP/oPmfQwO3WrvBWg="
```
