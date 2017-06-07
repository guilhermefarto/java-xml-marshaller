package farto.cleva.guilherme.vo;

import java.text.MessageFormat;
import farto.cleva.guilherme.vo.enums.TituloAcademico;

public class ProfessorVO {

	private String nome;
	private TituloAcademico tituloAcademico;

	public ProfessorVO(String nome, TituloAcademico tituloAcademico) {
		super();
		this.nome = nome;
		this.tituloAcademico = tituloAcademico;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public TituloAcademico getTituloAcademico() {
		return tituloAcademico;
	}

	public void setTituloAcademico(TituloAcademico tituloAcademico) {
		this.tituloAcademico = tituloAcademico;
	}

	@Override
	public String toString() {
		StringBuilder data = new StringBuilder("");

		data.append(MessageFormat.format("{0}, {1}", nome, tituloAcademico));

		return data.toString();
	}

}
