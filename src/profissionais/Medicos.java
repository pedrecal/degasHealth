package profissionais;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import utils.DateUtils;
import profissionais.Medico;

public class Medicos {
	
	ArrayList<Medico> listaMedicos = new ArrayList<Medico>();

	/**
	 * This method inserts, if possible, a new doctor into the doctors list
	 * NOT TESTED!!!!!
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
		char c;

		String s = checkInvalidsChar(nome, nacionalidade);
		if (s !="ok") {
			return s;
		};

		if(existingCRM(crm)) {
			return "ERRO! CRM J� existente!";
		}
		
		Date dtAdmissaoDate, dtFormaturaDate, dtNascDate;
		
		dtAdmissaoDate = strToDate(dtAdmissao);
		dtFormaturaDate = strToDate(dtFormatura);
		dtNascDate = strToDate(dtNasc);
		if (dtAdmissaoDate==null) {
			return "ERRO! Data Inv�lida!";
		}
		
		if (dtFormaturaDate==null) {
			return "ERRO! Data Inv�lida!";
		}
		
		if (dtNascDate==null) {
			return "ERRO! Data Inv�lida!";
		}
		
		if (dateBeforeError(dtFormaturaDate, dtAdmissaoDate)) {
			return "ERRO! Inconsistencia de datas: Formatura posterior a admiss�o!";
		}

		Medico medico = new Medico(nome, sexo, crm, nacionalidade, dtNascDate,
				dtAdmissaoDate, dtFormaturaDate);
		
		listaMedicos.add(medico);
		
		return "Medico inserido!";
	}
	
	public String encontraMedico(String atributo) {
		if(atributo.matches("[ ]*")) {
			return "Atributo inválido";
		}
		Medico medicoResult = null;
		
		if(atributo.matches("[0-9]{2,6}")) {
			for (Medico medico : listaMedicos) {
				if(medico.getCrm() == atributo) {
					medicoResult = medico;
				}
			}
		}else {
			for (Medico medico : listaMedicos) {
				if(medico.getNome() == atributo) {
					medicoResult = medico;
				}
			}
		}
		if(medicoResult != null) {
			return(medicoResult.getNome()+"%"+medicoResult.getSexo()+"%"+medicoResult.getCrm()
			+"%"+medicoResult.getNacionalidade()+"%"+DateUtils.formatDateBR(medicoResult.getDtNasc())+"%"+DateUtils.formatDateBR(medicoResult.getDtAdmissao())+"%"+DateUtils.formatDateBR(medicoResult.getDtFormatura()));
		}else {
			return "Medico não cadastrado";
		}
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
	 * This method checks if the crm is alrady inserted into medicoslist
	 * @param crm
	 * @return
	 */
	protected boolean existingCRM(String crm) {
		for (Medico m : listaMedicos) {
			if(crm.equals(m.getCrm())) {
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
