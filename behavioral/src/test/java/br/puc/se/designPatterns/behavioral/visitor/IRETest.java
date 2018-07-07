package br.puc.se.designPatterns.behavioral.visitor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.puc.se.designPatterns.behavioral.visitor.DescontoIRE;
import br.puc.se.designPatterns.behavioral.visitor.ImpostoSobre;
import br.puc.se.designPatterns.behavioral.visitor.Pagamento;

public class IRETest {
	
	// pessoa fisica paga 20% de imposto (reduca em 20% o valor dentro do objeto pagamento)
	// pessoa juridica paga 10% de imposto (reduca em 20% o valor dentro do objeto pagamento)
	// ONG e governo sao isentos
	
	@Test
	public void IRETestPF() {
		DescontoIRE descontoRetidoNaFonte = new DescontoIRE();
		Pagamento pagamentoPf = new Pagamento(ImpostoSobre.PESSOA_FISICA, 1000.f);
		descontoRetidoNaFonte.ajustaValor(pagamentoPf);
		assertEquals(pagamentoPf.getValor(), 800.f, 0.001f);
	}
	
	@Test
	public void IRETestPJ() {
		DescontoIRE descontoRetidoNaFonte = new DescontoIRE();
		Pagamento pagamentoPj = new Pagamento(ImpostoSobre.PESSOA_JURIDICA, 1000.f);
		descontoRetidoNaFonte.ajustaValor(pagamentoPj);
		assertEquals(pagamentoPj.getValor(), 900.f, 0.001f);
	}
	
	@Test
	public void IRETestOG() {
		DescontoIRE descontoRetidoNaFonte = new DescontoIRE();
		Pagamento pagamentoOg = new Pagamento(ImpostoSobre.ORGAO_GOVERNAMENTAL, 1000.f);
		descontoRetidoNaFonte.ajustaValor(pagamentoOg);
		assertEquals(pagamentoOg.getValor(), 1000.f, 0.001f);
	}
	
	@Test
	public void IRETestONG() {
		DescontoIRE descontoRetidoNaFonte = new DescontoIRE();		
		Pagamento pagamentoOg = new Pagamento(ImpostoSobre.ORGAO_GOVERNAMENTAL, 1000.f);
		descontoRetidoNaFonte.ajustaValor(pagamentoOg);
		assertEquals(pagamentoOg.getValor(), 1000.f, 0.001f);
	}

}
