import java.io.File;


import uk.co.rodderscode.mdpp.Mdpp;


public class Main {

    private String inputFilename;
    private String outputFilename;

    public Main(String[] args){
        checkFiles(args);
        inputFilename = args[0];
        outputFilename = args[1];



        try {
            if( !isMarkdown(inputFilename) )
                throw new Exception("File is not valid markdown file (.md)");

            Mdpp mdpp = new Mdpp(new File (inputFilename));
            mdpp.parse();
            mdpp.compile();
        }catch (Exception e){
            e.printStackTrace();
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

    /**
     * Checks if the file has a valid .md extension
     * @return boolean
     */
    private Boolean isMarkdown(String filename) {
        int dotIndex = filename.lastIndexOf(".")+1; //otherwise the dot will be included
        String extension = filename.substring(dotIndex);
        return extension.equals("md");
    }


    public static void main(String[] args){
        Main m = new Main(args);
    }

}
