package problema1;

import java.awt.Font;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class Reportes extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextArea textAreaReporte;

    public Reportes(ArrayList<Estudiantes> estudiantes) {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 650, 450);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(35, 70, 565, 300);
        contentPane.add(scrollPane);

        textAreaReporte = new JTextArea();
        textAreaReporte.setFont(new Font("Monospaced", Font.PLAIN, 16));
        scrollPane.setViewportView(textAreaReporte);

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
            sb.append("Sexo: ").append(estudiante.getSexo()).append("\n\n");
        }

        textAreaReporte.setText(sb.toString());
    }
}
