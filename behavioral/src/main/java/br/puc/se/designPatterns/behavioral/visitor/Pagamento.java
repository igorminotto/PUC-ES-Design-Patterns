package br.puc.se.designPatterns.behavioral.visitor;

// voce nao pode alterar essa classe nem extender ela
public final class Pagamento {

	private ImpostoSobre pessoaFisica;
	
	private float valor;

	public Pagamento(ImpostoSobre pessoaFisica, float valor) {
		this.pessoaFisica = pessoaFisica;
		this.valor = valor;
	}
	
	public ImpostoSobre getTipoEntidade() {
		return pessoaFisica;
	}
	
	public float getValor() {
		return valor;
	}
	
	public void setValor(float valor) {
		this.valor = valor;
	}

}
