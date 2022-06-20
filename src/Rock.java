public class Rock extends BaseSong {
    public Rock(String artist, String title, int duration) {
        super(artist, title, duration);
    }

    @Override
    public String getArtist() {
        return null;
    }

    @Override
    public String getTitle() {
        return null;
    }

    @Override
    public int getDuration() {
        return 0;
    }
}
