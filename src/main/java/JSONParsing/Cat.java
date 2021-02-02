package JSONParsing;

public class Cat {

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }
   public Cat(){}

    public  String name;
    public  int age ;

}
