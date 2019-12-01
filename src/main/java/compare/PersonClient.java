package compare;

import java.util.*;

public class PersonClient {

    public static void main(String[] args) {
        Person p1 = new Person("a", 10);
        Person p2 = new Person("b", 10);
        Person p3 = new Person("c", 9);

        List<Person> persons = new ArrayList<>();
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);

        //persons.sort(Person::compareTo);
        //Collections.sort(persons);

        Collections.sort(persons, new PersonComparator());
        System.out.println(persons.toString());
    }

    static class PersonComparator implements Comparator<Person> {
        @Override
        public int compare(Person p, Person q){
            if(p.getAge() < q.getAge()) return 1;
            return (p.getAge() == q.getAge()) ? q.getName().compareTo(p.getName()) : -1;
        }
    }
}
