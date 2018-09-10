package com.effective.java.yanaga.effectivejava;

import java.io.*;

public class IO {

    public static void main(String[] args) {
        try (OutputStream out = new FileOutputStream("out.txt"); InputStream in = new FileInputStream("in.txt")) {
            //out.write();
        } catch (IOException ex) {

        }
    }

    /* Old way
    public static void main(String[] args) {
        try {
            OutputStream out = new FileOutputStream("out.txt");
        } catch (IOException ex) {

        } finally {
            out.close();
        }
    }
    */
}
