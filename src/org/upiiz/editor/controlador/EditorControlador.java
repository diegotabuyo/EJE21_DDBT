package org.upiiz.editor.controlador;

import org.upiiz.editor.modelo.ArchivoModelo;
import org.upiiz.editor.vista.VentanaEditor;

import javax.swing.JOptionPane;
import java.awt.FileDialog;
import java.io.File;
import java.io.IOException;

public class EditorControlador {
    private ArchivoModelo modelo;
    private VentanaEditor vista;

    public EditorControlador(ArchivoModelo modelo, VentanaEditor vista) {
        this.modelo = modelo;
        this.vista = vista;
        configurarEventos();
    }

    public ArchivoModelo getModelo() {
        return modelo;
    }

    public void setModelo(ArchivoModelo modelo) {
        this.modelo = modelo;
    }

    public VentanaEditor getVista() {
        return vista;
    }

    public void setVista(VentanaEditor vista) {
        this.vista = vista;
    }

    private void configurarEventos() {
        vista.getItemNuevo().addActionListener(e -> nuevoArchivo());
        vista.getItemAbrir().addActionListener(e -> abrirArchivo());
        vista.getItemGuardar().addActionListener(e -> guardarArchivo());
        vista.getItemGuardarComo().addActionListener(e -> guardarArchivoComo());
        vista.getItemSalir().addActionListener(e -> salir());
        vista.getItemAcercaDe().addActionListener(e -> mostrarAcercaDe());
    }

    private void nuevoArchivo() {
        vista.getTextArea().setText("");
        modelo.setArchivoActual(null);
        vista.setTitle("Sin título - Editor de Textos");
    }

    private void abrirArchivo() {
        FileDialog fileDialog = new FileDialog(vista, "Abrir", FileDialog.LOAD);
        fileDialog.setVisible(true);

        if (fileDialog.getFile() != null) {
            String nombreArchivo = fileDialog.getDirectory() + fileDialog.getFile();
            File archivo = new File(nombreArchivo);
            try {
                String contenido = modelo.leerArchivo(archivo);
                vista.getTextArea().setText(contenido);
                vista.setTitle(archivo.getName() + " - Editor de Textos");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(vista, "Error al abrir el archivo: " + e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void guardarArchivo() {
        if (modelo.getArchivoActual() == null) {
            guardarArchivoComo();
        } else {
            try {
                modelo.guardarArchivo(vista.getTextArea().getText());
                JOptionPane.showMessageDialog(vista, "Archivo guardado correctamente.",
                        "Guardar", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException e) {
                JOptionPane.showMessageDialog(vista, "Error al guardar el archivo: " + e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void guardarArchivoComo() {
        FileDialog fileDialog = new FileDialog(vista, "Guardar como", FileDialog.SAVE);
        fileDialog.setVisible(true);

        if (fileDialog.getFile() != null) {
            String nombreArchivo = fileDialog.getDirectory() + fileDialog.getFile();
            File archivo = new File(nombreArchivo);
            try {
                modelo.guardarArchivo(archivo, vista.getTextArea().getText());
                vista.setTitle(archivo.getName() + " - Editor de Textos");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(vista, "Error al guardar el archivo: " + e.getMessage(),
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void salir() {
        System.exit(0);
    }

    private void mostrarAcercaDe() {
        JOptionPane.showMessageDialog(vista,
                "Editor de Textos en Java (MVC)\nDesarrollado por: Diego Daniel Becerra Tabuyo\nGrupo: 3IM1",
                "Acerca de",
                JOptionPane.INFORMATION_MESSAGE);
    }
}