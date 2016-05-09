package ch.fhnw.project;/**
 * Created by FelixYeung on 05.05.16.
 */

import javafx.scene.control.Alert;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class testClass {

    private final File file;

    public testClass(File file) {
        this.file = file;
    }

    private File getFile(){
        return file;
    }


    public int getVarnum() {
        int anzahl = 0;
        String bb;
        int n =0;


        try {
            Scanner scanner1 = new Scanner(getFile());

            bb = scanner1.nextLine();


            while(n<bb.length()){

                if (bb.charAt(n)== '\t')
                {
                    anzahl++;
                }
                n++;
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return anzahl+1;
    }


    public List<String> getList(){
        int n = 0;
        int b = getVarnum();          //for Variable
        HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();

        for(int i=0; i<b; i++) map.put("myList"+i,new ArrayList<String>());
        //List<String> serie = new ArrayList<>();

        try (Scanner scanner = new Scanner(getFile())) {

            while (scanner.hasNext()) {
                scanner.useDelimiter("\t|\n");

                while (n < b){
                    map.get("myList" + n).add(scanner.next());
                //serie.add(scanner.next());
                    n++;
            }
                n=0;
            }

            //have to implement into JAVAFX!!!!!!!!!!!!!
        } catch (FileNotFoundException e) {
            //System.err.println("Reading file failed: " + e.getMessage());

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Reading failed");
            alert.setHeaderText("Look, a Warning Dialog");
            alert.setContentText("Please try again!");

            alert.showAndWait();
        }
        return map.get("myList"+4);
    }


    public HashMap<String,ArrayList<String>> getMap(){
        int n = 0;
        int b = getVarnum();          //for Variable
        HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();

        for(int i=0; i<b; i++) map.put("myList"+i,new ArrayList<String>());
        //List<String> serie = new ArrayList<>();

        try (Scanner scanner = new Scanner(getFile())) {

            while (scanner.hasNext()) {
                scanner.useDelimiter("\t|\n");

                while (n < b){
                    map.get("myList" + n).add(scanner.next());
                    //serie.add(scanner.next());
                    n++;
                }
                n=0;
            }

            //have to implement into JAVAFX!!!!!!!!!!!!!
        } catch (FileNotFoundException e) {
            //System.err.println("Reading file failed: " + e.getMessage());

            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Reading failed");
            alert.setHeaderText("Look, a Warning Dialog");
            alert.setContentText("Please try again!");

            alert.showAndWait();
        }
        return map;
    }
}
