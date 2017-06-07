package farto.cleva.guilherme.vo;

import java.math.BigDecimal;
import java.text.MessageFormat;

public class NotaVO {

	private String descricao;
	private BigDecimal valor;

	public NotaVO(String descricao, BigDecimal valor) {
		super();
		this.descricao = descricao;
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		StringBuilder data = new StringBuilder("");

		data.append(MessageFormat.format("{0}: {1, number,#.00}", descricao, valor));

		return data.toString();
	}

}
