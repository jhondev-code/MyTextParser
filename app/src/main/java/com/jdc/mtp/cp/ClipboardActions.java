package com.jdc.mtp.cp;

/**
 * Esta interfaz es usada para manejar la entrada y salida de contenido del portapapeles.
 *
 * @author Jhon
 * @version 1.0.0
 **/
public interface ClipboardActions {

    /**
     * Obtiene el contenido del portapapeles
     **/
    Object getContent();

    /**
     * Modifica el contenido del portapapeles
     **/
    void setContent(Object object);

}
