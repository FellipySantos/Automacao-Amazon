Feature: Menu lateral e superior

  Scenario: Clicando no link do menu superior
    Given that I am accessing Amazon in mobile mode
    When I access the menu "Computadores"
    Then I must see products like "Computadores e Informática"

  Scenario: Clicando no link do menu lateral
    Given that I am accessing Amazon in mobile mode
    When I open the side menu
    And I access the category "Produtos em alta"
    Then I must see products in the category "Produtos em alta"

  Scenario: Clicando no link invalido do menu superior
    Given that I am accessing Amazon in mobile mode
    When I access the menu "Teste invalido"
    Then I should not be redirected

  Scenario: Clicando no link invalido do menu lateral
    Given that I am accessing Amazon in mobile mode
    When I open the side menu
    And I access the category "Teste invalido"
    Then I should not be redirected

  #Depois de executar os cenarios como mobile vi que o bloqueio da amazon para bots não funcionava
  #Aqui eu verifico as opções validas e invalidas do menu e seus redirecionamentos