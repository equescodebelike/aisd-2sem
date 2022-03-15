package task2_2;

import util.MyLinkedList;

public class Task2 {

    public static MyLinkedList<Integer> convert(MyLinkedList<Integer> entryList) throws Exception {
        final MyLinkedList<Integer> answerList = new MyLinkedList<>();
        int counter = 0;

        for (int i = 0; i < entryList.getCount(); i++) {
            for (int j = 0; j < entryList.getCount(); j++) {

                if (entryList.get(j).equals(entryList.get(i)) && j != i) {
                    counter++;
                }

                if (counter >= 1) {
                    break;
                }
            }

            if (counter == 0) {
                answerList.addLast(entryList.get(i));
            }

            counter = 0;
        }

        return answerList;
    }
}
