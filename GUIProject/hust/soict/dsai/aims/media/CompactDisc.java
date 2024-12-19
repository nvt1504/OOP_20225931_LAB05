package hust.soict.dsai.aims.media;

import hust.soict.dsai.aims.exception.PlayerException;
import java.util.ArrayList;
import java.util.Iterator;

public class CompactDisc extends Disc implements Playable {
    private String artist;               // Nghệ sĩ biểu diễn
    private ArrayList<Track> tracks;    // Danh sách các bài hát

    // Constructor đầy đủ
    public CompactDisc(String title, String category, float price, int length, String director, String artist) {
        super(++Disc.nbDiscs, title, category, price, length, director);  // Gọi constructor của Disc
        this.artist = artist;
        this.tracks = new ArrayList<>();
    }

    // Getter cho artist
    public String getArtist() {
        return artist;
    }

    // Phương thức thêm bài hát
    public void addTrack(Track track) {
        if (tracks.contains(track)) {
            System.out.println("Track already exists: " + track.getTitle());
        } else {
            tracks.add(track);
            System.out.println("Track added: " + track.getTitle());
        }
    }

    // Phương thức xóa bài hát
    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
            System.out.println("Track removed: " + track.getTitle());
        } else {
            System.out.println("Track not found: " + track.getTitle());
        }
    }

    // Phương thức tính tổng độ dài CD
    @Override
    public int getLength() {
        int totalLength = 0;
        for (Track track : tracks) {
            totalLength += track.getLength();
        }
        return totalLength;
    }

    // Phương thức play() với xử lý PlayerException
    @Override
    public void play() throws PlayerException {
        if (this.getLength() > 0) {
            System.out.println("Playing Compact Disc: " + this.getTitle());
            System.out.println("Artist: " + this.artist);
            System.out.println("Number of Tracks: " + this.tracks.size());

            Iterator<Track> iter = tracks.iterator();
            while (iter.hasNext()) {
                Track nextTrack = iter.next();
                try {
                    nextTrack.play(); // Gọi play() của từng Track
                } catch (PlayerException e) {
                    throw e; // Ném ngoại lệ nếu Track có lỗi
                }
            }
        } else {
            System.err.println("ERROR: CD length is non-positive!");
            throw new PlayerException("ERROR: CD length is non-positive!");
        }
    }

    @Override
    public String toString() {
        return "CompactDisc[ID=" + getId() + ", Title=" + getTitle() + ", Artist=" + artist + ", Price=" + getPrice() + "]";
    }
}
