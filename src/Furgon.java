
public class Furgon extends Vehiculo{

	private float cargaMax;
	private int plazas;
	
	public Furgon(String matricula, String modelo, String marca, float precio, float km, String motor,
			float cargaMax, int plazas) {
		super(matricula, modelo, marca, motor, precio, km);
		this.cargaMax = cargaMax;
		this.plazas = plazas;
	}

	public String mostrarVehiculos(int cargaMax, int plazas) {	
		String vehiculos=null;
		vehiculos = "Furgon: " + this.getMatricula()+ "  " + this.getModelo()+ this.getMarca();
		return vehiculos;
		 }
	
	public float getCargaMax() {
		return cargaMax;
	}

	public void setCargaMax(float cargaMax) {
		this.cargaMax = cargaMax;
	}

	public int getPlazas() {
		return plazas;
	}

	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}
	
	

}
