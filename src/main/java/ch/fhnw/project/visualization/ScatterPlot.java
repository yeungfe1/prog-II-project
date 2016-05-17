package ch.fhnw.project.visualization;

import ch.fhnw.project.datenmodell.*;

import ch.fhnw.project.datenmodell.LineOriented;

import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;

/**
 * Created by FelixYeung on 11.05.16.
 */
public class ScatterPlot implements Idiagramm{

     final List<String> liste;


    public ScatterPlot(List<String> list) {
        this.liste=list;
    }


    private List<String> getList(){return liste;}



    private int getNumberOfVariable(){
        return Integer.parseInt(getList().get(0));
    }


    private List<String> getListofName(){
        List<String> list = new ArrayList<>();
        for(int i = 0; i<getNumberOfVariable();i++){
            list.add(getList().get(i+1));
        }
        return list;
    }

    private List<Double> getListInDouble(){
        List<String> list = new ArrayList<>();
        List<Double> listToDouble = new ArrayList<>();

        for (String s : getList()) {
            list.add(s);
        }

        for(int i=0; i<=getNumberOfVariable();i++){
            list.remove(0);
        }

        for (String s : list) {
            listToDouble.add(Double.parseDouble(s));
        }

        return listToDouble;
    }



    @Override
    public String  getXName(int number) {

        return getListofName().get(number);
    }

    @Override
    public String getYName(int number) {
        return getListofName().get(number);
    }

    @Override
    public List<Double> getXAxis(int number) {
        List<Double> listDouble = new ArrayList<>();

        for (int i =0;i<getListInDouble().size();i++) {

            if(i==number){
                listDouble.add(getListInDouble().get(i));
                number=number+getNumberOfVariable();
            }
        }
        return listDouble;
    }

    @Override
    public List<Double> getYAxis(int number) {
        List<Double> listDouble = new ArrayList<>();

        for (int i = 0; i < getListInDouble().size(); i++) {

            if (i == number) {
                listDouble.add(getListInDouble().get(i));
                number = number + getNumberOfVariable();
            }
        }
        return listDouble;
    }

}
