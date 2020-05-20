package aplication;

import java.io.File;
import java.io.BufferedReader; // Para Ler
import java.io.BufferedWriter; // Para escrever
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.entities.Product;

public class program {

	public static void main(String[] args) {

		String path = "Z:\\tempale\\ws-eclipse\\readProductFile\\produto.csv";
		
		
		String sourceFileStr = path;
		File sourceFile = new File(sourceFileStr);
		String sourceFolderStr = sourceFile.getParent();
		boolean success = new File(sourceFolderStr + "\\out").mkdir();
		String targetFileStr = sourceFolderStr + "\\out\\summary.csv";
		
		
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {

			String line = br.readLine();
			
			List<Product> product = new ArrayList<>();
			
			while (line != null) {
				String name = line.split(",")[0];
				Double price = Double.parseDouble(line.split(",")[1]);
				Integer quantit = Integer.parseInt(line.split(",")[2]);
				
				product.add(new Product(name, price, quantit));
				line = br.readLine();
			}
			
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr, true))) {
				// Nessa declaração se o tiver o true o arquvio editado, sem o true o arquvi é recriado caso não ouver.
				
				for (Product item : product) {
					bw.write(item.toString());
					bw.newLine();
				}

				System.out.println(targetFileStr + " CREATED!");
				
			} catch (IOException e) {
				System.out.println("Error writing file: " + e.getMessage());
			}
						
			System.out.println();
			System.out.println("Produtos que estão no arquivo: ");
			for(Product prod : product) {
				System.out.println(prod);
			}
			
		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
