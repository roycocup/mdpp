package uk.co.rodderscode.mdpp;

import java.util.Collection;
import java.util.Iterator;
import java.util.function.Consumer;


public class SpecialIterator{

    Collection collection;

    public SpecialIterator(Collection collection) {
        this.collection = collection;
    }


    public Node get(){
        return new Node();
    }

    class Node {

    }

}
