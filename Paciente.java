package General;

public class Paciente implements Comparable<Paciente> {

	private static int numpaciente =0;
    private int id;
    private String nombre;

    public Paciente(String nombre)
    {
        this.nombre = nombre;
        numpaciente++;
        this.id = numpaciente;
    }
    
    public String toString(){
        return id +":"+nombre;
    }   
    
    public int getId() {
    	return this.id;
    }
    public String getNombre() {
    	return this.nombre;
    }
    
    

	@Override
	public int compareTo(Paciente p) {
		return this.nombre.compareTo(p.nombre);
	}

}
