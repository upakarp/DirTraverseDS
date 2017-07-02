package client;

/**
 * Created by ajay on 3/28/17.
 */

import server.Hello;

import java.io.File;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client {
    private Client(){}

    public static void main(String[] args){
        String host = (args.length<1) ? null : args[0];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Command : ");
        String command = sc.nextLine();
        try{
            Registry registry = LocateRegistry.getRegistry(host);
            Hello stub = (Hello) registry.lookup("Hello");

            if(command.equals("ls")) {
                String[] response = stub.listFileandDir();
//            for(File f : response){
//                System.out.println(response);
//            }
                for(String str : response){
                    System.out.println(str);
                }
            }
            else if(command.equals("pwd")){
                String response = stub.presentWorkingDir();
                System.out.println("Present Working Directory: "+response);
//
           } else if(command.matches("(^mkdir)[\\s+](.*)") || (command.equals("mkdir"))){
                System.out.println("Okay dokey");
            }
           else{
               System.out.println("Okay dokey");
           }
        } catch (Exception e){
            System.err.println("Client exception:" +e.toString());
            e.printStackTrace();
        }
    }
}
