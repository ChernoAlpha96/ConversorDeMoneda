package challengeOne2;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;



public class MenuInicio {

    private JFrame frame;
    private JTextArea txtArea;
    private JButton btnConvMoneda;
    private JButton btnConsumoCombus;
    private JButton btnSalir;
    private JTextArea txtrElegirUnaOpcion;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MenuInicio window = new MenuInicio();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public MenuInicio() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(128, 128, 128));
        frame.setBounds(100, 100, 574, 437);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        txtArea = new JTextArea();
        txtArea.setForeground(new Color(255, 255, 255));
        txtArea.setBackground(new Color(128, 128, 128));
        txtArea.setFont(new Font("Impact", Font.BOLD, 29));
        txtArea.setTabSize(1);
        txtArea.setText("Bienvenidos!!");
        txtArea.setBounds(182, 22, 179, 36);
        txtArea.setEditable(false);
        frame.getContentPane().add(txtArea);

        btnConvMoneda = new JButton("Convertidor de Moneda");
        btnConvMoneda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Aquí se abre la ventana del Conversor
            	Conversor conversor = new Conversor();
            	((Conversor) conversor).getFrame().setVisible(true);
            	}}
        );
        btnConvMoneda.addMouseListener(new MouseAdapter() {
           
            public void mouseClicked(MouseEvent e) {
                // Aquí se abre la ventana del Conversor
                Conversor conversor = new Conversor();
                conversor.getFrame().setVisible(true);
            }
        });
        btnConvMoneda.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnConvMoneda.setBounds(141, 127, 263, 47);
        frame.getContentPane().add(btnConvMoneda);
		
		btnConsumoCombus = new JButton("Consumo de Combustible");
		btnConsumoCombus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConsumoCombus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnConsumoCombus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnConsumoCombus.setBounds(141, 220, 263, 47);
		frame.getContentPane().add(btnConsumoCombus);
		
		btnSalir = new JButton("Salir");
		btnSalir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		btnSalir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSalir.setBounds(182, 312, 179, 47);
		frame.getContentPane().add(btnSalir);
		
		txtrElegirUnaOpcion = new JTextArea();
		txtrElegirUnaOpcion.setForeground(new Color(255, 255, 255));
		txtrElegirUnaOpcion.setBackground(new Color(128, 128, 128));
		txtrElegirUnaOpcion.setFont(new Font("Segoe UI Historic", Font.ITALIC, 18));
		txtrElegirUnaOpcion.setTabSize(1);
		txtrElegirUnaOpcion.setText("Elegir una Opcion:");
		txtrElegirUnaOpcion.setBounds(197, 81, 155, 36);
		txtrElegirUnaOpcion.setEditable(false);
		frame.getContentPane().add(txtrElegirUnaOpcion);
		
		 JTextArea txtrByFedePaiva = new JTextArea();
	        txtrByFedePaiva.setBackground(new Color(128, 128, 128));
	        txtrByFedePaiva.setText("by: fede paiva");
	        txtrByFedePaiva.setTabSize(1);
	        txtrByFedePaiva.setFont(new Font("Segoe UI Historic", Font.ITALIC, 21));
	        txtrByFedePaiva.setBounds(411, 354, 139, 36);
	        txtrByFedePaiva.setEditable(false);
	        frame.getContentPane().add(txtrByFedePaiva);
	}
}
