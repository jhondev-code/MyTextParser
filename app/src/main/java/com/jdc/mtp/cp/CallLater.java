package com.jdc.mtp.cp;

/**
 * Esta clase provee funcionalidad para ejecutar codigo despues de una accion.
 *
 * @author Jhon
 * @version 1.0.0
 **/
public interface CallLater {

    /**
     * Este metodo implementara el codigo que debe ser ejecutado al culminar una accion.
     **/
    void execute();

}
