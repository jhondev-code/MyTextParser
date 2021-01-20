package com.jdc.mtp.cp;

/**
 * Esta clase es el molde para clases encargadas de monitorear recurso o funciones.
 **/
public abstract class Monitor {

    /* Constructor por defecto */
    public Monitor() {/* empty constructor */}

    /**
     * Este metodo se usa para iniciar el monitor
     **/
    public void start() {}

    /**
     * Este mtodo se usa para pausar el monitor
     **/
    public void pause() {}

    /**
     * Este metodo se usa para detener al monitor
     **/
    public void stop() {}

}
