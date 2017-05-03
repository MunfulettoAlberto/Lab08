package it.polito.tdp.borders.model;

public class Border {

	private String siglaA;
	private String siglaB;
	private String nomeA;
	private String nomeB;
	private Country c1 ;
	private Country c2 ;
	
	public Border(String siglaA, String siglaB) {
		super();
		this.siglaA = siglaA;
		this.siglaB = siglaB;
	}
	
	public Border(Country c1, Country c2) {
		super();
		this.c1= c1 ;
		this.c2= c2 ;
	}

	
	public Country getC1() {
		return c1;
	}

	public void setC1(Country c1) {
		this.c1 = c1;
	}

	public Country getC2() {
		return c2;
	}

	public void setC2(Country c2) {
		this.c2 = c2;
	}

	public String getNomeA() {
		return nomeA;
	}

	public void setNomeA(String nomeA) {
		this.nomeA = nomeA;
	}

	public String getNomeB() {
		return nomeB;
	}

	public void setNomeB(String nomeB) {
		this.nomeB = nomeB;
	}

	public String getSiglaA() {
		return siglaA;
	}

	public String getSiglaB() {
		return siglaB;
	}
	
	
}
