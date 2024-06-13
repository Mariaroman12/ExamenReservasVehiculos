import java.util.ArrayList;
import java.util.*;


public class Empresa {
	private ArrayList <Vehiculo>misV;
	private Map<String, Cliente> misC;
	private List<Reserva> misReservas;
	
	public Empresa() {
		misV = new ArrayList<>();
		misC = new HashMap<>();
		misReservas = new ArrayList<>();
	}
/*
	public boolean addCliente (String nombre, String apellidos, String email, String telefono, String dni, String tarjetaCredito) { 
		for (int i = 0; i < misC.size(); i++) {
			 if(misC.get(i)==null) {
				 misC.put(dni, new Cliente(nombre, apellidos, email, telefono, dni, tarjetaCredito));
				 return true;
			 }	 
		 } 
		 misC.put(dni, new Cliente(nombre, apellidos, email, telefono, dni, tarjetaCredito));
		 return true;
	 }*/
	
	public boolean addCliente(Cliente c) {
		if(c!=null) {
			if(!misC.containsKey(c.getDni())) {
				misC.put(c.getDni(), c);
				return true;
			}
		}
		return false;
	}
	
	public boolean addVehiculo(Vehiculo v) {
		 if (v != null) { 
		        for (Vehiculo vehiculoExistente : misV) {
		            if (vehiculoExistente.getMatricula().equals(v.getMatricula())) {
		                return false;
		            }
		        }
		        misV.add(v);
		        return true;
		    }return false; 
		}
	
	public Vehiculo buscarVehiculo(String matricula) {
		for (Vehiculo v:misV) {
			if(matricula.equals(v.getMatricula())) {
				return v;
			}
		}
		return null;
	}
	
	public Reserva buscarReserva(String matricula,String dni) {
		for (Reserva r:misReservas) {
			if(matricula.equals(r.getMatricula())) {
				if(dni.equals(r.getDni())) {
					return r;
				}
			}
		}
		return null;
	}
	
	public boolean alquilarVehiculo(Reserva r) {
		if(r!=null) {
			if(misC.containsKey(r.getDni())) {
				Vehiculo v = buscarVehiculo(r.getMatricula());
				if(v != null) {
					misReservas.add(r);
					v.setAlquilado(true);
					return true;
				}
			}
		}
		return false;
	}
	
	public float devolverVehiculo(Reserva r, float km, int dias) {
		if(r!=null) {
			if(buscarReserva(r.getMatricula(),r.getDni()) != null) {
				misReservas.remove(r);
				return buscarVehiculo(r.getMatricula()).cobro(r, km, dias);
			}
		}
		return 0f;
	}
	
	
	public List<Vehiculo> listaCoches(int plazas, String tipo) {
		List<Vehiculo> misV = new ArrayList<>();
		for (Vehiculo v:misV) {
			if(v instanceof Coche) {
				Coche coche = (Coche) v;
                if (coche.getPlazas() == plazas && coche.getMotor().equals(tipo)) {
                    misV.add(coche);
				}
			}
		}
		return misV;
	}
	
	public List<Vehiculo> listaFurgones(float carga, int plazas) {
		List<Vehiculo> misV = new ArrayList<>();
		for (Vehiculo v:misV) {
			if(v instanceof Furgon) {
				if( ((Furgon) v).getPlazas() >= plazas && ((Furgon) v).getCargaMax() >= carga) {
					misV.add(v);
				}
			}
		}
		return misV;
	}
	
	public List<Vehiculo> listaCamiones(float carga, float longi) {
		List<Vehiculo> misV = new ArrayList<>();
		for (Vehiculo v:misV) {
			if(v instanceof Camion) {
				if( ((Camion) v).getCargaMax() >= carga && ((Camion) v).getLongi() >= longi) {
					misV.add(v);
				}
			}
		}
		return misV;
	}
	
	
	
	
	/*
	 * public boolean cobrar(String matricula) {
		for (Vehiculo miV: misV) {
			if(miV != null) {
				if(miV.getMatricula().equals(matricula)) {
					//precio*km
					//Aquí se harían los calculos para el cobro con los km, el precio y el 20%
				}
				
			}
		}
		return true;
	}
	
	
	public boolean alquilarVehiculo (String matricula, String dni) {
		for(Vehiculo v: misV) {
			if(v.getMatricula().equals(matricula)){
				if(v.getAlquilado()==false) {
					for (Clientes cliente : misC.values()) {
		                if (cliente.getDni().equals(dni)) {
							v.setAlquilado(true);
							cliente.asignarVehiculo(v);
							return true;
					}
				}	
			}	
		}
	}return false;
}*/
	/*
	public boolean mostrarVehiculos(String tipoV) {	
		 for (Vehiculo miV: misV) {
			if(miV != null) {
				if(tipoV.compareTo("coche")==0){
					miV.mostrarCoches(motor, plazas);
					return true;
				}else if (tipoV.compareTo("furgon")==0){
					miV.mostrarFurgones(cargaMax, plazas);
					return true;
				}else {
					miV.mostrarCamiones(cargaMax,longi);
					return true;
				}
			 }
		}return false;	
}*/
}




