
public class Ingrediente {
	private String nombreIngrediente;
	private int cantidadUnidad;
	private int cantidadGramos;
	private boolean enGramos;

	//getters
	public String getNombre(){
		return this.nombreIngrediente;
	}
	public int getUnidad(){
		return this.cantidadUnidad;
	}
	public int getGramos(){
		return this.cantidadGramos;
	}
	public boolean getEnGramos(){
		return this.enGramos;
	}

	//setters
	public void setNombre(String nombre){
		this.nombreIngrediente=nombre;
	}
	public void setUnidad(int unidad){
		this.cantidadUnidad=unidad;
	}
	public void setGramos(int gramos){
		this.cantidadGramos=gramos;
	}
	public void setEnGramos(boolean como){
		this.enGramos=como;
	}
}