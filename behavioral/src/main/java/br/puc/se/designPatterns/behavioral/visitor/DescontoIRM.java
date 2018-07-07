package br.puc.se.designPatterns.behavioral.visitor;

// orgaos governamentais pagam um imposto de 20% (reduza o valor do pagamento em 20% para esse tipo de orgao)
public class DescontoIRM extends PagamentoVisitor {
	
	@Override
	protected float getValorAjustado(Pagamento pagamento) {
		float valor = pagamento.getValor();
		if(pagamento.getTipoEntidade().equals(ImpostoSobre.ORGAO_GOVERNAMENTAL)) {
			valor *= 0.8f;
		}
		return valor;
	}

}
