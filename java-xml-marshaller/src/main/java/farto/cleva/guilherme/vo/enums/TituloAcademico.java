package farto.cleva.guilherme.vo.enums;

import farto.cleva.guilherme.utils.StringUtil;

public enum TituloAcademico {

	ESPECIALISTA("Esp"), MESTRE("Me"), DOUTOR("Dr");

	private String value;

	private TituloAcademico(String value) {
		this.value = value;
	}

	public static TituloAcademico findByValue(String value) {
		if (StringUtil.isNotEmptyOrNull(value)) {
			for (TituloAcademico tituloAcademico : TituloAcademico.values()) {
				if (value.equals(tituloAcademico.value)) {
					return tituloAcademico;
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
