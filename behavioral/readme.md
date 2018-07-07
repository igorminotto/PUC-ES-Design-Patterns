[presentation](https://docs.google.com/presentation/d/1IzJxLosZaGtwmvCjbhlL8f_Y0JdNU58mg_MSpBXq6dw/edit?usp=sharing)

# Exercicios

Para as atividades #1 e #2, utilize os pacotes `br.puc.se.designPatterns.behavioral.log.templatemethod` e `br.puc.se.designPatterns.behavioral.strategy`, respectivamente. Cada um tem seus proprios testes e verifica as classes separadamente. As mudancas no pacote `templatemethod` nao devem interferir no pacote `strategy`.

## 1 - estrutura de classes para fazer logs em console, arquivo e http post usando templatemethod (heranca)
 
Temos uma estrutura de logs que nos possibilita enviar logs para o console, arquivo e http. Contudo temos uma grande duplicacao de codigo. Sua tarefa e' reduzir essa duplicacao utilizando o padrao templatemethod. (Utilize as classes e teste do pacote `br.puc.se.designPatterns.behavioral.log.templatemethod` )

## 2 - estrutura de classes para fazer logs em console, arquivo e http post usando strategy (composicao)
 
Temos uma estrutura de logs que nos possibilita enviar logs para o console, arquivo e http. Contudo temos uma grande duplicacao de codigo. Sua tarefa e' reduzir essa duplicacao utilizando o padrao strategy. (Utilize as classes e teste do pacote `br.puc.se.designPatterns.behavioral.log.strategy` )

## 3 - aplicacao de impostos e ajuda de custo

Temos uma estrutura de pagamentos no pacote `br.puc.se.designPatterns.behavioral.visitor`. Note que voce nao pode modificar a classe `Pagamento`, mas precisa atualizar o valor do pagamento mediante a aplicacao dos impostos de IRM e IRE e aplicar a ajuda de custo.

Sua missao e' fazer os testes do pacote `br.puc.se.designPatterns.behavioral.visitor` passarem. Voce vai precisar utilizar o padrao de projeto visitor para ajustar os valores do pagamento.