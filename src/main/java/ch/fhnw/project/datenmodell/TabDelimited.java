package ch.fhnw.project.datenmodell;

import ch.fhnw.project.App;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by FelixYeung on 11.05.16.
 */
public class TabDelimited extends App implements IdatenFuerDatenmodell{
    File file;


    @Override       // von Interface
    public void IgetFile(File file) {
        this.file=file;

    }



    public TabDelimited(File file) {
        this.file = file;
    }

    public File getFile() {
        return file;
    }


    public String getName() throws FileNotFoundException {
        return getListString().get(0);

    }

    public int getVarNumber() {
        int number = 0;
        String firstLine;
        int iterLine =0;

        try {
            Scanner scanner1 = new Scanner(getFile());

            firstLine = scanner1.nextLine();

            while(iterLine<firstLine.length()){

                if (firstLine.charAt(iterLine)== '\t')
                {
                    number++;
                }
                iterLine++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return number+1;
    }

    public List<String> getVarNameList () throws FileNotFoundException {

        List<String> varListName = new ArrayList<>();
        int count =0;
        for (String s : getListString()) {
            if (count < getVarNumber()){
                varListName.add(s);
                count++;
            }

        }
        return varListName;
    }

    public List<String> getListString() throws FileNotFoundException {
        Scanner scanner = new Scanner(getFile());

        List<String> list = new ArrayList<>();

        while (scanner.hasNext()) {
            scanner.useDelimiter("\t|\n");
            list.add(scanner.next());
        }
        return list;
    }

    public List<Double> getVarValue() throws FileNotFoundException {
        List<Double> doubleList = new ArrayList<>();
        List<String> stringList = new ArrayList<>(getListString());
        int removeVar=0;


      while (getVarNumber()> removeVar){
          stringList.remove(0);
          removeVar++;
      }

        for (String element : stringList) {
            doubleList.add(Double.valueOf(element));
        }
        return doubleList;
    }



}


