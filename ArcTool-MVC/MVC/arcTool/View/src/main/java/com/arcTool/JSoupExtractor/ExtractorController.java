package com.arcTool.JSoupExtractor;

/**
 *
 * FR: Needs to extract
 */


import java.io.*;
import java.io.IOException;
//import java.util.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;


public class ExtractorController {

    //C:\Users\Mkasiboy\Documents\GitHub\ArcTool\demo_one\JavaDoc\index-files

    public void extract(String path) throws IOException {
        /*Scanner input = new Scanner(System.in);
        System.out.print("Enter file path: ");
        String path = input.nextLine();*/

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
    }
}
