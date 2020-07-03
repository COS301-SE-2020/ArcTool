package com.arcTool.gui;

import  com.arcTool.JSoupExtractor.ExtractorController;
//import com.arcTool.Controller.JsoupExtractor.ExtractorController;
import com.sun.tracing.dtrace.ModuleAttributes;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@RestController
public class mainController {

    //@Autowired
    private ExtractorController extractor;

    public  String index_page="";

    @RequestMapping("/")
    public String index(){
        /*try {
            this.extract("C:\\Users\\Mkasiboy\\Documents\\GitHub\\ArcTool\\demo_one\\JavaDoc\\index-files");
            System.out.println("Done************");
            return "File created";
        }
        catch (Exception e){
            return e.getMessage();
        }*/
        return  "index";
    }


    //@GetMapping("/index")
    public String getIndex_page(){
        /*try {
            this.extract("C:\\Users\\Mkasiboy\\Documents\\GitHub\\ArcTool\\demo_one\\JavaDoc\\index-files");
            C:\Users\Mkasiboy\Documents\GitHub\ArcTool\demo_one\JavaDoc\index-files
            return "File created";
        }
        catch (Exception e){
            return e.getMessage();
        }*/
        return  "index";
    }

    //@RequestMapping("/extract")
    @GetMapping("/extract")
    public String extract(@ModelAttribute Path path) throws IOException {
        /*Scanner input = new Scanner(System.in);
        System.out.print("Enter file path: ");
        String path = input.nextLine();*/
        System.out.println("Extracting*************");
        System.out.println("FR: " + path.getFR());
        System.out.println("Path: " + path.getPath());

        String text = "";
        FileWriter writer = new FileWriter("Functional_requirements.txt");
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
        return "File created";
    }
}
