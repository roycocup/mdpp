package uk.co.rodderscode.mdpp;

public interface MdFile {
    String filename = null;
    void setFilename(String filename);
    String getFilename();
    Boolean isMarkdown();

}
