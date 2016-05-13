package ch.fhnw.project.visualization;

import ch.fhnw.project.datenmodell.*;

import ch.fhnw.project.datenmodell.LineOriented;

import java.util.List;

/**
 * Created by FelixYeung on 11.05.16.
 */
public class ScatterPlot implements Idiagramm{

     final List<String> liste;


    public ScatterPlot(List<String> list) {
        this.liste=list;
    }


    @Override
    public String getXName() {
        return null;
    }

    @Override
    public String getYName() {
        return null;
    }

    @Override
    public List<Double> getXAxis() {
        return null;
    }

    @Override
    public List<Double> getYAxis() {
        return null;
    }
}
