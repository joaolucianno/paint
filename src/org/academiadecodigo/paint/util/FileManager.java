package org.academiadecodigo.paint.util;

import java.io.*;

public class FileManager {
    //Fields
    private static String saveLoadPath = "resources/saveLoad1.txt";

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
        //System.out.println(result);
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
