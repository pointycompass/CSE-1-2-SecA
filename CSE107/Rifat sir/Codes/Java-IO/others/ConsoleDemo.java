package others;

import java.io.Console;

class ConsoleDemo {
    public static void main(String args[]) throws Exception {
        String userName, password;
        Console con = System.console();
        if (con == null) return;
        userName = con.readLine("Enter UserName:");
        char p[] = con.readPassword("Enter Password:");
        password = new String(p);
        con.printf("UserName:%s\n", userName);
        con.printf("Password:%s\n", password);
    }
}