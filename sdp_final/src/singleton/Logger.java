package singleton;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Logger {
    private static Logger instance;
    private PrintWriter logFile;

    private Logger(){
        try {
            logFile = new PrintWriter(new FileWriter("log.txt", true));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static synchronized Logger getInstance(){
        if(instance == null){
            instance = new Logger();
        }
        return instance;
    }

    public void log(String txt){
        logFile.println(txt);
        logFile.flush();
    }

    public void close(){
        logFile.close();
    }
}