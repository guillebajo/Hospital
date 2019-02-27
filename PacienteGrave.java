package General;

public class PacienteGrave extends Paciente {
	
	private TipoGravedad gravedad; 

    public PacienteGrave(String nombre, TipoGravedad gravedad)
    {
        super(nombre);
        this.gravedad = gravedad ;
    }

    public String toString()
    {
        return "El paciente es " + super.toString() + "y está " + gravedad ;
    }
    public TipoGravedad getGravedad() {
    	return this.gravedad;
    }
}
