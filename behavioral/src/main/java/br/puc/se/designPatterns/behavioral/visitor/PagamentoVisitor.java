package br.puc.se.designPatterns.behavioral.visitor;

public abstract class PagamentoVisitor {
	
	public void ajustaValor(Pagamento pagamento) {
		float valor = this.getValorAjustado(pagamento);
		pagamento.setValor(valor);
	}
	
	protected abstract float getValorAjustado(Pagamento pagamento);
	
}
