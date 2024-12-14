package hust.soict.dsai.aims.media;

import java.util.ArrayList;

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

    // Phương thức hiển thị thông tin CD
    @Override
    public void play() {
        System.out.println("Playing Compact Disc: " + this.getTitle());
        System.out.println("Artist: " + this.artist);
        System.out.println("Number of Tracks: " + this.tracks.size());
        for (Track track : tracks) {
            track.play(); // Gọi phương thức play() của từng Track
        }
    }
    @Override
    public String toString() {
        return "CompactDisc[ID=" + getId() + ", Title=" + getTitle() + ", Artist=" + artist + ", Price=" + getPrice() + "]";
    }

}
