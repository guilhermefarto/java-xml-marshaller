package farto.cleva.guilherme.vo;

import java.text.MessageFormat;

public class DisciplinaVO {

	private String descricao;
	private ProfessorVO professor;

	public DisciplinaVO(String descricao, ProfessorVO professor) {
		super();
		this.descricao = descricao;
		this.professor = professor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public ProfessorVO getProfessor() {
		return professor;
	}

	public void setProfessor(ProfessorVO professor) {
		this.professor = professor;
	}

	@Override
	public String toString() {
		StringBuilder data = new StringBuilder("");

		data.append(MessageFormat.format("{0} - {1}", descricao, professor.toString()));

		return data.toString();
	}

}
