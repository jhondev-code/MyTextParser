package com.jdc.mtp.cp;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

/**
 * Un objeto de esta clase se encarga de escuchar el contenido del portapapeles dado un
 * intervalo de tiempo.
 *
 * @author Jhon
 * @version 1.0.0
 **/
public class ClipboardMonitor extends Monitor implements Runnable{

    private final Clipboard systemClipboard;
    private final ContentRequester requester;
    private final int delayTime;
    private int millis;
    private boolean start;
    private Thread executor;

    public ClipboardMonitor(ContentRequester requester, int delay) {
        this.requester = requester;
        this.delayTime = delay;
        this.systemClipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    }

    /**
     * Este metodo se encargara de iniciar el monitoreo de portapapeles.
     **/
    @Override
    public void start(CallBack back, CallLater later) {
        super.start(back, later);
        this.start = true;
        this.executor = new Thread(this);
        this.executor.start();
    }

    public void pause(CallBack back, CallLater later, int millis) {
        this.pause(back, later);
        this.millis = millis;
    }

    /**
     * El tiempo de pausa debe de tener un determinado intervalo de tiempo, al haber
     * pasado el tiempo detenido, el monitor se restablecera.
     **/
    @Override @Deprecated
    public void pause(CallBack back, CallLater later) {}

    /**
     * Este metodo se encargara de detener el monitoreo del portapapeles.
     **/
    @Override
    public void stop(CallBack back, CallLater later) {
        super.stop(back, later);
        this.start = false;
        this.executor = null;
    }

    /**
     * El hilo ejecutor llama este metodo y ejecuta el codigo.
     **/
    @Override
    public void run() {
        if (this.millis > 0) {
            try {
                Thread.sleep(this.millis);
            } catch (InterruptedException ie) {
                ie.printStackTrace();
            }
        } else {
            while (this.start) {
                try {
                    this.requester.onChanged(this.systemClipboard.getData(DataFlavor.stringFlavor), this.systemClipboard);
                    Thread.sleep(this.delayTime);
                } catch (InterruptedException | UnsupportedFlavorException | IOException ie) {
                    ie.printStackTrace();
                }
            }
        }
    }
}
