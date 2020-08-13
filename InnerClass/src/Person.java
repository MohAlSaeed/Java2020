public class Person {
    String name;
    int age;
    String doe;
    String comp;
    int salary;

    Person(String n, int age, String doe, String comp, int salary){
        this.name = n;
        this.age= age;
        this.doe = doe;
        this.comp = comp;
        this.salary = salary;
    }
    class Work{
        String doe;
        String comp;
        int salary;

        Work(String doe, String comp, int salary){
            this.doe = doe;
            this.comp = comp;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return " Date of Employeement='" + doe + '\'' +
                    ", company name='" + comp + '\'' +
                    ", salary=" + salary
                    ;
        }
    }
    public Work getjobdetails(String doe, String comp, int salary){
        Work job = new Work(doe, comp, salary);
        return job;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", Job details= { " + getjobdetails(doe, comp, salary) +
                " }"+ '}';
    }
}
