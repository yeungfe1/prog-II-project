package ch.fhnw.project.datenmodell;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by FelixYeung on 11.05.16.
 */
public interface IdatenFuerDatenmodell {

    //void IgetFile(File file);

    List<String> getListString() throws FileNotFoundException;


    int getVarNumber() throws FileNotFoundException;

/*

    String getName() throws FileNotFoundException;

    List<Double> getVarValue() throws FileNotFoundException;

    List<String> getVarNameList () throws FileNotFoundException;*/





}
