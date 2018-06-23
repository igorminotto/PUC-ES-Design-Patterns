Quarto exercicio:

Contexto: Voce possui diferentes destinos para logs ( 

public enum LoggerType {
	HTTP_POST, CONSOLE, FILE, JMS
}

Voce precisa criar um mecanismo para, a partir do tipo de log, criar uma implementacao
especifica da classe OutputLogger para que os logs sejam enviados para o destino correto.