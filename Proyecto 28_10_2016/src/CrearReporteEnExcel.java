import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class CrearReporteEnExcel {

    public CrearReporteEnExcel(ArrayList <Alumno> arrayAlumnos) throws IOException{
        HSSFWorkbook libro = new HSSFWorkbook();
        HSSFSheet hoja = libro.createSheet();	
        libro.setSheetName(0, "Alumnos");

        String[] cabeceras = new String[]{"RUT","NOMBRE","CORREO","DIRECCION","SEXO","EDAD","TELEFONO"};
        
        CellStyle estiloCabecera = libro.createCellStyle();
        Font tipoLetra = libro.createFont();
        tipoLetra.setBoldweight(Font.BOLDWEIGHT_BOLD);
        estiloCabecera.setFont(tipoLetra);

        CellStyle estilo = libro.createCellStyle();
        estilo.setFillForegroundColor(IndexedColors.LIGHT_YELLOW.getIndex());
        estilo.setFillPattern(CellStyle.SOLID_FOREGROUND);

        //Se agregan en la cabecera los datos contenidos en el arreglo de string cabeceras y ademas se le da un estilo a la letra
        HSSFRow cabeceraFila = hoja.createRow((short)0);
        for (int i = 0; i < cabeceras.length; ++i) {
            String cabecera = cabeceras[i];
            HSSFCell cell = cabeceraFila.createCell(i);
            cell.setCellStyle(estiloCabecera);
            cell.setCellValue(cabecera);
        }

        //Se llenan las columnas con los datos de los alumnos
        for (int i = 0; i < arrayAlumnos.size(); ++i) {
            HSSFRow datosFila = hoja.createRow(i + 1);
            String nombre = arrayAlumnos.get(i).getNombrePersona();
            String rut = arrayAlumnos.get(i).getRut();
            String correo = arrayAlumnos.get(i).getCorreo();
            String sexo = arrayAlumnos.get(i).getSexo();
            String direccion = arrayAlumnos.get(i).getDireccion();
            int edad = arrayAlumnos.get(i).getEdad();
            int telefono = arrayAlumnos.get(i).getTelefono();
            
            //Se agrega el dato especifico del alumno en cada celda
            datosFila.createCell(0).setCellValue(rut);
            datosFila.createCell(1).setCellValue(nombre);
            datosFila.createCell(2).setCellValue(correo);
            datosFila.createCell(3).setCellValue(direccion);
            datosFila.createCell(4).setCellValue(sexo);
            datosFila.createCell(5).setCellValue(edad);
            datosFila.createCell(6).setCellValue(telefono);
            
            //Ajusta el tamaño de la celda
            hoja.autoSizeColumn(i);
        }
        
        //Se llama al metodo para guardar archivo
        guardarArchivoXLS(libro);
            
    }//Fin Constructor
    
    
    /**
     *	Metodo que guarda el archivo .xls el cualquier parte que el usuario indique.
     *	@param libro	Es el archivo .xls que contiene los datos de todos los alumnos.
     * */
    public void guardarArchivoXLS(HSSFWorkbook libro)
    {
        JFileChooser fileChooserAlumnos = new JFileChooser();
       
        //filtro para ver solo archivos .xls
        fileChooserAlumnos.addChoosableFileFilter(new FileNameExtensionFilter("todos los archivos *.XLS", "xls","XLS"));
        int seleccion = fileChooserAlumnos.showSaveDialog(null);
        
        try{
        	//comprueba si ha presionado el boton de aceptar
            if (seleccion == JFileChooser.APPROVE_OPTION){
                File archivoJFileChooser = fileChooserAlumnos.getSelectedFile();
                FileOutputStream archivo = new FileOutputStream(archivoJFileChooser+".xls");
                libro.write(archivo);          
                JOptionPane.showMessageDialog(null,"Se guardó correctamente el archivo", "Guardado exitoso!", JOptionPane.INFORMATION_MESSAGE);
            }
        }catch (Exception e){
            JOptionPane.showMessageDialog(null,"Error al guardar el archivo!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
}//Fin Clase