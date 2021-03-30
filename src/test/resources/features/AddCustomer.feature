Feature: Agregar un nuevo cliente
  Yo como un usuario
  Quiero agregar un nuevo cliente
  Para ofrecer mis productos


  Scenario: Agregar Cliente
    Given Voy a la pagina Telecom Project
    When le doy click a Agregar cliente
    And ingresar datos
      | check | nombre | apellido | email          | direccion  | celular   |
      | done  | Jorge  | Paz      | jorge@test.com | micasa 752 | 974880014 |
    And envio el formulario
    And obtengo el numero de Orden
    And ingreso el orden
    Then valido el orden de Tarifa
    And verifico mensaje de felicitacion
    And regreso al Home

  @prueba
  Scenario: Alerta en el Formulario
    Given Voy a la pagina Telecom Project
    When le doy click a Agregar cliente
    And envio el formulario
    Then obtener mensaje

  Scenario Outline: Agregar varios Cliente
    Given Voy a la pagina Telecom Project
    When le doy click a Agregar cliente
    And Selecciono opcion "<check>"
    And Ingreso Nombre"<nombre>"
    And Ingreso Apellido "<apellido>"
    And Ingreso Email "<email>"
    And Ingreso direccion "<direccion>"
    And Ingreso celular "<celular>"
    And envio el formulario
    And obtengo el numero de Orden
    And ingreso el orden
    Then valido el orden de Tarifa
    Examples:
      | check   | nombre | apellido   | email           | direccion  | celular   |
      | done    | Jorge  | Paz        | jorge@test.com  | micasa 752 | 974880014 |
      | pending | Miguel | Rodriguez  | miguel@test.com | micasa 752 | 974880014 |
      | done    | Johana | Obando     | johana@test.com | micasa 752 | 974880014 |
      | pending | Axel   | Chacaliaza | jorge@test.com  | micasa 752 | 974880014 |

