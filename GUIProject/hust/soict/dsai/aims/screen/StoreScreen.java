package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.cart.Cart;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class StoreScreen extends JFrame {
    private Store store;
    private Cart cart;

    // Constructor
    public StoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;

        // Thiết lập container và layout
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        // Thêm các thành phần vào container
        cp.add(createNorth(), BorderLayout.NORTH); // Thêm phần North
        cp.add(createCenter(), BorderLayout.CENTER); // Thêm phần Center

        // Thiết lập cửa sổ
        setVisible(true);
        setTitle("Store"); // Tiêu đề cửa sổ
        setSize(1024, 768); // Kích thước cửa sổ
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    // Phương thức tạo vùng North (menu bar, header)
    private JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    // Phương thức tạo vùng Center (hiển thị sản phẩm)
    private JPanel createCenter() {
        // Tạo JPanel để chứa sản phẩm
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2)); // Lưới 3x3 với khoảng cách giữa các ô là 2px

        // Lấy danh sách sản phẩm từ cửa hàng
        ArrayList<Media> mediaInStore = store.getItemsInStore();

        // Thêm sản phẩm vào JPanel
        for (int i = 0; i < Math.min(9, mediaInStore.size()); i++) { // Hiển thị tối đa 9 sản phẩm
            MediaStore cell = new MediaStore(mediaInStore.get(i), cart); // Tạo một ô hiển thị sản phẩm
            center.add(cell); // Thêm ô vào JPanel
        }

        return center; // Trả về JPanel trung tâm
    }

    // Phương thức tạo menu bar
    private JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenuItem viewStore = new JMenuItem("View store");
        viewStore.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new StoreScreen(store, cart);
                dispose(); // Đóng cửa sổ hiện tại
            }
        });

        JMenuItem viewCart = new JMenuItem("View cart");
        viewCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CartScreen(cart);
                dispose(); // Đóng cửa sổ hiện tại
            }
        });

        menu.add(viewStore);
        menu.add(viewCart);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu);

        return menuBar;
    }

    // Phương thức tạo header
    private JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JButton cartButton = new JButton("View Cart");
        cartButton.setPreferredSize(new Dimension(150, 50));
        cartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CartScreen(cart);
                dispose(); // Đóng cửa sổ hiện tại
            }
        });

        header.add(Box.createHorizontalGlue());
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(cartButton);

        return header;
    }

    public void addMedia(Media m) throws LimitExceededException {
        if (itemsOrdered.size() < MAX_NUMBERS_ORDERED) {
            itemsOrdered.add(m); // Thêm media vào giỏ hàng
        } else {
            throw new LimitExceededException("ERROR: The number of media has reached its limit");
        }
    }

    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();
        new StoreScreen(store, cart);
    }


}
