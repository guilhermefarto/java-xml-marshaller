package farto.cleva.guilherme.main;

import java.io.File;
import java.util.List;
import farto.cleva.guilherme.bo.AlunoMarshallerBO;
import farto.cleva.guilherme.vo.AlunoVO;

public class MainAsFile {

	private static final String RESOURCES_DIR = "src/main/resources/";

	private static final File DATA = new File(RESOURCES_DIR + "data/dados1.xml");
	// private static final File DATA = new File(MainAsFile.class.getClassLoader().getResource("data/dados1.xml").getFile());

	public static void main(String[] args) {

		try {

			List<AlunoVO> alunos = AlunoMarshallerBO.parse(DATA);

			for (AlunoVO aluno : alunos) {
				System.out.println(aluno);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
