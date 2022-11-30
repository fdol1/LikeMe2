#Author: lpinedau@choucairtesting.com

@EjecutarTodo
Feature: Realizar el inicio de sesion en el portal web
  Como usuario quiero iniciar sesion por medio de
  una autenticacion con mis credenciales


  @IniciarSesion
  Scenario Outline: Intento de inicio de sesion, caso exitoso
    Given que el usuario quiere iniciar sesion
    When Ingresa sus credenciales de autenticacion
      | usuario   | clave   |
      | <usuario> | <clave> |
    Then Podra verificar datos sobre: Información de Contacto
    Examples:
      | usuario               | clave           |
      | fdo.nando01@gmail.com | LpinedauT35t!ng |

  @IniciarSesionConFormatoErrado
  Scenario Outline: Intento de inicio de sesion con un formato de correo errado, caso fallido
    Given que el usuario quiere iniciar sesion
    When Ingresa sus credenciales de autenticacion
      | usuario   | clave   |
      | <usuario> | <clave> |
    Then Podra verificar el mensaje: Por favor Ingrese dirección de correo electrónico válida. (Ej.: anónimo@dominio.com).
    Examples:
      | usuario           | clave           |
      | fdo.nando01@gmail | LpinedauT35t!ng |


  @IniciarSesionSinDatos
  Scenario: Intento de inicio de sesion sin datos de usuario, caso fallido
    Given que el usuario quiere iniciar sesion
    When Intenta iniciar sesion sin datos
    Then Podra verificar el mensaje: Este es un campo obligatorio.


  @IniciarSesionConClaveInvalida
  Scenario Outline: Intento de inicio de sesion con clave invalida, caso fallido
    Given que el usuario quiere iniciar sesion
    When Ingresa sus credenciales de autenticacion
      | usuario   | clave   |
      | <usuario> | <clave> |
    Then Podra verificar el mensaje de error:El inicio de sesión de la cuenta fue incorrecto o su cuenta está deshabilitada temporalmente. Espere y vuelva a intentarlo más tarde. Conoce aquí como crear una nueva contraseña
    Examples:
      | usuario               | clave       |
      | fdo.nando01@gmail.com | Lpinedau!ng |
