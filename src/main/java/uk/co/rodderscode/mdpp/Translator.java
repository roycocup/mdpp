package uk.co.rodderscode.mdpp;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;


public class Translator {

    Collection collection;
    Iterator iterator;

    // ArrayList<Syntax>
    public Translator(ArrayList<Syntax> collection) {
        this.collection = collection;
        iterator = this.collection.iterator();
    }


    public void translate(){
        while(iterator.hasNext()){
            Syntax v = (Syntax) iterator.next();
        }
    }

    public Node get(){
        return new Node();
    }

    class Node {

    }

}
