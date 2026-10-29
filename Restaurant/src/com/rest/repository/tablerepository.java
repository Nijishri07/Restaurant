package com.rest.repository;

import com.rest.models.table;
import java.util.ArrayList;
import java.util.List;

public class tablerepository {

    private final List<table> table=new ArrayList<>();
 
    public tablerepository(){
        table.add(new table(1,2));
        table.add(new table(2,4));
        table.add(new table(3,6)); 
    }
    public List<table> findall(){
        return table;   //show and return details of how many tables
    }
}
