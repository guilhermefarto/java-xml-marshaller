package farto.cleva.guilherme.vo.enums;

import farto.cleva.guilherme.utils.StringUtil;

public enum Sexo {

	MASCULINO("M"), FEMININO("F");

	private String value;

	private Sexo(String value) {
		this.value = value;
	}

	public static Sexo findByValue(String value) {
		if (StringUtil.isNotEmptyOrNull(value)) {
			for (Sexo sexo : Sexo.values()) {
				if (value.equals(sexo.value)) {
					return sexo;
				}
			}
		}

		return null;
	}

	@Override
	public String toString() {
		return value;
	}

}
