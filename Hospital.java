package General;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.*;
public class Hospital
{ 
    private Paciente tpacientes[];
    private int contadorpacientes;

    public Hospital(int numpacientes)
    {
        tpacientes = new Paciente[numpacientes];
        contadorpacientes = 0;
    }

    // Ingreso de un paciente al hospital
    public boolean ingreso(Paciente p){
    	tpacientes[contadorpacientes] = p;
    	contadorpacientes++;
        return true;
    }
    // Alta del paciente - se borra de la tabla
    public boolean alta ( int id_paciente){
    	for (int i = 0; i < contadorpacientes; i++) {
			if (tpacientes[i].getId() == id_paciente) {
				tpacientes[i] = null;
				for (int j = i; j < contadorpacientes ; j++) {
					tpacientes[j] = tpacientes [j + 1];
				}
				contadorpacientes--;
				break;
			}
		}
     
      
      return true;   
    }    
    
    // Devuelve el paciente con el identidador indicado o null si no existe
    public Paciente buscar(int id){
    	Paciente p = null;
    	for (int i = 0; i < contadorpacientes; i++) {
			if (tpacientes[i].getId() == id) {
				p = tpacientes[i];
			}
		}
    	return p;
    }
    
    // Imprime por consola la lista ORDENADO por NOMBRE de pacientes ***

    public void listapacientes (){
    	Arrays.sort(tpacientes,0,contadorpacientes);
    	for (int i = 0; i < contadorpacientes; i++) {
			System.out.println(tpacientes[i].toString());
		}
    }    
       
    // Devuelve el mas grave o el caso de paciente con la misma gravedad el
    // que su identificador sea mas bajo.
    public Paciente pacienteMasUrgente(){
    	PacienteGrave maxg = null;
        for (int i = 0; i < contadorpacientes; i++) {
        	Paciente aux = tpacientes[i]; 
			if( aux instanceof PacienteGrave == true ) {
				PacienteGrave auxg = (PacienteGrave) aux;
				
				if ( auxg.getGravedad().ordinal() > maxg.getGravedad().ordinal()) {
					maxg = auxg;
				}
				else if (auxg.getGravedad().ordinal() == maxg.getGravedad().ordinal()) {
					if (auxg.getId() > maxg.getId()) {
						maxg = auxg;
					}
				}
			}
		}
        if (maxg == null) {
        	Paciente aux1 = null;
        	for (int i = 0; i < contadorpacientes; i++) {
        		Paciente aux2 = tpacientes[i];
				if ( aux2.getId() < aux1.getId()) {
					aux1 = aux2;
				}
			}
        	maxg = (PacienteGrave) aux1;
        }
    return maxg;  
        
    }    
}
