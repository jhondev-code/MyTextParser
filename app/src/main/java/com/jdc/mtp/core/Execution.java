package com.jdc.mtp.core;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;

import com.jdc.mtp.cp.ClipboardMonitor;
import com.jdc.mtp.cp.ContentRequester;
import com.jdc.mtp.util.ImageUtil;

public class Execution {

    private ClipboardMonitor monitor;
    private String oldText = "";
    private final ContentRequester requester = (content, clipboard) -> {
        String text = (String) content;
        if (!this.oldText.equals(content)) {
            this.oldText = text;
            clipboard.setContents(new StringSelection(this.oldText.replaceAll("\n", " ")), null);
        }
    };

    private MenuItem start;
    private MenuItem stop;
    private MenuItem manual;

    public Execution() {
        if (SystemTray.isSupported()) {
            this.monitor = new ClipboardMonitor(this.requester, 500);
            this.initComponents();
        } else {
            System.exit(1);
        }
    }

    private void initComponents() {
        PopupMenu popup = new PopupMenu();
        this.start = new MenuItem("Iniciar monitor automatico");
        this.start.addActionListener(evt -> this.startButtonAction());
        popup.add(this.start);
        this.stop = new MenuItem("Detener monitor automatico");
        this.stop.setEnabled(false);
        this.stop.addActionListener(evt -> this.stopButtonAction());
        popup.add(this.stop);
        this.manual = new MenuItem("Procesar");
        this.manual.addActionListener(evt -> this.processButtonAction());
        popup.add(this.manual);
        popup.addSeparator();
        MenuItem exit = new MenuItem("Salir");
        exit.addActionListener(evt -> this.exitButtonAction());
        popup.add(exit);
        TrayIcon trayIcon = new TrayIcon(ImageUtil.loadPNG("/icons/settings.png"), "My text parser", popup);
        trayIcon.setImageAutoSize(true);
        try {
            SystemTray.getSystemTray().add(trayIcon);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    private void startButtonAction() {
        this.monitor.start(null, null);
        this.start.setEnabled(false);
        this.manual.setEnabled(false);
        this.stop.setEnabled(true);
    }

    private void stopButtonAction() {
        this.monitor.stop(null, null);
        this.start.setEnabled(true);
        this.stop.setEnabled(false);
        this.manual.setEnabled(true);
    }

    private void processButtonAction() {
        Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
        try {
            String content = (String) clipboard.getData(DataFlavor.stringFlavor);
            if (content.contains("\n")) {
                clipboard.setContents(new StringSelection(content.replaceAll("\n", " ")), null);
            }
        } catch (UnsupportedFlavorException | IOException e) {
            e.printStackTrace();
        }
    }

    private void exitButtonAction() {
        if (this.monitor.isRunning() || this.monitor.isPaused()) {
            this.monitor.stop(null, null);
        }
        System.exit(0);
    }

}
