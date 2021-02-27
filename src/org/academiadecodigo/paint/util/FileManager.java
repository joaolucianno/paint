package org.academiadecodigo.paint.util;

import java.io.*;

public class FileManager {
    //Fields
    private static String saveLoadPath = "save/saveLoad1.txt";

    //Setter
    public static void setSaveLoadPath(String newPath){
        saveLoadPath = newPath;
    }

    //Custom Methods
    /**
     *
     * @param save
     */
    public static void save(String save){
        System.out.println("Im here1");
        BufferedWriter bw = null;
        File file = new File(saveLoadPath);
        try {
            if(!file.exists()){
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            bw = new BufferedWriter(new FileWriter(saveLoadPath));
            bw.write(save);
        } catch (IOException errorSave) {
            System.err.println("SAVE ERROR");
        }
        finally {
            cleanUp(bw);
        }
    }

    /**
     *
     * @return file loaded
     */
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

    /**
     * Method safe close
     * @param closeable
     */
    private static void cleanUp(Closeable closeable) {
        try{
            if(closeable == null){
                return;
            }
            closeable.close();
        } catch (IOException error) {}
    }


}
