package ejerexamen;
import java.util.*;

public class colaClinicaVeterinaria {
  public static Scanner teclado=new Scanner(System.in);
	
	static int menu(){
     int opcion = 0;
    do{
    	System.out.println("                                           ");
    	System.out.println("                                           ");
    	System.out.println("--------------------------------------------------");
        System.out.println("|       Elija la operación que desee             |" );
        System.out.println("|                                                |" );
        System.out.println("|      1.- Insertar nuevo paciente ORDINARIO     |" );
        System.out.println("|      2.- Insertar nuevo paciente URGENTE       |" );
        System.out.println("|      3.- Mostrar cola de espera                |" );
        System.out.println("|      4.- Pasar un paciente a consulta          |" );
        System.out.println("|      5.- Borrar un Animal por su índice        |" );
        System.out.println("|      6.- Borrar todos                          |" );
        System.out.println("|      7.- Salir                                 |" );
        System.out.println("--------------------------------------------------");
        System.out.println("                                                  ");
        System.out.println("                                                  ");
        try{
			opcion=teclado.nextInt();
		}catch(InputMismatchException e){
			System.out.println("Opción Inconrrecta");
		} finally {
			teclado.nextLine();
		}
    }while( opcion<1 || opcion>7 );
    return opcion;
	}
    
    

	public static void main (String []args){
	
     int opcion;
    LinkedList<Animal> cola = new LinkedList<Animal>();
    opcion = menu();
    do{
    	opcion = menu(); 
        switch(opcion){
            case 1:
            	System.out.println("Introduce el nombre: ");
                String nombreNor = teclado.nextLine();
                System.out.println("Introduce el tipo: ");
                String tipoNor = teclado.nextLine();
                Animal normal = new Animal(nombreNor, tipoNor);
                cola.addLast(normal);
                System.out.println(nombreNor + " ha sido introducido como paciente normal.");
                break;
            case 2:
            	System.out.println("Introduce el nombre:  ");
                String nombrePri = teclado.nextLine();
                System.out.println("Introduce el tipo:  ");
                String tipoPri = teclado.nextLine();
                Animal urgente = new Animal(nombrePri, tipoPri);
                cola.addFirst(urgente);
                System.out.println(nombrePri + " ha sido introducido como paciente urgente.");
                break;
            case 3:
                for(int i=0;i<cola.size();i++){  
                	System.out.println(cola.get(i));
                        
                  break;
                  }
            case 4:
                  System.out.println( "siguiente paciente :  " +cola.getFirst());
                  cola.removeFirst();
                  break;
            case 5:
            	try{
					System.out.println("Indica el índice del Animal a borrar");
					int animal=teclado.nextInt();
				    cola.remove(animal);
				} catch(IndexOutOfBoundsException | InputMismatchException e){
					System.out.println("Se ha producido un error al borrar el Contacto.");
					System.out.println("No existe animal con ese indice "+ e.getMessage());
				} finally{
					teclado.nextLine();
				}
                   break;

            case 6:
                  System.out.println( "Se borraran todos los elementos de la lista" );
                  cola.clear();
                  break;
            case 7:
                  System.out.println( "Programa terminado" );
                  break;
            }
    }while( opcion != 7 );
        }

    
}

