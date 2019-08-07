package facade;

import profissionais.Medicos;

public class Facade {
	
	Medicos medicos = new Medicos();

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

}
