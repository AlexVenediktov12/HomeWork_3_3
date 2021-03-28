package ru.geekbrains.HomeWork_3_3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

    }
    public static void writeToByteArray() throws IOException { // task 1
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("someFile.txt"));
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        int x;
        while ((x = in.read()) != -1) {
            out.write(x);
        }

        byte[] b = out.toByteArray();
        System.out.println(Arrays.toString(b));

        in.close();
        out.close();
    }

    public static void fiveFilesToOne() throws IOException {

        ArrayList<InputStream> al = new ArrayList<>();
        al.add(new FileInputStream("someFile1.txt"));
        al.add(new FileInputStream("someFile2.txt"));
        al.add(new FileInputStream("someFile3.txt"));
        al.add(new FileInputStream("someFile4.txt"));
        al.add(new FileInputStream("someFile5.txt"));

        BufferedInputStream in = new BufferedInputStream(new SequenceInputStream(Collections.enumeration(al)));
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream("FinalFile.txt"));

        int x;
        while ((x = in.read()) != -1) {
            out.write(x);
        }

        in.close();
        out.close();
    }

    public static void readPage() throws IOException {

        final int PAGE = 1800;
        RandomAccessFile raf = new RandomAccessFile("someFile.txt", "r");

        System.out.println("Введите страницу: ");

        int page = 5;
        raf.seek(page * PAGE);

        byte[] barr = new byte[1800];
        raf.read(barr);

        System.out.println(new String(barr));
        raf.close();

    }

}
