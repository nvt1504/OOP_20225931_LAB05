package hust.soict.dsai.test.disc;
import hust.soict.dsai.aims.media.DigitalVideoDisc; // Import lớp hust.soict.dsai.aims.media.DigitalVideoDisc từ package disc


public class TestPassingParameter {
    public static void main(String[] args) {
        // Tạo các đối tượng hust.soict.dsai.aims.media.DigitalVideoDisc
        DigitalVideoDisc jungleDVD = new DigitalVideoDisc("Jungle");
        DigitalVideoDisc cinderellaDVD = new DigitalVideoDisc("Cinderella");

        // In ra tiêu đề của các DVD trước khi swap
        System.out.println("Before swap:");
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        // Gọi phương thức swap
        swap(jungleDVD, cinderellaDVD);

        // In ra tiêu đề của các DVD sau khi swap
        System.out.println("After swap:");
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
        System.out.println("cinderella dvd title: " + cinderellaDVD.getTitle());

        // Gọi phương thức changeTitle
        changeTitle(jungleDVD, cinderellaDVD.getTitle());

        // In ra tiêu đề của jungleDVD sau khi thay đổi
        System.out.println("After changeTitle:");
        System.out.println("jungle dvd title: " + jungleDVD.getTitle());
    }

    // Phương thức swap hoán đổi tiêu đề của hai đối tượng hust.soict.dsai.aims.media.DigitalVideoDisc
    public static void swap(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2) {
        String tmp = dvd1.getTitle();
        dvd1.setTitle(dvd2.getTitle());
        dvd2.setTitle(tmp);
    }

    // Phương thức thay đổi tiêu đề của DVD
    public static void changeTitle(DigitalVideoDisc dvd, String title) {
        dvd.setTitle(title);  // Đặt tiêu đề mới cho DVD
    }
}


