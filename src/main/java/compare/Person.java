package compare;

public class Person implements Comparable<Person> {

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String name = null;
    private int age = 0;

    @Override
    public int compareTo(Person p){
        if(this.age > p.age) return 1;
        return (this.age == p.age) ? this.name.compareTo(p.name) : -1;
    }

    @Override
    public String toString(){
        return name + ":" + age;
    }

}
