package hust.soict.dsai.aims.screen;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class MediaStore extends JPanel {
    private Media media;

    public MediaStore(Media media) {
        this.media = media; // Gán đối tượng Media
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS)); // Thiết lập BoxLayout theo trục Y

        // Tạo JLabel cho tiêu đề Media
        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20)); // Đặt font chữ
        title.setAlignmentX(CENTER_ALIGNMENT); // Căn giữa theo trục X

        // Tạo JLabel cho giá tiền
        JLabel cost = new JLabel(media.getPrice() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT); // Căn giữa theo trục X

        // Tạo JPanel chứa các nút
        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER)); // FlowLayout căn giữa

        // Thêm nút "Add to cart"
        container.add(new JButton("Add to cart"));

        // Nếu Media là một đối tượng Playable, thêm nút "Play"
        if (media instanceof Playable) {
            container.add(new JButton("Play"));
        }

        // Thêm các thành phần vào JPanel chính
        this.add(Box.createVerticalGlue()); // Thêm khoảng cách dọc
        this.add(title);                    // Thêm tiêu đề
        this.add(cost);                     // Thêm giá tiền
        this.add(Box.createVerticalGlue()); // Thêm khoảng cách dọc
        this.add(container);                // Thêm container chứa nút

        // Thêm đường viền cho MediaStore
        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
