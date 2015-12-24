package uk.co.rodderscode.mdpp;


public class MdppScanner{

    char[] chars;
    int position = 0;

    public MdppScanner() {}

    public MdppScanner(String source) {
        setString(source);
    }

    void setString(String source){
        chars = source.toCharArray();
    }

    boolean hasNext(){
        if (position >= getSize()-1)
            return false;
        return true;
    }

    char readNext(){
        return get(position++);
    }

    char readPrev(){
        return get(position--);
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
