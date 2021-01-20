package com.jdc.mtp.cp;

/**
 * Un objeto de esta clase se encarga de escuchar el contenido del portapapeles dado un
 * intervalo de tiempo.
 *
 * @author Jhon
 * @version 1.0.0
 **/
public class ClipboardMonitor extends Monitor {

    private ContentRequester requester;
    private int delayTime;

    public ClipboardMonitor(ContentRequester requester, int delay) {
        //
    }

    /**
     * Este metodo se encargara de iniciar el monitoreo de portapapeles.
     **/
    @Override
    public void start() {
    }

    /**
     * El tiempo de pausa debe de tener un determinado intervalo de tiempo, al haber
     * pasado el tiempo detenido, el monitor se restablecera.
     **/
    @Override @Deprecated
    public void pause() {}

    /**
     * Este metodo se encargara de detener el monitoreo del portapapeles.
     **/
    @Override
    public void stop() {}
}
