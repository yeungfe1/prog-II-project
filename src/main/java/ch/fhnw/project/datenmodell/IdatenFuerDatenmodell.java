package ch.fhnw.project.datenmodell;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by FelixYeung on 11.05.16.
 */
public interface IdatenFuerDatenmodell {

    void getFile1(File file);



    List<String> getVarNameList () throws FileNotFoundException;

}
