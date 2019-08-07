package facade;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TesteAceitacao1 {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testCadastros() {
		Facade facade = new Facade();

		String res;


		//novo m�dico: Nome, CRM, Sexo, Nacionalidade, Data Nasc., Data Admiss., Data Formatura


		res = facade.novoMedico("Nardelle Moraes","M","97719","Brasil","26/08/1977","29/06/2012","28/01/2007");
		assertEquals("Medico inserido!", res);

		res = facade.novoMedico("Rudine%  Rodrigues","M","46193","Brasil","28/05/1962","22/7/1992","18/11/1988");
		assertEquals("ERRO! Caracter '%' Invalido!", res);

		res = facade.novoMedico("Rudinei  R#drigues","M","46193","Brasil","28/05/1962","22/7/1992","18/11/1988");
		assertEquals("ERRO! Caracter '#' Invalido!", res);

		res = facade.novoMedico("Rudinei  Rodrigues","M","46193","Br@sil","28/05/1962","22/7/1992","18/11/1988");
		assertEquals("ERRO! Caracter '@' Invalido!", res);

		res = facade.novoMedico("Rudine%  Rodrigues","M","46193","Br@sil","28/05/1962","22/7/1992","18/11/1988");
		assertEquals("ERRO! Caracter '%' Invalido!", res);

		res = facade.novoMedico("Rudinei  R#drigues","M","46193","Br@sil","28/05/1962","22/7/1992","18/11/1988");
		assertEquals("ERRO! Caracter '#' Invalido!", res);

		res = facade.novoMedico("Rudinei  R@drig#es","M","46193","Brasil","28/05/1962","22/7/1992","18/11/1988");
		assertEquals("ERRO! Caracter '@' Invalido!", res);

		res = facade.novoMedico("Rudinei  Rodrigues","M","46193","Brasil","28/05/1962","22/7/1992","18/11/1988");
		assertEquals("Medico inserido!", res);

		res = facade.novoMedico("Rudinei  Rodrigues","M","46193","Brasil","28/05/1962","22/7/1992","18/11/1988");
		assertEquals("ERRO! CRM J� existente!", res);

		res = facade.novoMedico("Ailton  Carvalho","M","9614","Brasil","26/07/1970","04/10/1999","02/11/1995");
		assertEquals("Medico inserido!", res);

		res = facade.novoMedico("Tarcila do Amaral","F","9614","Brasil","26/07/1970","04/10/1999","02/11/1995");
		assertEquals("ERRO! CRM J� existente!", res);

		res = facade.novoMedico("Larissa Pereira","F","36311","Brasil","22/01/1977","13/08/2005","07/11/1999");
		assertEquals("Medico inserido!", res);

		res = facade.novoMedico("Jonelice  Pinto","F","3566","Portugal","07/02/1989","28/9/2017","22/12/2012");
		assertEquals("Medico inserido!", res);

		res = facade.novoMedico("Alvaro Degas","M","3566","Brasil","05/06/1989","28/09/2017","22/12/2012");
		assertEquals("ERRO! CRM J� existente!", res);

		res = facade.novoMedico("Jaqueline  das Neves","F","89673","Brasil","12/02/1984","31/04/2013","05/07/2011");
		assertEquals("ERRO! Data Inv�lida!", res);

		res = facade.novoMedico("Jaqueline  das Neves","F","89673","Brasil","12/02/1984","30/2/2013","05/07/2011");
		assertEquals("ERRO! Data Inv�lida!", res);

		res = facade.novoMedico("Jaqueline  das Neves","F","89673","Brasil","12/02/1984","31/3/2011","05/07/2013");
		assertEquals("ERRO! Inconsistencia de datas: Formatura posterior a admiss�o!", res);

		res = facade.novoMedico("Jaqueline  das Neves","F","89673","Brasil","12/02/1984","31/05/2013","05/07/2011");
		assertEquals("Medico inserido!", res);

		res = facade.encontraMedico("Nardelle Moraes");
		assertEquals("Nardelle Moraes%M%97719%Brasil%26/08/1977%29/06/2012%28/01/2007", res);

		res = facade.encontraMedico("36311");
		assertEquals("Larissa Pereira%F%36311%Brasil%22/01/1977%13/08/2005%07/11/1999", res);
//
//		res = facade.alteraMedico("97719","Nome", "Jose Ferreira");
//		assertEquals("Alteracao executada com sucesso!", res);
//		res = facade.encontraMedico("97719");
//		assertEquals("Jose Ferreira%M%97719%Brasil%26/08/1977%29/06/2012%28/01/2007", res);
//
//		res = facade.alteraMedico("46193","Sexo", "F");
//		assertEquals("Alteracao executada com sucesso!", res);
//		res = facade.encontraMedico("46193");
//		assertEquals("Rudinei  Rodrigues%F%46193%Brasil%28/05/1962%22/7/1992%18/11/1988", res);
//
//		res = facade.alteraMedico("9614","Nacionalidade", "Italia");
//		assertEquals("Alteracao executada com sucesso!", res);
//		res = facade.encontraMedico("9614");
//		assertEquals("Ailton  Carvalho%M%9614%Italia%26/07/1970%04/10/1999%02/11/1995", res);
//
//		res = facade.alteraMedico("36311","DtNasc", "31/01/1971");
//		assertEquals("Alteracao executada com sucesso!", res);
//		res = facade.encontraMedico("36311");
//		assertEquals("Larissa Pereira%F%36311%Brasil%31/01/1971%13/08/2005%07/11/1999", res);
//
//		res = facade.alteraMedico("3566","DtAdmiss", "19/07/2002");
//		assertEquals("ERRO! Inconsistencia de datas: Formatura posterior a admiss�o!", res);
//
//		res = facade.alteraMedico("3566","DtAdmiss", "19/07/2015");
//		assertEquals("Alteracao executada com sucesso!", res);
//		res = facade.encontraMedico("3566");
//		assertEquals("Jonelice  Pinto%F%3566%Portugal%07/02/1989%19/07/2015%22/12/2012", res);
//
//		res = facade.alteraMedico("89673","DtFormatura", "30/03/2014");
//		assertEquals("ERRO! Inconsistencia de datas: Formatura posterior a admiss�o!", res);
//
//		res = facade.alteraMedico("89673","DtFormatura", "30/03/2010");
//		assertEquals("Alteracao executada com sucesso!", res);
//		res = facade.encontraMedico("89673");
//		assertEquals("Jaqueline  das Neves%F%89673%Brasil%12/02/1984%31/05/2013%30/03/2010", res);

			
	}

}
