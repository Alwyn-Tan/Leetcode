public class QuickSort {

  public static void quickSort(int[] arr, int left, int right) {
    if (left >= right) {
      return;
    }
    int temp = arr[left];
    int i = left;
    int j = right;
    while (i < j) {
      while (i < j && arr[j] >= temp) {
        j--;
      }
      while (i < j && arr[i] <= temp) {
        i++;
      }
      if (i < j) {
        int temp2 = arr[i];
        arr[i] = arr[j];
        arr[j] = temp2;
      }
    }
    arr[left] = arr[i];
    arr[i] = temp;

    quickSort(arr, left, i - 1);
    quickSort(arr, i + 1, right);
  }

  public static void main(String[] args) {
    int[] arr = new int[] { 10, 1, 2, 7, 6, 1, 5 };
    quickSort(arr, 0, arr.length - 1);
    for (int i : arr) {
      System.out.print(i + " ");
    }
  }
}
