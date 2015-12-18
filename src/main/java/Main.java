import java.io.File;


import uk.co.rodderscode.mdpp.MDPPDocument;
import uk.co.rodderscode.mdpp.MdPlusPlus;

public class Main {

    private String inputFilename;
    private String outputFilename;

    public Main(String[] args){
        checkFiles(args);
        inputFilename = args[0];
        outputFilename = args[1];

        MdPlusPlus mdpp = null;
        try {
            mdpp = new MdPlusPlus(inputFilename);
        }catch (Exception e){
            System.err.println(e.getMessage());
            System.exit(0);
        }

        MDPPDocument newDocument = mdpp.parse();
        outputFilename = newDocument.toString();


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
