package com.lineadirecta.certificacion.exceptions;

import com.lineadirecta.certificacion.utils.Severidad;

import static com.lineadirecta.certificacion.utils.Severidad.SEVERIDAD_MEDIA;

public class IntentoDeInicioDeSesionException extends RuntimeException{

    private static final Severidad serialVersionUID = SEVERIDAD_MEDIA;

    private static final String ERROR = "Error al intentar iniciar sin credenciales";

    public IntentoDeInicioDeSesionException(String mensaje, Throwable motivo){
        super(mensaje,motivo);
    }

    public static String Error() {
        return ERROR;
    }
}