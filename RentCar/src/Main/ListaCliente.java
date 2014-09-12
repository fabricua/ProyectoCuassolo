/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Main;

import static Main.Ventana2.jTable2;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author fabri
 */
public class ListaCliente {
    
    public final static int CANTIDAD = 10;
    
    private static Cliente[] lista = new Cliente[CANTIDAD];
    
    private static String archivo = "array.db";
    private static FileInputStream fis = null;
    private static ObjectInputStream ois = null;
    private static FileOutputStream fos = null;
    private static ObjectOutputStream oos = null;
    
    public static boolean addCliente(Cliente clien) {
        for (int i = 0; i < lista.length; i++) {
            if (lista[i]==null){
                lista[i]= clien;
                return true;
            }
        }
        Cliente[] listaAux = new Cliente[lista.length+1];
        for (int i = 0; i < lista.length; i++) {
                listaAux[i] = lista[i];
        }
        listaAux[listaAux.length-1]=clien;
        lista=listaAux;
        return true;        
     }
    
    public static Cliente[] getBusquedaNombre(String cliente) {
            Cliente[] auxName = new Cliente[100];
        int cont = 0;
        for (int i = 0; i < lista.length; i++) {
            if (lista[i] != null) {
                
                if (lista[i].getCliente().compareToIgnoreCase(cliente) == 0){
                    auxName[cont] = lista[i];
                    System.out.println("igual ="+ lista[i].getCliente());
                    cont++;
                } 
            }
        }
        return auxName;
    
    } 
    
    public static void RefreshTableNombre (String cliente) {
                //Levantamos los datos a cargar
        Cliente[] listado = getBusquedaNombre(cliente);
        //Creamos el modelo de datos de la tabla.
        DefaultTableModel model = new DefaultTableModel() {
            /*Edito un método de la clase "DefaultTableModel" y cada vez que 
             se renderiza un celda, cuando se pregunta si es editable le digo que no.
             Lo explico mejor en clase;
             */

            @Override
            public boolean isCellEditable(int row, int column) {
                return true;
            }
        };

        model.addColumn("");
        model.addColumn("Nombre");
        model.addColumn("Apellido");
        model.addColumn("Dni");
        model.addColumn("Permiso de Conducir");
        model.addColumn("Caduc de Permiso");
        model.addColumn("Cant de Pasajeros");
        model.addColumn("Cant de Dias");
        model.addColumn("Telefono");
        model.addColumn("Movil");

        for (int i = 0; i < listado.length; i++) {
            if (listado[i] != null) {
                String[] fila = new String[10];
                fila[0] = "" + (i + 1);
                fila[1] = listado[i].getCliente();
                fila[2] = listado[i].getApellido();
                fila[3] = "" + listado[i].getDNI();
                fila[4] = "" + listado[i].getPermiso();
                fila[5] = "" + listado[i].getCaducpermiso();
                fila[6] = "" + listado[i].getCantidadpasa();
                fila[7] = "" + listado[i].getCantidaddias();
                fila[8] = "" + listado[i].getTelefono();
                fila[9] = "" + listado[i].getMovil();

                model.addRow(fila);
            }
        }
        jTable2.setModel(model);

    }
        

    public static void setLista(Cliente[] lista) {
        ListaCliente.lista = lista;
    }
    
    public static Cliente[] getLista() {
        return lista;
    }
    
    public static boolean saveLista() {
        
        boolean saved = false;
        
        try {
            fos = new FileOutputStream(archivo);
            oos = new ObjectOutputStream(fos);
            //Esta es otra forma de hacer un for, la sintaxis es la siguiente:
            //for (Clase aux:array), recorre el array y se lo asigna al auxiliar.
            oos.writeObject(lista);
            
        } catch (FileNotFoundException ex) {
            System.out.println("No se encuentra el archivo");
            return false;
        } catch (IOException ex) {
            System.out.println("Error al guardar el archivo");
            return false;
        } finally {
            try {
                if (oos != null) {
                    oos.close();
                    oos = null;
                }
                if (fos != null) {
                    fos.close();
                    fos = null;
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar archivo");
            }
        }   
        
         System.out.println("Guardado Correctamente");
        return true;
        
    }

    public static boolean levantarObjetoEntero() {
        Cliente[] aux=null;

        try {
            fis = new FileInputStream(archivo);
            ois = new ObjectInputStream(fis);

            aux = (Cliente[]) ois.readObject();
            System.out.println(aux.length);

        }  catch (Exception e1) {
            System.out.println("Error!!!" + e1);
            return false;
        } finally {
            try {
                if (ois != null) {
                    ois.close();
                    ois = null;
                }
                if (fis != null) {
                    fis.close();
                    fis = null;
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar archivo");
            }
        }
        lista = aux;
        return true;
    }

    static void del(int indice) {
        lista[indice-1] = null;
    }

}
