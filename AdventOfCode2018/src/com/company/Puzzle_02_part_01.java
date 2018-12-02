package com.company;

import com.sun.xml.internal.ws.util.StringUtils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class Puzzle_02_part_01 {

    public static void main(String[] args) {

        System.out.println("Puzzle_01_part_01");
        int countTwice = 0, countThirds = 0;
        int result = 0;
        String file = "C:\\Users\\Valon\\Documents\\NetBeansProjects\\AdventOfCode2018\\src\\inputFiles\\input02.txt";


        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            for (String line; (line = br.readLine()) != null; ) {
                boolean foundTwice = false, foundThirds = false;
                for (int i = 0; i < line.length(); i++) {
                    char c = line.charAt(i);
                    int count = line.length() - line.replaceAll(Character.toString(c), "").length();
                    if (count == 2 && !foundTwice) {
                        countTwice++;
                        foundTwice = true;
                    }
                    if (count == 3 && !foundThirds) {
                        countThirds++;
                        foundThirds = true;
                    }
                    if (foundThirds && foundTwice) break;
                }
            }

            result = countTwice * countThirds;
            System.out.println("result : " + result + " = " + countTwice + "*" + countThirds);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("finished");
    }
}
