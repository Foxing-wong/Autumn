package us.cijian.autumn.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

/**
 * Created by Murphy on 2/15/2015.
 */
public class IndexView extends JFrame {

    BorderLayout borderLayout = new BorderLayout();

    public IndexView() {
        setTitle("Autumn | Powered by MurphyL");
        setSize(1000, 618);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        JPanel topPanel = new JPanel();
        String[] columnName = {"姓名", "性别", "单位", "参加项目", "备注"};
        String[][] rowData = {
                {"张三", "男", "计算机系", "100 米 ,200 米", ""},
                {"李四", "男", "化学系", "100 米，铅球", ""},
        };
        // 创建表格
        JTable table = new JTable(new DefaultTableModel(rowData, columnName));
        // 创建包含表格的滚动窗格
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
        // 定义 topPanel 的布局为 BoxLayout，BoxLayout 为垂直排列
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.LINE_AXIS));
        // 加入包含表格的滚动窗格
        topPanel.add(scrollPane);
        // 再加入一个不可见的 Strut，从而使 topPanel 和 middlePanel 之间留出一定的空间
        add(topPanel);
        setResizable(false);
        setVisible(true);

    }


    public static void main(String[] args) {

        EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                IndexView ex = new IndexView();
                ex.setVisible(true);
            }
        });
    }
}
