package ch.fhnw.project.io;

import ch.fhnw.project.datenmodell.DataModel;

import java.io.File;
import java.util.List;

public interface FileParser {

	public void readData(File file);
	public List<DataModel> getList();
}
