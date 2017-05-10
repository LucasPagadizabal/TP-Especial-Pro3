package EjA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ABMcsv {

	public void cargar(Lista l,String archivo){
		String csvFile = "C:/DataSetTPE-Pro/"+archivo+".csv";
		String line = "";
		String cvsSplitBy = ";";

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			boolean saltoLinea = false;

			while ((line = br.readLine()) != null) {

				if(saltoLinea){//este if es para saltear el encabezado DNI-Gusto...

					String[] items = line.split(cvsSplitBy);

					l.addUser(items);

				}
				saltoLinea=true;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public void insert (Lista l){

		String csvFile = "C:/DataSetTPE-Pro/dataset_insert_10000.csv";
		String line = "";
		String cvsSplitBy = ";";

		BufferedWriter bw = null;

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			File file = new File("C:/DataSetTPE-Pro/salidaalta.csv");
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);

			long time_start, time_end;
			

			while ((line = br.readLine()) != null) {
				time_start = System.nanoTime();
				String[] items = line.split(cvsSplitBy);

				l.addUser(items);

				time_end = System.nanoTime();
				// Escribo la primer linea del archivo
				String contenidoLinea1 = items[0]+";"+(( time_end - time_start ));
				bw.write(contenidoLinea1);
				bw.newLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (bw != null)
					bw.close();
			} catch (Exception ex) {
				System.out.println("Error cerrando el BufferedWriter" + ex);
			}
		}


	}

	public void busqueda(Lista l){
		


		String csvFile = "C:/DataSetTPE-Pro/dataset_busqueda_10000.csv";
		String line = "";
		String cvsSplitBy = ";";

		BufferedWriter bw = null;

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			File file = new File("C:/DataSetTPE-Pro/salidabusqueda.csv");
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);

			long time_start, time_end;
			

			while ((line = br.readLine()) != null) {
				time_start = System.nanoTime();
				String[] items = line.split(cvsSplitBy);
				
				boolean existe = l.existe(items[0]);
				time_end = System.nanoTime();
				// Escribo la primer linea del archivo
				String contenidoLinea = "";
				if(existe){
					 contenidoLinea = items[0]+";"+(( time_end - time_start ))+";Existe";
				}else{
					 contenidoLinea = items[0]+";"+(( time_end - time_start ))+";NoExiste";
				}
				
				bw.write(contenidoLinea);
				bw.newLine();
			}

		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if (bw != null)
					bw.close();
			} catch (Exception ex) {
				System.out.println("Error cerrando el BufferedWriter" + ex);
			}
		}


	
		
	}
	
	public void escribir(String id, long time){
		BufferedWriter bw = null;
		try {
			File file = new File("C:/DataSetTPE-Pro/salida.csv");
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file);
			bw = new BufferedWriter(fw);

			// Escribo la primer linea del archivo
			String contenidoLinea1 = "Usuario1;Tiempo1";
			bw.write(contenidoLinea1);
			bw.newLine();

			// Escribo la segunda linea del archivo
			String contenidoLinea2 = "Usuario2;Tiempo2";
			bw.write(contenidoLinea2);
			bw.newLine();

			/*
			 *
			 * ... 
			 * 
			 */

		} catch (IOException ioe) {
			ioe.printStackTrace();
		} finally {
			try {
				if (bw != null)
					bw.close();
			} catch (Exception ex) {
				System.out.println("Error cerrando el BufferedWriter" + ex);
			}
		}
	}

}
