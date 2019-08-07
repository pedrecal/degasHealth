package profissionais;

import java.util.Date;

public class Medico {
	
	public String getNome() {
		return nome;
	}


	public String getCrm() {
		return crm;
	}


	public String getSexo() {
		return sexo;
	}


	public String getNacionalidade() {
		return nacionalidade;
	}


	public Date getDtNasc() {
		return dtNasc;
	}


	public Date getDtAdmissao() {
		return dtAdmissao;
	}


	public Date getDtFormatura() {
		return dtFormatura;
	}


	private String nome;
	private String crm;
	private String sexo;
	private String nacionalidade;
	private Date dtNasc;
	private Date dtAdmissao;
	private Date dtFormatura;
	

	public Medico(String nome, String sexo, String crm, String nacionalidade, Date dtNasc, Date dtAdmissao,
			Date dtFormatura) {
		this.nome=nome;
		this.crm=crm;
		this.sexo=sexo;
		this.nacionalidade=nacionalidade;
		this.dtNasc=dtNasc;
		this.dtAdmissao=dtAdmissao;
		this.dtFormatura=dtFormatura;
	}

}
