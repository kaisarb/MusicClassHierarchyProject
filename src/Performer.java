import java.util.Collection;
import java.util.Collections;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Performer extends Song {

    private Queue<Song> queue = new ConcurrentLinkedQueue<>();
    private volatile Song currentSong;

    public Performer() {
    }

    public Performer(Song song) {
        this(Collections.singletonList(song));
    }

    public Performer(Collection<Song> songs) {
        queue.addAll(songs);
    }

    public void add(Collection<Song> songs) {
        queue.addAll(songs);
    }

    public void add(Song song) {
        add(Collections.singletonList(song));
    }

    public void remove(Collection<Song> songs) {
        queue.removeAll(songs);
    }

    public void remove(Song song) {
        remove(Collections.singletonList(song));
    }

    public void play() throws InterruptedException {
        while (!queue.isEmpty()) {
            Song song = queue.poll();
            setCurrentSong(song);

            // Playing...
            Thread.sleep(song.getDuration());
        }
    }

    private void setCurrentSong(Song song) {
        synchronized (this) {
            currentSong = song;
        }
    }

    public Song getCurrentSong() {
        synchronized (this) {
            if (currentSong == null) {
                throw new IllegalStateException("No song is playing");
            }

            return currentSong;
        }
    }

    @Override
    public String getArtist() {
        return getCurrentSong().getArtist();
    }

    @Override
    public String getTitle() {
        return getCurrentSong().getTitle();
    }

    @Override
    public int getDuration() {
        return getCurrentSong().getDuration();
    }

    @Override
    public String getGenre() {
        return getCurrentSong().getGenre();
    }
}
