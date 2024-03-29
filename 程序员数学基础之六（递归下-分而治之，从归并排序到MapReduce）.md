## 递归（下）分而治之，从归并排序到MapReduce

	1、递归：递归的使用是用来处理迭代法中比较复杂的数值计算。
	2、而有些迭代法并不是简单的数值计算，而要通过迭代的过程进行一定的操作，
	过程更加复杂，需要考虑很多中间数据的匹配或者保存。



#### 归并排序中的分治思想

　　**归并排序：** 归并排序算法的核心就是“归并”，也就是把两个有序的数列合并起来，形成一个更大的有序数列。

　　假设需要从小到大的排序，合并两个有序数列A和B。这里我们需要开辟一个新的储存空间C,用于保存合并后的结果。

　　首先需要比较两个数列的第一个数，如果A数列的第一个数小于B数列的第一个数，那么就先取出A数列的第一个数放入C,并把这个A数列里删除。。如果是B的第一个数更小，那么先取出B数列的第一个数放入C,并把它从B数列里删除
　以此类推，知道A和B里所有的数都被取出来放入C。如果到了某一步，A或者B数列为空，那讲直接将另一个数列的数据依次取出放入C就可以了。这种操作，可以保证两个有序的数列A和B合并到C之后，C数列依然数有序的。
 
　　如下图：以合并有序数组{1,2,5,8}和{3，4，6}为例。

![归并排序.md.png](https://github.com/huangruqi88/MathLearningSample/blob/master/pictures/%E5%88%86%E8%80%8C%E6%B2%BB%E4%B9%8B%20-%20%E5%BD%92%E5%B9%B6%E6%8E%92%E5%BA%8F.png)


　　***归并：*** 为了保证的到有序的C数列，我们必须保证参与合并的A和B也是有序的。等待排序的数组一开始都是乱序的。


　　1、这里我可利用的也是递归的思想，把问题不断简化，也就是把数列不断简化，一直简化到只剩一个数。1个数本身就是有序的。

　　
　　2、简化问题。最简单的就是将长度为n的数列，每次简化为n-1的数列，直至长度为1。不过这样处理没有并行性，需要进行n-1次的归并操作，效率就会很低。
　　
![归并操作简化数列长度](https://github.com/huangruqi88/MathLearningSample/blob/master/pictures/%E5%BD%92%E5%B9%B6%E6%93%8D%E4%BD%9C%E7%AE%80%E5%8C%96%E6%95%B0%E5%88%97%E9%95%BF%E5%BA%A6.png)

　　**思想：将一个复杂的问题，分解成两个甚至多个规模相同或者类似的子问题然后对于这些子问题再进一步西风，知道最好的子问题变得很简单很容易就能求解出来，这样这个复杂的问题就求解出来了。分而治之简称分治。**

　　通过归并排序通过分治的思想，把长度为n的数列，每次简化为两个长度为n/2的数列。这样更有利于计算机的并行处理，只需要log2n次归并。
![log2n次归并.md.png](https://github.com/huangruqi88/MathLearningSample/blob/master/pictures/log2n.png)以一个包含0~9这10个数字的数组为例。如下

* 假设初始数组为{7, 6, 2, 4, 1, 9, 3, 8, 0, 5}我们要对它进行从小到大的排序。
* 第一次分解后，变成两个数组{7, 6, 2, 4, 1}和{9, 3, 8, 0, 5}。
* 然后，我们将{7，6，2，4，1}分解为{7，6}和{2，4，1}，将{9，3，8，0，5}分解为{9，3}和{8，0，5}。
* 如果细分后的数组仍然多于一个数组，我们可以将{4，1}分解为{4}和{1}。现在无法再细分了我们开始合并。在合并的过程中进行排序，所以合并的结果为{1，4}。合并后的结果将返回当前函数的调用，这就是函数返回的过程。
* 重复上述合并的过程，知道完成整个数组的排序，得到{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}。如下图

![归并排序0 9排序过程.md.png](https://github.com/huangruqi88/MathLearningSample/blob/master/pictures/%E5%BD%92%E5%B9%B6%E6%8E%92%E5%BA%8F0-9%E6%8E%92%E5%BA%8F%E8%BF%87%E7%A8%8B.png)

**归并、分治和递归：** 归并排序使用了分治的思想，而这个过程需要使用递归来实现。

　　***解释：*** 归并排序算法用分治的思想把数列不断地简化，直到每个数列今生下一个单独的数，然后在使用归并桌布合并有序的数列，从而达到整个数列进行排序的目的。而归并排序正好可以使用递归的方式来实现。

![归并、分治和递归的关系.png](https://github.com/huangruqi88/MathLearningSample/blob/master/pictures/%E5%BD%92%E5%B9%B6%E3%80%81%E5%88%86%E6%B2%BB%E5%92%8C%E9%80%92%E5%BD%92%E7%9A%84%E5%85%B3%E7%B3%BB.png)

　　分治的过程可以通过递归来表达，因此，归并排序最直观的实现方式就是递归。所以我们从递归步骤出，来看归并排序如何实现。

　　我们假设n=k-1的时候，我们已经对较小的两数组进行了排序。那我们只要在n=k的时候，经两个数组合并起来，并且保证合并后的数组仍然是有序的就行了。

　　所以，在递归的每次嵌套调用中，代码都将一组数分解成更小的两组，然后将这两个小组的排序交给下一次的嵌套调用。而本次调用只需要关系，如何将排好序的两个小组进行合并。
　　
　　在初始状态，也就是n=1的时候，对于排序的案例而言，只包含单个数字的分组。由于分组里只有一个数字，所以它已经是拍好徐的，之后就可以开始递归调用的返回阶段。如图：


![归并排序0 9迭代过程图.png](https://github.com/huangruqi88/MathLearningSample/blob/master/pictures/%E5%BD%92%E5%B9%B6%E6%8E%92%E5%BA%8F0-9%E8%BF%AD%E4%BB%A3%E8%BF%87%E7%A8%8B%E5%9B%BE.png)

　　代码如下：
	
    /**
     * @param toSort 等待排序的数组
     * @return int[] 排序后的数组
     * @Description: 使用过函数的递归（嵌套）调用，实现归并排序（从小到大）
     */
    public static int[] mergeSort(int[] toSort) {
        if (toSort == null) {
            return new int[0];
        }
        //如果分解到只剩一个数，返回该数
        if (toSort.length == 1) {
            return toSort;
        }
        //将数组分解成左右两半
        int middle = toSort.length / 2;
        int[] left = Arrays.copyOfRange(toSort, 0, middle);
        int[] right = Arrays.copyOfRange(toSort, middle, toSort.length);

        //嵌套调用，对两半分别进行排序
        left = mergeSort(left);
        right = mergeSort(right);
        //合并排序后的两半
        int[] merged = merge(left, right);
        return merged;
    }

    /**
     * @param left  第一个数组
     * @param right 第二个数组
     * @return int[] 合并后的数组
     * @Decription 合并两个已经排序完毕的数字（从小到大）
     */
    private static int[] merge(int[] left, int[] right) {
        if (left == null) {
            left = new int[0];
        }
        if (right == null) {
            right = new int[0];
        }
        int[] mergedOne = new int[left.length + right.length];

        int middleIndex = 0, leftIndex = 0, rightIndex = 0;

        //轮流冲连个数组中取出较小的值，放入合并后的数组中
        while (leftIndex < left.length && rightIndex < right.length) {
            if (left[leftIndex] <= right[rightIndex]) {
                mergedOne[middleIndex] = left[leftIndex];
                leftIndex++;
            } else {
                mergedOne[middleIndex] = right[rightIndex];
                rightIndex++;
            }
            middleIndex++;
        }

        //将某个数组内剩余的数字放入合并的数组中
        if (leftIndex < left.length) {
            for (int i = leftIndex; i < left.length; i++) {
                mergedOne[middleIndex] = left[i];
                middleIndex++;
            }
        } else {
            for (int i = rightIndex; i < right.length; i++) {
                mergedOne[middleIndex] = right[i];
                middleIndex++;
            }
        }
        return mergedOne;
    }

	public static void main(String[] args) {
        int[] toSort ={3434, 3356, 67, 12334, 878667, 387};
        int[] sorted= Lesson6_1.mergeSort(toSort);
        for (int i = 0; i < sorted.length; i++) {
            System.out.println(sorted[i]);
        }
    }



　　**分布式系统中的分治思想**
　　例如：当需要排序的数组很大（比如内存达到2014GB），我们没办法将这些数据塞入一台普通机器的内存里的。此时，我们可以把这个超级大的数据集(比如16GB或者更小)，分解为多个更小的数据集，然后分配到多带机器，让他们并行的处理。
　　等所有机器处理完后，中央服务器再进行结果的合并。由于多个小任务间不会互相干扰，可以同时处理，这样会大大增加处理的速度，减少等待时间。

　　在单台机器上实现归并排序的时候，我们只需要在递归函数内，实现数据分组以及合并就行了。而在多个机器之间分配数据的时候，递归函数内除了分组及合并，还要负责把数据分发到某台机器上。

![分支思想集群图示.png](https://github.com/huangruqi88/MathLearningSample/blob/master/pictures/%E5%88%86%E6%94%AF%E6%80%9D%E6%83%B3%E9%9B%86%E7%BE%A4%E5%9B%BE%E7%A4%BA.png)

　　如框架图中，分布式集群中的数据切分和合并，同单台机器上归并排序的过程是一样的，因此也是使用了分治的西乡。从理论的角度来看，上面这个图很容易理解。不过在实际运用中，有个地方需要注意一下。

　　上图的福接待你，例如机器1、2、3，他们都没有被分配排序的工作，只是在子节点的排序完成后进行有序数组的合并，因此集群的性能没有得到充分利用。另一种可能的数据切分是，每台机器拿出一半的数据给另一台机器处理，而自己来完成剩下一半的数据。

![分治集群机器架构图二.png](https://github.com/huangruqi88/MathLearningSample/blob/master/pictures/%E5%88%86%E6%B2%BB%E9%9B%86%E7%BE%A4%E6%9C%BA%E5%99%A8%E6%9E%B6%E6%9E%84%E5%9B%BE%E4%BA%8C.png)

　　如果分治的时候，只进行一次问题切分，那么上述层级型的分布式架构就可以转化为类似的MapReduce的架构。如下：

![分治思想 分布式架构MapReduce架构图.png](https://github.com/huangruqi88/MathLearningSample/blob/master/pictures/%E5%88%86%E6%B2%BB%E6%80%9D%E6%83%B3-%E5%88%86%E5%B8%83%E5%BC%8F%E6%9E%B6%E6%9E%84MapReduce%E6%9E%B6%E6%9E%84%E5%9B%BE.png)

　　分治思想体现如下：

　　**1.数据分割和映射**

　　分割是指数据源进行切分，并将分片发送到Mapper上。映射是指Mapper根据应用的需求，将内容按照 键-值 的匹配，储存到哈希结构中。这两个步骤将大的数据集合切分为更小的数据集，降低了每台机器节点的负载，因此分支中的问题分解类似。不过，MapReduce采取了哈希映射来分配数据，而普通的分治或递归不一定需要。 

　　**2.归约**

　　归约是指接受到的一组键值配对，如果键内容相同的配置，就将它们的值归并，这和本机的递归调用后返回结果的过程类似。不过，由于哈希映射的关系，MapReduce还需要洗牌的步骤，也就是将 键-值 的配对不断地发给对应的Reducer进行归约。普通的分治或递归不一定需要洗牌的步骤。

　　**3.合并**

　　为了提升洗牌阶段的效率，可以选择减少发送到归约阶段的  键-值 配对。具体做法是在数据映射和洗牌之间，加入合并的过程，在每个Mapper节点上先进行一次本地的归约。然后只将合并的结果发送到洗牌和归约阶段。这和本机的递归调用后返回结果的过程类似。

#### 总结

　　分治主要就是用在将复杂问题转化为若干个规模相当的小问题上。分治思想通常报过问题的细分和结果的合并，
正好对应于递归编程的函数嵌套调用和函数结果的返回。所以，分治问题适合使用递归来实现。同时，分治的西乡也
可以帮助我们设计分布式系统和并行计算，细分后的问题交给不同的机器来处理，而其中的某些机器专门负责收集来自不同机器的处理结果，完成结果的合并。










