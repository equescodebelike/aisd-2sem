package task2_2;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import util.ArrayUtils;
import util.JTableUtils;
import util.SwingUtils;
import util.CustomLinkedList;

public class FrameMain extends JFrame {
    private JPanel panelMain;
    private JTable tableInput;
    private JButton buttonRandomInput;
    private JTable tableOutput;
    private JScrollPane scrollPaneTableOutput;
    private JScrollPane scrollPaneTableInput;
    private JButton buttonExecute;

    public FrameMain() {
        this.setTitle("FrameMain");
        this.setContentPane(panelMain);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();

        JTableUtils.initJTableForArray(tableInput, 40, false,
                true, false, true);
        JTableUtils.initJTableForArray(tableOutput, 40, false,
                true, false, true);
        tableInput.setRowHeight(25);
        tableOutput.setRowHeight(25);
        scrollPaneTableInput.setPreferredSize(new Dimension(-1, 90));
        scrollPaneTableOutput.setPreferredSize(new Dimension(-1, 90));


        JFileChooser FILE_CH00SER_OPEN = new JFileChooser();
        FILE_CH00SER_OPEN.setCurrentDirectory(new File("."));
        JFileChooser FILE_CHOOSER_SAVE = new JFileChooser();
        FILE_CHOOSER_SAVE.setCurrentDirectory(new File("."));

        final FileFilter FILE_NAME_TXT_EXTENSION_FILTER = new FileNameExtensionFilter("Text files",
                "txt");

        FILE_CH00SER_OPEN.addChoosableFileFilter(FILE_NAME_TXT_EXTENSION_FILTER);
        FILE_CHOOSER_SAVE.addChoosableFileFilter(FILE_NAME_TXT_EXTENSION_FILTER);

        FILE_CHOOSER_SAVE.setAcceptAllFileFilterUsed(false);
        FILE_CHOOSER_SAVE.setDialogType(JFileChooser.SAVE_DIALOG);
        FILE_CHOOSER_SAVE.setApproveButtonText("Save");

        addFillWithRandomButton();
        addExecuteButton();
    }


    private void addFillWithRandomButton() {
        buttonRandomInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int[] arr = ArrayUtils.createRandomIntArray(tableInput.getColumnCount(), 100);
                    JTableUtils.writeArrayToJTable(tableInput, arr);
                } catch (Exception e) {
                    SwingUtils.showInfoMessageBox("Random array error");
                }
            }
        });
    }

    private void addExecuteButton() {
        buttonExecute.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    int[] arr = JTableUtils.readIntArrayFromJTable(tableInput);
                    CustomLinkedList<Integer> inputList = new CustomLinkedList<>();
                    assert arr != null;
                    for (int j : arr) {
                        inputList.addLast(j);
                    }

                    CustomLinkedList<Integer> answerList = Task2.convert(inputList);
                    int[] answerArr = new int[answerList.getSize()]; // первод из линкедлиста в одномерный массив
                    for (int i = 0; i < answerList.getSize(); i++) {
                        answerArr[i] = answerList.get(i);
                    }

                    JTableUtils.writeArrayToJTable(tableOutput, answerArr);
                } catch (Exception e) {
                    SwingUtils.showInfoMessageBox("Enter integer list");
                }
            }
        });
    }
}
