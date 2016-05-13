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
public class LineOriented implements IdatenFuerDatenmodell{

    private File file;

    public LineOriented(File file) {
        this.file=file;
    }

    public File getFile() {
        return file;
    }


    /*@Override
    public void IgetFile(File file) {
        this.file = file;
    }
*/
    @Override
    public int getVarNumber() throws FileNotFoundException {
        Scanner scanner = new Scanner(getFile());
        return Integer.parseInt(scanner.next());
    }

    @Override
    public List<String> getListString() throws FileNotFoundException {
        Scanner scanner = new Scanner(getFile());
        List<String> fileToList = new ArrayList<>();

        while (scanner.hasNext()){
            scanner.useDelimiter(";|\n");

            while(scanner.hasNext()){
                fileToList.add(scanner.next());
            }
        }

        fileToList.remove(0);

        for(int rem =0;rem < getVarNumber();rem++){
            fileToList.remove(getVarNumber());
        }
        return fileToList;
    }


}
