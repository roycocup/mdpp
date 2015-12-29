package uk.co.rodderscode.mdpp;


public class MdppScanner{

    char[] chars;
    int position = 0;

    public MdppScanner(String source) {
        setString(source);
    }

    void setString(String source){
        chars = source.toCharArray();
    }

    public String getString() {return String.valueOf(chars);}

    boolean hasNext(){
        if ( position <= (getSize()-1) )
            return true;
        return false;
    }

    char readNext(){
        return get(position++);
    }

    char readPrev(){
        return get(--position);
    }


    int getPosition(){
        return position;
    }

    int getSize(){return chars.length;}


    public char get() {
        return chars[position];
    }

    public char get(int mPosition){
        return chars[mPosition];
    }
}
