import java.util.Arrays;
import java.util.Random;

public class ex3 {
    public static void main(String args[]){
        Random rand = new Random();
        int arr[] = new int[10];        
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rand.nextInt(100);          
        }
        //int arr[] = {31, 3, 19, 89, 41, 27, 84, 71, 17, 20};
        System.out.println("Исходный массив:");
        System.out.println(Arrays.toString(arr));        

        ex3 sorting = new ex3();
        sorting.sort(arr);

        System.out.println("Отсортированный массив:");
        System.out.println(Arrays.toString(arr));
    }

    public void sort(int arr[]) {
        int n = arr.length;
        
        for (int i = n / 2 - 1; i >= 0; i--) { // Построение кучи (перегруппируем массив)
            heapify(arr, n, i);
        }    
        for (int i=n-1; i>=0; i--) { // Перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // Вызываем процедуру heapify на уменьшенной куче
            heapify(arr, i, 0);
        }
    }


    public void heapify(int arr[], int n, int i) // Преобразуем в arr[] в двоичную кучу с корневым узлом i, n - размер кучи
    {
        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2; 
           
        if (left < n && arr[left] > arr[largest])
            largest = left;

        if (right < n && arr[right] > arr[largest])
            largest = right;

        if (largest != i)
        {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            heapify(arr, n, largest);
        }
    }
}
