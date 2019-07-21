package profissionais;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.crypto.Data;

import utils.DateUtils;
import profissionais.Enfermeiro;

public class Enfermeiros {

	ArrayList<Enfermeiro> listaEnfermeiros = new ArrayList<Enfermeiro>();

	/**
	 * This method inserts, if possible, a new doctor into the doctors list
	 * NOT TESTED!!!!!
	 * @param nome
	 * @param coren
	 * @param sexo
	 * @param nacionalidade
	 * @param dtNasc
	 * @param dtAdmissao
	 * @param dtFormatura
	 * @return
	 */
	public String novoEnfermeiro(String nome, String sexo, String coren, String nacionalidade, String dtNasc,
			String dtAdmissao, String dtFormatura) {
		char c;

		String s = checkInvalidsChar(nome, nacionalidade);
		if (s !="ok") {
			return s;
		};

		if(existingCOREN(coren)) {
			return "ERRO! COREN Já existente!";
		}

		Date dtAdmissaoDate, dtFormaturaDate, dtNascDate;

		dtAdmissaoDate = strToDate(dtAdmissao);
		dtFormaturaDate = strToDate(dtFormatura);
		dtNascDate = strToDate(dtNasc);
		if (dtAdmissaoDate==null) {
			return "ERRO! Data Inválida!";
		}

		if (dtFormaturaDate==null) {
			return "ERRO! Data Inválida!";
		}

		if (dtNascDate==null) {
			return "ERRO! Data Inválida!";
		}

		if (dateBeforeError(dtFormaturaDate, dtAdmissaoDate)) {
			return "ERRO! Inconsistencia de datas: Formatura posterior a admissão!";
		}

		Enfermeiro medico = new Enfermeiro(nome, sexo, coren, nacionalidade, dtNascDate,
				dtAdmissaoDate, dtFormaturaDate);

		listaEnfermeiros.add(medico);

		return "Enfermeiro inserido!";
	}

	public String encontraEnfermeiro(String atributo) {
		if(atributo.matches("[ ]*")) {
			return "Atributo inválido";
		}
		Enfermeiro medicoResult = null;

		if(atributo.matches("[0-9]{2,6}")) {
			for (Enfermeiro medico : listaEnfermeiros) {
				if(medico.getCoren() == atributo) {
					medicoResult = medico;
				}
			}
		}else {
			for (Enfermeiro medico : listaEnfermeiros) {
				if(medico.getNome() == atributo) {
					medicoResult = medico;
				}
			}
		}
		if(medicoResult != null) {
			return(medicoResult.getNome()+"%"+medicoResult.getSexo()+"%"+medicoResult.getCoren()
			+"%"+medicoResult.getNacionalidade()+"%"+DateUtils.formatDateBR(medicoResult.getDtNasc())+"%"+DateUtils.formatDateBR(medicoResult.getDtAdmissao())+"%"+DateUtils.formatDateBR(medicoResult.getDtFormatura()));
		}else {
			return "Enfermeiro não cadastrado";
		}
	}

	public String alteraEnfermeiro(String coren, String coluna, String novoValor) {
		for (Enfermeiro medico : listaEnfermeiros) {
			if(medico.getCoren().equals(coren)) {
				return alteraAtributo(listaEnfermeiros.indexOf(medico), coluna, novoValor);
			}
		}

		return "Médico não encontrado";

	}

	public String alteraAtributo(int id, String coluna, String novoValor){

		switch(coluna) {
			case "Nome":
				listaEnfermeiros.get(id).setNome(novoValor);
				return "Alteracao executada com sucesso!";

			case "Sexo":
				listaEnfermeiros.get(id).setSexo(novoValor);
				return "Alteracao executada com sucesso!";

			case "Nacionalidade":
				listaEnfermeiros.get(id).setNacionalidade(novoValor);
				return "Alteracao executada com sucesso!";

			case "DtNasc":
				listaEnfermeiros.get(id).setDtNasc( DateUtils.createDateFromString(novoValor));
				return "Alteracao executada com sucesso!";
			case "DtAdmiss":
				if (dateBeforeError(listaEnfermeiros.get(id).getDtFormatura(), DateUtils.createDateFromString(novoValor))) {
					return "ERRO! Inconsistencia de datas: Formatura posterior a admissão!";
				}
				listaEnfermeiros.get(id).setDtAdmissao(DateUtils.createDateFromString(novoValor));
				return "Alteracao executada com sucesso!";
			case "DtFormatura":
				if (dateBeforeError(DateUtils.createDateFromString(novoValor), listaEnfermeiros.get(id).getDtAdmissao())) {
					return "ERRO! Inconsistencia de datas: Formatura posterior a admissão!";
				}
				listaEnfermeiros.get(id).setDtFormatura(DateUtils.createDateFromString(novoValor));
				return "Alteracao executada com sucesso!";
		}

		return "Enfermeiro náo encontrado!";
	}

	/**
	 * This method checks if date1 is before date2
	 * @param date1
	 * @param date2
	 * @return
	 */
	protected boolean dateBeforeError(Date date1, Date date2) {
		return !date1.before(date2);
	}

	/**
	 * This method checks if a string can be converted into a valid date.
	 * The string must be in dd/mm/aaaa format.
	 * @param dateStr
	 * @return
	 */
	protected Date strToDate(String dateStr) {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);

		try {

			Date date = sdf.parse(dateStr);
			return date;

		} catch (ParseException e) {

			return null;
		}
	}

	/**
	 * This method checks if the coren is alrady inserted into medicoslist
	 * @param coren
	 * @return
	 */
	protected boolean existingCOREN(String coren) {
		for (Enfermeiro m : listaEnfermeiros) {
			if(coren.equals(m.getCoren())) {
				return true;
			}
		}
		return false;
	}

	/**
	 * This method returns a string informing an error ith an invalid char
	 * or the single char 'x' otherwise
	 * NOT TESTED
	 * @param nome
	 * @param nacionalidade
	 */
	private String checkInvalidsChar(String nome, String nacionalidade) {
		char c;
		if((c=hasInvalidChar(nome))!='x') {
			return "ERRO! Caracter '"+String.valueOf(c)+"' Invalido!";
		}

		if((c=hasInvalidChar(nacionalidade))!='x') {
			return "ERRO! Caracter '"+String.valueOf(c)+"' Invalido!";
		}
		return "ok";
	}

	/**
	 * This method checks if the char '%, '#' or '@' exists into the string
	 * @param string
	 * @return
	 */
	protected char hasInvalidChar(String string) {
		char[] invalids = {'%','@', '#'};
		for (int i=0;i<3;i++) {
			char c = invalids[i];
			if (string.contains(String.valueOf(c))) {
				return c;
			}
		}
		return 'x';
	}

}
