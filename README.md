# 数据结构练习

**数组练习**
- MyArray 大小固定的数组实现
- MyDynamicArray 自动扩容数组实现
- LRUBaseArray 基于数组实现LRU算法
- LRUBaseArrayAndMap 基于数组与Map实现LRU算法
- PalindromeBaseArray 基于数组实现回文串的判断

**链表练习**
- SingleLinkedList 实现单链表的增、删、改、查操作
- LRUBaseLinkedList 基于单链表实现LRU算法
- PalindromeBaseLinked 基于链表实现回文串的判断

**栈练习**
- MyStack 基于数组实现栈的出栈入栈操作
- CalExpress 使用栈求简单表达式的值
- MyStackByLinked 基于链表实现栈的入栈出栈操作
- Browser 实现浏览器的前进后退功能

**队列练习**
- MyArrayQueue 基于固定大小的数组实现的队列
- MyDynamicArrayQueue 基于数组实现队列，空间不足自动搬移数据
- MyCircularQueue 基于固定大小的数组实现的环状队列
- MyQueueBaseLinkedList 基于链表实现的队列

**递归练习**
- OneOrTowStep 假如有n个台阶，每次可以跨1个台阶或者2个台阶，走完这n个台阶有多少种走法？

**排序练习**
- BubbleSort 冒泡排序
- SelectionSort 选择排序
- InsertionSort 插入排序
- MergeSort 归并排序
- QuickSort 快速排序
- KthSmallest 在数组中查找第k大的数
- CountingSort 计数排序

**查找**
- BinarySearch 二分法查找

**树**
- BinaryTreeBaseLinked 基于链表实现的二叉树
- BinarySearchTree 二叉查找树
- Heap 大顶堆实现
- HeapSort 堆排序
- Trie trie树实现

**字符串查找算法**
- BFMatch 基于BF算法查找，朴素匹配算法
- RKMatch 基于RK算法查找，使用hash函数优化BF算法

**算法**
- AddToBag 将一组不同重量的物品装入背包，求在满足背包最大重量限制的前提下，背包中物品总重量的最大值
- AddToBag2 将一组不同重量、不同价值的物品装入背包，求在满足背包最大重量限制的前提下，背包中物品总价值的最大值

**并发编程**
- SafeDateFormat 使用ThreadLocal解决SimpleDateFormat在并发场景下是线程安全的
- SafeCount 使用AtomicReference保证不可变对象的引用原子性
- ForkJoinFibonacci 使用Fork/Join计数斐波那也数
- ForkJoinWordCount 使用Fork/Join实现单词计数
- CompletionServiceTest CompletionService批量执行异步任务