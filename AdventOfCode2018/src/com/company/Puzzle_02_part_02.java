package com.company;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Puzzle_02_part_02 {

    public static void main(String[] args) {

        System.out.println("Puzzle_02_part_02");

        int result = 0;
        String file = "C:\\Users\\Valon\\Documents\\NetBeansProjects\\AdventOfCode2018\\src\\inputFiles\\input02.txt";
        List<String> lines = new ArrayList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            for (String line; (line = br.readLine()) != null; ) {
                lines.add(line);
            }

            Collections.sort(lines);

            for (int i = 1; i < lines.size(); i++) {
                String before = lines.get(i - 1);
                String after = lines.get(i);
                int count = 0;
                int diffIdx = 0;
                for (int j = 0; j < before.length(); j++) {
                    if (before.charAt(j) != after.charAt(j)) {
                        count++;
                        diffIdx = j;
                    }
                    if (count > 1) break;
                }
                if (count == 1) {
                    after = new StringBuilder(after).deleteCharAt(diffIdx).toString();
                    System.out.println("result : " + after);
                    break;
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("finished");
    }
}
