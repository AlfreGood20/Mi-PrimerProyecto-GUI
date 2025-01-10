package Practica_5;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Pantalla extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel panel;
	private JTextField campoTexto;
    private JTextField campoPegar;
	
    // .setBounds()
	public Pantalla() {
		setTitle("Mi Primera Interfaz"); // EL TITULO DE LA VENTANA
		setSize(500,400); // TAMAÑO DE LA VENTANA
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // CUANDO LE DE A CERRAR SE CIERRA EL PROGRMA
        setLocationRelativeTo(null); // CENTRA LA VENTANA
        setResizable(false); // BLOQUEA LA PANTALLA PARA QUE NO LO PUEDA HACER GRANDE
        componentes();
    }
	
	private void componentes() {
		crearPanel();
		botonCopiar();
		campoTexto();
		campoTextoPegar();
		botonLimpiar();
		etiquetaTitulo();
		imagenIlustracion();
	}
    
	private void crearPanel() {
		panel=new JPanel();
		panel.setLayout(null); // QUITAMOS EL DISEÑO POR DEFECTO DEL PANEL
		panel.setBackground(Color.yellow);
		this.getContentPane().add(panel); // AGREGAMOS A LA VENTANA EL PANEL
	}
	
	private void botonCopiar() {
		JButton copiar=new JButton();
		copiar.setText("Copiar txt...");
		copiar.setBounds(190,150,100, 40 ); // TAMAÑO DEL CUADRO
		panel.add(copiar);
		
		//HACE QUE EL BOTON SIRVA 
		copiar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				campoPegar.setText(campoTexto.getText()); // PEGAMOS EL TEXTO AL CAMPO PEGAR
			}
		});
	}
	
	private void campoTexto() {
		campoTexto = new JTextField();
		campoTexto.setText("");
		campoTexto.setBounds(20,125,440, 20);
		panel.add(campoTexto);
	}
	
	private void campoTextoPegar() {
		campoPegar=new JTextField();
		campoPegar.setText(""); //AQUI SE VA PEGAR EL TEXTO DE CAMPO DE TEXTO
		campoPegar.setEnabled(false);// PARA QUE EL USUARIO NO INGRESE TEXTO EN ESE LUGAR
		campoPegar.setBounds(20,255, 440,20);
		campoPegar.setDisabledTextColor(Color.BLACK); // COLOR DE LETRA PARA QUE NO SE VEA TAN TRANSPARENTE
		campoPegar.setBackground(Color.LIGHT_GRAY); // COLOR AL CAMPO DE TEXTO
		panel.add(campoPegar);
	}
	
	private void botonLimpiar() {
		JButton limpiar=new JButton();
		limpiar.setText("Limpiar...");
		limpiar.setBounds(190,280,100, 40);
		panel.add(limpiar);
		
		//TIENE ACCION EL BOTON
		limpiar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				campoPegar.setText(""); // LIMPIA EL TEXTO DE CAMPO
				campoTexto.setText(""); // LIMPIA EL TEXTO DE PEGAR
			}
		});
	}
	
	private void etiquetaTitulo() {
		JLabel etiqueta=new JLabel();
		etiqueta.setText("App Copiadora De Texto");
		etiqueta.setHorizontalAlignment(SwingConstants.CENTER);
		etiqueta.setBounds(0,20,500,25);
		etiqueta.setFont(new Font("Arial", Font.BOLD, 20));
		panel.add(etiqueta);
	}
	
	private void imagenIlustracion() {
		ImageIcon imagen=new ImageIcon("img.png"); // AGREGAMOS LA IMAGEN
		JLabel etiqueta=new JLabel();
		etiqueta.setBounds(25,20,80,80);
		etiqueta.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(etiqueta.getWidth(),etiqueta.getHeight(),Image.SCALE_SMOOTH))); // ESCALA LA IMAGEN ADECUADO CON LA ETIQUETA
		panel.add(etiqueta);
	}
	
}
