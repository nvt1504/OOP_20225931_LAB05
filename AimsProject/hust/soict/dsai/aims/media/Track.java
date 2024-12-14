package hust.soict.dsai.aims.media;

public class Track implements Playable {
    private final String title;  // Tiêu đề bài hát
    private final int length;    // Độ dài bài hát

    // Constructor đầy đủ
    public Track(String title, int length) {
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty.");
        }
        if (length < 0) {
            throw new IllegalArgumentException("Length must be a non-negative integer.");
        }
        this.title = title;
        this.length = length;
    }

    // Constructor chỉ với tiêu đề
    public Track(String title) {
        this(title, 0); // Mặc định độ dài là 0 nếu không cung cấp
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public int getLength() {
        return length;
    }

    // Ghi đè phương thức play() từ giao diện Playable
    @Override
    public void play() {
        System.out.println("Playing Track: " + title);
        System.out.println("Track Length: " + (length > 0 ? length + " minutes" : "N/A"));
    }

    // Ghi đè phương thức equals() để so sánh hai đối tượng Track
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true; // Kiểm tra tham chiếu
        if (obj == null || getClass() != obj.getClass()) return false; // Kiểm tra kiểu đối tượng
        Track track = (Track) obj; // Ép kiểu
        return length == track.length && title.equalsIgnoreCase(track.title); // So sánh tiêu đề và độ dài
    }

    // Ghi đè hashCode() để đảm bảo nhất quán với equals()
    @Override
    public int hashCode() {
        return title.toLowerCase().hashCode() + Integer.hashCode(length);
    }
}
