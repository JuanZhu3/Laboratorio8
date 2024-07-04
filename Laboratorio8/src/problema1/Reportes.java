package problema1;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class Reportes extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextArea textAreaReporte;

    public Reportes(ArrayList<Estudiantes> estudiantes) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 700, 500);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Reportes de Estudiantes");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblNewLabel.setBounds(204, 10, 250, 35);
        contentPane.add(lblNewLabel);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(35, 70, 610, 300);
        contentPane.add(scrollPane);

        textAreaReporte = new JTextArea();
        textAreaReporte.setFont(new Font("Monospaced", Font.PLAIN, 16));
        scrollPane.setViewportView(textAreaReporte);

        JButton btnVolver = new JButton("Volver al Formulario");
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                volverAlFormulario();
            }
        });
        btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnVolver.setBounds(230, 400, 200, 35);
        contentPane.add(btnVolver);

        mostrarEstudiantes(estudiantes);
    }

    private void mostrarEstudiantes(ArrayList<Estudiantes> estudiantes) {
        StringBuilder sb = new StringBuilder();

        sb.append("Lista de Estudiantes:\n\n");
        for (Estudiantes estudiante : estudiantes) {
            sb.append("Nombre: ").append(estudiante.getNombre()).append("\n");
            sb.append("Cédula: ").append(estudiante.getCedula()).append("\n");
            sb.append("Carrera: ").append(estudiante.getCarrera()).append("\n");
            sb.append("Índice: ").append(estudiante.getIndiceAcademico()).append("\n");
            sb.append("Sexo: ").append(estudiante.getSexo()).append("\n");
            sb.append("Beca: ").append(estudiante.getIndiceAcademico() >= 2 ? "Sí" : "No").append("\n\n");
        }

        textAreaReporte.setText(sb.toString());
    }

    private void volverAlFormulario() {
        this.dispose();
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Formulario frame = new Formulario();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
