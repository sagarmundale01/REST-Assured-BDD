Feature: Validating place APIs

"@AddPlace or @Regression"
Scenario Outline: Verify if place is being Successfully added using AddPlaceAPI

   Given Add Place Payload with "<name>" "<language>" "<address>"
   When user calls "addPlaceAPI" with "POST" http request
   Then the API call is success with status code 200
   And "status" in response body is "OK"
   And "scope" in response body is "APP"

Examples:
   | name     | language | address               |
   | AA House | English  | World cross center    |
   | BB House | Spanish  | Sea cross center      |
   | CC House | French   | Mountain cross center |
   
   