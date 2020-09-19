package ar.edu.fi.unju.front;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaImagen extends JFrame {
	private JPanel contentPane;

	/**
	 * Create the frame.
	 * constructor del jframe recibe el nombre de la clase que lo llame. 
	 */
	public VentanaImagen(String name) {
	     
		  String archivo = name;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel PATCH = new JLabel("");
		PATCH.setFont(new Font("Tahoma", Font.BOLD, 14));
		PATCH.setEnabled(false);
		PATCH.setBackground(Color.YELLOW);
		PATCH.setBounds(141, 11, 591, 20);
		PATCH.setText(archivo);
		contentPane.add(PATCH);
		
		JLabel lblNewLabel = new JLabel("Ubicacion:");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setIcon(null);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setBounds(38, 11, 82, 20);
		contentPane.add(lblNewLabel);
		
		JLabel VentanaEmergenteImagen = new JLabel("");
		VentanaEmergenteImagen.setBounds(38, 58, 694, 437);
		ImageIcon imagen = new ImageIcon(archivo);
		VentanaEmergenteImagen.setIcon(new ImageIcon(imagen.getImage().getScaledInstance(VentanaEmergenteImagen.getWidth(), VentanaEmergenteImagen.getHeight(), Image.SCALE_SMOOTH)));
		contentPane.add(VentanaEmergenteImagen);
		
		JButton btnNewButton = new JButton("SALIDA");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					dispose();
			}
		});
		btnNewButton.setBounds(349, 506, 91, 32);
		contentPane.add(btnNewButton);
	}

}
