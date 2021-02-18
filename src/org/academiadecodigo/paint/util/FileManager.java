package org.academiadecodigo.paint.util;

import java.io.*;

public class FileManager implements Closeable {
    //Fields
    private static String saveLoadPath = "resources/saveLoad1.txt";
    //private static String loadPath = "resources/saveLoad1.txt";

    //Getters
    public String getSavePath() {
        return saveLoadPath;
    }

    public static String getLoadPath() {
        return saveLoadPath;
    }

    //Setters
    public static void setSaveLoadPath(String newPath){
        saveLoadPath = newPath;
    }

//    public static void setLoadPath(String loadPath) {
//        FileManager.saveLoadPath = loadPath;
//    }

    //Custom Methods
    //Save
    public static void save(String save){
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(saveLoadPath));
            bw.write(save);
            //System.out.println("SAVE");
        } catch (IOException errorSave) {}
        finally {
            cleanUp(bw);
        }
    }

    //Load
    public static String load(){
        BufferedReader br = null;
        String result = "";
        try {
            br = new BufferedReader(new FileReader(saveLoadPath));
            String line;
            while((line = br.readLine()) != null){
                result += line + "\n";
            }
        } catch (IOException errorLoad) {}
        finally {
            cleanUp(br);
        }

        return result;
    }


    private static void cleanUp(Closeable closeable) {
        try{
            if(closeable == null){
                return;
            }
            closeable.close();
        } catch (IOException error) {}
    }


    @Override
    public void close() throws IOException {

    }
}
