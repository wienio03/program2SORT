package pl.uj.edu.s1192410;

import java.util.Scanner;


class Sort {
    int[][] selectionSortArrays;
    int[][] bubbleSortArrays;

    int getNextGap(int gap){
        gap = (gap*10)/13;
        if(gap < 1)
            return 1;
        return gap;
    }
    void displayArray(int[][] array){
        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array[i].length; j++){
                System.out.println(array[i][j]);
            }
        }
    }
    void bubbleSort(){
        boolean swapped = true;
        for(int i = 0; i < bubbleSortArrays.length; i++){
            for(int j = 0; j < bubbleSortArrays[i].length; j++){
                swapped = false;
                for(int k = j + 1; k < bubbleSortArrays[i].length - 1; k++){
                    if(bubbleSortArrays[i][k] > bubbleSortArrays[i][k+1]){
                        int tmp = bubbleSortArrays[i][k];
                        bubbleSortArrays[i][k] = bubbleSortArrays[i][k+1];
                        bubbleSortArrays[i][k+1] = tmp;
                        swapped = true;
                    }
                    if(swapped)
                        break;
                }

            }
        }
    }
    void combSort(){
        for(int i = 0; i < bubbleSortArrays.length; i++){
            int gap = bubbleSortArrays[i].length;
            boolean swapped = true;
            while( gap != 1 || swapped == true){
                gap = getNextGap(gap);
                swapped = false;
                for(int j = 0; j < bubbleSortArrays[i].length - gap;  j++){
                    if(bubbleSortArrays[i][j] > bubbleSortArrays[i][j+1]){
                        int tmp = bubbleSortArrays[i][j];
                        bubbleSortArrays[i][j] = bubbleSortArrays[i][j+1];
                        bubbleSortArrays[i][j+1] = tmp;
                        swapped = true;
                    }
                }
            }
        }
    }
    void selectionSort(){
        int min;
        for(int i = 0; i < selectionSortArrays.length; i++){
            for(int j = 0; j < selectionSortArrays[i].length; j++){
                min = j;
                for(int k = j+1; k < selectionSortArrays[i].length; k++){
                    if(selectionSortArrays[i][min] > selectionSortArrays[i][k])
                        min = k;
                    //usprawnienie
                    if(min != j){
                        int tmp = selectionSortArrays[i][min];
                        selectionSortArrays[i][min] = selectionSortArrays[i][j];
                        selectionSortArrays[i][j] = tmp;
                    }
                }
            }
        }
    }

}
public class Source {
    public static void main(String[] args) {

        Sort sort = new Sort();
        sort.selectionSortArrays = new int[][]{{5, 4, 3, 2, 1}, {6, 5, 4, 3, 2}, {7, 6, 5, 4, 3}, {8, 7, 6, 5, 4}, {9, 8, 7, 6, 5}};
        sort.bubbleSortArrays = new int[][]{{5, 4, 3, 2, 1}, {6, 5, 4, 3, 2}, {7, 6, 5, 4, 3}, {8, 7, 6, 5, 4}, {9, 8, 7, 6, 5}};
        //sort.bubbleSort();
        //sort.selectionSort();
        //sort.displayArray(sort.selectionSortArrays);
        sort.combSort();
        sort.displayArray(sort.bubbleSortArrays);
        System.out.println("Hello world!");
    }
}