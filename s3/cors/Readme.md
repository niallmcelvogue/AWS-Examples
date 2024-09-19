## Create Website 1
## Create a bucket
```sh
aws s3 mb s3://cors-example-nmce-1234
```

## Change block public access
```sh
aws s3api put-public-access-block \
--bucket cors-example-nmce-1234 \
--public-access-block-configuration "BlockPublicAcls=true,BlockPublicPolicy=false, RestrictPublicBuckets=false, IgnorePublicAcls=true"
```

## Create a bucket policy
```sh
aws s3api put-bucket-policy --bucket cors-example-nmce-1234 --policy file://policy.json
```
## Turn on static web hosting
```sh
aws s3 website s3://cors-example-nmce-1234/ --index-document index.html
```

## Upload a file
```sh
aws s3 cp index.html s3://cors-example-nmce-1234/
```

## Get the website URL
```sh
aws s3 presign s3://cors-example-nmce-1234/index.html
```

## Create API Gateway with Mock Response 
```sh
curl -X POST https://io8vh25yq3.execute-api.eu-north-1.amazonaws.com/prod/hello \
     -H "Content-Type: application/json"
```

## Set CORS on our bucket
```sh
aws s3api put-bucket-cors --bucket cors-example-nmce-1234 --cors-configuration file://cors.json
```

## Cleanup 
```sh
aws s3 rb s3://cors-example-nmce-1234 --force
```
