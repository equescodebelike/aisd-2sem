package task2_2;

import util.MyLinkedList;

public class Task2 {

    public static MyLinkedList<Integer> convert(MyLinkedList<Integer> entryList) throws Exception {
        MyLinkedList<Integer> answerList = new MyLinkedList<>();
        int counter = 0;

        for (int i = 0; i < entryList.getSize(); i++) { // берем элемент за сравнение
            for (int j = entryList.getSize() - 1; j >= 0; j--) { // с чем сравниваем

                if (entryList.get(j).equals(entryList.get(i)) && j != i) { // условие если находим одинаковые
                    counter++;
                }

                if (counter >= 1) {
                    break;
                }
            }

            if (counter == 0) {
                answerList.addLast(entryList.get(i)); // добавляем в ответ
            }

            counter = 0; // cброс счетчика после прохождения цикла
        }

        return answerList;
    }
}
