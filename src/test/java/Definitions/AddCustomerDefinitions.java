package Definitions;

import PageObjects.*;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static Support.screenshot.pantallazo;


public class AddCustomerDefinitions {
    MenuGuruPage menuGuru;
    HomeTelecomPage home;
    FormularioTelecomPage formulario;
    NroCustomerPage customer;
    ValidarOrdenPage validar;
    ValidarTarifaPage tarifa;
    VolverHomePage volver;

    public AddCustomerDefinitions() {
        menuGuru= new MenuGuruPage(Hooks.driver);
        home= new HomeTelecomPage(Hooks.driver);
        formulario= new FormularioTelecomPage(Hooks.driver);
        customer= new NroCustomerPage(Hooks.driver);
        validar= new ValidarOrdenPage(Hooks.driver);
        tarifa= new ValidarTarifaPage(Hooks.driver);
        volver= new VolverHomePage(Hooks.driver);
    }

    @Given("Voy a la pagina Telecom Project")
    public void voyALaPaginaTelecomProject() {
        Hooks.driver.get("http://demo.guru99.com/payment-gateway/index.php");
        menuGuru.ClickTelecom();
    }

    @When("le doy click a Agregar cliente")
    public void leDoyClickAAgregarCliente() {
        home.ClickAddCustomer();
    }

    @And("Registro Datos {string} {string} {string} {string} {string}")
    public void registroDatos(String nombre, String ape, String email, String direc, String telefono) {
        formulario.IngresarNombre(nombre);
        formulario.IngresarApellido(ape);
        formulario.IngresarEmail(email);
        formulario.IngresarDireccion(direc);
        formulario.IngresarCelular(telefono);
        formulario.EnviarRegistro();
    }

    @And("ingresar datos")
    public void ingresarDatos(DataTable cliente) throws IOException{
        List<Map<String,String>> lista=cliente.asMaps(String.class,String.class);
        for(int i=0; i<lista.size(); i++){
            formulario.ClickCheck(lista.get(i).get("check"));
            pantallazo();
            formulario.IngresarNombre(lista.get(i).get("nombre"));
            pantallazo();
            formulario.IngresarApellido(lista.get(i).get("apellido"));
            pantallazo();
            formulario.IngresarEmail(lista.get(i).get("email"));
            pantallazo();
            formulario.IngresarDireccion(lista.get(i).get("direccion"));
            pantallazo();
            formulario.IngresarCelular(lista.get(i).get("celular"));
            pantallazo();

        }
    }

    @And("envio el formulario")
    public void envioElFormulario() {
        formulario.EnviarRegistro();
    }

    @And("Selecciono opcion {string}")
    public void seleccionoOpcion(String check) {
        formulario.ClickCheck(check);
    }

    @And("Ingreso Nombre{string}")
    public void ingresoNombre(String nombre) {
        formulario.IngresarNombre(nombre);

    }

    @And("Ingreso Apellido {string}")
    public void ingresoApellido(String apellido) {
        formulario.IngresarApellido(apellido);
    }

    @And("Ingreso Email {string}")
    public void ingresoEmail(String email) {
        formulario.IngresarEmail(email);
    }

    @And("Ingreso direccion {string}")
    public void ingresoDireccion(String direccion) {
        formulario.IngresarDireccion(direccion);

    }

    @And("Ingreso celular {string}")
    public void ingresoCelular(String celular) {
        formulario.IngresarCelular(celular);
    }

    @Then("obtener mensaje")
    public void obtenerMensaje() throws IOException {
        formulario.ObtenerAlerta();
        pantallazo();
    }

    @And("obtengo el numero de Orden")
    public void obtengoElNumeroDeOrden() throws IOException{
        customer.CapturarOrden();
        pantallazo();
        customer.VolverHome();

    }

    @And("ingreso el orden")
    public void ingresoElOrden() {
        home.ClickAddTarifa();
        validar.ValidarTexto();
        validar.IngresarOrden();
        validar.ClickValidar();
    }

    @Then("valido el orden de Tarifa")
    public void validoElOrdenDeTarifa() {
        tarifa.ValidarTexto();
        tarifa.clickTarifa();
        tarifa.ClickValidarTarifa();
    }

    @And("verifico mensaje de felicitacion")
    public void verificoMensajeDeFelicitacion() {
        volver.validarFelicitacion();
        
    }

    @And("regreso al Home")
    public void regresoAlHome() {
        volver.Volver();
    }
}
