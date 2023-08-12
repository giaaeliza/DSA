import java.util.ArrayList;
import java.util.List;
public class ArrayIndexSearch {
    public static int[] searchIndexes(int[] arr, int num) {
        List<Integer> indexes = new ArrayList<>();
        searchIndexes(arr, num, 0, indexes);
        return indexes.stream().mapToInt(Integer::intValue).toArray();
    }
    private static void searchIndexes(int[] arr, int num, int index, List<Integer> indexes) {
        if (index >= arr.length) {
            return;
        }
        if (arr[index] == num) {
            indexes.add(index);
        }
        searchIndexes(arr, num, index + 1, indexes);
    }
    public static void main(String[] args) {
        System.out.println("Georgia Thomas\nSAP ID: 1000014172");
        int[] arr = {20, 5, 6, 0, 5, 9, 5};
        int num = 5;
        int[] result = searchIndexes(arr, num);
        System.out.print("[");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]);
            if (i < result.length - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }}
