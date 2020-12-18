package com.company;
import javax.swing.*;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.swing.JOptionPane;


public class Servrmi {


    public static void main (String args [ ]) {
        //Cria e instala o security manager
        //System.setSecurityManager(new RMISecurityManager() );

        try {
            Registry registry = LocateRegistry.createRegistry(9998);

            Servidor obj = new Servidor();
            registry.rebind("Calc.Simples", obj);
            JOptionPane.showMessageDialog("Conectado a Calc.Simples");
        } catch(Exception e) {
            JOptionPane.showMessageDialog("erro"+ e.getMessage());
        }

        try {
            Registry registry = LocateRegistry.createRegistry(9999);

            Servidor2 obj = new Servidor2();
            registry.rebind("Calc.Complexa", obj);
            JOptionPane.showMessageDialog("Conectado a Calc.Complexa");
        } catch(Exception e) {
            JOptionPane.showMessageDialog("erro"+ e.getMessage());
        }
    }
}







