package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class Puzzle_01_part_02 {

    public static void main(String[] args) {

        System.out.println("Puzzle_01_part_02");

        String file = "C:\\Users\\Valon\\Documents\\NetBeansProjects\\AdventOfCode2018\\src\\inputFiles\\input01.txt";
        int result = 0;
        HashSet<Integer> results = new HashSet<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            boolean found = false;
            do{
                for(String line; (line = br.readLine()) != null; ) {
                    result += Integer.parseInt(line);
                    if(!results.add(result)) {
                        System.out.println("result : " + result);
                        found = true;
                        break;
                    }
                }
                br = new BufferedReader(new FileReader(file));
            }while(!found);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("finished");
    }
}
