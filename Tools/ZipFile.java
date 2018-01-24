package com.Tools;

import java.io.*;
import java.util.zip.*;

public class ZipFile {

    public static void archivate(File file, String outputZipFile){
        try {
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(outputZipFile));
            out.setLevel(9);
            doZip(file, out);
            out.close();
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }


    private static void doZip(File dir, ZipOutputStream out) throws IOException {
        for (File f : dir.listFiles()) {
            if (f.isDirectory())
                doZip(f, out);
            else {
                out.putNextEntry(new ZipEntry(f.getPath()));
                write(new FileInputStream(f), out);
            }
        }
    }

    private static void write(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[1024];
        int len;
        while ((len = in.read(buffer)) >= 0)
            out.write(buffer, 0, len);
        in.close();
    }
}
