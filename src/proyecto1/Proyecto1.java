/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import mundo.Alumno;

/**
 *
 * @author DAVID ANCIZAR CASTRO BENITEZ 
 */
public class Proyecto1 {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        //Se crea la libreria y el Scanner para recibir los datos escritos
        Scanner consola = new Scanner  (System.in);
        
        ArrayList<Alumno> listAlumnos= new ArrayList <Alumno>();
        Alumno miAlumno = new Alumno();
            LeerReporte (listAlumnos);  
        //Se crea una variable de nombre bandera para utilizar el while correctamente y cerrar el programa cuando el usuario lo requiera
        boolean estadoPrograma = true;
    
          do{
              //Se crea el menu con los requerimientos previamente solicitados
        System.out.println("----------------------------");
        System.out.println("Porfavor ingrese el numero de la opcion que deese realizar: ");
        System.out.println("1. Agregar los datos de un nuevo estudiante y generar un reporte txt.");
        System.out.println("2. Consultar los datos de algun estudiante"); 
        System.out.println("3. Modificar los datos de un estudiante previamente registrado."); 
        System.out.println("4. Eliminar los datos de un estudiante previamente registrado. "); 
        System.out.println("5.Generar reporte por semestre");
        System.out.println("6.Borrar los reportes registrados");
        System.out.println("7. Cerrar el programa "); 
             
        System.out.println("----------------------------"); 
        
        int opcion = consola.nextInt();
       // Se utiliza el ciclo switch para implementar una tabla de opciones
              switch (opcion) { 
                  case 1: 
                        System.out.println("En la opcion elegida, puede agregar datos de un estudiante, bienvenido! :D");
                      
                        agregarAlumno( listAlumnos, consola);
                        Escritura(listAlumnos);
                      break;
                  case 2:
                      System.out.println("En la opcion elegida, podra ver todos los datos de los estudiantes registrados previamente, bienvenido! :D");
                      if (listAlumnos.isEmpty()){
                    System.out.println("-------------------------------------------------------------------------------------------------------------");
                    System.out.println("No hay alumnos registrados");

                    } 
                      else {
                       consultarAlumno( listAlumnos);    
                      }
                      break;
                  case 3:
                      System.out.println("En la opcion elegida, puede modificar los datos del estudiante, buscandolo con el Numero de cedula, bienvenido! :D");
                      
                      modificarAlumno(listAlumnos, consola);
                      break;
                  case 4:
                      System.out.println("En la opcion elegida, puede borrar los datos del estudiante, buscandolo con el numero de cedula, bienvenido! :D");
                      
                      eliminarAlumno(listAlumnos,  consola );
                      EliminarReporte(listAlumnos);
                      break;
                  case 5:
                      System.out.println("En la opcion elegida, puede generar un reporte txt, bienvenido! :D");
                      
                      generarReportexSemestre(listAlumnos, consola);
                      break;
                  case 6: 
                      EliminarReporte(listAlumnos);
                      Escritura(listAlumnos);
                      break;
                  case 7:
                     
                       System.out.println("Es un honor que haya usado mi programa, muchas gracias y espero haya disfrutado! :D");
                      estadoPrograma = false;
                      break;
                  default:
                      System.out.println("Ninguna opcion es correcta)");
                      break;
              }
              
        }while(estadoPrograma);
    }
    
    //Metodo para escritura de reporte
        public static void Escritura (ArrayList<Alumno> listAlumnos ) throws FileNotFoundException{
            //Creamos el archivo con clase File y ponemos la direccion del archivo
            File archivo = new File ("./data/Reporte.txt");
            
            //Creamos la pluma 

            PrintWriter pluma = new PrintWriter (archivo);
            
            for (Alumno alumno : listAlumnos) {
                
            //mostramos los datos que se recibieron previamente
                
            pluma.println(alumno.getCedula()+"//" + alumno.getNombre() + "//" + alumno.getApellido()+ "//" + alumno.getSemestre() +"//"+ alumno.getCorreo() + "//" + alumno.getCelular());

            }
            pluma.close();
        }
    //Creo el metodo para agregar los datos de un nuevo alumno
        public static void agregarAlumno (  ArrayList<Alumno> listAlumnos, Scanner consola ){
            //Se pide cada uno de los datos necesarios
                System.out.println("*Ingrese la cedula o ID del estudiante, porfavor."); 
                            String cedula = consola.next();
                            System.out.println("*Ingrese el nombre del estudiante, porfavor.");
                            String nombre = consola.next();
                            System.out.println("*Ingrese el apellido del estudiante, porfavor."); 
                            String apellido = consola.next();
                            System.out.println("*Ingrese el semestre del estudiante, porfavor."); 
                            String semestre = consola.next();
                            System.out.println("*Ingrese el correo electronico del estudiante,, porfavor."); 
                            String correo = consola.next();
                            System.out.println("*Ingrese el Telefono de contacto del estudiante, porfavor.");
                            String celular = consola.next();
                         
                            //Se crea un objeto para guardar la informacion de los alumnos que se registraran
                            Alumno a = new Alumno();
                            a.setCedula(cedula);
                            a.setNombre(nombre);
                            a.setApellido(apellido);
                            a.setSemestre(semestre);
                            a.setCorreo(correo);
                            a.setCelular(celular);
                            
                            //Agregar la informacion de el objeto al array
                            listAlumnos.add(a);
                            
        }
        //Creo el segundo metodo para consultar los datos de los alumnos previamente registrados
        public static void consultarAlumno(ArrayList<Alumno> listAlumnos ){
           //Creamos un ciclo para que coloque TODOS los estudiantes registrados
           
            for (Alumno todosAlumnos : listAlumnos  ) {
                    System.out.println("---------------------------------------------"); 
                 System.out.println("LOS DATOS DE LOS ESTUDIANTES REGISTRADOS SON: " );
                 System.out.println("Cedula del estudiante:" + todosAlumnos.getCedula());
                 System.out.println("Nombre del estudiante:" + todosAlumnos.getNombre());
                 System.out.println("Apellido del estudiante:" + todosAlumnos.getApellido());
                 System.out.println("Semestre del estudiante:" + todosAlumnos.getSemestre());
                 System.out.println("Correo  del estudiante:" + todosAlumnos.getCorreo());
                 System.out.println("Celular del estudiante:" + todosAlumnos.getCelular());  

            }
         
                            
        }
        //Creo el tercer metodo para modificar los datos de el alumno que desee previamente registrado, se identifica cual con la cedula
        public static void modificarAlumno (ArrayList<Alumno> listAlumnos, Scanner consola ){
            System.out.println("Ingrese la cedula de el estudiante que quiere modificar los datos ");
            String newID = consola.next();
            //Uso el metodo bandera para que cuando termine de modificar los datos,acabe con la lista de cambios y vuelva al menu principal.
            boolean bandera = false;
            //Creo los "if" necesarios para establecer el nuevo dato o mantener el mismo
            for (Alumno alumno : listAlumnos){
                if(alumno.getCedula().equals(newID)) { 
                  System.out.println("El alumno correspondiente de la cedula al cual se le modificara los datos es:"+ alumno.getNombre() + "" + alumno.getApellido());
                     
                  System.out.println("Introduce el nombre nuevo, si no desea cambiarlo solo presione *Enter*");
                String newNombre= consola.nextLine().trim();
                if (!newNombre.isEmpty()){
                    alumno.setNombre(newNombre);
                }
                  System.out.println("Introduce el apellido nuevo, si no desea cambiarlo solo presione *Enter*");
                String newApellido= consola.nextLine().trim();
                if (!newApellido.isEmpty()){
                    alumno.setApellido(newApellido);
                 }
                  System.out.println("Introduce el Semestre  nuevo, si no desea cambiarlo solo presione *Enter*");
                String newSemestre= consola.nextLine().trim();
                if (!newSemestre.isEmpty()){
                    alumno.setSemestre(newSemestre);
                }
                  System.out.println("Introduce el Correo nuevo, si no desea cambiarlo solo presione *Enter*");
                String newCorreo= consola.nextLine().trim();
                if (!newCorreo.isEmpty()){
                    alumno.setCorreo(newCorreo);
                }
                  System.out.println("Introduce el Celular nuevo, si no desea cambiarlo solo presione *Enter*");
                String newCelular= consola.nextLine().trim();
                if (!newCelular.isEmpty()){
                    alumno.setCelular(newCelular);
                }
                bandera = true;
                break;
                }  
            }
            //hago un "if" para determinar si la bandera siendo la variable identificadora, esta bien escrita como en los registros previamente hechos
          if (!bandera){
              System.out.println("No hay un Alumno con la cedula previamente registrada");
          }
    
}
        //Creo el cuarto metodo para eliminar los datos de algun alumno previamente registrado
        public static void eliminarAlumno (ArrayList<Alumno> listAlumnos, Scanner consola){
        //Creamos el primer if para que si hay alumnos, realize el proceso adecuado, si no, tire un aviso de que no hay   
            if (!listAlumnos.isEmpty()){
        //Pedimos la cedula para identificar cual Alumno borrar
            System.out.println("Digite el numero de cedula de el Alumno que contenga los datos que desea eliminar");
            String cedulaBorrar = consola.next();
        //Variable para identificar si la cedula 
            boolean CedulaExiste = false;
            
            //Creamos un ciclo para que recorra por los datos previamente guardados
            for ( Alumno guardar:listAlumnos ){
            //Creamos el "if" para ver si existe la cedula registrada
            if ( cedulaBorrar.equals(guardar.getCedula())){
                listAlumnos.remove(guardar);
                System.out.println("Se elimino los datos del alumno con exito");
                //Variable en la cual se pone true para verificar que es la cedula 
                CedulaExiste = true;
                break;
            }
            }
            //Creamos condicional por si no se encontro la cedula o no existe
            if ( CedulaExiste == false ){
               System.out.println("El estudiante con la cedula correspondiente no esta registrado");  
            }
            }else {
                System.out.println("No hay estudiantes registrados");
            }
           

        }
        //Creo metodo para generar reporte por semestre 
        public static void generarReportexSemestre (ArrayList<Alumno> listAlumnos, Scanner consola )throws FileNotFoundException{
            //Creamos un archivo de clase file
            File archivo = new File ("./data/Reporte.txt");
            
            //Creamos la pluma para escribir el archivo 
            PrintWriter pluma = new PrintWriter(archivo);
           
            if (!listAlumnos.isEmpty()){
                System.out.println("Digite el semestre el cual desee generear el reporte ");
                
                String semestreR = consola.next();
                System.out.println("Se genero el archivo! ");
                //Escribimos con la pluma en el archivo 
            pluma.println("Reporte de alumnos por semestre ");
            pluma.println("=============================== ");
                for ( Alumno almacenarestu: listAlumnos ){
                   
                    if ( almacenarestu.getSemestre().equals(semestreR)){
                        //Enseñamos los datos recibidos
                        pluma.println("-----------------------------------------------------------------");
                        pluma.println("Cedula:" + almacenarestu.getCedula());
                        pluma.println ("Nombre:" + almacenarestu.getNombre());
                        pluma.println("Apellido:"+ almacenarestu.getApellido());
                        pluma.println("Semestre:" + almacenarestu.getSemestre());
                        pluma.println("Correo:" + almacenarestu.getCorreo());
                        pluma.println("Celular:"+ almacenarestu.getCelular());
                        
                    }
                                        }
                pluma.close();
            }else{
                System.out.println("No hay estudiantes");
            }
            
        }
        //Creo metodo para leer el archivo
        public static void LeerReporte(ArrayList<Alumno> listAlumnos) throws IOException{
            //Ubicaciones donde leer 
            File documento =new File ("./data/Reporte.txt");
            
            try (FileReader fail = new FileReader(documento)){
              //Se usa BuferredReader para guardar la variable en un archivo 
              BufferedReader cx = new BufferedReader(fail);
              
              String linea;
              
              while((linea = cx.readLine()) !=null) {
                String [] datos = linea.split("//");
                
                String cedula = datos[0].trim();
                String nombre = datos [1].trim();
                String apellido = datos [2].trim();
                String semestre = datos [3].trim();
                String correo = datos [4].trim();
                String celular = datos [5].trim();
                
                Alumno newAlumno = new Alumno(nombre, apellido, semestre, correo, celular, cedula);
                listAlumnos.add(newAlumno);
            }  
                System.out.println("Se leyo el archivo de forma exitosa! :D");
            }catch (FileNotFoundException e){
                System.out.println("No existe un archivo de lectura :(");
            }
            
        }
        public static void EliminarReporte(ArrayList<Alumno> listAlumnos){
            //Creo un if por si el archivo esta sin estudiantes ya, el programa aviso
            if (!listAlumnos.isEmpty()){
                //limpiamos el array
                listAlumnos.clear();
                System.out.println("El reporte de los alumnos agregados previamente, ha sido eliminado.");
            }
                else {
                        System.out.println("El reporte esta vacio, no hay nada que eliminar");
                        }
                
            }
                
        }
        
                
    


