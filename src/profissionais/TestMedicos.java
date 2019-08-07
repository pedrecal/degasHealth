package profissionais;

import static org.junit.Assert.*;

import java.text.DateFormat;
import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestMedicos {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testHasIvalidChar() {
		//creating a string with %
		String string = "Degas%degas";
		Medicos medicos = new Medicos();
		assertEquals('%', medicos.hasInvalidChar(string));
		//another string with % in the begining
		string = "%degas";
		assertEquals('%', medicos.hasInvalidChar(string));
		//the % in the last character
		string = "degasdegas%";
		assertEquals('%', medicos.hasInvalidChar(string));
		
		string = "Degas#degas";
		assertEquals('#', medicos.hasInvalidChar(string));
		//another string with % in the begining
		string = "#degas";
		assertEquals('#', medicos.hasInvalidChar(string));
		//the % in the last character
		string = "degasdegas#";
		assertEquals('#', medicos.hasInvalidChar(string));
		
		string = "Degas@degas";
		assertEquals('@', medicos.hasInvalidChar(string));
		//another string with % in the begining
		string = "@degas";
		assertEquals('@', medicos.hasInvalidChar(string));
		//the % in the last character
		string = "degasdegas@";
		assertEquals('@', medicos.hasInvalidChar(string));
		
		
		//now a valid string
		string = "pedro de alcantara";
		assertEquals('x', medicos.hasInvalidChar(string));
	}
	
	@Test
	public void TestExistingCRM() {
		
		Date dtNasc = new Date(2000,01,01);
		Date dtAdmissao = new Date(2000,01,01);
		Date dtFormatura = new Date(2000,01,01);
		
		Medico medico1 = new Medico("Feliz", "M", "111", "Brasil", dtNasc, dtAdmissao, dtFormatura);
		Medico medico2 = new Medico("Zangado", "M", "222", "Brasil", dtNasc, dtAdmissao, dtFormatura);
		Medico medico3 = new Medico("Atchim", "F", "333", "Brasil", dtNasc, dtAdmissao, dtFormatura);
		
		Medicos medicos = new Medicos();
		
		//Insertings doctor by using the internal structures.
		//THIS IS NOT  GOOD PROGRAMING PRACTICE
		medicos.listaMedicos.add(medico1);
		medicos.listaMedicos.add(medico2);
		medicos.listaMedicos.add(medico3);
		
		assertTrue(medicos.existingCRM("111"));
		assertTrue(medicos.existingCRM("222"));
		assertTrue(medicos.existingCRM("333"));
		assertFalse(medicos.existingCRM("444"));
	}
	
	@Test
	public void testInValidDate() {
		Medicos medicos = new Medicos();
		String date = "01/04/2012";
		
		assertNotNull(medicos.strToDate(date));
		date = "30/02/2012";
		assertNull(medicos.strToDate(date));
		date = "31/04/2012";
		assertNull(medicos.strToDate(date));
		date = "32/05/2012";
		assertNull(medicos.strToDate(date));
		date = "31/06/2012";
		assertNull(medicos.strToDate(date));
		date = "31/09/2012";
		assertNull(medicos.strToDate(date));
		date = "31/11/2012";
		assertNull(medicos.strToDate(date));
		date = "30/13/2012";
		assertNull(medicos.strToDate(date));
		
	}
	
	@Test
	public void testDateBeforeError() {
		Date date1 = new Date(2000,01,01);
		Date date2 = new Date(2000,01,02);
		
		Medicos medicos = new Medicos();
		assertFalse(medicos.dateBeforeError(date1, date2));
		assertTrue(medicos.dateBeforeError(date2, date1));
	}

}
