package farto.cleva.guilherme.bo;

import java.io.File;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import farto.cleva.guilherme.utils.DateUtil;
import farto.cleva.guilherme.utils.XMLUtil;
import farto.cleva.guilherme.vo.AlunoVO;
import farto.cleva.guilherme.vo.CursoVO;
import farto.cleva.guilherme.vo.DisciplinaVO;
import farto.cleva.guilherme.vo.NotaVO;
import farto.cleva.guilherme.vo.PesquisaVO;
import farto.cleva.guilherme.vo.ProfessorVO;
import farto.cleva.guilherme.vo.enums.Sexo;
import farto.cleva.guilherme.vo.enums.TipoPesquisa;
import farto.cleva.guilherme.vo.enums.TituloAcademico;

public class AlunoMarshallerBO {

	public static List<AlunoVO> parse(File xmlFile) {
		Document document = XMLUtil.parse(xmlFile, XMLUtil.UTF_8);

		return marshall(document);
	}

	public static List<AlunoVO> parse(String xml) {
		Document document = XMLUtil.parse(xml, XMLUtil.UTF_8);

		return marshall(document);
	}

	private static List<AlunoVO> marshall(Document document) {
		List<AlunoVO> alunos = new LinkedList<AlunoVO>();

		Element root = document.getDocumentElement();

		root.normalize();

		NodeList nAluno = XMLUtil.getNodeList(root, "alunos", "aluno");

		for (int iAlunos = 0; iAlunos < nAluno.getLength(); iAlunos++) {
			Element eAluno = XMLUtil.iterateElement(nAluno, iAlunos);

			long ra = Long.parseLong(XMLUtil.getNodeValue(eAluno, "ra"));
			String nome = XMLUtil.getNodeValue(eAluno, "nome");
			Sexo sexo = Sexo.findByValue(XMLUtil.getNodeValue(eAluno, "sexo"));
			Date dataNascimento = DateUtil.parse(XMLUtil.getNodeValue(eAluno, "dataNascimento"));

			AlunoVO aluno = new AlunoVO(ra, nome, sexo, dataNascimento);

			// Element eCurso = (Element) XMLUtil.getNode(eAluno, "curso");
			// String cursoSigla = XMLUtil.getNodeValue(eCurso, "sigla");
			// String cursoDescricao = XMLUtil.getNodeValue(eCurso, "descricao");
			// long cursoQuantidadeAlunosRegular = Long.parseLong(XMLUtil.getNodeValue(eCurso, "quantidade-alunos-regular"));
			// long cursoQuantidadeAlunosDependencia = Long.parseLong(XMLUtil.getNodeValue(eCurso, "quantidade-alunos-dp"));

			String cursoSigla = XMLUtil.getNodeValue(eAluno, "sigla", "curso");
			String cursoDescricao = XMLUtil.getNodeValue(eAluno, "descricao", "curso");
			long cursoQuantidadeAlunosRegular = Long.parseLong(XMLUtil.getNodeValue(eAluno, "quantidade-alunos-regular", "curso"));
			long cursoQuantidadeAlunosDependencia = Long.parseLong(XMLUtil.getNodeValue(eAluno, "quantidade-alunos-dp", "curso"));

			CursoVO curso = new CursoVO(cursoSigla, cursoDescricao, cursoQuantidadeAlunosRegular, cursoQuantidadeAlunosDependencia);

			// Element eCursoCoordenador = (Element) XMLUtil.getNode(eAluno, "curso", "coordenador", "professor");
			// String nomeCoordenador = XMLUtil.getNodeValue(eCursoCoordenador, "nome");
			// TituloAcademico tituloAcademicoCoordenador = TituloAcademico.findByValue(XMLUtil.getNodeValue(eCursoCoordenador, "titulo"));

			String nomeCoordenador = XMLUtil.getNodeValue(eAluno, "nome", "curso", "coordenador", "professor");
			TituloAcademico tituloAcademicoCoordenador = TituloAcademico.findByValue(XMLUtil.getNodeValue(eAluno, "titulo", "curso", "coordenador", "professor"));

			ProfessorVO coordenador = new ProfessorVO(nomeCoordenador, tituloAcademicoCoordenador);

			NodeList nDisciplina = XMLUtil.getNodeList(eAluno, "curso", "disciplinas", "disciplina");

			for (int iDisciplinas = 0; iDisciplinas < nDisciplina.getLength(); iDisciplinas++) {
				Element eDisciplina = XMLUtil.iterateElement(nDisciplina, iDisciplinas);

				String descricaoDisciplina = XMLUtil.getNodeValue(eDisciplina, "descricao");

				// Element eDisciplinaProfessor = (Element) XMLUtil.getNode(eDisciplina, "professor");
				// String nomeProfessor = XMLUtil.getNodeValue(eDisciplinaProfessor, "nome");
				// TituloAcademico tituloAcademicoProfessor = TituloAcademico.findByValue(XMLUtil.getNodeValue(eDisciplinaProfessor, "titulo"));

				String nomeProfessor = XMLUtil.getNodeValue(eDisciplina, "nome", "professor");
				TituloAcademico tituloAcademicoProfessor = TituloAcademico.findByValue(XMLUtil.getNodeValue(eDisciplina, "titulo", "professor"));

				ProfessorVO professor = new ProfessorVO(nomeProfessor, tituloAcademicoProfessor);

				DisciplinaVO disciplina = new DisciplinaVO(descricaoDisciplina, professor);

				curso.adicionarDisciplina(disciplina);
			}

			NodeList nPesquisa = XMLUtil.getNodeList(eAluno, "pesquisas", "pesquisa");

			for (int iPesquisas = 0; iPesquisas < nPesquisa.getLength(); iPesquisas++) {
				Element ePesquisa = XMLUtil.iterateElement(nPesquisa, iPesquisas);

				String tituloPesquisa = XMLUtil.getNodeValue(ePesquisa, "titulo");
				TipoPesquisa tipoPesquisa = TipoPesquisa.findByValue(XMLUtil.getNodeValue(ePesquisa, "tipo"));

				PesquisaVO pesquisa = new PesquisaVO(tituloPesquisa, tipoPesquisa);

				aluno.adicionarPesquisa(pesquisa);
			}

			NodeList nNota = XMLUtil.getNodeList(eAluno, "notas", "nota");

			for (int iNotas = 0; iNotas < nNota.getLength(); iNotas++) {
				Element eNota = XMLUtil.iterateElement(nNota, iNotas);

				String descricaoNota = XMLUtil.getNodeValue(eNota, "descricao");
				BigDecimal valorNota = new BigDecimal(XMLUtil.getNodeValue(eNota, "valor"));

				NotaVO nota = new NotaVO(descricaoNota, valorNota);

				aluno.adicionarNota(nota);
			}

			curso.setCoordenador(coordenador);

			aluno.setCurso(curso);

			alunos.add(aluno);
		}

		return alunos;
	}

}
