package hust.soict.dsai.swing;
import javax.swing.*;       // Các thành phần Swing
import java.awt.*;          // Các lớp bố cục và container AWT
import java.awt.event.*;    // Các lớp xử lý sự kiện AWT

public class SwingAccumulator extends JFrame {
    private JTextField tfInput;
    private JTextField tfOutput;
    private int sum = 0; // Tích lũy tổng, khởi tạo bằng 0

    // Constructor để thiết lập các thành phần GUI và xử lý sự kiện
    public SwingAccumulator() {
        Container cp = getContentPane(); // Lấy content-pane của JFrame
        cp.setLayout(new GridLayout(2, 2)); // Thiết lập bố cục dạng lưới (2 hàng, 2 cột)

        cp.add(new JLabel("Enter an Integer: ")); // Thêm JLabel ẩn danh đầu tiên

        tfInput = new JTextField(10); // Trường nhập liệu với chiều dài 10 ký tự
        cp.add(tfInput);
        tfInput.addActionListener(new TFInputListener()); // Thêm listener xử lý sự kiện

        cp.add(new JLabel("The Accumulated Sum is: ")); // Thêm JLabel ẩn danh thứ hai

        tfOutput = new JTextField(10); // Trường hiển thị kết quả với chiều dài 10 ký tự
        tfOutput.setEditable(false); // Thiết lập chế độ chỉ đọc
        cp.add(tfOutput);

        setTitle("Swing Accumulator"); // Đặt tiêu đề cho JFrame
        setSize(350, 120);             // Thiết lập kích thước JFrame
        setVisible(true);              // Hiển thị JFrame
    }

    // Phương thức main
    public static void main(String[] args) {
        new SwingAccumulator(); // Gọi hàm dựng để hiển thị giao diện
    }

    // Lớp xử lý sự kiện (inner class)
    private class TFInputListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent evt) {
            int numberIn = Integer.parseInt(tfInput.getText()); // Chuyển đổi giá trị nhập thành số nguyên
            sum += numberIn;                                   // Cộng dồn vào tổng
            tfInput.setText("");                               // Xóa nội dung trường nhập
            tfOutput.setText(sum + "");                        // Hiển thị tổng mới
        }
    }
}

