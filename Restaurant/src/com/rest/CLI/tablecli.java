package com.rest.CLI;

import com.rest.models.table;
import com.rest.services.tableservice;
import java.util.List;
import java.util.Scanner;

public class tablecli {
    private final tableservice service;
    private final Scanner scanner=new Scanner(System.in);

    public tablecli(tableservice service){
        this.service=service;
    }

    public void start(){
        System.out.println("==RESTAURANT TABLE MANAGEMENT==");
        System.out.println("1.View All tables");
        System.out.println("0.Exit");

        System.out.print("Enter choice");
        int choice=Integer.parseInt(scanner.nextLine());
        
        if(choice==1){
            List<table> table=service.getAllTables();
            System.out.println("\n==ALL TABLES");
        
            for(table Tables: table){ 
                System.out.println(Tables);
            }
        }
        else if(choice==0){
 System.out.println("Thank you");
        }
        else{
            System.out.println("Invalid choice");
        }

    }
}

