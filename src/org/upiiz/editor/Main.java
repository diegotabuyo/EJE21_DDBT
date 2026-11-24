package org.upiiz.editor;

import org.upiiz.editor.controlador.EditorControlador;
import org.upiiz.editor.modelo.ArchivoModelo;
import org.upiiz.editor.vista.VentanaEditor;

import javax.swing.UIManager;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.out.println(e);
        }

        ArchivoModelo modelo = new ArchivoModelo();
        VentanaEditor vista = new VentanaEditor();
        new EditorControlador(modelo, vista);

        vista.setVisible(true);
    }
}