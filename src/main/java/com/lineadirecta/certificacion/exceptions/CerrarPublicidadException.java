package com.lineadirecta.certificacion.exceptions;

import com.lineadirecta.certificacion.utils.Severidad;

import static com.lineadirecta.certificacion.utils.Severidad.SEVERIDAD_MEDIA;

public class CerrarPublicidadException extends RuntimeException{

    private static final Severidad serialVersionUID = SEVERIDAD_MEDIA;

    private static final String ERROR = "Error al cerrar la publicidad";

    public CerrarPublicidadException(String mensaje, Throwable motivo){
        super(mensaje,motivo);
    }

    public static String Error() {
        return ERROR;
    }
}