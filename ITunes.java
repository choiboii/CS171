public class ITunes{

  public static void main(String[] args){

    // Sample testing code ...
    Playlist pl = new Playlist();

    pl.addLast("PlanetMoney",26.0);
    pl.addLast("HowIBuiltThis",10);
    pl.addLast("EzraKleinShow",65.0);
    pl.addLast("RadioLab",25.5);
    pl.addLast("MakeMeSmart",24.5);
    pl.addLast("Worldly",55);
    pl.addLast("Explained",23.0);
    pl.addLast("Invisibilia",33.5);

    pl.displayPlaylistForward();
    pl.displayPlaylistBackward();

    pl.deleteEveryMthEpisode(3);

    pl.displayPlaylistForward();
    pl.displayPlaylistBackward();

  }
}
