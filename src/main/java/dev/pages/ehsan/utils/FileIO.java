package dev.pages.ehsan.utils;

import java.io.*;

public class FileIO {
    /**
     * This method checks if the file exist or not. If not exist then
     * creates file with <b>T</b> object. The purpose of this method
     * is to prevent the exception while reading serialized object from
     * file for the first time.
     */
    public static <T> void checkDB(String filePath, T obj) {
        try {
            File f1 = new File(filePath);
            boolean isF1Created = f1.createNewFile();
            if (isF1Created)
                writeObjToFile(obj, filePath);
        } catch (IOException e) {
            System.out.println(" - ERROR: EXCEPTION HAPPENED WHILE CHECKING " + filePath);
            e.printStackTrace();
        }
    }

    /**
     * This method reads serialized object from file.
     */
    public static <T> T readObjFromFile(String filePath) {
        T obj = null;
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(filePath));
            obj = (T) in.readObject();
            in.close();
            System.out.println(" - Read Serialized data from " + filePath);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(" - ERROR: EXCEPTION HAPPENED WHILE READING " + filePath);
            e.printStackTrace();
        }
        return obj;
    }

    /**
     * This method writes serialized object to file.
     */
    public static <T> void writeObjToFile(T obj, String filePath) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filePath));
            out.writeObject(obj);
            out.close();
            System.out.println(" - Serialized data is saved in " + filePath);
        } catch (IOException i) {
            System.out.println(" - ERROR: EXCEPTION HAPPENED WHILE WRITING " + filePath);
            i.printStackTrace();
        }
    }
}
