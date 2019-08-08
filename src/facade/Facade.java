package facade;

import profissionais.Medicos;
import profissionais.Enfermeiros;
import profissionais.Auxiliares;


public class Facade {
	
	Medicos medicos = new Medicos();
	Enfermeiros enfermeiros= new Enfermeiros();
	Auxiliares auxiliares= new Auxiliares();

	/**
	 * This method inserts a medic into the system
	 * Nome, CRM, Sexo, Nacionalidade, Data Nasc., Data Admiss., Data Formatura
	 * @param nome
	 * @param crm
	 * @param sexo
	 * @param nacionalidade
	 * @param dtNasc
	 * @param dtAdmissao
	 * @param dtFormatura
	 * @return
	 */
	public String novoMedico(String nome, String sexo, String crm, String nacionalidade, String dtNasc,
			String dtAdmissao, String dtFormatura) {
		
		return medicos.novoMedico(nome, sexo, crm, nacionalidade, dtNasc,
			dtAdmissao, dtFormatura);
	}
	
	public String encontraMedico(String atributo) {
		return medicos.encontraMedico(atributo);
	}
	
	public String alteraMedico(String crm, String coluna, String novoValor) {
		return medicos.alteraMedico(crm, coluna, novoValor);
	}
	
	public String novoEnfermeiro(String nome, String sexo, String coren, String nacionalidade, String dtNasc,
			String dtAdmissao, String dtFormatura) {

		return enfermeiros.novoEnfermeiro(nome, sexo, coren, nacionalidade, dtNasc,
			dtAdmissao, dtFormatura);
	}

	public String encontraEnfermeiro(String atributo) {
		return enfermeiros.encontraEnfermeiro(atributo);
	}

	public String alteraEnfermeiro(String coren, String coluna, String novoValor) {
		return enfermeiros.alteraEnfermeiro(coren, coluna, novoValor);
	}

	public String novoAuxiliar(String nome, String sexo, String coren, String nacionalidade, String dtNasc,
			String dtAdmissao, String dtFormatura) {

		return auxiliares.novoAuxiliar(nome, sexo, coren, nacionalidade, dtNasc,
			dtAdmissao, dtFormatura);
	}

	public String encontraAuxiliar(String atributo) {
		return auxiliares.encontraAuxiliar(atributo);
	}

	public String alteraAuxiliar(String coren, String coluna, String novoValor) {
		return auxiliares.alteraAuxiliar(coren, coluna, novoValor);
	}
}
