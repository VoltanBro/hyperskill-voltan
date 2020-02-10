package HyperSkill;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BubbleSort {

    public static int[] bubbleSort(int[] arr) {
        int counter = 0;
        int temp = 0;
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] < arr[j+1]) {
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    counter++;
                }
            }
        }

        System.out.println(counter);
        return arr;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> myList = new ArrayList<>();
        do {
            myList.add(sc.nextInt());
        } while (sc.hasNextInt());

        int[] myArr = new int[myList.size()];

        for (int i = 0; i < myArr.length; i++) {
            myArr[i] = myList.get(i);
        }

        bubbleSort(myArr);

    }
}
