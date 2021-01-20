package com.jdc.mtp.cp;

import java.awt.datatransfer.Clipboard;

/**
 * Esta interfaz posee un metodo el cual es llamado cuando el contenido del portapapeles ha cambiado.
 *
 * @author Jhon
 * @version 1.0.0
 **/
public interface ContentRequester {

    /**
     * Es llamado cuando el contenido del portapapeles cambia
     **/
    void onChanged(Object content, Clipboard clipboard);

}
