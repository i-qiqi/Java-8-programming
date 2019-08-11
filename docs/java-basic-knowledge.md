# 数据类型
## 基本数据类型常量池

## Integer , IntegerCahche

# String
## String的不可变性
- `String Pool 的需要`: 我们编程有百分之八十的时间在处理字符串，而处理的字符串中有很大概率会出现重复的情况
- `安全性`: 可以有效的防止字符串被有意或者无意的篡改。String 不可变性天生具备线程安全
- `缓存hashcode`: 作为HashMap、HashTable等hash型数据key的必要。jvm底层很容易在缓存String对象的时候缓存其hashcode，这样在执行效率上会大大提升。

## String Pool
字符串常量池的诞生是为了提升效率和减少内存分配
-  String的String Pool是一个`固定大小的Hashtable`，默认值大小长度是1009;在jdk7中，StringTable的长度可以通过一个参数指定：`-XX:StringTableSize=99991`
- `new String("abc")` : 一共会创建两个字符串对象:
    - 第一个对象是“abc”字符串存储在常量池中,在常量池中保存一个指向堆的引用(intern 方法);
    - 第二个对象在JAVA Heap中的字符串对象;
## String#intern
- 在jdk1.7之前，字符串常量存储在方法区的PermGen Space。在jdk1.7之后，字符串常量重新被移到了堆中,常量池中不需要再存储一份对象了，可以直接存储堆中的引用


# Object类的方法

# Java的Exception类型 


# 
＃　Ref
- [Intern面试题](https://www.cnblogs.com/xuxinstyle/p/9526210.html)
- [String::intern](https://tech.meituan.com/2014/03/06/in-depth-understanding-string-intern.html)
- [String类相关面试题](https://www.jianshu.com/p/a4a73d9480a3)

