import java.util.OptionalInt;

public class Person {
    protected final String name;
    protected  final  String surname;
    protected   OptionalInt age;
    public String address;

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this(name, surname);
        this.age = OptionalInt.of(age);
    }

    public Person(String name, String surname, int age, String address) {
        this(name, surname, age);
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String setAddress(String address) {
        this.address = address;
        return address;
    }

    public boolean hasAge () {
        return this.age.isPresent();
    }

    public boolean hasAddress () {
        return this.address != null;
    }

    public void birthday () {
        this.age = OptionalInt.of(this.age.getAsInt() + 1);
    }

    public PersonBuilder newChildBuilder () {
        return new PersonBuilder()
                .setSurname(this.surname)
                .setAge(0)
                .setAddress(this.address);
    }

    @Override
    public String toString() {
        return "Person:" +
                "\n name = " + name +
                "\n surname = " + surname +
                "\n age = " + age +
                "\n address = " + address;
    }


}
