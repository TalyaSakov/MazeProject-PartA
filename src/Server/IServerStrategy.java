package Server;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public interface IServerStrategy {
    void applyStrategy(InputStream inFromClient, OutputStream outToClient);
}
