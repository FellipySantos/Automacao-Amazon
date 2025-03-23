Feature: Autocomplete de busca na Amazon

  Scenario:  Exibição de sugestões ao digitar um termo válido
    Given that I am on the Amazon home page
    When I search for "notebook"
    Then I should see suggestions that contain the text "notebook"

  Scenario:  Exibição de sugestões ao digitar um termo inválido
    Given that I am on the Amazon home page
    When I search for "kasjhdkajskdh"
    Then I shouldn't see suggestions that contain the text "kasjhdkajskdh"

    #Aqui eu misturo português com ingles, mas isso vai de acordo com o padrão de projeto
    #Podemos usar o io.cucumber.java.pt para manter tudo em português caso necessario

    #Os testes são configuraveis e valeria uma pesquisa junto a equipe de produtos para levantar os produtos mais vendidos
    #Basta alterar os valores entre aspas no teste para variar o que será inserido na pesquisa