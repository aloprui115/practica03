package practica03;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class Practica03 extends JFrame {
    
    ArrayList<Cliente> clientes = new ArrayList<>(5);    

    //Etiquetas para identificar los campos de texto
    private JLabel numeroLabel;
    private JLabel nombreLabel;
    private JLabel edadLabel;

    //Text fields para introducir números (ahora son de Swing: JTextField)
    private JTextField numeroField;
    private JTextField nombreField;
    private JTextField edadField;
    
    private JButton atrasButton;
    private JButton adelanteButton;

    private int posicionActual = 0;
    private void mostrarCliente() {
    Cliente c = clientes.get(posicionActual);

    numeroField.setText(String.valueOf(c.getNumero()));
    nombreField.setText(c.getNombre());
    edadField.setText(String.valueOf(c.getEdad()));
}
    public Practica03() {
        super("Practica03");
        clientes.add(new Cliente(1, "Ana", 25));
        clientes.add(new Cliente(2, "Carlos", 32));
        clientes.add(new Cliente(3, "Laura", 28));
        clientes.add(new Cliente(4, "Pedro", 45));
        clientes.add(new Cliente(5, "Maria", 21));
        
        //Lo que pasa si cerramos la ventana (sustituye al WindowListener
        //con windowClosing y System.exit(0) de la versión anterior).
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Crea las etiquetas.
        numeroLabel = new JLabel("Numero ");
        nombreLabel = new JLabel("Nombre ");
        edadLabel = new JLabel("Edad ");
        
        //Campo donde vamos a introducir el número
        Cliente c = clientes.get(posicionActual);
        numeroField = new JTextField(10);
        
        numeroField.setEditable(false);

        //Campo que nos muestra el doble del numero introducido
        nombreField = new JTextField(10);
        nombreField.setEditable(false);
        nombreField.setForeground(Color.red);
        
        edadField = new JTextField(10);        
        edadField.setEditable(false);
        edadField.setForeground(Color.green);

        atrasButton = new JButton("Atras");
        atrasButton.addActionListener(new ActionListener() {  // Evento de boton.
            public void actionPerformed(ActionEvent e) {
                if (posicionActual > 0) {
                posicionActual--;
                mostrarCliente();
                System.out.println("atras");
                }
            }
        });
        
        adelanteButton = new JButton("Adelante");
        adelanteButton.addActionListener(new ActionListener() {  // Evento de boton.
            public void actionPerformed(ActionEvent e) {
                if (posicionActual < clientes.size() - 1) {
                posicionActual++;
                mostrarCliente();
                
                System.out.println("adelante");
                }
            }
        });
        
        //Dispone la geometría de las etiquetas en un panel
        JPanel labelPane = new JPanel();
        labelPane.setLayout(new GridLayout(0, 1));
        labelPane.add(numeroLabel);
        labelPane.add(nombreLabel);
        labelPane.add(edadLabel);

        //Dispone los campos de texto en otro panel
        JPanel fieldPane = new JPanel();
        fieldPane.setLayout(new GridLayout(0, 1));
        fieldPane.add(numeroField);
        fieldPane.add(nombreField);
        fieldPane.add(edadField);
        
        JPanel botonesPane = new JPanel();
        botonesPane.setLayout(new GridLayout(1, 0));
        botonesPane.add(atrasButton);
        botonesPane.add(adelanteButton);

        //Incluye los dos paneles en otro panel,
        //etiquetas a la izquierda
        //y campos de texto a la derecha.
        JPanel contentPane = new JPanel();
        contentPane.setBorder(
               BorderFactory.createEmptyBorder(20, 20, 20, 20));
        contentPane.setLayout(new BorderLayout());
        contentPane.add(labelPane, BorderLayout.CENTER);
        contentPane.add(fieldPane, BorderLayout.EAST);
        contentPane.add(botonesPane, BorderLayout.SOUTH);
        setContentPane(contentPane);
        mostrarCliente();//this.setContentPane(contentPane);
          // es set, o sea, machado el contenedor del objeto "Doble", hijo de JFrame

    }

    public static void main(String[] args) {

        // Toda la interfaz Swing se crea en el hilo de eventos (receta: se hace siempre así).
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                final Practica03 app = new Practica03();

                
                app.pack();
                app.setVisible(true);
            }
        });
    }
}
