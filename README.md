Instructions to run:
Create connection with mysql db
Create database paymentmethoddb
Use jdk 1.8 and java version 8
Spring boot version 2.7.3
Run application

Here is the sample curl for post request
curl --location --request POST 'http://localhost:9090/api/v1.0/configuration/payment-methods' \
--header 'Content-Type: application/json' \
--data-raw '{
    "paymentMethods": {
        "name": "cash",
        "displayName": "credit card",
        "paymentType": "MOBILE_CARRIER",
        "paymentPlans": [
            {
                "netAmount": 5.03,
                "taxAmount": 5.21,
                "grossAmount": 5.24,
                "currency": "USD",
                "duration": "MONTH"
            },
            {
                "netAmount": 50,
                "taxAmount": 50,
                "grossAmount": 5.02,
                "currency": "PKR",
                "duration": "WEEK"
            },
            {
                "netAmount": 5.03,
                "taxAmount": 5.21,
                "grossAmount": 5.24,
                "currency": "USD",
                "duration": "MONTH"
            },
            {
                "netAmount": 50,
                "taxAmount": 50,
                "grossAmount": 5.02,
                "currency": "PKR",
                "duration": "WEEK"
            },
            {
                "netAmount": 5.03,
                "taxAmount": 5.21,
                "grossAmount": 5.24,
                "currency": "bitcoin",
                "duration": "MONTH"
            }
        ]
    }
}'
