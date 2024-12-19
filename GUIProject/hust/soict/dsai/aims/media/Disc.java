package hust.soict.dsai.aims.media;

public class Disc extends Media {
    public static int nbDiscs = 0;  // Đếm số lượng đối tượng Disc đã được tạo
    private int length;             // Thời lượng của Disc
    private String director;        // Đạo diễn của Disc

    // Constructor đầy đủ
    public Disc(String title, String category, float price, int length, String director) {
        super(++nbDiscs, title, category, price);  // Gọi constructor của Media, ID tự động tăng
        this.length = length;
        this.director = director;
    }

    // Constructor không có length và director
    public Disc(int i, String title, String category, float price) {
        super(++nbDiscs, title, category, price);  // Gọi constructor của Media, ID tự động tăng
        this.length = 0;
        this.director = null;
    }

    // Constructor với ID tùy chỉnh
    public Disc(int id, String title, String category, float price, int length, String director) {
        super(id, title, category, price);  // Gọi constructor của Media với ID cụ thể
        this.length = length;
        this.director = director;
    }

    // Getters
    public int getLength() {
        return length;
    }

    public String getDirector() {
        return director;
    }

    // Setters
    public void setLength(int length) {
        this.length = length;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    // Phương thức tĩnh để lấy số lượng Disc đã tạo
    public static int getNbDiscs() {
        return nbDiscs;
    }

    // Phương thức kiểm tra độ dài hợp lệ
    public boolean isValidLength() {
        return length > 0;
    }

    // Phương thức so sánh hai Disc dựa trên độ dài
    public boolean isLongerThan(Disc other) {
        return this.length > other.length;
    }

    // Phương thức kiểm tra xem đạo diễn có khớp với một từ khóa không
    public boolean matchesDirector(String keyword) {
        return director != null && director.toLowerCase().contains(keyword.toLowerCase());
    }

    // Phương thức kiểm tra xem độ dài nằm trong khoảng cụ thể
    public boolean isLengthInRange(int min, int max) {
        return length >= min && length <= max;
    }

    // Phương thức hiển thị thông tin Disc
    public void showInfo() {
        System.out.println("Disc ID: " + getId());
        System.out.println("Title: " + getTitle());
        System.out.println("Category: " + getCategory());
        System.out.println("Price: $" + getPrice());
        System.out.println("Length: " + (length > 0 ? length + " minutes" : "N/A"));
        System.out.println("Director: " + (director != null ? director : "N/A"));
    }
}
