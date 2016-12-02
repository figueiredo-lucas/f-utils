package br.com.futils.test;

public class ComplexClass {

	private String campo1;

	private Long campo2;

	public String getCampo1() {
		return campo1;
	}

	public void setCampo1(final String campo1) {
		this.campo1 = campo1;
	}

	public Long getCampo2() {
		return campo2;
	}

	public void setCampo2(final Long campo2) {
		this.campo2 = campo2;
	}

	@Override
	public String toString() {
		return "ComplexClass [campo1=" + campo1 + ", campo2=" + campo2 + "]";
	}

}
