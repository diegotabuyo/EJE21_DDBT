package org.upiiz.editor.modelo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ArchivoModelo {
    private File archivoActual;

    public ArchivoModelo() {
        this.archivoActual = null;
    }

    // Constructor sobrecargado
    public ArchivoModelo(File archivoActual) {
        this.archivoActual = archivoActual;
    }

    public File getArchivoActual() {
        return archivoActual;
    }

    public void setArchivoActual(File archivoActual) {
        this.archivoActual = archivoActual;
    }

    public String leerArchivo(File archivo) throws IOException {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        }
        this.archivoActual = archivo;
        return contenido.toString();
    }

    // Guarda en un archivo específico (usado por "Guardar como")
    public void guardarArchivo(File archivo, String contenido) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(archivo))) {
            writer.write(contenido);
        }
        this.archivoActual = archivo;
    }

    // Metodo sobrecargado: guarda directamente en el archivo actual
    public void guardarArchivo(String contenido) throws IOException {
        if (this.archivoActual != null) {
            guardarArchivo(this.archivoActual, contenido);
        }
    }
}