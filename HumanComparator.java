package FamilyTree.Human;

import java.time.LocalDate;
import java.time.Period;
import java.util.Comparator;

public class HumanComparator implements Comparator<Human> {

    @Override
    public int compare(Human o1, Human o2) {
        return Period.between(o1.getBirthDate(), LocalDate.now()).getYears()
                - Period.between(o2.getBirthDate(), LocalDate.now()).getYears();
    }
}