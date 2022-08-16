package DefineAnInterfacePerson;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String information = scanner.nextLine();
        List<Birthable> livingBeings = new ArrayList<>();

        while (!information.equals("End")){
            String[] splittetInformation = information.split("\\s+");
            switch (splittetInformation[0]){
                case "Citizen":
                    livingBeings.add(new Citizen(splittetInformation[1],Integer.parseInt(splittetInformation[2]),splittetInformation[3],splittetInformation[4]));
                    break;
                case "Pet":
                    livingBeings.add(new Pet(splittetInformation[1],splittetInformation[2]));
                    break;
            }
            information = scanner.nextLine();
        }
        String year = scanner.nextLine();
        livingBeings.stream().filter(livingBeing -> livingBeing.getBirthDate().endsWith(year)).map(livingBeing -> livingBeing.getBirthDate()).forEach(System.out::println);

        scanner.close();
    }
}
