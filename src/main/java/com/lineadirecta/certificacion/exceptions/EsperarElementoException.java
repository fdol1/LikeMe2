package com.lineadirecta.certificacion.exceptions;

import com.lineadirecta.certificacion.utils.SerialVersionUid;

import static com.lineadirecta.certificacion.utils.SerialVersionUid.SERIAL2;

public class EsperarElementoException extends RuntimeException{

    private static final SerialVersionUid serialVersionUID = SERIAL2;

    private static final String ERROR = "Error al esperar el elemento";

    public EsperarElementoException(String mensaje, Throwable motivo){
        super(mensaje,motivo);
    }

    public static String Error() {
        return ERROR;
    }
}