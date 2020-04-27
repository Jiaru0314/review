package com.xzq.algorithm.array;

import lombok.Data;

/**
 * @ClassName: MyArray
 * @description: 自定义一个数组类，实现数组的插入、删除、扩容、输出
 * @author: XZQ
 * @create: 2020/4/16 8:00
 **/
@Data
public class MyArray {
    private int size;
    private int[] array;

    public MyArray(int capacity) {
        this.size = 0;
        this.array = new int[capacity];
    }

    public void add(int element) {
        //判断是否需要扩容
        ensureExplicitCapacity();
        array[size++] = element;
    }

    public int delete(int index) {
        //判断是否越界
        rangeCheckForAdd(index);
        int deleteElement = array[index];
        for (int i = size - 1; i <= index; i++) {
            array[i] = array[i] + 1;
        }
        size--;
        return deleteElement;
    }

    public void insert(int index, int element) {
        //判断是否越界
        rangeCheckForAdd(index);

        //判断是否需要扩容
        ensureExplicitCapacity();

        for (int i = size - 1; i <= index; i++) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        size++;
    }

    private void resize() {
        int[] newArray = new int[array.length << 1];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    private void rangeCheckForAdd(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("超出数组实际元素范围");
    }

    //判断是否需要扩容
    private void ensureExplicitCapacity() {
        if (size >= array.length) {
            resize();
        }
    }

    public void outPutArray() {
        for (int i = 0; i < size; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void main(String[] args) {
        MyArray myArray = new MyArray(10);
        for (int i = 0; i < 10; i++) {
            myArray.add(i);
        }
        myArray.outPutArray();
        myArray.insert(4,50);
        System.out.println(myArray);
        myArray.delete(2);
        System.out.println(myArray);
    }
}
