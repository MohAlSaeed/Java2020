import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.util.Date;

public class Person implements  myinterface{
    int age;
    int mage;
    String dob;
    String name;
    String whattosay;
    int maxage;

    Date tod = new Date();
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    Date d1;
    Person(String dob, String n, String s, int max) throws ParseException {
        this.dob = dob;
        this.d1 = df.parse(dob);
        this.name = n;
        this.whattosay = s;
        this.maxage = max;
    }

    @Override
    public int yourage() {
        this.age = tod.getYear() - d1.getYear();
        return age;
    }

    @Override
    public int youragemonth() {
        this.mage = tod.getMonth() - d1.getMonth();
        return mage;
    }

    @Override
    public String say() {
        return whattosay;
    }

    @Override
    public String older() {
        this.age = tod.getYear() - d1.getYear();
        if (age < maxage) {
            return " You are still on milk :-) ";
        } else
        return "You are big enough";
    }

    @Override
    public String toString() {
        return "name = " + name +
                ", age = " + yourage() + " and " + youragemonth() + " months "+ '\n' +
                "Date Of Birth = " + d1 + '\n' +
                "today Date = " + tod + '\n' +
                "Older than Maxage = " + older() + '\n' +
                name + " says ( " + say() + " )."
                ;
    }
}
