package Register;

import java.io.*;
import java.util.Scanner;

public class Data {
    private String name,email,username,password;
    private String temp;
    private String[] arr;

    public Data() {
        name = "";
        email = "";
        username = "";
        password = "";
        arr = null;
    }

    public boolean checkEmail(String email){
        File file = new File("data.txt");
        try {
            Scanner fsc = new Scanner(file);
            while(fsc.hasNext()) {
                temp = fsc.nextLine();
                arr = temp.split(" ");
                this.email = arr[1];
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
        return email.equals(this.email);
    }

    public boolean checkUsername(String username){
        File file = new File("data.txt");
        try {
            Scanner fsc = new Scanner(file);
            while(fsc.hasNext()) {
                temp = fsc.nextLine();
                arr = temp.split(" ");
                this.username = arr[2];
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
        return username.equals(this.username);
    }

    public boolean checkPassword(String password){
        File file = new File("data.txt");
        try {
            Scanner fsc = new Scanner(file);
            while(fsc.hasNext()) {
                temp = fsc.nextLine();
                arr = temp.split(" ");
                this.password = arr[3];
            }

        } catch (FileNotFoundException e) {
            System.err.println("File not found");
        }
        return password.equals(this.password);
    }

    public void addToFile(String name,String email,String username,String password){
        File file = new File("data.txt");

        try {
            FileOutputStream fos = new FileOutputStream(file,true);
            PrintWriter pw = new PrintWriter(fos);
            pw.print(name+" "+email+" "+username+" "+password+"\n");
            pw.close();
            fos.close();

        } catch (FileNotFoundException e) {
            System.err.println("File not found in addToFile");
        } catch (IOException e) {
            System.err.println("File Handling error");
        }
    }
}
