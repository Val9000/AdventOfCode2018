package com.company;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Puzzle_03_part_01 {

    public static void main(String[] args) {

        System.out.println("Puzzle_03_part_01");
        String file = "C:\\Users\\Valon\\Documents\\NetBeansProjects\\AdventOfCode2018\\src\\inputFiles\\input03.txt";

        String[][] map = new String[1500][1500];
        int count = 0;
        try {

            BufferedReader br = new BufferedReader(new FileReader(file));
            for (String line; (line = br.readLine()) != null; ) {
                int startY, startX, x, y;
                String id;
                line = line.replaceAll("[ ,:#@x]", ":");
                final String[] splits = line.split(":");
                id = splits[1];
                startY = Integer.parseInt(splits[4]);
                startX = Integer.parseInt(splits[5]);
                y = Integer.parseInt(splits[7]);
                x = Integer.parseInt(splits[8]);


                for (int i = startY; i < y + startY; i++) {
                    for (int j = startX; j < x + startX; j++) {
                        if (map[i][j] == null) map[i][j] = id;

                        else if (map[i][j] != "X" && map[i][j] != null) {
                            map[i][j] = "X";
                            count++;
                        }
                    }
                }
            }

            System.out.println("count : " + count);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("finished");
    }


}
//System.out.println("id : " + id + "  StartY : " + startY + "  startX : " + startX + " y : " + y + "  x: " + x);