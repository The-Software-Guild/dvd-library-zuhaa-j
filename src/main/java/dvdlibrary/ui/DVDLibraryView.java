package dvdlibrary.ui;

import dvdlibrary.dto.DVD;

import java.util.List;

public class DVDLibraryView {

    private UserIO io;

    public int printMenuAndGetSelection(){
        io.print("Main Menu:");
        io.print("      1. Add a DVD to the collection");
        io.print("      2. Remove a DVD from the collection");
        io.print("      3. Edit a DVD in the collection");
        io.print("      4. List all DVDs in the collection");
        io.print("      5. Find a DVD in the collection");
        io.print("      6. Quit");

        return io.readInt("      Please select from the above choices",1,6);
    }

    public DVD getNewDVDInfo() {
        String title = io.readString("      Please enter Title of DVD.");
        String releaseDate = io.readString("      Please enter Release Date of DVD (DD-MM-YYYY).");
        while (!(releaseDate.matches("^\\d{2}-\\d{2}-\\d{4}$"))){
            io.print("      Release Date must be of form DD-MM-YYYY");
            releaseDate = io.readString("      Please enter Release Date of DVD (DD-MM-YYYY).");
        }
        String MPAARating = io.readString("      Please enter MPAA Rating of DVD.");
        String directorName = io.readString("      Please enter Director's Name of DVD.");
        String studio = io.readString("      Please enter Studio of DVD.");
        String userNote = io.readString("      Please enter any additional information.");
        DVD currentDVD = new DVD(title);
        currentDVD.setReleaseDate(releaseDate);
        currentDVD.setMPAARating(MPAARating);
        currentDVD.setDirectorName(directorName);
        currentDVD.setStudio(studio);
        currentDVD.setUserNote(userNote);
        return currentDVD;
    }

    public void displayAddDVDBanner(){
        io.print("Add DVD Menu:");
    }

    public void displayAddSuccessBanner(){
        io.readString("      DVD successfully added. Please hit enter to continue.");
    }

    public void displayDVDList(List<DVD> dvdList){
        for (DVD currentDVD : dvdList){
            io.print(currentDVD.getTitle());
        }
        io.readString("      Please hit enter to continue.");
    }

    public void displayDisplayAllBanner(){
        io.print("List All DVDs Menu:");
    }

    public void displayDisplayDVDBanner(){
        io.print("Find DVD Menu:");
    }

    public String getTitleChoice(){
        return io.readString("      Please enter Title of DVD.");
    }

    public void displayDVD(DVD dvd){
        if (dvd != null){
            io.print("      Title: "+dvd.getTitle());
            io.print("      Release Date:"+dvd.getReleaseDate());
            io.print("      MPAA Rating: "+dvd.getMPAARating());
            io.print("      Director's Name: "+dvd.getDirectorName());
            io.print("      Studio: "+dvd.getStudio());
            io.print("      User Note: "+dvd.getUserNote());
            io.print(" ");
        } else {
            io.print("      No such DVD record.");
        }
        io.readString("      Please hit enter to continue.");
    }

    public void displayRemoveDVDBanner(){
        io.print("Remove DVD Menu:");
    }

    public void displayRemoveResult(DVD dvdRecord){
        if (dvdRecord != null){
            io.print("      DVD successfully removed.");
        } else {
            io.print("      No such DVD record.");
        }
        io.readString("      Please hit enter to continue.");
    }

    public void displayEditDVDBanner(){
        io.print("Edit DVD Menu:");
    }

    public DVD editDVDInfo(DVD dvd){
        io.print("      (1) Release Date");
        io.print("      (2) MPAA Rating");
        io.print("      (3) Director's Name");
        io.print("      (4) Studio");
        io.print("      (5) Additional Information");
        int choice = io.readInt("      Which field would you like to edit?",1,5);
        switch (choice){
            case 1:
                String releaseDate = io.readString("      Enter new Release Date of DVD (DD-MM-YYYY).");
                while (!(releaseDate.matches("^\\d{2}-\\d{2}-\\d{4}$"))){
                    io.print("      Release Date must be of form DD-MM-YYYY");
                    releaseDate = io.readString("      Enter new Release Date of DVD (DD-MM-YYYY).");
                }
                dvd.setReleaseDate(releaseDate);
                break;
            case 2:
                dvd.setMPAARating(io.readString("      Enter new MPAA Rating of DVD."));
                break;
            case 3:
                dvd.setDirectorName(io.readString("      Enter new Director's Name of DVD."));
                break;
            case 4:
                dvd.setStudio(io.readString("      Enter new Studio of DVD."));
                break;
            case 5:
                dvd.setUserNote(io.readString("      Enter new Additional Information of DVD."));
                break;
            default:
                displayUnknownCommandBanner();
                break;
        }
        return dvd;
    }

    public void displayEditResult(DVD dvdRecord){
        if ((dvdRecord != null)){
            io.print("      DVD successfully edited.");
        } else {
            io.print("      No such DVD record.");
        }
        io.readString("      Please hit enter to continue.");
    }

    public void displayExitBanner(){
        io.print("Good bye!");
    }

    public void displayUnknownCommandBanner(){
        io.print("      Unknown Command!");
    }

    public DVDLibraryView(UserIO io){
        this.io = io;
    }

    public void displayErrorMessage(String errorMsg){
        io.print("      Error!");
        io.print(errorMsg);
    }

}
