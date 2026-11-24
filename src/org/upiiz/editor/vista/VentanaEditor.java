package org.upiiz.editor.vista;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;

public class VentanaEditor extends JFrame {
    private JTextArea textArea;
    private JScrollPane scrollPane;
    private JMenuBar barraMenu;
    private JMenu menuArchivo;
    private JMenu menuAyuda;
    private JMenuItem itemNuevo;
    private JMenuItem itemAbrir;
    private JMenuItem itemGuardar;
    private JMenuItem itemGuardarComo;
    private JMenuItem itemSalir;
    private JMenuItem itemAcercaDe;

    public VentanaEditor(String titulo) {
        setTitle(titulo);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        iniciarComponentes();
    }

    // Constructor sobrecargado
    public VentanaEditor() {
        this("Sin título - Editor de Textos");
    }

    private void iniciarComponentes() {
        // Área de texto con barra de desplazamiento
        textArea = new JTextArea();
        textArea.setFont(new Font("Consolas", Font.PLAIN, 14));
        scrollPane = new JScrollPane(textArea);
        getContentPane().add(scrollPane, BorderLayout.CENTER);

        // Barra de menús
        barraMenu = new JMenuBar();

        // Menú Archivo
        menuArchivo = new JMenu("Archivo");

        itemNuevo = new JMenuItem("Nuevo");
        itemNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, KeyEvent.CTRL_DOWN_MASK));

        itemAbrir = new JMenuItem("Abrir");
        itemAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK));

        itemGuardar = new JMenuItem("Guardar");
        itemGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, KeyEvent.CTRL_DOWN_MASK));

        itemGuardarComo = new JMenuItem("Guardar como");
        itemGuardarComo.setAccelerator(KeyStroke.getKeyStroke(
                KeyEvent.VK_G, KeyEvent.CTRL_DOWN_MASK | KeyEvent.SHIFT_DOWN_MASK));

        itemSalir = new JMenuItem("Salir");
        itemSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, KeyEvent.CTRL_DOWN_MASK));

        menuArchivo.add(itemNuevo);
        menuArchivo.add(itemAbrir);
        menuArchivo.add(itemGuardar);
        menuArchivo.add(itemGuardarComo);
        menuArchivo.addSeparator();
        menuArchivo.add(itemSalir);

        // Menú Ayuda
        menuAyuda = new JMenu("Ayuda");

        itemAcercaDe = new JMenuItem("Acerca de");
        itemAcercaDe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, KeyEvent.CTRL_DOWN_MASK));

        menuAyuda.add(itemAcercaDe);

        // Agregar menús a la barra y asignarla a la ventana
        barraMenu.add(menuArchivo);
        barraMenu.add(menuAyuda);
        setJMenuBar(barraMenu);
    }

    // Métodos de acceso (getters) para el controlador
    public JTextArea getTextArea() {
        return textArea;
    }

    public JMenuItem getItemNuevo() {
        return itemNuevo;
    }

    public JMenuItem getItemAbrir() {
        return itemAbrir;
    }

    public JMenuItem getItemGuardar() {
        return itemGuardar;
    }

    public JMenuItem getItemGuardarComo() {
        return itemGuardarComo;
    }

    public JMenuItem getItemSalir() {
        return itemSalir;
    }

    public JMenuItem getItemAcercaDe() {
        return itemAcercaDe;
    }
}