package hust.soict.dsai.swing;

import javax.swing.*;       // Các thành phần Swing
import java.awt.*;          // Các lớp bố cục và container AWT
import java.awt.event.*;    // Các lớp xử lý sự kiện

public class NumberGrid extends JFrame {
    private JButton[] btnNumbers = new JButton[10]; // Mảng nút số từ 0 đến 9
    private JButton btnDelete, btnReset;            // Nút "DEL" và "C"
    private JTextField tfDisplay;                  // Trường hiển thị nội dung

    // Lớp nội bộ để xử lý sự kiện nút bấm
    private class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String button = e.getActionCommand(); // Lấy tên nút được nhấn

            if (button.charAt(0) >= '0' && button.charAt(0) <= '9') {
                // Nếu là nút số, thêm chữ số vào cuối chuỗi hiển thị
                tfDisplay.setText(tfDisplay.getText() + button);
            } else if (button.equals("DEL")) {
                // Xóa ký tự cuối cùng nếu chuỗi không rỗng
                String currentText = tfDisplay.getText();
                if (!currentText.isEmpty()) {
                    tfDisplay.setText(currentText.substring(0, currentText.length() - 1));
                }
            } else if (button.equals("C")) {
                // Xóa toàn bộ nội dung hiển thị
                tfDisplay.setText("");
            }
        }
    }

    // Constructor của lớp
    public NumberGrid() {
        // Thiết lập JTextField để hiển thị
        tfDisplay = new JTextField();
        tfDisplay.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT); // Hiển thị từ phải sang trái
        tfDisplay.setEditable(false); // Không cho phép chỉnh sửa nội dung trực tiếp

        // Tạo JPanel chứa các nút
        JPanel panelButtons = new JPanel(new GridLayout(4, 3)); // Lưới 4 hàng, 3 cột
        addButtons(panelButtons); // Thêm nút vào panel

        // Lấy content pane của JFrame và thiết lập layout
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());
        cp.add(tfDisplay, BorderLayout.NORTH); // Thêm JTextField vào phần phía trên
        cp.add(panelButtons, BorderLayout.CENTER); // Thêm JPanel vào phần trung tâm

        // Thiết lập JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Number Grid"); // Tiêu đề cửa sổ
        setSize(300, 400);       // Kích thước cửa sổ
        setVisible(true);        // Hiển thị cửa sổ
    }

    // Phương thức để thêm nút vào JPanel
    private void addButtons(JPanel panelButtons) {
        ButtonListener btnListener = new ButtonListener(); // Listener cho các nút

        // Thêm các nút từ 1 đến 9
        for (int i = 1; i <= 9; i++) {
            btnNumbers[i] = new JButton("" + i); // Tạo nút với nhãn là số i
            panelButtons.add(btnNumbers[i]);    // Thêm nút vào panel
            btnNumbers[i].addActionListener(btnListener); // Gắn listener
        }

        // Thêm nút "DEL"
        btnDelete = new JButton("DEL");
        panelButtons.add(btnDelete);
        btnDelete.addActionListener(btnListener);

        // Thêm nút "0"
        btnNumbers[0] = new JButton("0");
        panelButtons.add(btnNumbers[0]);
        btnNumbers[0].addActionListener(btnListener);

        // Thêm nút "C"
        btnReset = new JButton("C");
        panelButtons.add(btnReset);
        btnReset.addActionListener(btnListener);
    }

    // Phương thức main để chạy chương trình
    public static void main(String[] args) {
        new NumberGrid();
    }
}
