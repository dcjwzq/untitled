package com.study;

public class Sort {
    public int[] insertSort(int[] nums){//直接插入排序
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i-1]){
                int j = i - 1;
                int tem = nums[i];//提取数字
                while (j > -1 && tem <= nums[j]){//数字前的数组后移
                    nums[j+1] = nums[j];
                    j--;
                }
                nums[j+1] = tem;//插入
            }
        }
        return nums;
    }
    public int[] shellSort(int[] nums,int gap){
        while (gap != 0){
            for (int i = gap; i < nums.length; i+=gap) {
                if (nums[i] < nums[i-gap]){//插入排序
                    int j = i - gap;
                    int tem = nums[i];
                    while (j > -1 && tem <= nums[j]){
                        nums[j+gap] = nums[j];
                        j -= gap;
                    }
                    nums[j+gap] = tem;
                }
            }
            gap /= 2;
        }
        return nums;
    }
    public int[] selectionSort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            int loc = i;
            for (int j = i+1; j < nums.length; j++) {//找到最小的值的位置
                if (nums[loc] > nums[j]){
                    loc = j;
                }
            }
            int tem = nums[loc];//交换
            nums[loc] = nums[i];
            nums[i] = tem;
        }
        return nums;
    }
    public int[] heapSort(int[] nums){
        for (int i = nums.length-1; i > 0; i--) {
            for (int j = (i+1)/2-1; j >= 0 ; j--) {//建堆
                int left = j * 2 + 1;
                if (left + 1 < i + 1){//(i+1)为nums.length使其不用新添加变量即可变化
                    if (nums[left] < nums[left+1]){
                        left++;
                    }
                    if (nums[j] < nums[left]){
                        int tem = nums[j];
                        nums[j] = nums[left];
                        nums[left] = tem;
                    }
                }
                else{
                    if (nums[j] < nums[left]){
                        int tem = nums[j];
                        nums[j] = nums[left];
                        nums[left] = tem;
                    }
                }
            }
            int tem = nums[0];
            nums[0] = nums[i];
            nums[i] = tem;
        }
        return nums;
    }
    public int[] bubbleSort(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length-i-1; j++) {
                if (nums[j] > nums[j+1]){
                    int tem = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tem;
                }
            }
        }
        return nums;
    }
    public int[] quickSort(int[] nums,int low,int high){
        if (low>=high){
            return nums;
        }
        int left = low;
        int right = high;
        int pivot = nums[left];
        while (left < right){
            while (left < right && pivot <= nums[right]){
                right--;
            }
            if (left < right) {//填坑
                nums[left] = nums[right];
                left++;
            }
            while (left < right && pivot >= nums[left]){
                left++;
            }
            if (left < right) {//填坑
                nums[right] = nums[left];
                right--;
            }

        }
        nums[left] = pivot;//将最后位置的坑填上

        quickSort(nums,low,left-1);
        quickSort(nums,left+1,high);
        return nums;
    }
    public int[] mergeSort(int[] nums,int low,int high){
        int mid = (low + high) / 2;
        if (low < high){
            mergeSort(nums ,low ,mid);
            mergeSort(nums ,mid +1,high);
            merge(nums ,low ,mid ,high);
        }
        return nums;
    }
    public void merge(int[] nums,int low, int mid, int high){
        int[] temp = new int[high-low +1];
        int left = low;
        int right = mid + 1;
        int k = 0;
        while (left <= mid && right <= high){
            if (nums[left] < nums[right]){
                temp[k++] = nums[left++];
            } else {
              temp[k++] = nums[right++];
            }

        }
        while (left <= mid){//左边数组数字存入temp
            temp[k++] = nums[left++];
        }
        while (right <= high){//把右边数组数字存入temp
            temp[k++] = nums[right++];
        }
        for (int i = 0; i < temp.length; i++) {
            nums[i+low] = temp[i];
        }
    }
    public int[] radixSort(int[] nums){//升位
        int tem = nums[0];
        for (int i = 0; i < nums.length; i++) {//找出最大位数
            if (tem < nums[i]){
                tem = nums[i];
            }
        }

        int temDigit = 1;
        while (tem / 10 > 0){//找出最高位
            temDigit++;
            tem /= 10;
        }

        int[][] buckets = new int[10][nums.length];//桶
        int base = 10;
        for (int i = 0; i < temDigit; i++) {
            int[] bucketNumber = new int[10];//记录桶中每位个数
            for (int j = 0; j < nums.length; j++) {
                int whichBuckets = (nums[j] % base) / (base / 10);
                buckets[whichBuckets][bucketNumber[whichBuckets]] = nums[j];
                bucketNumber[whichBuckets]++;
            }
            int k = 0;
            for (int j = 0; j < buckets.length; j++) {
                for (int l = 0; l < bucketNumber[j]; l++) {
                    nums[k++] = buckets[j][l];
                }
            }
            base *= 10;
        }
        return nums;
    }

    public void outNums(int[] nums){
        for (int i:nums) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] nums = {32, 54, 98, 76, 90, 92, 14, 35, 63, 11, 98, 51, 71, 39};
        Sort sort = new Sort();
/*        System.out.printf("希尔排序\t");
        sort.outNums(sort.shellSort(nums,5));
        System.out.printf("插入排序\t");
        sort.outNums(sort.insertSort(nums));
        System.out.printf("选择排序\t");
        sort.outNums(sort.selectionSort(nums));
        System.out.printf("堆排序\t");
        sort.outNums(sort.heapSort(nums));
        System.out.printf("快速排序\t");
        sort.outNums(sort.quickSort(nums,0,nums.length-1));
        System.out.printf("归并排序\t");
        sort.outNums(sort.mergeSort(nums,0,nums.length-1));*/
        System.out.printf("基数排序\t");
        sort.outNums(sort.radixSort(nums));
/*        long start = System.nanoTime();

        long end = System.nanoTime();
        System.out.println(end-start);*/
    }
}
