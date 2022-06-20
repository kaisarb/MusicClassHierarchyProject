public class Jazz extends BaseSong {
    public Jazz(String artist, String title, int duration) {
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
