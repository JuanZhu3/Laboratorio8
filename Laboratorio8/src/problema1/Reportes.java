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
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Reportes extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextArea textAreaReporte;
    private ArrayList<Estudiantes> estudiantes;

    public Reportes(ArrayList<Estudiantes> estudiantes) {
        this.estudiantes = estudiantes;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 650, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Reportes de Estudiantes");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblNewLabel.setBounds(204, 10, 250, 35);
        contentPane.add(lblNewLabel);

        JButton btnVolver = new JButton("Volver al Formulario");
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                volverAlFormulario();
            }
        });
        btnVolver.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnVolver.setBounds(214, 368, 220, 35);
        contentPane.add(btnVolver);

        textAreaReporte = new JTextArea();
        textAreaReporte.setFont(new Font("Monospaced", Font.PLAIN, 16));
        
        JScrollPane scrollPane = new JScrollPane(textAreaReporte);
        scrollPane.setBounds(35, 70, 565, 280);
        contentPane.add(scrollPane);

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
            sb.append("Becado: ").append(estudiante.getIndiceAcademico() >= 2.0 ? "Sí" : "No").append("\n\n");
        }

        textAreaReporte.setText(sb.toString());
    }

    private void volverAlFormulario() {
        this.dispose(); // Cierra la ventana actual (Reportes)
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Formulario frame = new Formulario();
                    frame.setVisible(true); // Abre una nueva instancia de Formulario
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
