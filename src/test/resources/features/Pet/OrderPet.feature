@StoreAPI
Feature: Order Pet
  Scenario: Post order pet with valid json
    Given Post order with valid json
    When User send request post order
    Then Should return status code 200
    And Response body contains id 1 and pet id 1
    And Validate schema for Post Order Json

  Scenario: Get order pet with valid id
    Given Get pet order data with id 1
    When Get pet order request
    Then Should return status code 200
    And Response body contains id 1
    And Validate schema for Get Order Json

  Scenario: Get inventory data with valid path
    Given Get inventory data with valid path "inventory"
    When Get inventory data request
    Then Should return status code 200
    And Validate schema for Get inventory Json