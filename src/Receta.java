import java.util.*;
public class Receta{
	private String nombreReceta;
	private ArrayList <Ingrediente> ingredientes;
	private String preparacion;
	
	//getters
	public String getNombre(){
		return this.nombreReceta;
	}
	public ArrayList <Ingrediente> getIngrediente(){
		return this.ingredientes;
	}
	public String getPreparacion(){
		return this.preparacion;
	}
	
	//setters
	public void setNombre(String nombre){
		this.nombreReceta=nombre;
	}
	public void setIngrediente(ArrayList <Ingrediente> lista){
		this.ingredientes=lista;
	}
	public void setPreparacion(String descripcion){
		this.preparacion=descripcion;
	}
	
}