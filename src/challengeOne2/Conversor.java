package challengeOne2;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.math.RoundingMode;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextArea;



public class Conversor {

    private JFrame frame;
    private JButton btn;
    private JComboBox<Moneda> cmb;
    private JLabel lbl;
    private JTextField txt;

    public enum Moneda {
        pesosArg_a_dolar,
        pesosArg_a_euro,
        pesosArg_a_libraEsterlina,
        pesosArg_a_yenJaponés,
        pesosArg_a_wonSulCoreano,
        dolar_a_pesosArg,
        euro_a_pesosArg,
        libraEsterlina_a_pesosArg,
        yenJaponés_a_pesosArg,
        wonSulCoreano_a_pesosArg
    }

    public double dolar = 276.01;
    public double euro = 304.34;
    public double libraEsterlina = 351.85;
    public double yenJaponés = 1.95;
    public double wonSulCoreano = 0.21;

    public double valorInput = 0.00;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Conversor window = new Conversor();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Conversor() {
        initialize();
    }

    private void initialize() {
        frame = new JFrame();
        frame.getContentPane().setBackground(new Color(128, 128, 128));
        frame.setBounds(100, 100, 574, 437);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        cmb = new JComboBox<Moneda>();
		cmb.setModel(new DefaultComboBoxModel<>(Moneda.values()));
		cmb.setBounds(330, 144, 187, 22);
		frame.getContentPane().add(cmb);

        btn = new JButton("Convertir");
        btn.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btn.setBounds(216, 205, 106, 32);
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Convertir();
            }
        });
        frame.getContentPane().add(btn);

        lbl = new JLabel("00.00");
        lbl.setFont(new Font("Tahoma", Font.PLAIN, 26));
        lbl.setBounds(39, 281, 295, 36);
        frame.getContentPane().add(lbl);

        txt = new JTextField();
        txt.setBounds(39, 138, 205, 36);
        frame.getContentPane().add(txt);
        txt.setColumns(10);

        JTextArea txtrConvertidorDeMoneda = new JTextArea();
        txtrConvertidorDeMoneda.setForeground(new Color(255, 255, 255));
        txtrConvertidorDeMoneda.setBackground(new Color(128, 128, 128));
        txtrConvertidorDeMoneda.setFont(new Font("Segoe UI Historic", Font.ITALIC, 26));
        txtrConvertidorDeMoneda.setTabSize(1);
        txtrConvertidorDeMoneda.setText("Convertidor de Moneda");
        txtrConvertidorDeMoneda.setBounds(169, 26, 281, 36);
        txtrConvertidorDeMoneda.setEditable(false);
        frame.getContentPane().add(txtrConvertidorDeMoneda);

        JTextArea txtrByFedePaiva = new JTextArea();
        txtrByFedePaiva.setBackground(new Color(128, 128, 128));
        txtrByFedePaiva.setText("by: fede paiva");
        txtrByFedePaiva.setTabSize(1);
        txtrByFedePaiva.setFont(new Font("Segoe UI Historic", Font.ITALIC, 21));
        txtrByFedePaiva.setBounds(411, 354, 139, 36);
        txtrByFedePaiva.setEditable(false);
        frame.getContentPane().add(txtrByFedePaiva);
    }

    public JFrame getFrame() {
        return frame;
    }

    public void Convertir() {
        if (Validar(txt.getText())) {
            Moneda moneda = (Moneda) cmb.getSelectedItem();

            switch (moneda) {
                case pesosArg_a_dolar:
                    PesosAMoneda(dolar);
                    break;
                case pesosArg_a_euro:
                    PesosAMoneda(euro);
                    break;
                case pesosArg_a_libraEsterlina:
                    PesosAMoneda(libraEsterlina);
                    break;
                case pesosArg_a_yenJaponés:
                    PesosAMoneda(yenJaponés);
                    break;
                case pesosArg_a_wonSulCoreano:
                    PesosAMoneda(wonSulCoreano);
                    break;
                case dolar_a_pesosArg:
                    MonedaAPesos(dolar);
                    break;
                case euro_a_pesosArg:
                    MonedaAPesos(euro);
                    break;
                case libraEsterlina_a_pesosArg:
                    MonedaAPesos(libraEsterlina);
                    break;
                case yenJaponés_a_pesosArg:
                    MonedaAPesos(yenJaponés);
                    break;
                case wonSulCoreano_a_pesosArg:
                    MonedaAPesos(wonSulCoreano);
                    break;
                default:
                    throw new IllegalArgumentException("Unexpected value: " + moneda);
            }
        }
    }

    public void PesosAMoneda(double moneda) {
        double res = valorInput / moneda;
        lbl.setText(Redondear(res));
    }

    public void MonedaAPesos(double moneda) {
        double res = valorInput * moneda;
        lbl.setText(Redondear(res));
    }

    public String Redondear(double valor) {
        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);
        return df.format(valor);
    }

    public boolean Validar(String texto) {
        try {
            double x = Double.parseDouble(texto);
            if (x > 0) {
                valorInput = x;
                return true;
            }
        } catch (NumberFormatException e) {
            lbl.setText("Solamente Numeros");
            return false;
        }
        return false;
    }
}
