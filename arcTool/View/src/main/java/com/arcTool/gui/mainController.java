package com.arcTool.gui;

import  com.arcTool.JSoupExtractor.ExtractorController;
//import com.arcTool.Controller.JsoupExtractor.ExtractorController;
//import com.sun.tracing.dtrace.ModuleAttributes;
import net.sourceforge.plantuml.GeneratedImage;
import net.sourceforge.plantuml.SourceFileReader;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

//@RestController
public class mainController {

    //@Autowired
   /* private ExtractorController extractor;

    public  String index_page="";

    @RequestMapping(value="/index")
    public String index(){
        /*try {
            this.extract("C:\\Users\\Mkasiboy\\Documents\\GitHub\\ArcTool\\demo_one\\JavaDoc\\index-files");
            System.out.println("Done************");
            return "File created";
        }
        catch (Exception e){
            return e.getMessage();
        }
        return  "index";
    }


    /*@GetMapping("/index")
    public String getIndex_page(){
        /*try {
            this.extract("C:\\Users\\Mkasiboy\\Documents\\GitHub\\ArcTool\\demo_one\\JavaDoc\\index-files");
            C:\Users\Mkasiboy\Documents\GitHub\ArcTool\demo_one\JavaDoc\index-files
            return "File created";
        }
        catch (Exception e){
            return e.getMessage();
        }
        return  "index";
    }

    //@RequestMapping("/extract")
    @GetMapping("/extract")
    public String extract(@ModelAttribute Path path) throws IOException {
        /*Scanner input = new Scanner(System.in);
        System.out.print("Enter file path: ");
        String path = input.nextLine();*/
        /*System.out.println("Extracting*************");
        System.out.println("FR: " + path.getFR());
        System.out.println("Path: " + path.getPath());

        String text = "";
        FileWriter writer = new FileWriter("/home/aliata/Desktop/The Page/ArcTool-MVC/MVC/arcTool/View/src/main/resources/public/Functional_requirements.txt");
        File files = new File(path.getPath());
        int numFiles = files.list().length;

        for (int a = 1; a < numFiles; a++) {
            File input1 = new File(path.getPath()+"/index-"+a+".html");
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
                    break;
                }
            }
        }

        writer.close();
        drawSD();
        drawCD();
        return "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "    <title>results</title>\n" +
                "    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css\">\n" +
                "</head>\n" +
                "<style type=\"text/css\">\n" +
                "    * {\n" +
                "        text-decoration: none;\n" +
                "        list-style: none;\n" +
                "    }\n" +
                "    .page {\n" +
                "        height: 100vh;\n" +
                "        width: 100%;\n" +
                "    }\n" +
                "    .nav {\n" +
                "        position: relative;\n" +
                "        height: 7%;\n" +
                "        width: 100%;\n" +
                "        box-shadow: 3px 3px 3px black;\n" +
                "        border-radius: 20px;\n" +
                "    }\n" +
                "    .logo {\n" +
                "        width: 30%;\n" +
                "        height: 100%;\n" +
                "\n" +
                "    }\n" +
                "    .logo img {\n" +
                "        height: 70%;\n" +
                "        padding-left: 50px;\n" +
                "    }\n" +
                "    .result {\n" +
                "        height: 60%;\n" +
                "        width: 100%;\n" +
                "        position: relative;\n" +
                "        top: 10%;\n" +
                "    }\n" +
                "    .result_sec {\n" +
                "        height: 60%;\n" +
                "        width: 100%;\n" +
                "        position: relative;\n" +
                "        top: 30%;\n" +
                "    }\n" +
                "    .result_image {\n" +
                "        height: 85%;\n" +
                "        width: 50%;\n" +
                "        margin: 0 auto;\n" +
                "        border-radius: 10px;\n" +
                "        box-shadow: 5px 5px 5px gray;\n" +
                "    }\n" +
                "    #resut_img {\n" +
                "        width: 300px;\n" +
                "        height: 300px;\n" +
                "    }\n" +
                "    .download {\n" +
                "        height: 10%;\n" +
                "        width: 10%;\n" +
                "        margin: 0 auto;\n" +
                "        border-radius: 10px;\n" +
                "        padding-top: 20px;\n" +
                "    }\n" +
                "    .btn {\n" +
                "        width: 100%;\n" +
                "        height: 100%;\n" +
                "        outline: none;\n" +
                "        background: green;\n" +
                "        border: yellow 1px groove;\n" +
                "        border-radius: 10px;\n" +
                "        box-shadow: 3px 3px 3px blue;\n" +
                "        font-size: 25px;\n" +
                "    }\n" +
                "    .btn:hover {\n" +
                "        background: lime;\n" +
                "        color: white;\n" +
                "    }\n" +
                "</style>\n" +
                "<body>\n" +
                "<div class=\"page\">\n" +
                "    <div class=\"nav\">\n" +
                "        <div class=\"logo\">\n" +
                "            <img src=\"logo.png\" alt=\"c.png\">\n" +
                "        </div>\n" +
                "    </div>\n" +
                "    <div class=\"result\">\n" +
                "        <div class=\"result_image\" id=\"result_image1\">\n" +
                "            <img class=\"result_img\" id=\"result_img1\" src=\"component_diagram.png\" style=\"width: 800px; height: 400px;\">\n" +
                "        </div>\n" +
                "        <div class=\"download\">\n" +
                "            <a href=\"component_diagram.png\" download><button class=\"btn\" id=\"btn1\"><i class=\"fa fa-download\" >Download</i></button></a>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "    <div class=\"result_sec\">\n" +
                "        <div class=\"result_image\" id=\"result_image\">\n" +
                "            <img class=\"result_img\" id=\"result_img\" src=\"sequence_diagram.png\" style=\"width: 800px; height: 400px;\">\n" +
                "        </div>\n" +
                "        <div class=\"download\">\n" +
                "            <a href=\"sequence_diagram.png\" download><button class=\"btn\" id=\"btn\"><i class=\"fa fa-download\" >Download</i></button></a>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</div>\n" +
                "</body>\n" +
                "</html>";
    }

    private void drawSD() throws IOException {
        try {
            File myObj = new File("/home/aliata/Desktop/The Page/ArcTool-MVC/MVC/arcTool/View/src/main/resources/public/Functional_requirements.txt");
            FileWriter fileWriter = new FileWriter("/home/aliata/Desktop/The Page/ArcTool-MVC/MVC/arcTool/View/src/main/resources/public/sequence_diagram.txt");
            Scanner myReader = new Scanner(myObj);
            fileWriter.write("@startuml\n");
//            fileWriter.write("database\n");
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
            File source = new File("/home/aliata/Desktop/The Page/ArcTool-MVC/MVC/arcTool/View/src/main/resources/public/sequence_diagram.txt");
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

    private void drawCD() throws IOException{
        try {
            File myObj = new File("/home/aliata/Desktop/The Page/ArcTool-MVC/MVC/arcTool/View/src/main/resources/public/Functional_requirements.txt");
            FileWriter fileWriter = new FileWriter("/home/aliata/Desktop/The Page/ArcTool-MVC/MVC/arcTool/View/src/main/resources/public/component_diagram.txt");
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
            File source = new File("/home/aliata/Desktop/The Page/ArcTool-MVC/MVC/arcTool/View/src/main/resources/public/component_diagram.txt");
            SourceFileReader reader = new SourceFileReader(source);
            List<GeneratedImage> list = reader.getGeneratedImages();
            // Generated files
            File png = list.get(0).getPngFile();
            System.out.println("Component diagram generated!!!!");

        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }*/
}
