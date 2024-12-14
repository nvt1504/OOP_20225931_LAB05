package hust.soict.dsai.test.store;
import hust.soict.dsai.aims.media.DigitalVideoDisc; // Import lớp hust.soict.dsai.aims.media.DigitalVideoDisc từ package disc

import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    // fixed branch
    public static void main(String[] args) {
        // Tạo cửa hàng với sức chứa tối đa là 5 DVD
        Store store = new Store(5);

        // Tạo một số DVD mẫu
        DigitalVideoDisc dvd1 = new DigitalVideoDisc(1, "Inception", "Sci-Fi", 19.99f, "Christopher Nolan", 148);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc(2, "Titanic", "Romance", 15.99f, "James Cameron", 195);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc(3, "Avatar", "Action", 22.99f, "James Cameron", 162);

        // Thêm DVD vào cửa hàng
        store.addDVD(dvd1);
        store.addDVD(dvd2);
        store.addDVD(dvd3);

        // Hiển thị các DVD trong cửa hàng
        store.showItemsInStore();

        // Xóa DVD khỏi cửa hàng
        store.removeDVD(dvd2);
        store.removeDVD(dvd1);

        // Hiển thị lại các DVD sau khi xóa
        store.showItemsInStore();
    }
}
