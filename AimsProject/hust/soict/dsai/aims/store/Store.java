package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.media.Media;
import java.util.ArrayList;

public class Store {
    private ArrayList<Media> itemsInStore; // Danh sách các đối tượng Media

    // Constructor
    public Store() {
        this.itemsInStore = new ArrayList<>();
    }

    // Phương thức thêm Media vào cửa hàng
    public void addMedia(Media media) {
        if (!itemsInStore.contains(media)) {
            itemsInStore.add(media);
            System.out.println(media.getTitle() + " đã được thêm vào cửa hàng.");
        } else {
            System.out.println(media.getTitle() + " đã tồn tại trong cửa hàng.");
        }
    }

    // Phương thức xóa Media khỏi cửa hàng
    public boolean removeMedia(Media media) {
        if (itemsInStore.contains(media)) {
            itemsInStore.remove(media);
            System.out.println(media.getTitle() + " đã được xóa khỏi cửa hàng.");
            return true;
        } else {
            System.out.println(media.getTitle() + " không tìm thấy trong cửa hàng.");
            return false;
        }
    }

    // Phương thức hiển thị các Media trong cửa hàng
    public void showItemsInStore() {
        System.out.println("***********************STORE***********************");
        if (itemsInStore.isEmpty()) {
            System.out.println("Cửa hàng hiện tại trống.");
        } else {
            int count = 1;
            for (Media media : itemsInStore) {
                System.out.println(count + ". " + media.getTitle() + " - " + media.getCategory() + " - $" + media.getPrice());
                count++;
            }
        }
        System.out.println("***************************************************");
    }

    // Tìm kiếm Media theo tiêu đề
    public Media searchMediaByTitle(String title) {
        for (Media media : itemsInStore) {
            if (media.getTitle().equalsIgnoreCase(title)) {
                return media;
            }
        }
        System.out.println("Không tìm thấy sản phẩm với tiêu đề: " + title);
        return null;
    }
}
