package application;
import java.util.*;

public class TextAnalyzer {
	public TextAnalyzer() {
		System.out.println("Hello");
	}
	
	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);

		while(true){
			System.out.print("Please enter the text you'd like to get analyzed (q to exit): ");
			String data = sc.nextLine();
			if (data.equals("q"))
				break;
			DataExtractor extract = new DataExtractor(data);

			extract.printAllData();

		}
		sc.close();
		
		
	}
}