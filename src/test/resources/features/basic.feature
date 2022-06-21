Feature: basic

  Scenario: scenario
    Given visit duck duck go
    When I search FluentLenium
    Then Title contains FluentLenium
