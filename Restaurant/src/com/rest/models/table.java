package com.rest.models;

    public class table{

public enum Availability{
    free,
    occupy
}

private int id;
private int capacity;
private Availability Status;

public table(int id, int capacity){
    this.id=id;
    this.capacity=capacity;
    this.Status=Availability.free;
}

public int getid(){
    return  id;
}

public int getcapacity(){
    return capacity;
}

public Availability getStatus(){
    return Status;
}

public void freetable(){
    this.Status=Availability.free;
}

public void occupytable(){
    this.Status=Availability.occupy;
}
public  String toString(){
    return "Table ID: "+id+",Capacity: "+capacity+",Status: "+Status;
}
    }
