package com.optimaize.counter;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        printHelp();
        commandLoop(new Store());
    }

    static void commandLoop(Store store) {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            String line = scanner.nextLine();

            switch (line) {
                case "help":
                case "?":
                    printHelp();
                    break;
                case "counters":
                    printStats(store.counters());
                    break;
                case "averageLength":
                    printAverageLength(store.averageLength());
                    break;
                case "reset":
                    store.reset();
                    break;
                case "exit":
                    exit = true;
                    break;
                default:
                    store.put(line);
                    break;
            }
        }
    }

    private static void printHelp() {
        System.out.println("Supported commands: counters, averageLength, reset, exit, help");
        System.out.println("All other strings will be added to store");
    }

    private static void printStats(List<Map.Entry<String, Integer>> stats) {
        System.out.println("Total counters: " + stats.size());
        for (Map.Entry<?, ?> line: stats) {
            System.out.println(line.getKey() + ": " + line.getValue());
        }
    }

    private static void printAverageLength(double averageLength) {
        System.out.println("Average length: " + averageLength);
    }

}
