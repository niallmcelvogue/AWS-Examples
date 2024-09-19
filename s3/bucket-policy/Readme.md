## Create a bucket
```sh
aws s3 mb s3://bucket-policy-example-nmce-1234
```
## Create a bucket policy
```sh
aws s3api put-bucket-policy --bucket bucket-policy-example-nmce-1234 --policy file://policy.json
```

## Access bucket from other account
```sh
touch bootcamp.txt
aws s3 cp bootcamp.txt s3://bucket-policy-example-nmce-1234/
aws s3 ls s3://bucket-policy-example-nmce-1234/
```

## Cleanup
```sh
aws s3 rm s3://bucket-policy-example-nmce-1234/bootcamp.txt
aws s3 rb s3://bucket-policy-example-nmce-1234
```
