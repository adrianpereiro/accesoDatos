import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class CopiaFicheros {

	private JFrame frame;
	private JTextField rutaOrigen;
	private JTextField rutaDestino;
	private JTextField nombreDestino;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CopiaFicheros window = new CopiaFicheros();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CopiaFicheros() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 718, 378);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Origen");
		lblNewLabel.setBounds(30, 42, 46, 14);
		frame.getContentPane().add(lblNewLabel);
		
		rutaOrigen = new JTextField();
		rutaOrigen.setBounds(111, 39, 341, 20);
		frame.getContentPane().add(rutaOrigen);
		rutaOrigen.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Destino");
		lblNewLabel_1.setBounds(30, 89, 46, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		rutaDestino = new JTextField();
		rutaDestino.setBounds(325, 86, 313, 20);
		frame.getContentPane().add(rutaDestino);
		rutaDestino.setColumns(10);
		
		JComboBox codificacionDestino = new JComboBox();
		codificacionDestino.setModel(new DefaultComboBoxModel(new String[] {"ISO-8859-1", "UTF-8", "US-ASCII"}));
		codificacionDestino.setBounds(325, 172, 127, 22);
		frame.getContentPane().add(codificacionDestino);
		
		JButton btnNewButton = new JButton("Copiar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				File f1= CodigoCopia.abrirFichero(rutaOrigen.getText());
				File f2= CodigoCopia.crearFichero(rutaDestino.getText(),nombreDestino.getText());
				CodigoCopia.copiarFichero(f1,f2,codificacionDestino.getSelectedItem().toString());
			}
		});
		btnNewButton.setBounds(291, 277, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Ruta");
		lblNewLabel_2.setBounds(111, 89, 46, 14);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Nombre fichero (opcional)");
		lblNewLabel_3.setBounds(111, 129, 162, 14);
		frame.getContentPane().add(lblNewLabel_3);
		
		nombreDestino = new JTextField();
		nombreDestino.setBounds(325, 126, 313, 20);
		frame.getContentPane().add(nombreDestino);
		nombreDestino.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Codificaci\u00F3n destino");
		lblNewLabel_4.setBounds(111, 176, 133, 14);
		frame.getContentPane().add(lblNewLabel_4);
		
		
	}
}
