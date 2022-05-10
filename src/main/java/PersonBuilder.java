import java.util.OptionalInt;

public class PersonBuilder {
    private String name;
    private String surname;
    private OptionalInt age;
    private String address;

    public PersonBuilder() {

    }

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = OptionalInt.of(age);
        if (age < 0) {
            throw new IllegalArgumentException("Указан не корректный возраст " + age);
        }
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        if (name == null || surname == null || age == null || address == null) {
            throw new IllegalArgumentException("Не все данные добавлены");
        }
        return new Person(name, surname, age.getAsInt(), address);


    }
}
