package uk.co.rodderscode.utils;


import java.io.File;
import java.io.PrintWriter;


public class Printer {

    public static String logFilename = "log.log";

    public static void pl(Object o){System.out.println(o.toString());}

    public static void err(Object o){System.err.println(o.toString());}

    public static void log(Object o){
        File file = new File(Printer.logFilename);
        PrintWriter writer;
        try {
            writer = new PrintWriter(file, "UTF-8");
            writer.println(o.toString());
            writer.close();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }



}
