Feature: Project widget

  Background: login
    Given I send a POST request to /projects
      | name                              | AT01 project-01 |
      | iteration_length                  | 1               |
      | week_start_day                    | Monday          |
      | point_scale                       | 0,1,2,3         |
      | start_date                        | 2016-08-29      |
      | number_of_done_iterations_to_show | 12              |
      | initial_velocity                  | 10              |
    And I expect the status code 200
    And Synchronize Mach2 and Pivotal

  @deleteAllProjects
  Scenario: Validate All information from pivotal projects are displayed in Mach2 table widget
    When I add a table widget in the board
    And I select the Project option
    Then Validate project table against pivotal project

  Scenario: C65_PW-Verify that the info in the Name field on a INFO in M2 is the same as on PT
    When I add a info widget in the board
      And I select the Project option
      And Click on ‘Save’ button
      And Go to the Project table 'Name' column
    Then Verify that the project name is the same that the project on Pivotal Tracker
