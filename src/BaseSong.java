abstract public class BaseSong extends Song {

    private final String artist;
    private final String title;
    private final int duration;

    public BaseSong(String artist, String title, int duration) {
        this.artist = artist;
        this.title = title;
        this.duration = duration;
    }

    @Override
    public String getGenre() {
        return this.getClass().getSimpleName();
    }

}
