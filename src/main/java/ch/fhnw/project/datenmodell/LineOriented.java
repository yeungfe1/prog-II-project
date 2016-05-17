package ch.fhnw.project.datenmodell;

import ch.fhnw.project.App;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

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
        Scanner scanner1 = new Scanner(getFile());
        List<String> fileToList0 = new ArrayList<>();
        List<String> fileToList = new ArrayList<>();
        List<String> separatedList = new ArrayList<>();

    /*    while(scanner1.hasNextLine()){
            scanner1.useDelimiter()
        }*/

        while (scanner.hasNextLine()){
            scanner.useDelimiter(";|\n");
            fileToList.add(scanner.nextLine());
        }

        for (String s : fileToList) {
            fileToList0.add(s);
        }



        for(int rem =0;rem < getVarNumber()+2;rem++){
            fileToList.remove(0);
        }

        /*HashMap<String,ArrayList<String>> map = new HashMap<String,ArrayList<String>>();

        for(int i=0; i<getVarNumber(); i++) {
            map.put("items" + i,Arrays.asList(fileToList.get(0).split(";")));
        }


        for (int count =0; count != map.get("items"+0).size();count++) {
            for (int i = 0; i < getVarNumber(); i++) {
                separatedList.add(map.get("items" + i).get(count));
            }
        }*/
        List<String> items1 = Arrays.asList(fileToList.get(0).split(";"));
        List<String> items2 = Arrays.asList(fileToList.get(1).split(";"));


        for (int count =0; count != items1.size();count++) {
            separatedList.add(items1.get(count));
            separatedList.add(items2.get(count));

        }

/*        fileToList.remove(0);

        for(int rem =0;rem < getVarNumber();rem++){
            fileToList.remove(getVarNumber());
        }*/


        for(int i = getVarNumber(); i>=0; i--){
            separatedList.add(0,fileToList0.get(i));
        }

        return separatedList;
    }




}
