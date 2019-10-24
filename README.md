关于函数式接口
 1. 如果一个接口只有一个抽象方法，那么就是一个函数式接口。
 2. 如果我们在接口上声明了@FunctionalInterface注解，那么编译器会按照函数式接口来要求该接口。
 3. 如果一个接口只有一个抽象方法，但没有@FunctionalInterface注解，编译器依旧会认为该接口为函数式接口。
 4. java8中接口中可以有默认实现
 
方法引用 method reference
 1. 方法引用实际上是个lambda表达式的一个语法糖
 2. 我们可以将方法引用看作是一个函数指针，function pointer
 3. 方法引用分为4类：
   * 类名::静态方法名
   * 引用名(对象的句柄)::实例方法名
   * 类名::实例方法名
   * 构造方法的引用：类::new        
   
流由3部分组成
 1. 源
 2. 零个或者多个中间操作
 3. 终止操作
 
流的分类
 1. 惰性操作
 2. 及早求值
 
collect:收集器
 1. Collector是collect的方法参数
 2. Collector是一个接口，它是一个可变的汇聚操作，将输入元素累积到一个可变的结果容器中；它会在所有元素都处理完毕后将累积的结果转换为一个最终的表示（这是个可选的操作）；它支持串行与并行两种方式。
 3. Collectors本身提供了关于Collector的常见汇聚实现，Collectors本身是一个工厂。
 
流操作底层原理 
 1. StreamSupport:这个类主要用于创建流的低级方法
 2. ReferencePipeline:表示流的源阶段或者中间阶段，ReferencePipeline.Head:表示流的源阶段。二者大部分的属性设定上是一样的。
 3. 流操作的重要流程：
   ```java
   //将流的所有操作串起来，然后让每个数据依次进行这些操作
    if (!StreamOpFlag.SHORT_CIRCUIT.isKnown(getStreamAndOpFlags())) {
            wrappedSink.begin(spliterator.getExactSizeIfKnown()); 
            spliterator.forEachRemaining(wrappedSink);
            wrappedSink.end();
        }
   ```
 4. 类层次:BaseStream->AbstractPipeline->ReferencePipeline->ReferencePipeline.Head,ReferencePipeline.StatelessOp,ReferencePipeline.StatefulOp
 5. TerminalOp:终止操作

 
 
 
 
 
 
 
 