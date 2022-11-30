#Author: lpinedau@choucairtesting.com

@EjecutarTodo
Feature: Realizar compras en la plataforma de LIKE ME
  Como usuario quiere realizar compras de articulos por medio
  de la app de LIKE ME

  Background: Se Inicia sesion en la app
    Given que el usuario quiere iniciar sesion
    When Ingresa sus credenciales de autenticacion
      | usuario               | clave           |
      | fdo.nando01@gmail.com | LpinedauT35t!ng |

  @RealizarPedido
  Scenario Outline: Intento de ingresar productos al carrito de compra estando autenticado, Caso exitoso
    Given que requiero seleccionar mis productos
      | categoria   | opcion   | prenda   |
      | <categoria> | <opcion> | <prenda> |
    When selecciono detalles de la compra
      | talla   | cantidad   |
      | <talla> | <cantidad> |
    Then podra verificar que el precio total de la compra sea:$46.798
    Examples:
      | categoria | opcion    | prenda                          | talla | cantidad |
      | Hombre    | Camisetas | CAMISETA MANGA CORTA Multicolor | L     | 2        |

