import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.nio.charset.StandardCharsets.UTF_8;
import java.io.IOException;

public class Bank {
    public static void main(String[] args) {
        String fIn = "Bank.dat";
        String fErr = "Bank.err";
        Map<String,Account> accs = readData(fIn,fErr);
        for (Map.Entry<String,Account> e : accs.entrySet()) {
            System.out.println(e.getValue());
            printall(e.getValue().tran);
        }

        try {
            String errLog = new String(Files.readAllBytes(Paths.get(fErr)), UTF_8);
            System.out.println("\nContent of " +
            "\"Bank.err\" follows:\n"
            );
            System.out.println(errLog);
        } catch (IOException e) {
            System.out.println("Problems With error log");
            return;
        }
    }
    private static Map<String, Account> readData(String fIn, String fErr) {
        Map<String,Account> mymap = new HashMap<>();
        int count = 0;
        String content = "";
        Account account = new Account();
        Person person = new Person();
        try {
            List<String> data = Files.readAllLines(Paths.get(fIn));
            for (String i : data) {
                count ++;
                String[] line = i.split(" ");
                int j = line.length;
                if (j == 4) {
                    int inb = Integer.parseInt(line[3]);
                    person = new Person(line[1], line[2]);
                    Transaction tr = new Transaction(line[0], person, inb, 0);
                    account = new Account(line[0], person, inb, tr);
                    String errLog = new String(Files.readAllBytes(Paths.get(fErr)), UTF_8);
                    content = errLog;
                    if (mymap.containsKey(line[0])) {
                        String err2 = "Line\t"+count+": " + account.getId() + " " + person + account.getBalance() ;
                        String err = "\tError: Account already exists";
                        //String errLog = new String(Files.readAllBytes(Paths.get(fErr)), UTF_8);
                        content = content.concat("\n" + err2 + "\n" + err);
                        Files.write(Paths.get(fErr), content.getBytes());
                    } else if (inb < 0) {
                        String err2 = "Line\t"+count+": " + account.getId() + " " + person + account.getBalance() ;
                        String err = "\tError: Initial deposit non-positive";
                        //String errLog = new String(Files.readAllBytes(Paths.get(fErr)), UTF_8);
                        content = content.concat("\n" + err2 + "\n" + err);
                        Files.write(Paths.get(fErr), content.getBytes());
                    } else 
                    mymap.put(line[0], account);
                }
                if (j == 2) {
                    String id = line[0];
                    int bal = Integer.parseInt(line[1]);
                    if (bal > 0) {
                        Account tmp = mymap.get(id);
                        Transaction ntr = new Transaction(line[0], null, bal, 1);
                        bal = bal+tmp.getBalance();
                        tmp.setBalance(bal);
                        tmp.tran.add(ntr);
                        mymap.replace(id, tmp);
                    } else if (bal < 0 && mymap.get(id).getBalance() < -bal) {
                        String err2 = "Line\t"+count+": " + account.getId() + " " + person + account.getBalance() ;
                        String err = "\tError: Insufficient funds";
                        //String errLog = new String(Files.readAllBytes(Paths.get(fErr)), UTF_8);
                        content = content.concat("\n" + err2 + "\n" + err);
                        Files.write(Paths.get(fErr), content.getBytes());
                    } else {
                        Account tmp = mymap.get(id);
                        Transaction ntr = new Transaction(line[0], null, bal, 2);
                        bal = tmp.getBalance()+bal;
                        tmp.setBalance(bal);
                        tmp.tran.add(ntr);
                        mymap.replace(id, tmp);
                    }
                }
                if (j == 3) {
                    String id = line[0];
                    String id2 = line[1];
                    int bal = Integer.parseInt(line[2]);
                    int bal2 = Integer.parseInt(line[2]);

                    if (mymap.get(id).getBalance() < bal) {
                        String err2 = "Line\t"+count+": " + account.getId() + " " + person + account.getBalance() ;
                        String err = "\tError: Insufficient funds";
                        //String errLog = new String(Files.readAllBytes(Paths.get(fErr)), UTF_8);
                        content = content.concat("\n" + err2 + "\n" + err);
                        Files.write(Paths.get(fErr), content.getBytes());
                    } else {
                        Account tmp1 = mymap.get(id);
                        Account tmp2 = mymap.get(id2);
                        Transaction ntr = new Transaction(tmp2.getId(), tmp2.getPerson(), -bal, 3);
                        
                        bal = tmp1.getBalance()-bal;
                        tmp1.setBalance(bal);
                        tmp1.tran.add(ntr);
                        mymap.replace(id, tmp1);
                        
                        Transaction ntr2 = new Transaction(tmp1.getId(), tmp1.getPerson(), bal2, 4);
                        bal2 = tmp2.getBalance()+bal2;
                        tmp2.setBalance(bal2);
                        tmp2.tran.add(ntr2);
                        mymap.replace(id2, tmp2);
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Problems With IN DATA");
        }
        return mymap;
    }
    public static void printall (Transaction i){
        while (!i.empty()) {
            System.out.println(i.get()); 
        }
    }
}

    class Account{
        private String id;
        private Person owner;
        private int balance;
        Transaction tran = new Transaction();
        
        Account(){
            this.id = null;
            this.owner = null;
        }
    
        Account(String i,Person p, int b, Transaction t){
            this.id = i;
            this.owner = p;
            this.balance = b;
            this.tran.add(t);
        }
    
        public String getId(){
            return this.id;
        }
        public int getBalance(){
            return this.balance;
        }
        public Person getPerson(){
            return this.owner;
        }
        public void setBalance(int balance) {
            this.balance = balance;
        }
    
        @Override
        public int hashCode() {
            return balance;
        }
    
        @Override
        public boolean equals(Object obj) {
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            Account acc = (Account) obj;
            return id.equals(acc.id);
        }
    
        @Override
        public String toString() {
            return "*** Acc " + id + " (" + owner + ") ." + " Balance: " + balance +  ". Transactions: " + "\n" + tran.get();
        }
    }
    
class Person {
    final private String firstName;
    final private String lastName;

    Person(){
        this.firstName = null;
        this.lastName = null;
    }

    Person(String fn, String ln){
        this.firstName = fn;
        this.lastName = ln;
    }

    public String getFname(){
        return this.firstName;
    }
    public String getLname(){
        return this.lastName;
    }

    @Override
    public String toString() {
        return " " + firstName + " " + lastName + " ";
    }
}

class Transaction {
    public static final int INIT_DEPOS = 0;
    public static final int DEPOSIT = 1;
    public static final int WITHDRAWAL = 2;
    public static final int TRANS_FROM = 3;
    public static final int TRANS_TO = 4;
    private static final String opTypes[] = { "Init depos ", "Deposit ", "Withdrawal ", "Trans. from", "Trans. to " };
    private int bal;
    private Transaction tail;
    private Transaction top;
    private String desc;
    private Person per;

    Transaction() {
    }

    Transaction(String s, Person p, int b, int op) {
        if (op == 0 || op == 1) {
            this.bal = b;
            this.desc = opTypes[op];
        } else if (op == 3) {
            this.bal = b;
            this.per = p;
            this.desc = opTypes[op] + " this account to" + per + s;
        } else if (op == 4) {
            this.bal = b;
            this.per = p;
            this.desc = opTypes[op] + " this account from" + per + s;
        } else if (op == 2) {
            this.bal = b;
            this.desc = opTypes[op];
        }
    }

    Transaction(Transaction t, Transaction b) {
        this.top = t;
        this.tail = b;
    }

    private Transaction body = null;

    void add(Transaction i) {
        this.body = new Transaction(i, body);
    }

    Transaction get() {
        Transaction d = body.top;
        body = body.tail;
        return d;
    }

    public boolean empty() {
        return body == null;
    }

    @Override
    public String toString() {
        return "\t" + bal + "\t: " + desc;
    }

}