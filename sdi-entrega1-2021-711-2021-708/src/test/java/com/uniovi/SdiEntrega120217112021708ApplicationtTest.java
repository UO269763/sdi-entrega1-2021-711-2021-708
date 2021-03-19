package com.uniovi;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.uniovi.tests.pageobjects.PO_HomeView;
import com.uniovi.tests.pageobjects.PO_LoginView;
import com.uniovi.tests.pageobjects.PO_NavView;
import com.uniovi.tests.pageobjects.PO_PrivateView;
import com.uniovi.tests.pageobjects.PO_Properties;
import com.uniovi.tests.pageobjects.PO_RegisterView;
import com.uniovi.tests.pageobjects.PO_View;

//Ordenamos las pruebas por el nombre del método
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class SdiEntrega120217112021708ApplicationtTest {

	// En Windows (Debe ser la versión 65.0.1 y desactivar las actualizacioens
	// automáticas)):
	// static String PathFirefox65 = "C:\\Program Files\\Mozilla
	// Firefox\\firefox.exe";
	static String PathFirefox65 = "C:\\Program Files\\Mozilla Firefox\\firefox.exe";
	// static String Geckdriver024 =
	// "C:\\Users\\santi\\Desktop\\Informatica\\Tercero\\SegundoCuatri\\SDI\\PL-SDI-Sesión5-material\\geckodriver024win64.exe";
	static String Geckdriver024 = "C:\\Users\\Usuario\\Desktop\\TERCEROINFORMATICA\\SEGUNDOSEMESTRE\\SDI\\lab\\PL-SDI-Sesión5-material\\PL-SDI-Sesión5-material\\geckodriver024win64.exe";
	// En MACOSX (Debe ser la versión 65.0.1 y desactivar las actualizacioens
	// automáticas):
	// static String PathFirefox65 =
	// "/Applications/Firefox.app/Contents/MacOS/firefox-bin";
	// static String Geckdriver024 = "/Users/delacal/selenium/geckodriver024mac";
	// Común a Windows y a MACOSX
	static WebDriver driver = getDriver(PathFirefox65, Geckdriver024);
	static String URL = "http://localhost:8090";

	public static WebDriver getDriver(String PathFirefox, String Geckdriver) {
		System.setProperty("webdriver.firefox.bin", PathFirefox);
		System.setProperty("webdriver.gecko.driver", Geckdriver);
		WebDriver driver = new FirefoxDriver();
		return driver;
	}

	@Before
	public void setUp() {
		driver.navigate().to(URL);
	}

	@After
	public void tearDown() {
		driver.manage().deleteAllCookies();
	}

	@BeforeClass
	static public void begin() {
	}

	@AfterClass
	static public void end() {
		driver.quit();
	}

	// 1.REGISTRO DEL USUARIO CON DATOS VÁLIDOS
	@Test
	public void PR01() {
		// Vamos al formulario de registro
		PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");
		// Rellenamos el formulario.
		PO_RegisterView.fillForm(driver, "pedro@gmail.com", "Pedro", "Garcia", "123456", "123456");
		// Comprobamos que entramos en la sección privada
		PO_View.checkElement(driver, "text", "pedro@gmail.com");
	}

	// 2.REGISTRO DE USUARIO CON DATOS INVÁLIDOS (EMAIL VACÍO, NOMBRE VACÍO,
	// APELLIDOS VACÍOS)
	@Test
	public void PR02() {
		// Vamos al formulario de registro
		PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");
		// Rellenamos el formulario.
		PO_RegisterView.fillForm(driver, "", "Pedro", "Garcia", "123456", "123456");
		PO_View.getP();
		// Comprobamos que no se redirige a la vista privada
		PO_RegisterView.checkElement(driver, "text", "Regístrate");
		// Rellenamos el formulario.
		PO_RegisterView.fillForm(driver, "pedro@gmail.com", "", "Garcia", "123456", "123456");
		// Comprobamos que no se redirige a la vista privada
		PO_RegisterView.checkElement(driver, "text", "Regístrate");
		// Rellenamos el formulario.
		PO_RegisterView.fillForm(driver, "pedro@gmail.com", "Pedro", "", "123456", "123456");
		// Comprobamos el error de apellido vacio.
		// Comprobamos que no se redirige a la vista privada
		PO_RegisterView.checkElement(driver, "text", "Regístrate");
	}

	// 3.REGISTRO DEL USUARIO CON DATOS INVÁLIDOS (REPETICIÓN DE LA CONTRASEÑA MAL)
	@Test
	public void PR03() {
		// Vamos al formulario de registro
		PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");
		// Rellenamos el formulario.
		PO_RegisterView.fillForm(driver, "kike@gmail.com", "Kike", "Perez", "123456", "123456789");
		// Comprobamos el error de la contraseña no coincide.
		PO_RegisterView.checkKey(driver, "Error.signup.passwordConfirm.coincidence", PO_Properties.getSPANISH());

	}

	// 4.REGISTRO DEL USUARIO CON DATOS INVÁLIDOS (EMAIL EXISTENTE)
	// @Test
	public void PR04() {
		// Vamos al formulario de registro
		PO_HomeView.clickOption(driver, "signup", "class", "btn btn-primary");
		// Rellenamos el formulario.
		PO_RegisterView.fillForm(driver, "lucas@email.es", "Josefo", "Perez", "77777", "77777");
		PO_View.getP();
		// Comprobamos el error de DNI repetido.
		PO_RegisterView.checkKey(driver, "Error.signup.error.duplicate", PO_Properties.getSPANISH());

	}

	// 5.INICIO DE SESIÓN CON DATOS VÁLIDOS (ADMIN).
	@Test
	public void PR05() {
		// Vamos al formulario de logueo.
		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
		// Rellenamos el formulario
		PO_LoginView.fillForm(driver, "admin@email.es", "123456");
		// COmprobamos que entramos en la pagina privada de Admin
		PO_View.checkElement(driver, "text", "Gestión de usuarios");
	}

	// 6.INICIO DE SESIÓN CON DATOS VÁLIDOS (USUARIO ESTÁNDAR)
	@Test
	public void PR06() {
		// Vamos al formulario de logueo.
		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
		// Rellenamos el formulario
		PO_LoginView.fillForm(driver, "lucas@email.es", "123456");
		// COmprobamos que entramos en la pagina privada de usuario
		PO_View.checkElement(driver, "text", "Gestión de ofertas");
	}

	// 7.INICIO DE SESIÓN CON DATOS INVÁLIDOS (USUARIO ESTÁNDAR, CAMPO EMAIL Y
	// CONTRASEÑA VACÍO)
	@Test
	public void PR07() {
		// Vamos al formulario de logueo.
		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
		// Rellenamos el formulario
		PO_LoginView.fillForm(driver, "", "");
		// Comprobamos que seguimos en la página de logueo
		PO_View.checkElement(driver, "text", "Identifícate");
	}

	// 8.INICIO DE SESIÓN CON DATOS VÁLIDOS (USUARIO ESTÁNDAR, EMAIL EXISTENTE, PERO
	// CONTRASEÑA INCORRECTA)
	@Test
	public void PR08() {
		// Vamos al formulario de logueo.
		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
		// Rellenamos el formulario
		PO_LoginView.fillForm(driver, "lucas@email.es", "123456789");
		// Comprobamos que seguimos en la página de logueo
		PO_View.checkElement(driver, "text", "Identifícate");
	}

	// 9.INICIO DE SESIÓN CON DATOS INVÁLIDOS (USUARIO ESTÁNDAR, EMAIL NO EXISTENTE
	// EN LA APLICACIÓN)
	@Test
	public void PR09() {
		// Vamos al formulario de logueo.
		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
		// Rellenamos el formulario
		PO_LoginView.fillForm(driver, "prueba@email.es", "123456789");
		// Comprobamos que seguimos en la página de logueo
		PO_View.checkElement(driver, "text", "Identifícate");
	}

	// 10.HACER CLICK EN LA OPCIÓN DE SALIR SESIÓN Y COMPROBAR QUE SE REDIRIGE A LA
	// PÁGINA DE INICIO
	@Test
	public void PR10() {
		// Vamos al formulario de logueo.
		PO_HomeView.clickOption(driver, "login", "class", "btn btn-primary");
		// Rellenamos el formulario
		PO_LoginView.fillForm(driver, "admin@email.es", "123456");
		// COmprobamos que entramos en la pagina privada de usuario
		PO_View.checkElement(driver, "text", "Gestión de ofertas");
		// Ahora nos desconectamos
		PO_PrivateView.logout(driver, "Identifícate");
	}

	// 11.COMPROBAR QUE EL BOTÓN DE CERRAR SESIÓN NO ESTÁ VISIBLE PARA UN USUARIO NO
	// AUTENTICADO

}
