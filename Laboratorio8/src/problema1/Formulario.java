package problema1;

//Integrantes: Juan Zhu, Jeremy Martinez; Rafael Gomez, Alex De Boutaud

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class Formulario extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textNombre;
    private JTextField textIndice;
    private JTextField textCedula;
    private JComboBox<String> comboBoxCarreras;
    private JComboBox<String> comboBoxSexo;
    private static ArrayList<Estudiantes> estudiantes = new ArrayList<>();
    private static Becas becas = new Becas();

    public static void main(String[] args) {
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

    public Formulario() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 932, 552);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Información de estudiantes");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 22));
        lblNewLabel.setBounds(277, 10, 271, 62);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("Nombre:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1.setBounds(21, 97, 95, 22);
        contentPane.add(lblNewLabel_1);

        textNombre = new JTextField();
        textNombre.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textNombre.setBounds(141, 102, 153, 19);
        contentPane.add(textNombre);
        textNombre.setColumns(10);

        JLabel lblNewLabel_1_1 = new JLabel("Índice:");
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_1.setBounds(21, 239, 95, 22);
        contentPane.add(lblNewLabel_1_1);

        textIndice = new JTextField();
        textIndice.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textIndice.setColumns(10);
        textIndice.setBounds(141, 240, 153, 19);
        contentPane.add(textIndice);

        JLabel lblNewLabel_1_1_1 = new JLabel("Cédula:");
        lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_1_1.setBounds(21, 166, 95, 22);
        contentPane.add(lblNewLabel_1_1_1);

        textCedula = new JTextField();
        textCedula.setFont(new Font("Tahoma", Font.PLAIN, 20));
        textCedula.setColumns(10);
        textCedula.setBounds(141, 167, 153, 19);
        contentPane.add(textCedula);

        JLabel lblNewLabel_1_1_2 = new JLabel("Carrera:");
        lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_1_2.setBounds(21, 308, 95, 22);
        contentPane.add(lblNewLabel_1_1_2);

        comboBoxCarreras = new JComboBox<>();
        comboBoxCarreras.setModel(new DefaultComboBoxModel<>(new String[] { "Ingeniería Civil", "Ingeniería Eléctrica",
                "Ingeniería Industrial", "Ingeniería en Sistemas", "Ingeniería Mecánica", "Ingeniería Marítima" }));
        comboBoxCarreras.setBounds(141, 312, 153, 21);
        comboBoxCarreras.setSelectedIndex(-1);
        contentPane.add(comboBoxCarreras);

        JLabel lblNewLabel_1_1_3 = new JLabel("Sexo:");
        lblNewLabel_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblNewLabel_1_1_3.setBounds(21, 374, 95, 22);
        contentPane.add(lblNewLabel_1_1_3);

        comboBoxSexo = new JComboBox<>();
        comboBoxSexo.setModel(new DefaultComboBoxModel<>(new String[] { "Masculino", "Femenino" }));
        comboBoxSexo.setBounds(141, 377, 153, 21);
        comboBoxSexo.setSelectedIndex(-1);
        contentPane.add(comboBoxSexo);

        JButton btnGuardar = new JButton("Guardar Datos");
        btnGuardar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnGuardar.setBounds(341, 457, 184, 34);
        contentPane.add(btnGuardar);

        JButton btnBuscarCedula = new JButton("Buscar por Cédula");
        btnBuscarCedula.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnBuscarCedula.setBounds(341, 160, 184, 34);
        contentPane.add(btnBuscarCedula);

        JButton btnBuscarCarreraSexo = new JButton("Buscar por Carrera y Sexo");
        btnBuscarCarreraSexo.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnBuscarCarreraSexo.setBounds(310, 343, 260, 34);
        contentPane.add(btnBuscarCarreraSexo);

        JButton btnReportes = new JButton("Mostrar Reportes");
        btnReportes.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnReportes.setBounds(707, 457, 184, 34);
        contentPane.add(btnReportes);

        btnGuardar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                guardarDatos();
            }
        });

        btnBuscarCedula.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarPorCedula();
            }
        });

        btnBuscarCarreraSexo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                buscarPorCarreraYSexo();
            }
        });

        btnReportes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                mostrarReportes();
            }
        });
    }

    private void guardarDatos() {
        try {
            String nombre = textNombre.getText();
            String cedula = textCedula.getText();
            String indiceStr = textIndice.getText();
            String carrera = (String) comboBoxCarreras.getSelectedItem();
            String sexo = (String) comboBoxSexo.getSelectedItem();

            if (nombre.isEmpty() || cedula.isEmpty() || indiceStr.isEmpty() || carrera == null || sexo == null) {
                throw new IllegalArgumentException("Debe completar todos los campos.");
            }

            double indice = Double.parseDouble(indiceStr);
            if (indice < 0 || indice > 3) {
                throw new NumberFormatException("El índice debe estar entre 0 y 3.");
            }

            Estudiantes estudiante = new Estudiantes(nombre, cedula, carrera, indice, sexo);
            estudiantes.add(estudiante);
            becas.agregarEstudiante(estudiante);

            JOptionPane.showMessageDialog(this, "Información guardada correctamente", "Éxito",
                    JOptionPane.INFORMATION_MESSAGE);

            limpiarCampos();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese un índice válido (entre 0 y 3).", "Error",
                    JOptionPane.ERROR_MESSAGE);
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limpiarCampos() {
        textNombre.setText("");
        textCedula.setText("");
        textIndice.setText("");
        comboBoxCarreras.setSelectedIndex(-1);
        comboBoxSexo.setSelectedIndex(-1);
    }

    private void buscarPorCedula() {
        String cedula = textCedula.getText().trim();

        if (cedula.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Por favor, ingrese una cédula.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        Estudiantes encontrado = becas.buscarPorCedula(cedula);

        if (encontrado != null) {
            mostrarMensajeEstudiante(encontrado);
        } else {
            JOptionPane.showMessageDialog(this, "No se encontró ningún estudiante con la cédula ingresada.", "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    private void buscarPorCarreraYSexo() {
        String carrera = (String) comboBoxCarreras.getSelectedItem();
        String sexo = (String) comboBoxSexo.getSelectedItem();

        if (carrera == null || sexo == null) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione carrera y sexo.", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        ArrayList<Estudiantes> encontrados = becas.buscarPorCarreraYSexo(carrera, sexo);

        if (!encontrados.isEmpty()) {
            mostrarReporteBusqueda(encontrados);
        } else {
            JOptionPane.showMessageDialog(this, "No se encontraron estudiantes con la carrera y sexo seleccionados.",
                    "Información", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void mostrarMensajeEstudiante(Estudiantes estudiante) {
        JOptionPane.showMessageDialog(this,
                "Nombre: " + estudiante.getNombre() + "\n" +
                "Cédula: " + estudiante.getCedula() + "\n" +
                "Carrera: " + estudiante.getCarrera() + "\n" +
                "Índice: " + estudiante.getIndiceAcademico() + "\n" +
                "Sexo: " + estudiante.getSexo(),
                "Información de Estudiante",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarReporteBusqueda(ArrayList<Estudiantes> encontrados) {
        StringBuilder sb = new StringBuilder();

        sb.append("Estudiantes encontrados:\n\n");
        for (Estudiantes estudiante : encontrados) {
            sb.append("Nombre: ").append(estudiante.getNombre()).append("\n");
            sb.append("Cédula: ").append(estudiante.getCedula()).append("\n");
            sb.append("Carrera: ").append(estudiante.getCarrera()).append("\n");
            sb.append("Índice: ").append(estudiante.getIndiceAcademico()).append("\n");
            sb.append("Sexo: ").append(estudiante.getSexo()).append("\n");
            sb.append("Beca: ").append(estudiante.getIndiceAcademico() >= 2 ? "Sí" : "No").append("\n\n");
        }

        JOptionPane.showMessageDialog(this, sb.toString(), "Estudiantes Encontrados",
                JOptionPane.INFORMATION_MESSAGE);
    }

    private void mostrarReportes() {
        Reportes reporteFrame = new Reportes(estudiantes);
        reporteFrame.setVisible(true);
    }
}
