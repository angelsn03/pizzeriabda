package UI;

import interfaces.IProductoDAO;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class ProductosUI extends JFrame {
    private JTextField idField, nombreField, precioField, descripcionField;
    private JButton guardarBoton, cancelarBoton, editarBoton, eliminarBoton;
    private JTable tablaProductos;
    private DefaultTableModel modelo;

    public ProductosUI() {
        // Configuración de la ventana principal
        this.setSize(1000, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        // Panel de formulario (a la izquierda)
        JPanel panelFormulario = new JPanel();
        panelFormulario.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel idLabel = new JLabel("Id Producto: ");
        idField = new JTextField(15);
        JLabel nombreLabel = new JLabel("Nombre: ");
        nombreField = new JTextField(15);
        JLabel precioLabel = new JLabel("Precio: ");
        precioField = new JTextField(15);
        JLabel descripcionLabel = new JLabel("Descripción: ");
        descripcionField = new JTextField(15);

        panelFormulario.add(idLabel);
        panelFormulario.add(idField);
        panelFormulario.add(nombreLabel);
        panelFormulario.add(nombreField);
        panelFormulario.add(precioLabel);
        panelFormulario.add(precioField);
        panelFormulario.add(descripcionLabel);
        panelFormulario.add(descripcionField);

        this.add(panelFormulario, BorderLayout.WEST);

        // Panel de botones (abajo)
        JPanel panelBotones = new JPanel();
        panelBotones.setLayout(new GridLayout(1, 4, 10, 10));

        cancelarBoton = new JButton("Cancelar");
        guardarBoton = new JButton("Guardar");
        editarBoton = new JButton("Editar");
        eliminarBoton = new JButton("Eliminar");

        panelBotones.add(cancelarBoton);
        panelBotones.add(guardarBoton);
        panelBotones.add(editarBoton);
        panelBotones.add(eliminarBoton);

        this.add(panelBotones, BorderLayout.SOUTH);

        // Tabla de productos (centro)
        JPanel panelTabla = new JPanel();
        modelo = new DefaultTableModel();
        modelo.addColumn("Id Producto");
        modelo.addColumn("Nombre");
        modelo.addColumn("Precio");
        modelo.addColumn("Descripción");

        tablaProductos = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tablaProductos);
        panelTabla.add(scrollPane);
        this.add(panelTabla, BorderLayout.CENTER);

    }


}
