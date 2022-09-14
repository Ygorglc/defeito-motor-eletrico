package com.costa.ygor.defeito_motor_eletrico.util;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SocketPublicarThread extends Thread {
    PrintWriter out;
    Integer porta;

    public SocketPublicarThread(Integer porta) {
        porta = porta;
    }

    public SocketPublicarThread() {
    }
    public void run(){
        try {
            ServerSocket socketServidor = new ServerSocket(porta);
            Socket socketClient = socketServidor.accept();
            out = new PrintWriter(socketClient.getOutputStream(),true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void publicar(String menssagem){
        out.println(menssagem);
    }
}

