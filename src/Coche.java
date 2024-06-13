
public class Coche extends Vehiculo{
	
	private int plazas;
	private int puertas;
	private float volumenM;
	private String tipo;
	

	public Coche(String matricula, String modelo, String marca, String motor, float precio, float km,
			int plazas, int puertas, float volumenM, String tipo) {
		super(matricula, modelo, marca, motor, precio, km);
		this.plazas = plazas;
		this.puertas = puertas;
		this.volumenM = volumenM;
		this.tipo = tipo;
	}


	public String mostrarVehiculos(String motor, int plazas) {	
		 String vehiculos=null;
			 vehiculos = "Coche: " + this.getMatricula()+ "  " + this.getModelo()+ this.getMarca();
			 return vehiculos;
		 }
     

	public int getPlazas() {
		return plazas;
	}

	public void setPlazas(int plazas) {
		this.plazas = plazas;
	}

	public int getPuertas() {
		return puertas;
	}

	public void setPuertas(int puertas) {
		this.puertas = puertas;
	}

	public float getVolumenM() {
		return volumenM;
	}

	public void setVolumenM(float volumenM) {
		this.volumenM = volumenM;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


}
