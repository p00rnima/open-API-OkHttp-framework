@swapi @people
Feature: Find the people details from swapi
  As an API user
  I want to get people details from swapi
  So that I use their starships and vehicle details

  Scenario Outline: Get given people details and verify the response
    When a user gets single person details from swapi with id <PEOPLE_ID>
    Then user verifies the people details
      | NAME   | HEIGHT   | MASS   | HAIR_COLOR   | SKIN_COLOR   | EYE_COLOR   | BIRTH_YEAR   | GENDER   |
      | <NAME> | <HEIGHT> | <MASS> | <HAIR_COLOR> | <SKIN_COLOR> | <EYE_COLOR> | <BIRTH_YEAR> | <GENDER> |
    Examples:
      | PEOPLE_ID | NAME           | HEIGHT | MASS | HAIR_COLOR | SKIN_COLOR | EYE_COLOR | BIRTH_YEAR | GENDER |
      | 1         | Luke Skywalker | 172    | 77   | blond      | fair       | blue      | 19BBY      | male   |
      | 4         | Darth Vader    | 202    | 136  | none       | white      | yellow    | 41.9BBY    | male   |

  Scenario Outline: Get all people details and verify given people data in the response
    When a user gets all the people details list
    Then user verifies the given person details
      | NAME   | EYE_COLOR   |
      | <NAME> | <EYE_COLOR> |
    Examples:
      | NAME           | EYE_COLOR |
      | Luke Skywalker | blue      |
      | Darth Vader    | yellow    |