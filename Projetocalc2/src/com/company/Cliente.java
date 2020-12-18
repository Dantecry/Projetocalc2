package com.company;

import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;
import java.rmi.*;
import javax.swing.*;

public class Cliente{

    public static void main(String[] args) throws UnknownHostException, RemoteException {

            Socket client;
            int opcao = 0;
            opcao = Integer.parseInt(JOptionPane.showInputDialog("Digite o servidor de sua preferencia 1/2 ?"));
            Socket cliente = null;
            if (opcao == 1) {
                cliente = new Socket("127.0.1.1", 9998);
            }if (opcao == 2) {
                cliente = new Socket("127.0.1.1", 9999);
            }else{
                System.out.printf("Você digitou uma opção inválida.");
            }


        int num1 = 0;
        int num2 = 0;
        int operacao = 0;
        char opr;
        System.out.println("Conectado");


        ObjectInputStream resultado = new ObjectInputStream(cliente.getInputStream());
        ObjectOutputStream dados = new ObjectOutputStream(cliente.getOutputStream());


        num1 = Integer.parseInt(JOptionPane.showInputDialog("Digite o primeiro número"));
        num2 = Integer.parseInt(JOptionPane.showInputDialog("Digite o segundo número"));
        operacao = Integer.parseInt(JOptionPane.showInputDialog("Qual operação desejada? 1=+,2=-,3=X,4=/,5=%,6=r,7=^ "));
        dados.writeInt(operacao);
        dados.writeInt(num1);
        dados.writeInt(num2);

        dados.flush();

        double total = resultado.readDouble();
        opr = resultado.readChar();
        System.out.println("Total de " + num1 + opr + num2 + " = " + total);

        cliente.close();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}














