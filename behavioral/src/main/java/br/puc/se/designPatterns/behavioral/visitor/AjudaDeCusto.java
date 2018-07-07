package br.puc.se.designPatterns.behavioral.visitor;

// se uma pessa fisica recebe menos de 250f, adicione uma ajuda de custo de 10% ao valor do pagamento
// por outro lado, se qualquer entidade recebe mais que 250f, cobre um imposto de 2%
public class AjudaDeCusto extends PagamentoVisitor {
	public static final float LIMITE_DA_FAIXA = 250.0f;

	@Override
	protected float getValorAjustado(Pagamento pagamento) {
		float valor = pagamento.getValor();
		if(pagamento.getTipoEntidade().equals(ImpostoSobre.PESSOA_FISICA) && valor < AjudaDeCusto.LIMITE_DA_FAIXA) {
			valor *= 1.1f;
		} else {
			valor *= 0.98f;
		}
		return valor;
	}

}
