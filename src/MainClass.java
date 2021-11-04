import org.w3c.dom.ls.LSOutput;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

public class MainClass {

    public static void main(String[] args) throws IOException {

        GridLayout gridLayout = new GridLayout();

        // Creates the Array list of Phones and adds each to that list
        ArrayList<Phone> phones = new ArrayList<Phone>();

        Phone p1 = new Phone("Sony", "Experia X", 32,12.5,4.6,"Yes",150);
        Phone p2 = new Phone("Sony", "Experia Y", 64,14.2,5.6,"Yes",175);
        Phone p3 = new Phone("Samsung", "Galaxy M", 64,14.5,5.4,"Yes",180);
        Phone p4 = new Phone("Nokia", "3330", 16,13.2,2.3,"No",90);
        Phone p5 = new Phone("Motorola", "M1", 8,11.3,4.9,"Yes",100);
        Phone p6 = new Phone("Iphone", "6", 32,13.5,6.4,"Yes",250);
        Phone p7 = new Phone("Alcatel", "A3", 8,9.3,2.4,"No",50);

        phones.add(p1);
        phones.add(p2);
        phones.add(p3);
        phones.add(p4);
        phones.add(p5);
        phones.add(p6);
        phones.add(p7);

        //Creates the Serialization file and adds each phone to the file

        try{
            FileOutputStream fileOut = new FileOutputStream("phone.ser");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

                for (Phone p : phones){
                    objectOut.writeObject(p);
                    System.out.println("Make: " + p.getMake() + ", Model: " + p.getModel() + ", Memory (GB): " + p.getMemory() + ", Camera(MP): " + p.getCamera() + ", Screesize: " + p.getScreenSize() + ", Smart: " + p.getSmart() + ", Price: " + p.getPrice());

                }
            System.out.println("File Serialized");
            System.out.println("*************************************************************");
            System.out.println();
            objectOut.close();

        }catch (FileNotFoundException e){
            //TODO Auto-generated catch block
            e.printStackTrace();
        }

        //Deserializes the file
        try {
            FileInputStream fileIn = new FileInputStream("phone.ser");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            for (Phone p : phones){
                p = (Phone) objectIn.readObject();
                System.out.println("Make: " + p.getMake() + ", Model: " + p.getModel() + ", Memory (GB): " + p.getMemory() + ", Camera(MP): " + p.getCamera() + ", Screesize: " + p.getScreenSize() + ", Smart: " + p.getSmart() + ", Price: " + p.getPrice());
            }
            System.out.println("File DeSerialized");
            System.out.println("*************************************************************");

            objectIn.close();
        }catch (FileNotFoundException | ClassNotFoundException e){
            e.printStackTrace();
        }

        // Remove Alcatel Phone from list and print list

        System.out.println();
        System.out.println("*********** Removing Alcatel from list  *******");
        phones.remove(6);
        for (Phone p : phones){
            System.out.println("Make: " + p.getMake() + ", Model: " + p.getModel() + ", Memory (GB): " + p.getMemory() + ", Camera(MP): " + p.getCamera() + ", Screesize: " + p.getScreenSize() + ", Smart: " + p.getSmart() + ", Price: " + p.getPrice());
        }

        // Add new phone to list and print list
        System.out.println();
        System.out.println("*********** Adding New Phone to the list  *******");
        Phone p8 = new Phone("Samsung", "Galaxy S12", 128,16.0,7.0,"Yes",450);
        phones.add(p8);
        for (Phone p : phones){
            System.out.println("Make: " + p.getMake() + ", Model: " + p.getModel() + ", Memory (GB): " + p.getMemory() + ", Camera(MP): " + p.getCamera() + ", Screesize: " + p.getScreenSize() + ", Smart: " + p.getSmart() + ", Price: " + p.getPrice());
        }
        System.out.println("*****************************************************");
        System.out.println();

        // Deleting existing file and re-serializing it again after changes
        System.out.println("************* Deleting File to re-serialize  *****************");
        System.out.println("file Deleted");
        System.out.println();
        System.out.println();

        File file = new File("phone.ser");
        file.delete();

        //Serialization a second time
        try{
            FileOutputStream fileOut = new FileOutputStream("phone.ser");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);

            for (Phone p : phones){
                objectOut.writeObject(p);
                System.out.println("Make: " + p.getMake() + ", Model: " + p.getModel() + ", Memory (GB): " + p.getMemory() + ", Camera(MP): " + p.getCamera() + ", Screesize: " + p.getScreenSize() + ", Smart: " + p.getSmart() + ", Price: " + p.getPrice());

            }
            System.out.println("File Serialized");
            System.out.println("*************************************************************");
            System.out.println();
            objectOut.close();

        }catch (FileNotFoundException e){
            //TODO Auto-generated catch block
            e.printStackTrace();
        }

        //Deserialization a second time
        try {
            FileInputStream fileIn = new FileInputStream("phone.ser");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            for (Phone p : phones){
                p = (Phone) objectIn.readObject();
                System.out.println("Make: " + p.getMake() + ", Model: " + p.getModel() + ", Memory (GB): " + p.getMemory() + ", Camera(MP): " + p.getCamera() + ", Screesize: " + p.getScreenSize() + ", Smart: " + p.getSmart() + ", Price: " + p.getPrice());
            }
            System.out.println("File DeSerialized");
            System.out.println("*************************************************************");

            objectIn.close();
        }catch (FileNotFoundException | ClassNotFoundException e){
            e.printStackTrace();
        }

        // Set the action Listener for button 1 to show the array data
        gridLayout.b1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
               String arrayData = "";
                for (Phone p : phones){

                 arrayData   += "\nMake: " + p.getMake() + ", Model: " + p.getModel() + ", Memory (GB): " + p.getMemory() + ", Camera(MP): " + p.getCamera() + ", Screesize: " + p.getScreenSize() + ", Smart: " + p.getSmart() + ", Price: " + p.getPrice() + "\n";

                    gridLayout.t1.setText(arrayData);
            }

            }

        });

        // Set the action Listener for button 2 to hide the array Data
        gridLayout.b2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gridLayout.t1.setText("");
            }

        });
    }
}
