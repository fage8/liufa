import java.util.Arrays;

/**
 * 字符串排序
 * 输入["nice", "try", "do"]
 * 输出["do", "nice", "try"]
 */
public class StringArraySort {


        public static void main(String[] args) {
            String[] a = new String[]{"nice", "try", "do"};
            String[] res = quick_sort(a);
            for (int i = 0; i < res.length; i++) {
                System.out.print(res[i] + " ");
            }
        }
        /**
         *
         * @param array string字符串一维数组
         * @return string字符串一维数组
         */
        public static String[] quick_sort (String[] array) {
            // write code here
            // 对 arr 进行拷贝，不改变参数内容
            String[] arr = Arrays.copyOf(array, array.length);
            return quickSort(arr, 0, arr.length - 1);
        }

        private static String[] quickSort(String[] arr, int left, int right) {
            if (left < right) {
                int partitionIndex = partition(arr, left, right);
                quickSort(arr, left, partitionIndex - 1);
                quickSort(arr, partitionIndex + 1, right);
            }
            return arr;
        }

        private static int partition(String[] arr, int left, int right) {
            // 设定基准值（pivot）
            int pivot = left;
            int index = pivot + 1;
            for (int i = index; i <= right; i++) {
                if (arr[i].compareTo(arr[pivot]) < 0) {
                    swap(arr, i, index);
                    index++;
                }
            }
            swap(arr, pivot, index - 1);
            return index - 1;
        }

        private static void swap(String[] arr, int i, int j) {
            String temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }


}
