package com.arcTool.Controller;

import net.sourceforge.plantuml.GeneratedImage;
import net.sourceforge.plantuml.SourceFileReader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class ExtractorController {

    @RequestMapping(value = {"/process"}, method = RequestMethod.POST)
    public String process(@RequestParam("path") String path){
        System.out.println("*******Processing*******");
        System.out.println("The path received: " + path);
        //System.out.println("The name of the zip file is: ");
        System.out.println("******calling the extraction function****");
        Boolean extraction = false;

        try{
            extraction = extract(path);
        }
        catch (Exception e){
            System.out.println("Extraction failed because: " + e.getMessage());
        }

        if(extraction)
            System.out.println("Extraction successful");
        else
            System.out.println("Extraction failed");

        //ModelAndView model = new ModelAndView();
        //model.setViewName("FR/results");
        return "Processed";
    }

/* @RequestMapping(value = {"/process"}, method = RequestMethod.POST)
 public String Process(@RequestParam("FR") String fr, @RequestParam("path") String path) throws IOException {
  System.out.println("****************************************Processing**********************");
  System.out.println("The User's FR is: "+ fr);
 }*/

    //Extraction
    //
    public Boolean extract(String path) throws IOException {
         /*Scanner input = new Scanner(System.in);
         System.out.print("Enter file path: ");
         String path = input.nextLine();*/
        System.out.println("Extracting*************");
        System.out.println("Path: " + path);

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
                    System.out.println(e.getMessage());
                    //return "File not created";
                    break;
                }
            }
        }

        writer.close();
        return true;
    }



    private static  void drawSD() throws IOException {
        try {
            System.out.println("Drawing a sequence diagram");
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
            System.out.println("Drawing a component diagram");
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
