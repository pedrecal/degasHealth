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


	public void setCrm(String crm) {
		this.crm = crm;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}


	public void setDtNasc(Date dtNasc) {
		this.dtNasc = dtNasc;
	}


	public void setDtAdmissao(Date dtAdmissao) {
		this.dtAdmissao = dtAdmissao;
	}


	public void setDtFormatura(Date dtFormatura) {
		this.dtFormatura = dtFormatura;
	}


	public void setNome(String nome) {
		// TODO Auto-generated method stub
		this.nome = nome;
	}

}
