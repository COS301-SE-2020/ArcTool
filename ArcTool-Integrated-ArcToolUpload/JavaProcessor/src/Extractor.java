/**
 * 
 * FR: Needs to extract
 */


import java.io.*;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import net.sourceforge.plantuml.GeneratedImage;
import net.sourceforge.plantuml.SourceFileReader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/*
* KEYWORDS TO LOOK FOR:
* FR:
* -	Functional requirements
* It must start with sspecifying the classes relationship with other classes, separate everything with a comma and end with a semi colon.
* Example: Database->sql:is a, Database->person; This classs is for this and that.
* - Must state which functional requirement the class caters for.
*/
public class Extractor {
	public static void main(String[] args) throws IOException {
		Scanner input = new Scanner(System.in);
		System.out.print("Enter file path: ");
		//path=/home/mxolisi/Documents/GitHub/ArcTool/demo_one/JavaDoc/index-files/
		//path=file:/home/mxolisi/Documents/3rd Year/COS301/ArcTool/Demo 2/demo_one/JavaDoc/index-files
		String path = input.nextLine();
		
		String text = "";
		FileWriter writer = new FileWriter("Functional_requirements.txt");
		File files = new File(path);
		int numFiles = files.list().length;	
		
		for (int a = 1; a < numFiles; a++) {
			File input1 = new File(path+"/index-"+a+".html");
			Document doc = Jsoup.parse(input1, "UTF-8", "");
			int i = 0;
			while (true) {
				try {
					text = doc.getElementsByClass("block").get(i).text();
					if (text.contains("FR")) {
						writer.write(text+"\n");
						System.out.print(text+".");
						
						int index = 0;
						while (true) {
							try {
								text = doc.getElementsByClass("typeNameLink").get(index).ownText();
								writer.write("Class: "+text+"\n");
								System.out.println("\t\t:: Class:"+text);
								break;
							} catch (Exception e) {
								break;
							}
						}
					}
					i++;
				} catch (Exception e) {
					break;
				}
			}
		}
		
		writer.close();
		drawSD();
		drawCD();
	}

	private static  void drawSD() throws IOException {
		try {
			File myObj = new File("Functional_requirements.txt");
			FileWriter fileWriter = new FileWriter("seq.txt");
			Scanner myReader = new Scanner(myObj);
			fileWriter.write("@startuml\n");
			Boolean bool = false;
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				System.out.println(data);
				if (data.contains("Class")) {
					String str[] = data.split(" ");
					if (!bool)
						fileWriter.write(str[str.length - 1] + "->");
					else
						fileWriter.write(str[str.length - 1] + "\n");
					bool = !bool;
				}
			}
			fileWriter.write("@enduml\n");
			myReader.close();
			fileWriter.close();

			//Generating the diagram
			File source = new File("seq.txt");
			SourceFileReader reader = new SourceFileReader(source);
			List<GeneratedImage> list = reader.getGeneratedImages();
			// Generated files
			File png = list.get(0).getPngFile();
			System.out.println("Sequence diagram generated!!!");

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}

	private static  void drawCD() throws IOException{
		try {
			File myObj = new File("Functional_requirements.txt");
			FileWriter fileWriter = new FileWriter("comp.txt");
			Scanner myReader = new Scanner(myObj);
			fileWriter.write("@startuml\n");
			Boolean bool = false;
			while (myReader.hasNextLine()) {
				String data = myReader.nextLine();
				System.out.println(data);
				if (data.contains("Class")) {
					String str[] = data.split(" ");
					if (!bool) {
						fileWriter.write("database \"MySQL\"{\n" +
								"[" + str[str.length - 1] + "]->");
					}
					else {
						fileWriter.write(str[str.length - 1] + "\n}\n");
					}
					bool = !bool;
				}
			}
			fileWriter.write("@enduml\n");
			myReader.close();
			fileWriter.close();

			//Generating the diagram
			File source = new File("comp.txt");
			SourceFileReader reader = new SourceFileReader(source);
			List<GeneratedImage> list = reader.getGeneratedImages();
			// Generated files
			File png = list.get(0).getPngFile();
			System.out.println("Component diagram generated!!!!");

		} catch (FileNotFoundException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
