[presentation](https://docs.google.com/presentation/d/1ITX8MWqPOQw95XxwHxGqowqnHWN5BlKk3s6ZPRz7qOo/edit?usp=sharing)


# Exercicios

Qualquer pacote que tenha um arquivo com o nome `dont-change.txt` nao deve ser modificado, senão perde a graça! :D

## 1 - servico de conversao de moedas
 
Temos um serviço de conversão de moedas implementado em código legado `LegacyCurrencyConverterService` e precisamos usar o código legado a partir do novo serviço `CurrencyConverterService`. O serviço legado utiliza um database para recuperar as cotações das moedas e isso não satisfaz mais os requisitos do software. Agora temos uma conexão que provê o valor da cotação online. Porém, o serviço legado está numa biblioteca que não temos mais como modificar. Nossa tarefa e conseguir usar o nosso novo `CurrencyOnlinePriceProvider` para prover a cotação para que o serviço legado faça os cálculos usando esse novo provider.


## 2 - escaneando imagens

Nosso software tem uma funcionalidade que obtém imagens a partir de um scanner. O código já funciona, mas está um pouco feio. Nossa tarefa e refatorar o código para melhorar a manutenção e organizar melhor a estrutura das classes.

## 3 - carregando por demanda

Temos um artefato chamado `DatabaseReader` que conecta no banco e carrega infinitos eventos `LogEvent` para cada entrada de log `LogEntry`. Contudo, não precisamos que toda essa carga seja feita na hora que carregamos a LogEntry. O que podemos fazer para essa carga de eventos seja realizada apenas quando os eventos do log forem realmente necessários?
