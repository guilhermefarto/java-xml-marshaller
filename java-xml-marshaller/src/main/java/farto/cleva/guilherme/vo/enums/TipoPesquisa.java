package farto.cleva.guilherme.vo.enums;

import farto.cleva.guilherme.utils.StringUtil;

public enum TipoPesquisa {

	PIC("PIC"), ARTIGO("Artigo"), MONOGRAFIA("Monografia");

	private String value;

	private TipoPesquisa(String value) {
		this.value = value;
	}

	public static TipoPesquisa findByValue(String value) {
		if (StringUtil.isNotEmptyOrNull(value)) {
			for (TipoPesquisa tipoPesquisa : TipoPesquisa.values()) {
				if (value.equals(tipoPesquisa.value)) {
					return tipoPesquisa;
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
