package farto.cleva.guilherme.vo;

import java.text.MessageFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import farto.cleva.guilherme.utils.DateUtil;
import farto.cleva.guilherme.utils.ListUtil;
import farto.cleva.guilherme.vo.enums.Sexo;

public class AlunoVO {

	private long ra;
	private String nome;
	private Sexo sexo;
	private Date dataNascimento;
	private CursoVO curso;
	private List<PesquisaVO> pesquisas;
	private List<NotaVO> notas;

	public AlunoVO(long ra, String nome, Sexo sexo, Date dataNascimento) {
		this(ra, nome, sexo, dataNascimento, null);
	}

	public AlunoVO(long ra, String nome, Sexo sexo, Date dataNascimento, CursoVO curso) {
		super();

		this.ra = ra;
		this.nome = nome;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.curso = curso;
	}

	public long getRa() {
		return ra;
	}

	public void setRa(long ra) {
		this.ra = ra;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public CursoVO getCurso() {
		return curso;
	}

	public void setCurso(CursoVO curso) {
		this.curso = curso;
	}

	public List<PesquisaVO> getPesquisas() {
		if (ListUtil.isNull(pesquisas)) {
			pesquisas = new LinkedList<PesquisaVO>();
		}

		return pesquisas;
	}

	public void setPesquisas(List<PesquisaVO> pesquisas) {
		this.pesquisas = pesquisas;
	}

	public void adicionarPesquisa(PesquisaVO pesquisa) {
		this.getPesquisas().add(pesquisa);
	}

	public List<NotaVO> getNotas() {
		if (ListUtil.isNull(notas)) {
			notas = new LinkedList<NotaVO>();
		}

		return notas;
	}

	public void setNotas(List<NotaVO> notas) {
		this.notas = notas;
	}

	public void adicionarNota(NotaVO nota) {
		this.getNotas().add(nota);
	}

	@Override
	public String toString() {
		StringBuilder data = new StringBuilder("");

		data.append(MessageFormat.format("{0} - {1}", String.valueOf(ra), nome));
		data.append("\n");
		data.append(MessageFormat.format("Sexo: {0}", sexo));
		data.append("\n");
		data.append(MessageFormat.format("Data de Nascimento: {0}", DateUtil.format(dataNascimento)));
		data.append("\n");
		data.append(MessageFormat.format("Curso: {0}", curso.toString()));

		if (ListUtil.isNotEmptyOrNull(pesquisas)) {
			data.append("\n");
			data.append("  Pesquisas");

			for (PesquisaVO pesquisa : pesquisas) {
				data.append("\n");
				data.append(MessageFormat.format("    {0}", pesquisa.toString()));
			}
		}

		if (ListUtil.isNotEmptyOrNull(notas)) {
			data.append("\n");
			data.append("  Notas");

			for (NotaVO nota : notas) {
				data.append("\n");
				data.append(MessageFormat.format("    {0}", nota.toString()));
			}
		}

		return data.toString();
	}

}
