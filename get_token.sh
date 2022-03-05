curl --location --request POST 'http://localhost:8080/auth/realms/master/protocol/openid-connect/token' \
--header 'Authorization: Basic cGF5bWVudC1hcHA6YjExYmNiOGItOTUyMS00ZGE5LWJhYzUtYThiYzkwNTg5NDA5' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--data-urlencode 'grant_type=client_credentials'