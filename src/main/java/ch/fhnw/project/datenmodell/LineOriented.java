package ch.fhnw.project.datenmodell;

import ch.fhnw.project.App;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by FelixYeung on 11.05.16.
 */
public class LineOriented implements IdatenFuerDatenmodell{

    private File file;

    public LineOriented(File file) {
        this.file=file;
    }


    @Override
    public void getFile1(File file) {

            this.file=file;

    }

    @Override
    public List<String> getVarNameList() throws FileNotFoundException {
        List<String> testList = new ArrayList<>();
        testList.add("h");
        testList.add("d");
    return testList;
    }
}
