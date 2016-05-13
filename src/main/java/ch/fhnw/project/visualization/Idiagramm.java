package ch.fhnw.project.visualization;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by FelixYeung on 13.05.16.
 */
public interface Idiagramm {


    String getXName();

    String getYName();

    List<Double> getXAxis();

    List<Double> getYAxis();
}
