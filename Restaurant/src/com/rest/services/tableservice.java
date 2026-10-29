package com.rest.services;
import com.rest.models.table;
import com.rest.repository.tablerepository;
import java.util.List;

public class tableservice {
    private final tablerepository repository;

    public tableservice(){
        repository=new tablerepository();
    }
    public List<table> getAllTables(){
      return repository.findall();
    }
}
