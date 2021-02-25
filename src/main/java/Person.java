public class Person {
    String id;
    String name;
    String sex;
    String date;
    Division div;
    String salary;

    public Person(String Id, String Name, String Sex, String Date, String Salary, Division Div){
        this.id = Id;
        this.name = Name;
        this.sex = Sex;
        this.date = Date;
        this.salary = Salary;
        this.div = Div;

    }

    //public Person(String id, String name, String sex, String date, String s, Division division) { }

    public void setId(String Id) { id = Id; }
    public String getId() { return id; }

    public void setName(String Name) { name = Name; }
    public String getName(){ return name; }

    public void setSex(String Sex) { sex = Sex; }
    public String getSex() { return sex; }

    public void setName(Division Div) { div = Div; }
    public Division getDiv() { return div; }

    public void setSalary(String Salary) { salary = Salary; }
    public String getSalary() { return salary; }

    public void setDate(String Date) { date = Date; }
    public String getDate() { return this.date; }
}
