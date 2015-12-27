package uk.co.rodderscode.mdpp;


public class Token {

    private final Character value;
    private final Syntax token;


    public Token(Character value, Syntax token) {
        this.value = value;
        this.token = token;
    }

    public Character getValue() {
        return value;
    }

    public Syntax getToken() {
        return token;
    }

    @Override
    public String toString(){
        return getToken().toString();
    }

}
