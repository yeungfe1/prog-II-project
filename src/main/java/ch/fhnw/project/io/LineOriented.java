package ch.fhnw.project.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

import ch.fhnw.project.datamodel.Variable;

public class LineOriented implements FileParser{

	private int countVar;
	private char delimiter;


	@Override
	public List<Variable> readData(File file) throws IOException {

		List<Variable> lstData = new ArrayList<>();
		String line;
		FileReader fileReader = new FileReader(file);
		BufferedReader br = new BufferedReader(fileReader);
		countVar = Integer.parseInt(br.readLine());

		for(int i = 0; i < countVar; i++){

			lstData.add(new Variable(br.readLine()));
		}

		delimiter = br.readLine().charAt(0);

		double steps = 100/countVar;

		for(int i = 0; i < countVar; i++) {
			line = br.readLine();
			String[] splitted = line.split(delimiter + "");
			for (String s : splitted) {
				lstData.get(i).addValue(Double.parseDouble(s));
			}
		}

		return lstData;
	}
}
