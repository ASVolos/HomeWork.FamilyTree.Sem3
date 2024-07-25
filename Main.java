package FamilyTree;

import FamilyTree.FamilyTree.FamilyTree;
import FamilyTree.Human.Gender;
import FamilyTree.Human.Human;
import FamilyTree.Writer.FileHandler;

import java.io.IOException;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FamilyTree familyTree = new FamilyTree();

        Human person1 = new Human("John", "Wick", LocalDate.of(1982, 1, 1),
                Gender.male);
        Human person2 = new Human("Natalie", "Portman", LocalDate.of(1989, 2, 3),
                Gender.female);
        Human person3 = new Human("Johnsson", "Wick Jr.", LocalDate.of(2007, 4, 15),
                Gender.male);
        Human person4 = new Human("Johnsdaughter", "Wick ", LocalDate.of(2012, 5, 23),
                Gender.female);
        Human person5 = new Human("Alex", "Wick ", LocalDate.of(2019, 12, 18),
                Gender.female);


        familyTree.addMember(person1);
        familyTree.addMember(person2);
        familyTree.addMember(person3);
        familyTree.addMember(person4);
        familyTree.addMember(person5);

        person1.getChildren().add(person3);
        person2.getChildren().add(person3);
        person1.getChildren().add(person4);
        person2.getChildren().add(person4);
        person1.getChildren().add(person5);
        person2.getChildren().add(person5);


//        compareTo() находится в Human, строка #82
        // сортировка по имени, метод находится в классе FamilyTree, строка #46
//        familyTree.sortByName();
        // сортировка по возрасту, метод находится в классе FamilyTree, строка #50
        familyTree.sortByAge();
        saveTree(familyTree);

        System.out.println(readTree());
    }

    private static void saveTree(FamilyTree familyTree) {
        FileHandler fileHandler = new FileHandler();
        fileHandler.serializeFamily(familyTree);
    }

    private static FamilyTree readTree() {
        FileHandler fileHandler = new FileHandler();
        return (FamilyTree) fileHandler.deserializeFamily();
    }
}