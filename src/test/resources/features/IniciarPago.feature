#Author: lpinedau@choucairtesting.com

@EjecutarTodo
Feature: Realizar pago de los articulos
  Como usuario quiere realizar el pago de los articulos
  agregados al carrito de compra

  Background: Se Inicia sesion en la app
    Given que el usuario quiere iniciar sesion
    When Ingresa sus credenciales de autenticacion
      | usuario                      | clave           |
      | lpinedau@choucairtesting.com | LpinedauT35t!ng |


  @RealizarPagoConEfectivo
  Scenario Outline: Intento de realizar pagos estando autenticado, Caso exitoso
    Given que el usuario ingresa hasta el formulario de pagos
    When ingresa los datos de compra
      | nombre   | apellido   | tipoDoc   | numDoc   | celular   | direccion   | dirAdicional   | departamento   | ciudad   |
      | <nombre> | <apellido> | <tipoDoc> | <numDoc> | <celular> | <direccion> | <dirAdicional> | <departamento> | <ciudad> |
    Examples:
      | nombre   | apellido | tipoDoc              | numDoc      | celular    | direccion    | dirAdicional | departamento | ciudad   |
      | Fernando | Pineda   | Cédula de Ciudadanía | 1029543457 | 3103456755 | Calle 10 - 9 | apto 8       | Antioquia    | Medellín |

