# 📦 Automação Amazon

Este projeto tem como objetivo automatizar testes da **página inicial da Amazon Brasil** utilizando as seguintes tecnologias:

- ✅ **Selenium WebDriver**
- ✅ **JUnit**
- ✅ **Cucumber (Gherkin)**
- ✅ **Padrão de Projeto POM (Page Object Model)**

---

## 🎯 Funcionalidades testadas

- Sugestões de busca (**Autocomplete**)
- Menu superior
- Menu de hambúrguer

> ⚠️ **Observação:**  
Devido à proteção da Amazon contra bots, todos os testes foram configurados para simular **dispositivos mobile**.  
Por isso, em alguns casos, foi necessário o uso de **XPath** para localizar elementos dinâmicos, o que pode gerar instabilidades pontuais.

Se algum cenário falhar, **recomenda-se executar novamente**, pois pode ser um falso negativo relacionado à proteção de bot.

---

## 🚀 Como executar o projeto

- Faça o clone do repositorio
- Faça download das dependencias presentes no pom.xml
- Execute a partir do arquivo "TestRunner" ou no terminal com "mvn test"
