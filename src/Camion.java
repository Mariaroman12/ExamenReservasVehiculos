
public class Camion extends Vehiculo{

	private float cargaMax;
	private float longi;
	
	public Camion(String matricula, String modelo, String marca, float precio, float km, String motor,
			float cargaMax, float longi) {
		super(matricula, modelo, marca, motor, precio, km);
		this.cargaMax = cargaMax;
		this.longi = longi;
	}
	
	public String mostrarVehiculos(int cargaMax, int longi) {	
		String vehiculos=null;
		vehiculos = "Camión: " + this.getMatricula()+ "  " + this.getModelo()+ this.getMarca();
		return vehiculos;
		 }
	
	public float getCargaMax() {
		return cargaMax;
	}

	public void setCargaMax(float cargaMax) {
		this.cargaMax = cargaMax;
	}

	public float getLongi() {
		return longi;
	}

	public void setLongi(float longi) {
		this.longi = longi;
	}
	

}
