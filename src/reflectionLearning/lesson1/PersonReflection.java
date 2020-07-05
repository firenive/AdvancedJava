package reflectionLearning.lesson1;
@AuthorReflection(name = "Maks" , dateOfCreation = 2020)
public class PersonReflection {
    private int id;
    private String name;
    public String notDeclared;

    public PersonReflection() {
        this.id = -1;
        this.name = "No name";
    }
    public PersonReflection(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public void sayHello() {
        System.out.println("Person with id: " + id + " and name " + name + " says Hello!");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "PersonReflection{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
