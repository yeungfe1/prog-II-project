package ch.fhnw.project.datenmodell;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by FelixYeung on 11.05.16.
 */
public class TabDelimitedFormat implements datenFuerDatenmodell {

    final File file;


    public TabDelimitedFormat(File file) {
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


}


