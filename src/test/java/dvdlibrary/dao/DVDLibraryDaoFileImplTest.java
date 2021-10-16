package dvdlibrary.dao;

import dvdlibrary.dto.DVD;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileWriter;

import static org.junit.jupiter.api.Assertions.*;

public class DVDLibraryDaoFileImplTest {

    DVDLibraryDao testDao;

    public DVDLibraryDaoFileImplTest(){
    }

    @BeforeEach
    public void setUp() throws Exception{
        String testFile = "testDvDLibrary.txt";
        new FileWriter(testFile);
        testDao = new DVDLibraryDaoFileImpl(testFile);
    }

    @Test
    public void testAddGetDVD() throws Exception{
        String title = "0001";
        DVD dvd = new DVD(title);
        dvd.setDirectorName("director name");
        dvd.setMPAARating("pg");
        dvd.setReleaseDate("31-08-1999");
        dvd.setStudio("studio");
        dvd.setUserNote("note");

        testDao.addDVD(title, dvd);
        DVD retrievedDVD = testDao.getDVD(title);

        assertEquals(dvd.getTitle(), retrievedDVD.getTitle(), "Checking title.");
        assertEquals(dvd.getDirectorName(), retrievedDVD.getDirectorName(), "Checking MPAA rating.");
        assertEquals(dvd.getReleaseDate(), retrievedDVD.getReleaseDate(), "Checking release date.");
        assertEquals(dvd.getStudio(), retrievedDVD.getStudio(), "Checking Studio name.");
        assertEquals(dvd.getUserNote(), retrievedDVD.getUserNote(), "Checking User Note.");
    }

}