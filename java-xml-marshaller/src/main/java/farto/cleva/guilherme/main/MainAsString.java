package farto.cleva.guilherme.main;

import java.util.List;
import farto.cleva.guilherme.bo.AlunoMarshallerBO;
import farto.cleva.guilherme.vo.AlunoVO;

public class MainAsString {

	public static void main(String[] args) {

		StringBuilder data = new StringBuilder("");

		data.append("<root>");
		data.append("  <alunos>");
		data.append("    <aluno>");
		data.append("      <ra>1234</ra>");
		data.append("      <nome>Guilherme de Cleva Farto</nome>");
		data.append("      <sexo>M</sexo>");
		data.append("      <dataNascimento>01/01/1989</dataNascimento>");
		data.append("      <curso>");
		data.append("        <sigla>BCC</sigla>");
		data.append("        <descricao>Bacharelado em Ciência da Computação</descricao>");
		data.append("        <quantidade-alunos-regular>21</quantidade-alunos-regular>");
		data.append("        <quantidade-alunos-dp>3</quantidade-alunos-dp>");
		data.append("        <disciplinas>");
		data.append("          <disciplina>");
		data.append("            <descricao>Algoritmos</descricao>");
		data.append("            <professor>");
		data.append("              <nome>Almir Camolesi</nome>");
		data.append("              <titulo>Dr</titulo>");
		data.append("            </professor>");
		data.append("          </disciplina>");
		data.append("          <disciplina>");
		data.append("            <descricao>Teoria dos Grafos</descricao>");
		data.append("            <professor>");
		data.append("              <nome>Marisa Nitto</nome>");
		data.append("              <titulo>Dr</titulo>");
		data.append("            </professor>");
		data.append("          </disciplina>");
		data.append("          <disciplina>");
		data.append("            <descricao>Inteligência Artificial</descricao>");
		data.append("            <professor>");
		data.append("              <nome>Luiz Carlos Begosso</nome>");
		data.append("              <titulo>Dr</titulo>");
		data.append("            </professor>");
		data.append("          </disciplina>");
		data.append("        </disciplinas>");
		data.append("        <coordenador>");
		data.append("          <professor>");
		data.append("            <nome>Alex Poletto</nome>");
		data.append("            <titulo>Dr</titulo>");
		data.append("          </professor>");
		data.append("        </coordenador>");
		data.append("      </curso>");
		data.append("      <pesquisas>");
		data.append("        <pesquisa>");
		data.append("          <titulo>Teste de Aplicações Móveis</titulo>");
		data.append("          <tipo>PIC</tipo>");
		data.append("        </pesquisa>");
		data.append("        <pesquisa>");
		data.append("          <titulo>Análise de padrões em DNA com RegEx</titulo>");
		data.append("          <tipo>Artigo</tipo>");
		data.append("        </pesquisa>");
		data.append("      </pesquisas>");
		data.append("      <notas>");
		data.append("        <nota>");
		data.append("          <descricao>Trabalho 1</descricao>");
		data.append("          <valor>8.2</valor>");
		data.append("        </nota>");
		data.append("        <nota>");
		data.append("          <descricao>Trabalho 2</descricao>");
		data.append("          <valor>9.15</valor>");
		data.append("        </nota>");
		data.append("        <nota>");
		data.append("          <descricao>Prova 1</descricao>");
		data.append("          <valor>8.9</valor>");
		data.append("        </nota>");
		data.append("        <nota>");
		data.append("          <descricao>Prova 2</descricao>");
		data.append("          <valor>7.6</valor>");
		data.append("        </nota>");
		data.append("        <nota>");
		data.append("          <descricao>Resenha Artigo 1</descricao>");
		data.append("          <valor>8.9</valor>");
		data.append("        </nota>");
		data.append("      </notas>");
		data.append("    </aluno>");
		data.append("    <aluno>");
		data.append("      <ra>4321</ra>");
		data.append("      <nome>Tamires Alves da Silva</nome>");
		data.append("      <sexo>F</sexo>");
		data.append("      <dataNascimento>01/01/1987</dataNascimento>");
		data.append("      <curso>");
		data.append("        <sigla>ADS</sigla>");
		data.append("        <descricao>Análise e Desenvolvimento de Sistemas</descricao>");
		data.append("        <quantidade-alunos-regular>27</quantidade-alunos-regular>");
		data.append("        <quantidade-alunos-dp>4</quantidade-alunos-dp>");
		data.append("        <disciplinas>");
		data.append("          <disciplina>");
		data.append("            <descricao>Tópicos em Programação</descricao>");
		data.append("            <professor>");
		data.append("              <nome>Domingos Villela</nome>");
		data.append("              <titulo>Esp</titulo>");
		data.append("            </professor>");
		data.append("          </disciplina>");
		data.append("          <disciplina>");
		data.append("            <descricao>Matemática Discreta</descricao>");
		data.append("            <professor>");
		data.append("              <nome>Marisa Nitto</nome>");
		data.append("              <titulo>Dr</titulo>");
		data.append("            </professor>");
		data.append("          </disciplina>");
		data.append("        </disciplinas>");
		data.append("        <coordenador>");
		data.append("          <professor>");
		data.append("            <nome>Alex Poletto</nome>");
		data.append("            <titulo>Dr</titulo>");
		data.append("          </professor>");
		data.append("        </coordenador>");
		data.append("      </curso>");
		data.append("      <pesquisas>");
		data.append("        <pesquisa>");
		data.append("          <titulo>Sistema para Gestão de Eventos</titulo>");
		data.append("          <tipo>Monografia</tipo>");
		data.append("        </pesquisa>");
		data.append("      </pesquisas>");
		data.append("      <notas>");
		data.append("        <nota>");
		data.append("          <descricao>Trabalho 1</descricao>");
		data.append("          <valor>3.25</valor>");
		data.append("        </nota>");
		data.append("        <nota>");
		data.append("          <descricao>Prova 1</descricao>");
		data.append("          <valor>2.8</valor>");
		data.append("        </nota>");
		data.append("        <nota>");
		data.append("          <descricao>Artigo 1</descricao>");
		data.append("          <valor>4.5</valor>");
		data.append("        </nota>");
		data.append("      </notas>");
		data.append("    </aluno>");
		data.append("  </alunos>");
		data.append("</root>");

		try {

			List<AlunoVO> alunos = AlunoMarshallerBO.parse(data.toString());

			for (AlunoVO aluno : alunos) {
				System.out.println(aluno);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
