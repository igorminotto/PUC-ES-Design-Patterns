package br.puc.se.designPatterns.behavioral.visitor;

// pessoa fisica paga 20% de imposto (reduca em 20% o valor dentro do objeto pagamento)
// pessoa juridica paga 10% de imposto (reduca em 20% o valor dentro do objeto pagamento)
// ONG e governo sao isentos
public class DescontoIRE extends PagamentoVisitor {
	
	@Override
	protected float getValorAjustado(Pagamento pagamento) {
		float valor = pagamento.getValor();
		if(pagamento.getTipoEntidade().equals(ImpostoSobre.PESSOA_FISICA)) {
			valor *= 0.8f;
		} else if(pagamento.getTipoEntidade().equals(ImpostoSobre.PESSOA_JURIDICA)) {
			valor *= 0.9f;
		}
		return valor;
	}

}
