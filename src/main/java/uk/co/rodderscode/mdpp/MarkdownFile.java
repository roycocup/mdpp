package uk.co.rodderscode.mdpp;

public interface MarkdownFile {
    String filename = null;
    void setFilename(String filename);
    String getFilename();
    Boolean isMarkdown();

}
