
/*
Oasis Internships : Java Programming Internship
Task 2 : ATM Interface
Programmed By : Aditya Rajesh Sakhadeo  
*/


import java.util.*;
class validate {
    int user_id;
    int pin;
    static boolean val = false;
    Random random = new Random();
    Scanner sc = new Scanner(System.in);

    int genrate_userid() {
        user_id = random.nextInt(100);
        return user_id + 1;
    }

    int genrate_pin() {
        pin = random.nextInt(1111, 9999);
        return pin;
    }

    void check() {
        System.out.println("Your User-Id and Pin is:\nUser-Id-> " + user_id + "\nPin-> " + pin);
        System.out.println("Enter User-Id");
        int temp_user = sc.nextInt();
        System.out.println("Enter Pin");
        int temp_pin = sc.nextInt();

        if (temp_user == user_id & temp_pin == pin) {
            val = true;
        } else {
            System.out.println("Wrong pin try again.....");
            if (temp_user == user_id & temp_pin == pin) {
                val = true;
            }
        }

    }
}

class history extends deposite {
    deposite d = new deposite();
    private static List<String> history = new ArrayList<>();

    void showHistory() {
        if (history.isEmpty()) {
            System.out.println("No transaction history yet...\n");
            System.out.println("Current account balance is:" + d.amount);
        } else {
            System.out.println("Transaction history is:\n" + history);
            System.out.println("Current account balance is:" + d.amount);
        }
    }

    void makeLog(String str) {
        history.add(str);
    }
}

class deposite {
    static int amount = 0;

    void addAmount(int amt) {
        if (amt < 0) {
            System.out.println("Enter valid amount\n");
        } else {
            amount += amt;
            System.out.println(("Amount Deposited Sucessfully....\n"));
        }
    }
}

class withdraw extends deposite {
    deposite d = new deposite();

    void reduceAmount(int amt) {
        if (amt > d.amount) {
            System.out.println("Not enough account balance!!!!");
        } else if (amt < 0) {
            System.out.println("Enter valid amount\n");
        } else {
            d.amount -= amt;
            System.out.println("Amount Deducted...\n");
        }
    }
}

class transfer extends deposite {
    int acn_no;
    deposite d = new deposite();
    Scanner sc = new Scanner(System.in);

    void transferAmount(int pin_transfer, int pin, int amt) {
        if (amt > d.amount) {
            System.out.println("Not enough account balance!!!!");
        } else if (amt < 0) {
            System.out.println("amount can not be negative!!!!");
        } else {
            System.out.println("Enter the account number: ");
            acn_no = sc.nextInt();
            if (pin_transfer == pin) {
                d.amount -= amt;
                System.out.println("Amount transferred to account " + acn_no + "\n");
            }
        }
    }
}

public class Task2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int user_id, pin, option, amt_temp, pin_temp;
        boolean terminate = true;
        validate v1 = new validate();
        history h1 = new history();
        deposite d1 = new deposite();
        withdraw w1 = new withdraw();
        transfer t1 = new transfer();

        System.out.println("Welcome to ATM interface.....\n");
        user_id = v1.genrate_userid();
        pin = v1.genrate_pin();
        v1.check();
        v1.check();

        while (terminate & v1.val) {
            System.out.println("*****************************************************");
            System.out.println("Choose the Operation:");
            System.out.println("1:Transaction History\n2:Deposite\n3:Withdraw\n4:Tranfer\n5:Quit");
            System.out.println("*****************************************************");
            System.out.println("Enter Operation: ");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    h1.showHistory();
                    break;

                case 2:
                    System.out.println("Enter the amount to deposite: ");
                    amt_temp = sc.nextInt();
                    d1.addAmount(amt_temp);
                    h1.makeLog("Amount Deposited: " + amt_temp);
                    break;

                case 3:
                    System.out.println("Enter the amount to withdraw: ");
                    amt_temp = sc.nextInt();
                    w1.reduceAmount(amt_temp);
                    if (d1.amount < amt_temp) {
                        h1.makeLog("Amount Withdraw: " + amt_temp + " (failed)");
                        break;
                    }
                    h1.makeLog("Amount Withdraw: " + amt_temp);
                    break;

                case 4:
                    System.out.println("Enter pin: ");
                    pin_temp = sc.nextInt();
                    System.out.println("Enter the amount to transfer: ");
                    amt_temp = sc.nextInt();
                    t1.transferAmount(pin_temp, pin, amt_temp);
                    if (d1.amount < amt_temp) {
                        h1.makeLog("Amount transferred: " + amt_temp + " (failed)");
                        break;
                    }
                    h1.makeLog("Amount transferred: " + amt_temp);
                    break;

                case 5:
                    System.out.println("Thank you for using ATM interface...\n");
                    terminate = false;
                    break;

                default:
                    System.out.println("Enter the correct operation number\n");
                    break;

            }
        }

    }
}
