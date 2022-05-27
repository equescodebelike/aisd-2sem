package task2_3;

import util.basic.ArrayUtils;
import util.basic.JTableUtils;
import util.basic.SwingUtils;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class FrameMain extends JFrame { // унаследование формы
    private JButton customConvert;
    private JPanel panelMain;
    private JTable tableInput;
    private JScrollPane JScrollPaneInput;
    private JTable tableOutput;
    private JScrollPane JScrollPaneOutput;
    private JButton saveToButtonIn;
    private JButton saveToButtonOut;
    // private JButton randomButton;
    private JButton openFileButton;
    private JButton javaConvert;

    private final JFileChooser fileChooserOpen;
    private final JFileChooser fileChooserSave;


    public FrameMain() {
        this.setTitle("Task3");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        JTableUtils.initJTableForArray(tableInput, 40, false, true, false, true);
        JTableUtils.initJTableForArray(tableOutput, 40, false, true, false, true);
        //tableOutput.setEnabled(false);
        tableInput.setRowHeight(25);
        tableOutput.setRowHeight(25);
        JScrollPaneInput.setPreferredSize(new Dimension(-1, 90));
        JScrollPaneOutput.setPreferredSize(new Dimension(-1, 90));

        fileChooserOpen = new JFileChooser();
        fileChooserSave = new JFileChooser();
        fileChooserOpen.setCurrentDirectory(new File("."));
        fileChooserSave.setCurrentDirectory(new File("."));
        FileFilter filter = new FileNameExtensionFilter("Text files", "txt");
        fileChooserOpen.addChoosableFileFilter(filter);
        fileChooserSave.addChoosableFileFilter(filter);

        fileChooserSave.setAcceptAllFileFilterUsed(false);
        fileChooserSave.setDialogType(JFileChooser.SAVE_DIALOG);
        fileChooserSave.setApproveButtonText("Save");

        /* convert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int arr [][] = JTableUtils.readIntMatrixFromJTable(tableInput);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
            }
         }); */

        customConvert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    String[] arr = JTableUtils.readStringArrayFromJTable(tableInput);
                    assert arr != null;
                    // List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
                    JTableUtils.writeArrayToJTable(tableOutput, Task3.customConvert(Task3.setCustomPQueue(arr)));
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        javaConvert.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    String[] arr = JTableUtils.readStringArrayFromJTable(tableInput);
                    assert arr != null;
                    // List<Integer> list = Arrays.stream(arr).boxed().collect(Collectors.toList());
                    JTableUtils.writeArrayToJTable(tableOutput, Task3.javaConvert(Task3.setJavaPQueue(arr)));
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        openFileButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserOpen.showOpenDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        String[] arr = ArrayUtils.readLinesFromFile(fileChooserOpen.getSelectedFile().getPath());
                        JTableUtils.writeArrayToJTable(tableInput, arr);
                    }
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        /* randomButton.addActionListener(new ActionListener() { // random
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int[] arr = ArrayUtils.createRandomIntArray(tableInput.getColumnCount(), -99, 99);
                    JTableUtils.writeArrayToJTable(tableInput, arr);
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        }); */

        saveToButtonIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserSave.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        String[] arr = JTableUtils.readStringArrayFromJTable(tableInput);
                        String file = fileChooserSave.getSelectedFile().getPath();
                        if (!file.toLowerCase().endsWith(".txt")) {
                            file += ".txt";
                        }
                        assert arr != null;
                        ArrayUtils.writeStringArrayToFile(file, arr);
                    }
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });

        saveToButtonOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (fileChooserSave.showSaveDialog(panelMain) == JFileChooser.APPROVE_OPTION) {
                        String[] arr = JTableUtils.readStringArrayFromJTable(tableOutput);
                        String file = fileChooserSave.getSelectedFile().getPath();
                        if (!file.toLowerCase().endsWith(".txt")) {
                            file += ".txt";
                        }
                        assert arr != null;
                        ArrayUtils.writeStringArrayToFile(file, arr);
                    }
                } catch (Exception e) {
                    SwingUtils.showErrorMessageBox(e);
                }
            }
        });
    }
}
