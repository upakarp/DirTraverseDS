package server;

/**
 * Created by ajay on 3/28/17.
 */

import java.io.File;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Hello extends Remote{
    //int addition(int a, int b) throws RemoteException;
    String[] listFileandDir() throws RemoteException;
    String presentWorkingDir() throws RemoteException;
}
