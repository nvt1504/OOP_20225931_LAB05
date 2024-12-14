package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {
    private static int nbDigitalVideoDiscs = 0;  // Đếm số lượng DVD đã tạo
    private String director;
    private int length;

    // Constructor với tiêu đề duy nhất
    public DigitalVideoDisc(String title) {
        super(++nbDigitalVideoDiscs, title, null, 0.0f);  // Gọi constructor của Media
        this.director = null;
        this.length = 0;
    }

    // Constructor với tiêu đề, danh mục và giá
    public DigitalVideoDisc(String title, String category, float price) {
        super(++nbDigitalVideoDiscs, title, category, price);  // Gọi constructor của Media
        this.director = null;
        this.length = 0;
    }

    // Constructor với đạo diễn, danh mục, tiêu đề và giá
    public DigitalVideoDisc(String director, String category, String title, float price) {
        super(++nbDigitalVideoDiscs, title, category, price);  // Gọi constructor của Media
        this.director = director;
        this.length = 0;
    }

    // Constructor đầy đủ với id, tiêu đề, danh mục, giá, đạo diễn và độ dài
    public DigitalVideoDisc(int id, String title, String category, float price, String director, int length) {
        super(id, title, category, price);  // Gọi constructor của Media với id cụ thể
        this.director = director;
        this.length = length;
    }

    // Constructor với tiêu đề, danh mục, đạo diễn, độ dài và giá
    public DigitalVideoDisc(String title, String category, String director, int length, float price) {
        super(++nbDigitalVideoDiscs, title, category, price);  // Gọi constructor của Media
        this.director = director;
        this.length = length;
    }

    // Getter và Setter
    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    // Phương thức hiển thị thông tin DVD
    public void play() {
        System.out.println("DVD ID: " + getId());
        System.out.println("DVD Title: " + getTitle());
        System.out.println("Category: " + getCategory());
        System.out.println("Price: $" + getPrice());
        System.out.println("Director: " + (this.director != null ? this.director : "N/A"));
        System.out.println("Length: " + (this.length > 0 ? this.length + " minutes" : "N/A"));
    }

    // Kiểm tra độ dài hợp lệ
    public boolean isValidLength() {
        return this.length > 0;
    }

    // Kiểm tra tiêu đề có khớp với từ khóa tìm kiếm
    public boolean matchesTitle(String searchTerm) {
        return getTitle() != null && getTitle().toLowerCase().contains(searchTerm.toLowerCase());
    }

    // Kiểm tra danh mục có khớp không
    public boolean matchesCategory(String searchCategory) {
        return getCategory() != null && getCategory().equalsIgnoreCase(searchCategory);
    }

    // Kiểm tra giá có nằm trong khoảng quy định
    public boolean isWithinPriceRange(Float minPrice, Float maxPrice) {
        float price = getPrice();
        if (minPrice != null && price < minPrice) {
            return false;
        }
        if (maxPrice != null && price > maxPrice) {
            return false;
        }
        return true;
    }

    // Getter cho số lượng DVD đã tạo
    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }
    @Override
    public String toString() {
        return "DigitalVideoDisc[ID=" + getId() + ", Title=" + getTitle() + ", Director=" + director +
                ", Length=" + length + " minutes, Price=" + getPrice() + "]";
    }

}
