package com.Tools;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

public class SaveToTxt {

    private static final String SAVE_PATH = "results\\";
    private static FileWriter fileWriter;
    private static BufferedWriter bufferedWriter;
    private static File file;

    public SaveToTxt(String dirName, String fileName) {
        try {
            file = new File(SAVE_PATH + dirName);
            file.mkdirs();
            if (!file.exists()) {
                file.createNewFile();
            }
            fileWriter = new FileWriter(file + "\\" + fileName + ".xls", true);
            bufferedWriter = new BufferedWriter(fileWriter);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void save(String data) {
        try {
            if (fileWriter != null && bufferedWriter != null) {
                bufferedWriter.write(data + "\r\n");
                bufferedWriter.flush();
                fileWriter.flush();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void close(){
        try {
            bufferedWriter.close();
            fileWriter.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


    private boolean isFileExist(String dirName, String fileName) {
        return false;
    }


}
