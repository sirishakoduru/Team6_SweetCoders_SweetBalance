@account

Feature: Validation on Account Information section for registered free user dashboard page

Background: User is in Home Page after logged in 
 @t7
  Scenario: Verify age should accept only Numeric Value
  When  User edit age field with valid data
  Then  User should see that entered age is displayed in that field
  @t8
  Scenario:  Verify height should accept only Numeric Value
  When  User Edit height field with valid data
  Then  User should see that entered height is displayed in Height field
  @t9
  Scenario:  Verify Weight should accept only Numeric Value
  When  User Edit Weight field with valid data
  Then  User should see that entered weight is displayed  in Weight field
  @t10
  Scenario:  Verify Exercise Routine Level dropdown is displayed with options
  When  User clicks the dropdown of Exercise Routine Level
  Then  User should see the dropdown with options "Easy","Medium","Hard"
  @t11
  Scenario:  Verify Cuisine Preferences dropdown is displayed with options
  When  User clicks the dropdown of Cuisine Preferences
  Then  User should see the dropdown with list of cuisine types "Indian","American","Continental","Mediterranean","Asian","Middle Eastern,"Mexican" 
  @t12
  Scenario: Verify Food Allergies dropdown is displayed with options
  When   User clicks the dropdown of Food Allergies
  Then   User should see the dropdown list of common allergy options "None","Dairy","Gluten","Shellfish","Soy","Eggs","Nuts","Other"
  