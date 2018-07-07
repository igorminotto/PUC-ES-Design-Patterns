package br.puc.se.designPatterns.behavioral.visitor;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.puc.se.designPatterns.behavioral.visitor.DescontoIRM;
import br.puc.se.designPatterns.behavioral.visitor.ImpostoSobre;
import br.puc.se.designPatterns.behavioral.visitor.Pagamento;

public class IRMTest {
	
	// orgaos governamentais pagam um imposto de 20% (reduza o valor do pagamento em 20% para esse tipo de orgao)
	
	@Test
	public void IRMTestPF() {
		DescontoIRM descontoRetidoNaFonte = new DescontoIRM();
		Pagamento pagamentoPf = new Pagamento(ImpostoSobre.PESSOA_FISICA, 1000.f);
		descontoRetidoNaFonte.ajustaValor(pagamentoPf);
		assertEquals(pagamentoPf.getValor(), 1000.f, 0.001f);
	}
	
	@Test
	public void IRMTestPJ() {
		DescontoIRM descontoRetidoNaFonte = new DescontoIRM();
		Pagamento pagamentoPj = new Pagamento(ImpostoSobre.PESSOA_JURIDICA, 1000.f);
		descontoRetidoNaFonte.ajustaValor(pagamentoPj);
		assertEquals(pagamentoPj.getValor(), 1000.f, 0.001f);
	}
	
	@Test
	public void IRMTestOG() {
		DescontoIRM descontoRetidoNaFonte = new DescontoIRM();
		Pagamento pagamentoOg = new Pagamento(ImpostoSobre.ORGAO_GOVERNAMENTAL, 1000.f);
		descontoRetidoNaFonte.ajustaValor(pagamentoOg);
		assertEquals(pagamentoOg.getValor(), 800.f, 0.001f);
	}
	
	@Test
	public void IRMTestONG() {
		DescontoIRM descontoRetidoNaFonte = new DescontoIRM();		
		Pagamento pagamentoOg = new Pagamento(ImpostoSobre.ONG, 1000.f);
		descontoRetidoNaFonte.ajustaValor(pagamentoOg);
		assertEquals(pagamentoOg.getValor(), 1000.f, 0.001f);
	}

}
