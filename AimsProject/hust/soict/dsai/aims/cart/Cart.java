package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;

public class Cart {
    private ArrayList<Media> itemsOrdered; // Danh sách các đối tượng Media
    private final int capacity;

    // Constructor
    public Cart() {
        this.itemsOrdered = new ArrayList<>();
        this.capacity = 20; // Giới hạn tối đa cho giỏ hàng
    }

    // Thêm Media vào giỏ hàng
    public void addMedia(Media media) {
        if (itemsOrdered.size() < capacity) {
            if (!itemsOrdered.contains(media)) {
                itemsOrdered.add(media);
                System.out.println(media.getTitle() + " đã được thêm vào giỏ hàng.");
            } else {
                System.out.println(media.getTitle() + " đã tồn tại trong giỏ hàng.");
            }
        } else {
            System.out.println("Không thể thêm Media. Giỏ hàng đã đầy.");
        }
    }

    // Xóa Media khỏi giỏ hàng
    public boolean removeMedia(Media media) {
        if (itemsOrdered.contains(media)) {
            itemsOrdered.remove(media);
            System.out.println(media.getTitle() + " đã được xóa khỏi giỏ hàng.");
        } else {
            System.out.println(media.getTitle() + " không tìm thấy trong giỏ hàng.");
        }
        return false;
    }

    // Tính tổng chi phí
    public float calculateTotalPrice() {
        float totalPrice = 0;
        for (Media media : itemsOrdered) {
            totalPrice += media.getPrice();
        }
        return totalPrice;
    }

    // Hiển thị thông tin giỏ hàng
    public void showItems() {
        System.out.println("Giỏ hàng có " + itemsOrdered.size() + " mục:");
        for (Media media : itemsOrdered) {
            System.out.println("- " + media.getTitle() + ": $" + media.getPrice());
        }
        System.out.println("Tổng giá: $" + calculateTotalPrice());
    }

    // In chi tiết giỏ hàng
    public void printCartDetails() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        if (itemsOrdered.isEmpty()) {
            System.out.println("Giỏ hàng hiện tại trống.");
        } else {
            int count = 1;
            for (Media media : itemsOrdered) {
                System.out.println(count + ". " + media.getTitle() + " - " + media.getCategory() + " - $" + media.getPrice());
                count++;
            }
        }
        System.out.println("Total cost: $" + calculateTotalPrice());
        System.out.println("***************************************************");
    }
}
