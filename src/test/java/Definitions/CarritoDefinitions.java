package Definitions;

import PageObjects.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.IOException;

import static Support.screenshot.pantallazo;

public class CarritoDefinitions {

    MenuPage menu;
    TarjetaPage tarjeta;
    HomePage home;
    RegistrarDatosTarjetaPage confirmar;
    ConfirmarPagoPage pago;

    public CarritoDefinitions() {
        menu = new MenuPage(Hooks.driver);
        tarjeta = new TarjetaPage(Hooks.driver);
        home = new HomePage(Hooks.driver);
        confirmar = new RegistrarDatosTarjetaPage(Hooks.driver);
        pago = new ConfirmarPagoPage(Hooks.driver);
    }

    @Given("la web esta disponible")
    public void laWebEstaDisponible() {
        Hooks.driver.get("http://demo.guru99.com/payment-gateway/index.php");
    }

    @When("doy click en generar tarjeta")
    public void doyClickEnGenerarTarjeta() {
        menu.ClickGenerarTarjeta();
    }

    @And("capturo los datos de la tarjeta")
    public void capturoLosDatosDeLaTarjeta() {
        tarjeta.UbicarWindows();
        tarjeta.Capturar_Tarjeta();
        tarjeta.Capturar_CVV();
        tarjeta.Capturar_Fecha();
        tarjeta.Capturar_Credito();
        tarjeta.CerrarVentana();
    }

    @And("selecciono cantidad {string} para comprar producto")
    public void seleccionoCantidadParaComprarProducto(String cantidad) {
        home.SeleccionarCantidad(cantidad);
        home.ClickComprar();
    }

    @And("Ingreso Datos de tarjeta")
    public void ingresoDatosDeTarjeta() {
        confirmar.MontoComprar();
        confirmar.IngresarTarjeta();
        confirmar.BtnConfirmar();
    }

    @Then("Valido Frase de Pago {string}")
    public void validoFraseDePago(String validar) {
        pago.ValidarFrase(validar);
    }

    @And("Valido el numero de orden")
    public void validoElNumeroDeOrden() throws IOException {
        pago.ValidarNroOrden();
        pantallazo();

    }

    @And("regreso a la pagina de inicio")
    public void regresoALaPaginaDeInicio() {
        pago.VolverHome();
    }


}

