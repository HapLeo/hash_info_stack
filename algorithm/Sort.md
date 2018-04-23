 ### 排序算法

 #### 冒泡排序  O(n^2)
**思想：相邻比较（小熊掰玉米）**

 ```java

 public static void bubbleSort(int[] a){
         int temp;
         boolean flag;

         for (int i=0;i<a.length-1;i++){
             flag = false;
             for (int j=0;j<a.length-1-i;j++){
                 if (a[j] > a[j+1]){
                     temp = a[j];
                     a[j] = a[j+1];
                     a[j+1] = temp;
                     flag = true;
                 }
             }
  // 如果没有人和交换，则停止循环
             if (!flag){
                 break;
             }
         }
     }

 ```

 #### 插入排序 O(n^2)
 **思想：默认第一个元素有序，后面的找位置插入**

 ```java
 public static void insertionSort(int[] a){

         int temp;

         for (int i=0;i<a.length-1;i++){
             boolean flag = false;
             for (int j=i+1;j>0;j--){

                 if (a[j] < a[j-1]){
                     temp = a[j];
                     a[j] = a[j-1];
                     a[j-1] = temp;
                     flag = true;
                 }else {
                   // 如果不再交换，说明已经到达正确位置，无需继续内循环
                     break;
                 }
             }
         }
     }
 ```

 #### 选择排序 O(n^2)
 **思想：选择当前及之后位置的最小值，保存在当前位置上**
 ```java
 public static void selectionSort(int[] a){
       int temp;
       int minIndex;
       boolean flag;
       for (int i=0;i<a.length-1;i++){
           flag = false;
           minIndex = i;
           for (int j=i+1;j<a.length;j++){
               if (a[minIndex] > a[j]){
                   minIndex = j;
                flag = true;
               }
           }

           if (flag){
               temp = a[i];
               a[i] = a[minIndex];
               a[minIndex] = temp;
           }
       }
   }

 ```

##### 归并排序 O(nlogn)
**分治思想，递归操作，拆分数组为单元素数组即为有序数组，再将两个有序集合合并**
```java

public static void mergeSort(int[] a, int[] temp, int start, int end) {
    if (start < end) {
        int mid = (start + end) / 2;
        mergeSort(a, temp, start, mid);
        mergeSort(a, temp, mid + 1, end);
        merge(a, temp, start, mid, end);
    }
}

private static void merge(int[] a, int[] temp, int start, int mid, int end) {
    int st1 = start;
    int ed1 = mid;
    int st2 = mid + 1;
    int ed2 = end;
    int tp = start;

    while (st1 <= ed1 && st2 <= ed2) {
        if (a[st1] <= a[st2]) {
            temp[tp] = a[st1];
            tp++;
            st1++;
        } else{
            temp[tp] = a[st2];
            tp++;
            st2++;
        }
    }

    while (st1 <= ed1) {
        temp[tp] = a[st1];
        tp++;
        st1++;
    }

    while (st2 <= ed2) {
        temp[tp] = a[st2];
        tp++;
        st2++;
    }

    for (int i=start;i<=end;i++){
        a[i] = temp[i];
    }
}

```
