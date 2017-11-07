package com.aos.oigo.test;

/**
 * @Author : HuangHaoXin
 * @Description :快速排序算法
 * @Date : Create in 2017-10-16
 */
public class QuickSort
{
    //将arr[i]和arr[j]调换
    private void swap(int arr[], int i, int j)
    {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    int partition(int arr[], int l, int r)
    {
        int pivot = arr[r];
        //将小于等于pivot的元素移到左边区域
        // 将大于pivot的元素移到右边区域
        int index = l;
        for (int i = index; i < r; ++i)
        {
            if (arr[i] <= pivot)
            {
                swap(arr, index++, i);
            }
        }
        swap(arr, index, r);
        return index;
    }

    public void sort(int arr[], int l, int r)
    {
        if (l < r)
        {
            int q = partition(arr, l, r);//对左半段排序
            sort(arr, l, q - 1);//对右半段排序
            sort(arr, q + 1, r);
        }
    }
}
