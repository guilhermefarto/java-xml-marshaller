package farto.cleva.guilherme.vo;

import java.text.MessageFormat;
import java.util.LinkedList;
import java.util.List;
import farto.cleva.guilherme.utils.ListUtil;

public class CursoVO {

	private String sigla;
	private String descricao;
	private long quantidadeAlunosRegular;
	private long quantidadeAlunosDependencia;
	private List<DisciplinaVO> disciplinas;
	private ProfessorVO coordenador;

	public CursoVO(String sigla, String descricao, long quantidadeAlunosRegular, long quantidadeAlunosDependencia) {
		super();
		this.sigla = sigla;
		this.descricao = descricao;
		this.quantidadeAlunosRegular = quantidadeAlunosRegular;
		this.quantidadeAlunosDependencia = quantidadeAlunosDependencia;
	}

	public String getSigla() {
		return sigla;
	}

	public void setSigla(String sigla) {
		this.sigla = sigla;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public long getQuantidadeAlunosRegular() {
		return quantidadeAlunosRegular;
	}

	public void setQuantidadeAlunosRegular(long quantidadeAlunosRegular) {
		this.quantidadeAlunosRegular = quantidadeAlunosRegular;
	}

	public long getQuantidadeAlunosDependencia() {
		return quantidadeAlunosDependencia;
	}

	public void setQuantidadeAlunosDependencia(long quantidadeAlunosDependencia) {
		this.quantidadeAlunosDependencia = quantidadeAlunosDependencia;
	}

	public List<DisciplinaVO> getDisciplinas() {
		if (ListUtil.isNull(disciplinas)) {
			disciplinas = new LinkedList<DisciplinaVO>();
		}

		return disciplinas;
	}

	public void setDisciplinas(List<DisciplinaVO> disciplinas) {
		this.disciplinas = disciplinas;
	}

	public void adicionarDisciplina(DisciplinaVO disciplina) {
		this.getDisciplinas().add(disciplina);
	}

	public ProfessorVO getCoordenador() {
		return coordenador;
	}

	public void setCoordenador(ProfessorVO coordenador) {
		this.coordenador = coordenador;
	}

	@Override
	public String toString() {
		StringBuilder data = new StringBuilder("");

		data.append(MessageFormat.format("{0} - {1}", sigla, descricao));
		data.append("\n");
		data.append(MessageFormat.format("  Coordenador: {0}", coordenador.toString()));
		data.append("\n");
		data.append(MessageFormat.format("  Quantidade de Alunos (regular): {0, number,00}", quantidadeAlunosRegular));
		data.append("\n");
		data.append(MessageFormat.format("  Quantidade de Alunos (dependência): {0, number,00}", quantidadeAlunosDependencia));

		if (ListUtil.isNotEmptyOrNull(disciplinas)) {
			data.append("\n");
			data.append("  Disciplinas");

			for (DisciplinaVO disciplina : disciplinas) {
				data.append("\n");
				data.append(MessageFormat.format("    {0}", disciplina.toString()));
			}
		}

		return data.toString();
	}

}
