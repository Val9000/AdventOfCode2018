package com.company;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.IntStream;

public class Puzzle_04_part_01 {

    public static void main(String[] args) {

        System.out.println("Puzzle_04_part_01");
        String file = "C:\\Users\\Valon\\Documents\\NetBeansProjects\\AdventOfCode2018\\src\\inputFiles\\input04.txt";
        ArrayList<String> lines = new ArrayList<>();
        HashMap<String, int[]> guards = new HashMap<>();


        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            for (String line; (line = br.readLine()) != null; ) lines.add(line);
            Collections.sort(lines);
            String currentID = "";
            boolean sleep = false;
            for (int i = 0; i < lines.size(); i++) {
                String line = lines.get(i);
                line = line.replace("[", "").replace("]", "");
                String[] s = line.split(" ");
                boolean containsGuard = line.contains("Guard");

                if (containsGuard) {
                    currentID = s[3];
                    if (!guards.containsKey(currentID)) guards.put(currentID, new int[59]);
                }

                Point time = getTime(s[1]);
                int minute = time.y;
                if (time.x != 23 && minute >= 0 && minute <= 59 && !containsGuard) {
                    int u = Integer.parseInt(lines.get(++i).replace("]", "").split(":")[1].split(" ")[0]);
                    System.out.println(u + "  " + currentID);
                    for (int start = minute; start < u; start++)
                        guards.get(currentID)[start]++;
                }
            }
            String maxID = "";
            int maxSleepSum = 0;

            for (Map.Entry<String, int[]> pair : guards.entrySet()) {
                String id = pair.getKey();
                int sum = IntStream.of(pair.getValue()).sum();
                if (sum > maxSleepSum) {
                    maxSleepSum = sum;
                    maxID = id;
                }
            }

            int mostOftenSleptMin = 0;
            int idx = 0;
            int[] arr = guards.get(maxID);

            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > mostOftenSleptMin) {
                    mostOftenSleptMin = arr[i];
                    idx = i;
                }
            }

            System.out.println("sleep minute on most days : " + idx + ".... id : " + maxID + " === " + idx * Integer.parseInt(maxID.replace("#", "")));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("finished");
    }

    public static Point getTime(String line) {
        String[] split = line.split(":");
        return new Point(Integer.parseInt(split[0]), Integer.parseInt(split[1]));
    }

}