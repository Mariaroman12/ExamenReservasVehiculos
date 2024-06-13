import java.util.ArrayList;

public class Vehiculo {

	protected String matricula;
	protected String modelo;
	protected String marca;
	protected String motor;
	protected float precio;
	protected float km;
	protected boolean alquilado=false;
	
public Vehiculo(String matricula, String modelo, String marca, String motor, float precio, float km) {
		super();
		this.matricula = matricula;
		this.modelo = modelo;
		this.marca = marca;
		this.motor = motor;
		this.precio = precio;
		this.km = km;
		this.alquilado = false;
		
	}
	
	public float cobro(Reserva r, float kmMas, int dias) {
		float resultado = 0.0f;
		km+=kmMas;
		resultado += r.getDiasAlquilados() * precio;
		if (km/r.getDiasAlquilados()> 500) {
			resultado *= 1.2;
		}
		if (r.getDiasAlquilados()<dias) {
			int diferencia = dias-r.getDiasAlquilados();
			resultado += (precio*1.5)*diferencia;
			r.setDiasAlquilados(dias);
		}
		this.alquilado = false;
		return resultado;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public float getKm() {
		return km;
	}

	public void setKm(float km) {
		this.km = km;
	}

	public boolean getAlquilado() {
		return alquilado;
	}

	public void setAlquilado(boolean alquilado) {
		this.alquilado = alquilado;
	}
	
	/* 
	 * public void darAltaVehiculo(Vehiculo vehiculo) {
	    if (vehiculo instanceof Coche) {
	        misCo.add((Coche) vehiculo);
	    } else if (vehiculo instanceof Furgon) {
	        misF.add((Furgon) vehiculo);
	    } else if (vehiculo instanceof Camion) {
	        misCa.add((Camion) vehiculo);
	    }
	}
	
	public boolean mostrarCoches(String motor, int plazas) {	
		 String vehiculos=null;
		 for(Coche miCoche:misCo) {
			if(miCoche.getMotor().equals(motor)&& miCoche.getPlazas() > plazas) {
			    miCoche.mostrarVehiculos(motor, plazas);
				return true;
				}
		 }return false;
	}
	
	public boolean mostrarFurgones(int cargaMax, int plazas) {	
		 String vehiculos=null;
		 for(Furgon miFurgon:misF) {
			if(miFurgon.getCargaMax()> cargaMax && miFurgon.getPlazas() > plazas) {
				miFurgon.mostrarVehiculos(cargaMax, plazas);
				return true;
				}
		 }return false;
	}
	
	public boolean mostrarCamiones(int cargaMax, int longi) {	
		 String vehiculos=null;
		 for(Camion miCamion:misCa) {
			if(miCamion.getCargaMax()> cargaMax && miCamion.getLongi() < longi) {
				miCamion.mostrarVehiculos(cargaMax, longi);
				return true;
				}
		 }return false;
	}*/
}


