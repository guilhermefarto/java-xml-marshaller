package farto.cleva.guilherme.vo;

import java.text.MessageFormat;
import farto.cleva.guilherme.vo.enums.TipoPesquisa;

public class PesquisaVO {

	private String titulo;
	private TipoPesquisa tipoPesquisa;

	public PesquisaVO(String titulo, TipoPesquisa tipoPesquisa) {
		super();
		this.titulo = titulo;
		this.tipoPesquisa = tipoPesquisa;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public TipoPesquisa getTipoPesquisa() {
		return tipoPesquisa;
	}

	public void setTipoPesquisa(TipoPesquisa tipoPesquisa) {
		this.tipoPesquisa = tipoPesquisa;
	}

	@Override
	public String toString() {
		StringBuilder data = new StringBuilder("");

		data.append(MessageFormat.format("{0} ({1})", titulo, tipoPesquisa));

		return data.toString();
	}

}
