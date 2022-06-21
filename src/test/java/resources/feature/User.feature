@Users
Feature: Users CRUD Test
  As a user I would like to verify to CRUD operation of the application

  Scenario: I create a new user on the application
    When I send a POST request to the application using a valid payload
    Then I get a valid status code 201 from the application

  Scenario: I read a new created user from the application

    When I send a GET request to the application to read newly created user
    And  I get a valid status code 200 from the application
    Then I verify if the new user created with correct details

  Scenario: I update a new created user on the application
    When I send a PATCH request to the application using a valid payload
    And  I get a valid status code 200 from the application
    Then I verify if the new user updated with correct details

  Scenario: I delete a new created user from the application
    When I send a DELETE request to the application
    And  I get a valid status code 204 from the application
    Then I verify if the new user deleted from the application

  Scenario: I get all users of the application
    When I send a GET request to the application to read all users
    And  I get a valid status code 200 from the application
    And  I verify if total records are 20
    And  I verify if the id 3262 has name "Gautam Mehrotra"
    And  I verify if the id 3262 had email "gautam_mehrotra@mante-gorczany.org"
    And  I verify if the all id has status "active"
    And  I verify if the id 3900 has gender "female"
    Then I verify if the id 3897 had gender "male"
