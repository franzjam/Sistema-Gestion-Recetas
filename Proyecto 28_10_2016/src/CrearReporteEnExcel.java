import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class CrearArchivoXLS {

    public CrearArchivoXLS(ArrayList <Alumno> arrayAlumnos) throws IOException{
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

        //Se agregan en la cabecera los datos contenidos en "cabeceras" y ademas se le da un estilo a la letra
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
        
        //Se crea el archivo con una ruta especifica y luego se escriben los datos en el .xls
        FileOutputStream archivo = new FileOutputStream("Universidad Catolica De Gastronomia\\Alumnos.xls");
        libro.write(archivo);
        archivo.flush();
        archivo.close();
    }
}