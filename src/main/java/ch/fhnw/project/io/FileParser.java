package ch.fhnw.project.io;

import java.util.*;

import ch.fhnw.project.datamodel.Variable;

import java.io.*;

public interface FileParser {

	List<Variable> readData(File file) throws IOException;

}


