package pl.com.bottega.Kolekcje;

import java.util.*;

public class PersonUtils {

    public static int firstIndexOver20 (List<Person> persons) {
        int index = 0;

        for ( Person person : persons)
            if (person.getAge() >20 )
                return index;
        index++;
        return -1;

    }
    public static int firstIndexOver20Iterator(List<Person> persons) {

        for (ListIterator<Person> i = persons.listIterator(); i.hasNext();) {
            Person person = i.next();
            if (person.getAge() >20)
                return i.previousIndex();
        }
        return -1;
    }

    public static void displaySortedPeople(Collection<Person> people) {
        List<Person> peopleList = new ArrayList<>(people);
        peopleList.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int compareLastName = o1.getLastName().compareTo(o2.getLastName());
                if (compareLastName == 0) {
                    int compareFirstName = o1.getFirstName().compareTo(o2.getFirstName());
                    if (compareFirstName == 0) {
                        return o1.getAge().compareTo(o2.getAge());

                    } else
                        return compareFirstName;
                }else
                return compareLastName;

            }
        });



        for (Person person : peopleList)
            System.out.println(person);




    }


    public static List<Person> listOver20 ( Set<Person> people) {
        List<Person> sortedPeople = new LinkedList<>(people);
        sortedPeople.sort(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.getAge().compareTo(o2.getAge());
            }
        });
        for (Iterator<Person> i = sortedPeople.iterator(); i.hasNext();)
            if (i.next().getAge() <=20)
                i.remove();
        else
            break;
        return sortedPeople;

    }

    public static boolean containsPerson(Set<Person> people, String firstName, String lastName, Integer age) {
        return people.contains(new Person(firstName,lastName,age));
    }

    public static Map<Integer, Integer> ageMap ( Collection<Person> people) {

        Map<Integer, Integer> peopleMap = new HashMap<>();

        for ( Person person : people) {
            Integer currentCount = peopleMap.get(person.getAge());
            if (currentCount == null)
                peopleMap.put(person.getAge(), 1);
            else
                peopleMap.put(person.getAge(), currentCount + 1);
        }
        return peopleMap;



    }

    public static void main(String[] args) {

        Person p1 = new Person( "Jan", "Nowak", 17);
        Person p2 = new Person ("Janina", "Nowak", 22);
        Person p3 = new Person("John", "Doe", 30);

        List<Person> people = new LinkedList<>();
        people.add(p1);
        people.add(p2);
        people.add(p3);

        System.out.println(firstIndexOver20(people));
        System.out.println(firstIndexOver20Iterator(people));
        displaySortedPeople(people);

    Set<Person> personSet = new HashSet<Person>();
    personSet.add(p1);
    personSet.add(p2);
    personSet.add(p3);

}
}
