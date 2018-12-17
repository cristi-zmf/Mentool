@subjects
Feature: Incognito app permits the listing of all subjects


  As User i want to see the subjects
  So that i can find interesting subjects

  Scenario Consult the list of subjects
    Given There is 1 subject:
      | title     | description     |
      | iphone xs | expensive phone |
    When The use consults the subject list
    Then He sees the following list:
      | title     | description     |
      | iphone xs | expensive phone |