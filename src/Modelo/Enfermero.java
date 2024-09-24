package Modelo;

import Vista.frmEnfermero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;


public class Enfermero {

   
    private String uuid_Enfermero;
    private String nombre;
    private int edad;
    private int peso;
    private String correo;
    
     public String getUuid_Enfermero() {
        return uuid_Enfermero;
    }

    public void setUuid_Enfermero(String uuid_Enfermero) {
        this.uuid_Enfermero = uuid_Enfermero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    
     public void Guardar() {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();
        try {
            //Creamos el PreparedStatement que ejecutará la Query
            PreparedStatement addEnfermero = conexion.prepareStatement("INSERT INTO Enfermero(UUID_Enfermero, Nombre_Enfermero, Edad_Enfermero, Peso_Enfermero, Correo_Enfermero ) VALUES (?, ?, ?, ?, ?)");
            //Establecer valores de la consulta SQL
            addEnfermero.setString(1, UUID.randomUUID().toString());
            addEnfermero.setString(2, getNombre());
            addEnfermero.setInt(3, getEdad());
            addEnfermero.setInt(4, getPeso());
            addEnfermero.setString(5, getCorreo());
 
            //Ejecutar la consulta
            addEnfermero.executeUpdate();
 
        } catch (SQLException ex) {
            System.out.println("este es el error en el modelo:metodo guardar " + ex);
        }
    }
     
     
     public void Mostrar(JTable tabla) {
        //Creamos una variable de la clase de conexion
        Connection conexion = ClaseConexion.getConexion();
        //Definimos el modelo de la tabla
        DefaultTableModel modeloDeDatos = new DefaultTableModel();
        
        modeloDeDatos.setColumnIdentifiers(new Object[]{"UUID_Enfermero", "Nombre_Enfermero", "Edad_Enfermero", "Peso_Enfermero", "Correo_Enfermero",});
        try {
            //Creamos un Statement
            Statement statement = conexion.createStatement();
            //Ejecutamos el Statement con la consulta y lo asignamos a una variable de tipo ResultSet
            ResultSet rs = statement.executeQuery("SELECT * FROM Enfermero");
            //Recorremos el ResultSet
            while (rs.next()) {
                //Llenamos el modelo por cada vez que recorremos el resultSet
                modeloDeDatos.addRow(new Object[]{rs.getString("uuid_Enfermero"), 
                    rs.getString("Nombre_Enfermero"), 
                    rs.getInt("Edad_Enfermero"), 
                    rs.getInt("Peso_Enfermero"), 
                    rs.getString("Correo_Enfermero")});
            }
            //Asignamos el nuevo modelo lleno a la tabla
            tabla.setModel(modeloDeDatos);
        } catch (Exception e) {
            System.out.println("Este es el error en el modelo, metodo mostrar " + e);
        }
    }
     
     
     public void Eliminar(JTable tabla) {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();

        //obtenemos que fila seleccionó el usuario
        int filaSeleccionada = tabla.getSelectedRow();
        //Obtenemos el id de la fila seleccionada
        String miId = tabla.getValueAt(filaSeleccionada, 0).toString();
        
        //borramos 
        try {
            PreparedStatement deleteEnfermero = conexion.prepareStatement("delete from Enfermero where UUID_Enfermero = ?");
            deleteEnfermero.setString(1, miId);
            deleteEnfermero.executeUpdate();
        } catch (Exception e) {
            System.out.println("este es el error metodo de eliminar" + e);
        }
        
     } 
     
     
     public void cargarDatosTabla(frmEnfermero vista) {
        // Obtén la fila seleccionada 
        int filaSeleccionada = vista.jtbEnfermero.getSelectedRow();

        // Debemos asegurarnos que haya una fila seleccionada antes de acceder a sus valores
        if (filaSeleccionada != -1) {
            String UUIDDeTb = vista.jtbEnfermero.getValueAt(filaSeleccionada, 0).toString();
            String NombreDeTB = vista.jtbEnfermero.getValueAt(filaSeleccionada, 1).toString();
            String EdadDeTb = vista.jtbEnfermero.getValueAt(filaSeleccionada, 2).toString();
            String PesoDeTB = vista.jtbEnfermero.getValueAt(filaSeleccionada, 3).toString();
            String CorreoDeTB = vista.jtbEnfermero.getValueAt(filaSeleccionada, 4).toString();


            // Establece los valores en los campos de texto
            vista.txt_Nombre.setText(NombreDeTB);
            vista.txt_Edad.setText(EdadDeTb);
            vista.txt_Peso.setText(PesoDeTB);
            vista.txt_Correo.setText(CorreoDeTB);
        }
     }
     
     
     public void Actualizar(JTable tabla) {
        //Creamos una variable igual a ejecutar el método de la clase de conexión
        Connection conexion = ClaseConexion.getConexion();

        //obtenemos que fila seleccionó el usuario
        int filaSeleccionada = tabla.getSelectedRow();
        if (filaSeleccionada != -1) {
            //Obtenemos el id de la fila seleccionada
            String miUUId = tabla.getValueAt(filaSeleccionada, 0).toString();
            try { 
                //Ejecutamos la Query
                PreparedStatement updateUser = conexion.prepareStatement("update Enfermero set Nombre_Enfermero= ?, Edad_Enfermero = ?, Peso_Enfermero = ?, Correo_Enfermero = ? where UUID_paciente = ?");

                updateUser.setString(1, getNombre());
                updateUser.setInt(2, getEdad());
                updateUser.setInt(3, getPeso());
                updateUser.setString(4, getCorreo());
                updateUser.setString(5, miUUId);
                updateUser.executeUpdate();
            } catch (Exception e) {
                System.out.println("este es el error en el metodo de actualizar" + e);
            }
        } else {
            System.out.println("no");
        }
          
     }
     
      public void limpiar(frmEnfermero vista) {
        vista.txt_Nombre.setText("");
        vista.txt_Edad.setText("");
        vista.txt_Peso.setText("");
        vista.txt_Correo.setText("");
    }
}
