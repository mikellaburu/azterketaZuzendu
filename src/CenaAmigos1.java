import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;

public class CenaAmigos{
	public static void main(String[] args){
		Scanner tecla=new Scanner(System.in);
		int cantRecetas=0;
		int cantIngr=0;
		String nombreRec=" ";
		String nombreIng=" ";
		String prep=" ";

		System.out.println("Cuantas recetas?");
		cantRecetas=tecla.nextInt();
		int j=1;// contador para recetas

		ArrayList<Receta> listaReceta=new ArrayList<Receta>();

		for (int i=0;i<cantRecetas;i++){
			System.out.println("Receta "+j+":");
			System.out.println("Nombre de la Receta "+j);
			nombreRec=tecla.next();
			System.out.println("Cuantos ingredientes tiene?");
			cantIngr=tecla.nextInt();

			ArrayList<Ingrediente> listaIng=new ArrayList<Ingrediente>();
			int l=1;//contador para ingredientes
			for (int k=0;k<cantIngr;k++){
				String como=" ";
				int gramos=0;
				int unidades=0;
				boolean enGr=false;
				System.out.println("Nombre del ingrediente "+l);
				nombreIng=tecla.next();
				
				do{
					System.out.println("Se mide en gramos(g) o unidades(u)? ");
					como=tecla.next();
					switch (como){
						case "g":
						System.out.println("Cuantos gramos tiene?");
						gramos=tecla.nextInt();
						unidades=-1;
						enGr=true;
						break;

						case "u":
						System.out.println("Cuantos unidades tiene?");
						unidades=tecla.nextInt();
						gramos=-1;
						enGr=false;
						break;

						default:
						System.out.println("Has introducido mal.");
						break;

					}

					
				}while((!como.equalsIgnoreCase("g"))&&(!como.equalsIgnoreCase("u")));
				
				Ingrediente ing=new Ingrediente();
				ing.setNombre(nombreIng);
				ing.setUnidad(unidades);
				ing.setGramos(gramos);
				ing.setEnGramos(enGr);
				
				listaIng.add(ing);
				l++;
			}//final for ingredientes

			System.out.println("Como se prepara?");
			prep=tecla.next();
			Receta r1=new Receta();
			r1.setNombre(nombreRec);
			r1.setIngrediente(listaIng);
			r1.setPreparacion(prep);

			listaReceta.add(r1);
			j++;
		}// final for recetas

		//mostrar recetas
		for (int i=0;i<listaReceta.size();i++){
			System.out.println("Receta "+i);
				            System.out.println("\tNombre: "+listaReceta.get(i).getNombre());
				            System.out.println("\tIngrediente : "+i+":"+ listaReceta.get(i).getIngrediente());
				         /*  for (int k=0;k<listaIng.size();k++){
				            	System.out.println("\t"+ listaReceta.get(i).listaIng.get(k).getNombre());
				            	/*System.out.println("\t"+ listaIng.get(k).getUnidad());
				            	System.out.println("\t "+ listaIng.get(k).getGramos());
				            	System.out.println("\t "+ listaIng.get(k).getEnGramos());
				            }*/
				            

				            System.out.println("\tPreparacion: "+listaReceta.get(i).getPreparacion() );
		}

		//crear fichero
		try{
			File archivo=new File("/home/zubiri/ProyectosJava/examen/src/","listRecetas.txt");
			if(archivo.createNewFile()){
				System.out.println("Se ha creado el archivo 'listRecetas.txt' correctamente");
			}else{
				System.out.println("No se ha podido crear el archivo 'listRecetas.txt'");
			}
		}catch(Exception e){
			System.out.println("Error");
		}

	//escribir fichero
		try{
            //Abro stream, crea el fichero si no existe
            FileWriter fw=new FileWriter("./listRecetas.txt");
            //Escribimos en el fichero un String y un caracter 97 (a)
           
            for (int i=0;i<listaReceta.size();i++){
						fw.write(listaReceta.get(i).getNombre()+";");
						/*for (int k=0;k<listaIng.size();k++){
							fw.write(listaIng.get(k).getNombre());
							fw.write(listaIng.get(k).getUnidad());
				            	fw.write(listaIng.get(k).getGramos());
				            	fw.write(listaIng.get(k).getEnGramos());
						}*/
				        fw.write(listaReceta.get(i).getIngrediente()+";");
				        fw.write(listaReceta.get(i).getPreparacion()+";");
			}
            //Cierro el stream
            fw.close(); 
                //Abro el stream, el fichero debe existir
           /* FileReader fr=new FileReader("D:\\fichero1.txt");
            //Leemos el fichero y lo mostramos por pantalla
            int valor=fr.read();
            while(valor!=-1){
                System.out.print((char)valor);
                valor=fr.read();
            }
            //Cerramos el stream
            fr.close();*/
        }catch(Exception e){
            System.out.println("Error E/S: "+e);
        }




/*
		//leer receta
		System.out.println("Leer recetas desde el fichero");
					try{	
						String ruta="/home/zubiri/ProyectosJava/examen/src/";
						String nombreFichero="listadoRecetas.txt";
						//fitxategi motako objetua sortu, parametroetan bidea eta fitxategiaren izena adieraziz
						File fichero = new File(ruta,nombreFichero);
						//irakurketa fitxategitik egiteko teklatutik izan beharrean
						Scanner leerFichero=new Scanner (fichero);
						ArrayList <Receta> recetas1=new ArrayList <Receta>();
						ArrayList <Ingrediente> ingredientes1=new ArrayList <Ingrediente>();
						String fila;
						//fitxategiak hurrengo lerroa duen bitartean 
						
						while (leerFichero.hasNextLine()) {
							fila=leerFichero.nextLine();//lerro bat irakurri fitxategitik eta string moduan gorde
							String [] dividirReceta = fila.split(";");
							String texto_ing=dividirReceta[1];
							String [] divIng=texto_ing.split("#");
							//String [] divAtrIng=divIng[].split("*");



							
							//Receta receta1=new Receta();
							//Partido p = new Partido();
							//array-aren posizioetan dauden datuak Partido motako 'p' objetuaren atributuei ezarri
							System.out.println(dividirReceta[0]);
							System.out.println(dividirReceta[1]);
							System.out.println(dividirReceta[2]);

						//	System.out.println(divAtrIng[1]);
							
							
							/*
							receta1.setNombre(dividirAtributos[0]);
							
							//objetu bakoitza bere atributuekin arraylist-ean gehitu
							partidos.add(p);
						}
						
						
					}catch(Exception e){
						System.out.println("Error: "+e);
					}*/


	}


}