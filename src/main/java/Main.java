import java.io.File;


import uk.co.rodderscode.mdpp.MdppDocument;
import uk.co.rodderscode.mdpp.Mdpp;
import uk.co.rodderscode.utils.Printer;

public class Main {

    private String inputFilename;
    private String outputFilename;

    public Main(String[] args){
        checkFiles(args);
        inputFilename = args[0];
        outputFilename = args[1];

        Mdpp mdpp = null;
        try {
            mdpp = new Mdpp(inputFilename);
            MdppDocument newDocument = mdpp.parse();
            outputFilename = newDocument.toString();
        }catch (Exception e){
            System.err.println(e.getClass());
            System.exit(0);
        }


    }

    private void checkFiles(String[] args){
        if (args.length < 2 ){
            System.err.println("Program requires at least 2 arguments.");
            System.err.println("Usage: Java targetFile.md outputFile.txt");
            System.exit(0);
        }

        File f = new File(args[0]);
        if(!f.exists()){
            System.err.println("Target file "+ args[0].toString() +" does not exist.");
            System.err.println("Usage: Java targetFile.md outputFile.txt");
            System.exit(0);
        }
    }


    public static void main(String[] args){
        Main m = new Main(args);
    }

}
