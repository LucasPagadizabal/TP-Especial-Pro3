package Entrega3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import EjA.Lista;

public class CargaCSV {

	public void cargarInicial(Grafo g,String archivo){
		String csvFile = "C:/DataSetTPE-Pro/"+archivo+".csv";
		String line = "";
		String cvsSplitBy = ";";

		try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

			while ((line = br.readLine()) != null) {

					String[] items = line.split(cvsSplitBy);

					g.add(items);
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}


