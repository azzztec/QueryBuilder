package org.azzztec.querybuilder.exeptions;

public class RelationExeption extends Exception {

    static final long serialVersionUID = -3914187672976633815L;

    public RelationExeption(String error) {
        super("[QueryBuilder] Type '" + error + "' not supported" );
    }
}
