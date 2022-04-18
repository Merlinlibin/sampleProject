Feature: Login page Execution

  @validusername
  Scenario: Validate the Login page with correct username  and password	 
    Given Login into the Application
  When Enter the user name "sakthivijayarajan"
  And Enter the password "9755Z6"
  And Click the login
  Then Validate the Home page title
  
   @invalidusername
  Scenario: Validate the Login page with correct username  and password	 
  Given Login into the Application
  When Enter the invalid user name "<name>"
  And Enter the password "<pass>"
  And Click the login
  Then Validate the Home page title
  Examples:
  |name|pass|
  |merlin|12345|
  |libin|56789|
  |nisha|25846|
  
  #list
   @validusernameaslist
  Scenario: Validate the Login page with correct username  and password	 
  Given Login into the Application
  And Enter the password 
  |merlin|12345|libin|56789|
  
   #lists
   @validusernameaslists
  Scenario: Validate the Login page with correct username  and password	 
  Given Login into the Application
  And Enter the username & password
  |merlin|12345|
  |libin|56789|
  |nisha|25846| 
  
   @Map
  Scenario: Validate the Login page with correct username  and password	 
  Given Login into the Application
  When Enter the username & password
  |name1|name2|name3|
  |Aiite1|Aiite3|Aiite4|
  |Aiite7|Aiite5|Aiite6|
 # |1|libin|
 # |2|merlin|
 # |3|nisha| 
  
  
