package com.jdc.mtp.cp;

/**
 * Esta clase es el molde para clases encargadas de monitorear recurso o funciones.
 **/
public abstract class Monitor {

    private boolean run = false;
    private boolean pause = false;
    private boolean stop = false;

    /* Constructor por defecto */
    public Monitor() {/* empty constructor */}

    /**
     * Este metodo se usa para iniciar el monitor
     **/
    public void start(CallBack back, CallLater later) {
        this.run = true;
        this.pause = false;
        this.stop = false;
    }

    /**
     * Este mtodo se usa para pausar el monitor
     **/
    public void pause(CallBack back, CallLater later) {
        this.pause = true;
        this.run = false;
        this.stop = false;
    }

    /**
     * Este metodo se usa para detener al monitor
     **/
    public void stop(CallBack back, CallLater later) {
        this.run = false;
        this.pause = false;
        this.stop = true;
    }

    public boolean isPaused() {
        return this.pause;
    }

    public boolean isRunning() {
        return this.run;
    }

    public boolean isStopped() {
        return this.stop;
    }
}
