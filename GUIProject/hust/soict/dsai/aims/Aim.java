package hust.soict.dsai.aims;

import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.store.Store;

import java.util.Scanner;

public class Aim {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeStore(); // Khởi tạo cửa hàng với các sản phẩm mẫu
        int choice;
        do {
            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Bỏ qua ký tự xuống dòng
            switch (choice) {
                case 1:
                    viewStore();
                    break;
                case 2:
                    updateStore();
                    break;
                case 3:
                    seeCart();
                    break;
                case 0:
                    System.out.println("Exiting AIMS...");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        } while (choice != 0);
    }

    private static void initializeStore() {
        // Thêm sản phẩm mẫu vào cửa hàng
        store.addMedia(new DigitalVideoDisc(1, "Inception", "Sci-Fi", 19.99f, "Christopher Nolan", 148));
        store.addMedia(new DigitalVideoDisc(2, "Interstellar", "Sci-Fi", 24.99f, "Christopher Nolan", 169));
        store.addMedia(new Book(3, "Java Programming", "Education", 29.99f));
        CompactDisc cd = new CompactDisc(4, "Thriller", "Music", 15.99f, "Michael Jackson");
        cd.addTrack(new Track("Thriller", 5));
        cd.addTrack(new Track("Billie Jean", 4));
        store.addMedia(cd);
    }

    private static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    private static void viewStore() {
        store.displayItems(); // Hiển thị tất cả các sản phẩm trong cửa hàng
        int choice;
        do {
            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addMediaToCart();
                    break;
                case 3:
                    playMediaInStore();
                    break;
                case 4:
                    seeCart();
                    break;
                case 0:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        } while (choice != 0);
    }

    private static void storeMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. See a media’s details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    private static void seeMediaDetails() {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = store.findMediaByTitle(title);
        if (media != null) {
            System.out.println(media.toString());
            if (media instanceof Playable) {
                mediaDetailsMenu();
                int choice = scanner.nextInt();
                scanner.nextLine();
                if (choice == 1) {
                    cart.addMedia(media);
                    System.out.println("Added to cart.");
                } else if (choice == 2) {
                    ((Playable) media).play();
                }
            }
        } else {
            System.out.println("Media not found.");
        }
    }

    private static void mediaDetailsMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    private static void addMediaToCart() {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = store.findMediaByTitle(title);
        if (media != null) {
            cart.addMedia(media);
            System.out.println("Media \"" + media.getTitle() + "\" added to the cart.");
        } else {
            System.out.println("Media not found.");
        }
    }

    private static void playMediaInStore() {
        System.out.print("Enter the title of the media to play: ");
        String title = scanner.nextLine();
        Media media = store.findMediaByTitle(title);
        if (media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played.");
        }
    }

    private static void updateStore() {
        System.out.println("Update store:");
        System.out.println("1. Add a media");
        System.out.println("2. Remove a media");
        System.out.println("0. Back");
        int choice = scanner.nextInt();
        scanner.nextLine();
        switch (choice) {
            case 1:
                // Implement logic to add a new media
                break;
            case 2:
                System.out.print("Enter the title of the media to remove: ");
                String title = scanner.nextLine();
                Media media = store.findMediaByTitle(title);
                if (media != null) {
                    store.removeMedia(media);
                    System.out.println("Media removed from the store.");
                } else {
                    System.out.println("Media not found.");
                }
                break;
            case 0:
                System.out.println("Returning to main menu...");
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void seeCart() {
        cart.displayItems(); // Hiển thị giỏ hàng
        int choice;
        do {
            cartMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    // Implement filtering
                    break;
                case 2:
                    // Implement sorting
                    break;
                case 3:
                    System.out.print("Enter the title of the media to remove: ");
                    String title = scanner.nextLine();
                    Media media = cart.findMediaByTitle(title);
                    if (media != null) {
                        cart.removeMedia(media);
                        System.out.println("Media removed from the cart.");
                    } else {
                        System.out.println("Media not found.");
                    }
                    break;
                case 4:
                    // Implement playing media from cart
                    break;
                case 5:
                    System.out.println("Order placed. The cart is now empty.");
                    cart.emptyCart();
                    break;
                case 0:
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    private static void cartMenu() {
        System.out.println("Options: ");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }
}
