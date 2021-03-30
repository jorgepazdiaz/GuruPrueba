Feature: Carrito de compras
  Yo como cliente
  Quiero realizar una compra
  Para aquirir mis productos

  @prueba
  Scenario: Comprar un producto
    Given la web esta disponible
    When doy click en generar tarjeta
    And capturo los datos de la tarjeta
    And selecciono cantidad "0" para comprar producto
    And Ingreso Datos de tarjeta
    Then Valido Frase de Pago "Payment successfull!"
    And Valido el numero de orden
    And regreso a la pagina de inicio

  Scenario Outline: Comprar varios productos
    Given la web esta disponible
    When doy click en generar tarjeta
    And capturo los datos de la tarjeta
    And selecciono cantidad "<cantidad>" para comprar producto
    And Ingreso Datos de tarjeta
    Then Valido Frase de Pago "<Frase>"
    And Valido el numero de orden
    And regreso a la pagina de inicio
    Examples:
      | cantidad | Frase                |
      | 5        | Pago successfull!    |
      | 2        | Payment successfull! |
      | 9        | Payment successfull! |
      | 7        | Pago Exitoso!        |