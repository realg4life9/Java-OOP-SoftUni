package SortByNameAndAge;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        Team team = new Team("Black Eagles");
        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        List<Person> people = new ArrayList<>();

        for (int i = 0; i < numberOfPeople; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            team.addPlayer(new Person(input[0], input[1], Integer.parseInt(input[2]),Double.parseDouble(input[3])));
        }

        System.out.printf("Firs team have %d players",team.getFirstTeam().size());
        System.out.printf("Reserve team have %d players",team.getReserveTeam().size());
    }

}
