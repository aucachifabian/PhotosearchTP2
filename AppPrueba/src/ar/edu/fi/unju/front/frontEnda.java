package ar.edu.fi.unju.front;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import javax.swing.JLayeredPane;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import java.awt.Insets;

public class frontEnda extends JFrame {
    public static String resultado =null;// "C:\\Users\\Fabian\\Desktop/okais.jpg";
    File ruta = new File("C:\\Users");
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frontEnda frame = new frontEnda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * constructor del jframe.
	 */
	public frontEnda() {
		getContentPane().setBackground(SystemColor.textHighlight);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 877, 520);
		getContentPane().setLayout(null);
		
		 JButton btnNewButton = new JButton("Buscar Imagen");
		btnNewButton.setActionCommand("Buscar");
	
		// Se escucha al boton de busqueda que nos mandara la ventana de dialogo a ingresar nombre imagen
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean bandera = false;
				String nombreImagen = JOptionPane.showInputDialog("Ingrese nombre de la imagen");
				if(nombreImagen.isEmpty())
			    {
			    	JOptionPane.showInternalMessageDialog(null, "EL CAMPO NO DEBE ESTAR VACIO");
			    }
			    else
				{
			    	//lamamos al metodo que realiza la busqueda recursiva en carpetas y subcarpetas la imagen
			    	buscarArchivo(ruta, nombreImagen, bandera);
			    	// si no la encuentra "resultado" queda en nulo y muestra una ventana emergente,
			    	//y si la encuentra crea un objeto frame mostrando la
			    	// la imagen junto con su PATH 
			    	if(resultado!=null)
			    	{
			    	VentanaImagen ventana = new VentanaImagen(resultado);
			    	ventana.setVisible(true);
			    	}
			    	else
			    		JOptionPane.showInternalMessageDialog(null, "Archivo 'jpg' no encontrado");
					   
				}   
			}
		});
		
		/* Caracteristicas visuales del boton de salida*/
		JButton btnNewButton_1 = new JButton("SALIR");
		btnNewButton_1.setForeground(new Color(255, 0, 0));
		btnNewButton_1.setBorder(UIManager.getBorder("InternalFrame.border"));
		btnNewButton_1.setMargin(new Insets(21, 19, 19, 21));
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton_1.setBackground(new Color(255, 255, 255));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//cierra la ventana emergente
				dispose();
			}
		});
		
		
		btnNewButton_1.setBounds(390, 382, 106, 32);
		getContentPane().add(btnNewButton_1);
		btnNewButton.setBorder(UIManager.getBorder("InternalFrame.border"));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		btnNewButton.setBackground(new Color(245, 245, 220));
		btnNewButton.setBounds(302, 329, 285, 42);
		getContentPane().add(btnNewButton);
		
		JLayeredPane layeredPane = new JLayeredPane();
		layeredPane.setBounds(0, 0, 434, 1);
		getContentPane().add(layeredPane, BorderLayout.NORTH);
		
		JLayeredPane layeredPane_1 = new JLayeredPane();
		layeredPane_1.setBounds(139, 123, 1, 1);
		getContentPane().add(layeredPane_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(new Color(135, 206, 235));
		lblNewLabel.setIcon(new ImageIcon(frontEnda.class.getResource("/ar/edu/fi/unju/front/img/okkkkkkk.jpg")));
		lblNewLabel.setBounds(0, 0, 863, 486);
		getContentPane().add(lblNewLabel);
	}
	
	/**
	 * Metodo para llamad a un color
	 * @return
	 */
	public static Color colorText()
	{
     	Color ok = new Color(255,233,111);
     	
		return ok;
	}
	
	/**
	 * Tenemos un procedimiento recursivo que busca en todas las carpetas y subcarpetas de la maquina 
	 * @param ruta seria la carpeta Padre del equipo C:/
	 * @param nomArchivo nombre del archivo que buscamos, sera .jpg
	 * @param bandera sirve para cortar el recorrido enviarle siempre falso.
	 * 
	 * como es recursivo tuve que usar una variable para tooda la clase, y la bandera por parametro.
	 */
	public static void buscarArchivo(File ruta, String nomArchivo, boolean bandera) {
	       File[] archivo = ruta.listFiles();
	       if (archivo != null) {
	           for (int i = 0; i < archivo.length && bandera == false; i++) {
	               File Arc = archivo[i];
	               if (archivo[i].isDirectory()) {
	                   buscarArchivo(archivo[i], nomArchivo, bandera);
	               } else {
	                   if (archivo[i].getName().endsWith(nomArchivo + ".jpg")) {
	                	   bandera = true;
	                	   resultado = archivo[i].getAbsolutePath();
	                   }
	               }
	           }
	       }
      }
}

