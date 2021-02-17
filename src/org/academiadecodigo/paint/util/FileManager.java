package org.academiadecodigo.paint.util;

import java.io.*;

public class FileManager implements Closeable {
    //Fields
    private static String savePath = "resources/saveLoad.txt";
    private static String loadPath = "resources/saveLoad.txt";

    //Getters
    public String getSavePath() {
        return savePath;
    }

    public static String getLoadPath() {
        return loadPath;
    }

    //Setters
    public void setPath(String newPath){
        savePath = newPath;
    }

    public static void setLoadPath(String loadPath) {
        FileManager.loadPath = loadPath;
    }

    //Custom Methods
    //Save
    public static void save(String save){
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(savePath));
            bw.write(save);
            System.out.println("SAVE");
        } catch (IOException errorSave) {}
        finally {
            cleanUp(bw);
        }
    }

    //Load
    public static void load(String load){
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(loadPath));
        } catch (IOException errorLoad) {}
        finally {
            cleanUp(br);
        }
    }


    private static void cleanUp(Closeable closeable) {
        try{
            closeable.close();
        } catch (IOException error) {}
    }


    @Override
    public void close() throws IOException {

    }
}
