## Create a new bucket
```sh
aws s3api create-bucket --bucket acl-example-nmce-1234 --region eu-north-1  --create-bucket-configuration="LocationConstraint=eu-north-1"
```

## Turn off block public access for ACLs

```sh
aws s3api put-public-access-block \
--bucket acl-example-nmce-1234 \
--public-access-block-configuration "BlockPublicAcls=false,BlockPublicPolicy=true,RestrictPublicBuckets=true"
```

## Change bucket ownership

```sh
aws s3api put-bucket-ownership-controls \
--bucket acl-example-nmce-1234 \
--ownership-controls="Rules=[{ObjectOwnership=BucketOwnerPreferred}]"
```

## Chance ACLs to allow for a user in another AWS account 

```sh
aws s3api put-bucket-acl \
--bucket acl-example-nmce-1234 \
--access-control-policy file:///Users/niall.mcelvogue/AWS-Examples/s3/acls/policy.json
```

## Access bucket from other account
```sh
touch bootcamp.txt
aws s3 cp bootcamp.txt s3://acl-example-nmce-1234/
aws s3 ls s3://acl-example-nmce-1234/
```

## Cleanup
```sh
aws s3 rm s3://acl-example-nmce-1234/bootcamp.txt
aws s3 rb s3://acl-example-nmce-1234
```