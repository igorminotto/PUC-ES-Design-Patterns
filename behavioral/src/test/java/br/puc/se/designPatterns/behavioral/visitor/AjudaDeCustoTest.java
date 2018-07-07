package br.puc.se.designPatterns.behavioral.visitor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.puc.se.designPatterns.behavioral.visitor.AjudaDeCusto;
import br.puc.se.designPatterns.behavioral.visitor.ImpostoSobre;
import br.puc.se.designPatterns.behavioral.visitor.Pagamento;

public class AjudaDeCustoTest {
	
	// se uma pessa fisica recebe menos de 250f, adicione uma ajuda de custo de 10% ao valor do pagamento
	// por outro lado, se qualquer entidade recebe mais que 250f, cobre um imposto de 2%
	
	@Test
	public void ajudaCustoTestPFDentroDaFaixa() {
		AjudaDeCusto descontoRetidoNaFonte = new AjudaDeCusto();
		Pagamento pagamentoPf = new Pagamento(ImpostoSobre.PESSOA_FISICA, 200.f);
		descontoRetidoNaFonte.ajustaValor(pagamentoPf);
		assertEquals(pagamentoPf.getValor(), 220.f, 0.001f);
	}
	
	@Test
	public void ajudaCustoTestPFForaDaFaixa() {
		AjudaDeCusto descontoRetidoNaFonte = new AjudaDeCusto();
		Pagamento pagamentoPf = new Pagamento(ImpostoSobre.PESSOA_FISICA, 1000.f);
		descontoRetidoNaFonte.ajustaValor(pagamentoPf);
		assertEquals(pagamentoPf.getValor(), 980.f, 0.001f);
	}
	
	@Test
	public void ajudaCustoTestPJ() {
		AjudaDeCusto descontoRetidoNaFonte = new AjudaDeCusto();
		Pagamento pagamentoPj = new Pagamento(ImpostoSobre.PESSOA_JURIDICA, 1000.f);
		descontoRetidoNaFonte.ajustaValor(pagamentoPj);
		assertEquals(pagamentoPj.getValor(), 980.f, 0.001f);
	}
	
	@Test
	public void ajudaCustoTestOG() {
		AjudaDeCusto descontoRetidoNaFonte = new AjudaDeCusto();
		Pagamento pagamentoOg = new Pagamento(ImpostoSobre.ORGAO_GOVERNAMENTAL, 1000.f);
		descontoRetidoNaFonte.ajustaValor(pagamentoOg);
		assertEquals(pagamentoOg.getValor(), 980.f, 0.001f);
	}
	
	@Test
	public void ajudaCustoTestONG() {
		AjudaDeCusto descontoRetidoNaFonte = new AjudaDeCusto();	
		Pagamento pagamentoOg = new Pagamento(ImpostoSobre.ONG, 1000.f);
		descontoRetidoNaFonte.ajustaValor(pagamentoOg);
		assertEquals(pagamentoOg.getValor(), 980.f, 0.001f);
	}


}
