/*
 * @Author: Jetty 
 * @Date: 2022-08-24 22:04:13 
 * @Last Modified by: Jetty
 * @Last Modified time: 2022-08-25 11:56:14
 */
package chapter2.ImageViewer;

import java.awt.*;
import java.io.*;
import javax.swing.*;

public class ImageViewer {
    public static void main(String[] args){
        EventQueue.invokeLater(() -> {
            var frame = new ImageViewerFrame(); // frame
            frame.setTitle("ImageViewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class ImageViewerFrame extends JFrame{
    private static final int DEFAULT_WIDTH = 300; // DEFAULT_WIDTH
    private static final int DEFAULT_HEIGHT = 400; // DEFAULT_HEIGHT

    public ImageViewerFrame(){
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);

        var label = new JLabel(); // label
        add(label);
        var chooser = new JFileChooser(); // chooser
        chooser.setCurrentDirectory(new File("."));
        var menuBar = new JMenuBar(); // menuBar
        setJMenuBar(menuBar);
        var menu = new JMenu("File"); // menu
        menuBar.add(menu);
        var openItem = new JMenuItem("Open"); // openItem
        menu.add(openItem);
        openItem.addActionListener(event -> {
            int result = chooser.showOpenDialog(null); // result
            if (result == JFileChooser.APPROVE_OPTION){
                String name = chooser.getSelectedFile().getPath(); // name
                label.setIcon(new ImageIcon(name));
            }
        });
        var exitItem = new JMenuItem("Exit"); // exitItem
        menu.add(exitItem);
        exitItem.addActionListener(event -> System.exit(0));
    }
}