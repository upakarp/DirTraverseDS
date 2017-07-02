package server;

/**
 * Created by ajay on 3/28/17.
 */

import java.io.File;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Server implements Hello{
    //String basePath = System.getProperty("user.dir");

    public Server(){

    }

//    public int addition(int a, int b){
//        return a+b;
//    }

//    public List<File> listFileandDir(String directoryName) {
//        File directory = new File(directoryName);
//        List<File> resultList = new ArrayList<File>();
//
//        File[] flist = directory.listFiles();
//        resultList.addAll(Arrays.asList(flist));
//
//        for(File file : flist){
//            if (file.isFile()){
//                System.out.println(file.getAbsolutePath());
//            } else if(file.isDirectory()){
//                resultList.addAll(listFileandDir(file.getAbsolutePath()));
//            }
//        }
//        return resultList;
//    }

//    public String presentWorkingDir(){
//        String workingDir = System.getProperty("user.dir");
//        return workingDir;
//    }
    public String[] listFileandDir(){

        File dir = new File(System.getProperty("user.dir"));
        String[] filesanddir = dir.list();
        return filesanddir;
    }

    public String presentWorkingDir(){
        String workingDir = System.getProperty("user.dir");
        return workingDir;
    }



    public static void main(String args[]){
        try {
            Server obj = new Server();
            Hello stub = (Hello) UnicastRemoteObject.exportObject(obj,0);

            //Bind the remote object's stub in the registry
            Registry registry = LocateRegistry.getRegistry();
            registry.bind("Hello", stub);

            System.out.println("Server ready");
        } catch (Exception e){
            System.err.println("Server exception: "+ e.toString());
            e.printStackTrace();
        }
    }
}
