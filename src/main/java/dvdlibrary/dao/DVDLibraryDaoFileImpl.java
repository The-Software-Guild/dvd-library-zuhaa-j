package dvdlibrary.dao;

import dvdlibrary.dto.DVD;

import java.io.*;
import java.util.*;

public class DVDLibraryDaoFileImpl implements DVDLibraryDao{
    private Map<String, DVD> dvds = new HashMap<>();

    private final String DVD_LIBRARY_FILE;

    public DVDLibraryDaoFileImpl(){
        DVD_LIBRARY_FILE = "dvdlibrary.txt";
    }

    public DVDLibraryDaoFileImpl(String dvdLibraryTextFile){
        DVD_LIBRARY_FILE = dvdLibraryTextFile;
    }

    public static final String DELIMITER = "::";

    public DVD addDVD(String title, DVD dvd) throws DVDLibraryDaoException{
        loadLibrary();
        DVD newDVD = dvds.put(title, dvd);
        writeLibrary();
        return newDVD;
    }

    public DVD removeDVD(String title) throws DVDLibraryDaoException{
        loadLibrary();
        DVD removedDVD = dvds.remove(title);
        writeLibrary();
        return removedDVD;
    }

    public DVD editDVD(String title, DVD dvd) throws DVDLibraryDaoException{
        loadLibrary();
        DVD editedDVD = dvds.replace(title, dvd);
        writeLibrary();
        return null;
    }

    public List<DVD> getAllDVDs() throws DVDLibraryDaoException{
        loadLibrary();
        return new ArrayList(dvds.values());
    }

    public DVD getDVD(String title) throws DVDLibraryDaoException{
        loadLibrary();
        return dvds.get(title);
    }

    private DVD unmarshallDVD(String dvdAsText){
        String [] dvdTokens = dvdAsText.split(DELIMITER);
        String title = dvdTokens[0];
        DVD dvdFromFile = new DVD(title);
        dvdFromFile.setReleaseDate(dvdTokens[1]);
        dvdFromFile.setMPAARating(dvdTokens[2]);
        dvdFromFile.setDirectorName(dvdTokens[3]);
        dvdFromFile.setStudio(dvdTokens[4]);
        dvdFromFile.setUserNote(dvdTokens[5]);
        return dvdFromFile;
    }

    private void loadLibrary() throws DVDLibraryDaoException{
        Scanner scanner;

        try {
            scanner = new Scanner(new BufferedReader(new FileReader(DVD_LIBRARY_FILE)));
        } catch (FileNotFoundException e){
            throw new DVDLibraryDaoException("-_- Could not load DVD library data into memory.",e);
        }

        String currentLine;
        DVD currentDVD;
        while (scanner.hasNextLine()){
            currentLine = scanner.nextLine();
            currentDVD = unmarshallDVD(currentLine);
            dvds.put(currentDVD.getTitle(),currentDVD);
        }
        scanner.close();
    }

    private String marshallDVD(DVD aDVD){
        String dvdAsText = aDVD.getTitle() + DELIMITER;
        dvdAsText += aDVD.getReleaseDate() + DELIMITER;
        dvdAsText += aDVD.getMPAARating() + DELIMITER;
        dvdAsText += aDVD.getDirectorName() + DELIMITER;
        dvdAsText += aDVD.getStudio() +DELIMITER;
        dvdAsText += aDVD.getUserNote();
        return dvdAsText;
    }

    private void writeLibrary() throws DVDLibraryDaoException {
        PrintWriter out;

        try {
            out = new PrintWriter(new FileWriter(DVD_LIBRARY_FILE));
        } catch (IOException e){
            throw new DVDLibraryDaoException("Could not save DVD data.",e);
        }

        String dvdAsText;
        List<DVD> dvdList = this.getAllDVDs();
        for (DVD currentDVD : dvdList){
            dvdAsText = marshallDVD(currentDVD);
            out.println(dvdAsText);
            out.flush();
        }
        out.close();
    }
}
