[TOC]

# 一、创建型

## 1.1 单例模式（Singleton）

### 1.1.1 介绍

**意图：**保证一个类仅有一个实例，并提供一个访问它的全局访问点。

**主要解决：**一个全局使用的类频繁地创建与销毁。

**何时使用：**当想控制实例数目，节省系统资源的时候。

**如何解决：**判断系统是否已经有这个单例，如果有则返回，如果没有则创建。

**关键代码：**构造函数是私有的。

**应用实例：**

1、Windows 是多进程多线程的，在操作一个文件的时候，就不可避免地出现多个进程或线程同时操作一个文件的现象，所以所有文件的处理必须通过唯一的实例来进行。 

2、一些设备管理器常常设计为单例模式，比如一个电脑有两台打印机，在输出的时候就要处理不能两台打印机打印同一个文件。

**优点：** 

1、在内存里只有一个实例，减少了内存的开销，尤其是频繁的创建和销毁实例（比如管理学院首页页面缓存）。 

2、避免对资源的多重占用（比如写文件操作）。

**缺点：** **没有接口，不能继承，与单一职责原则冲突，一个类应该只关心内部逻辑，而不关心外面怎么样来实例化。**

**使用场景：** 

1、要求生产唯一序列号。 

2、WEB 中的计数器，不用每次刷新都在数据库里加一次，用单例先缓存起来。

3、创建的一个对象需要消耗的资源过多，比如 I/O 与数据库的连接等。

**注意事项：**getInstance() 方法中需要使用同步锁 synchronized (Singleton.class) 防止多线程同时进入造成 instance 被多次实例化。

### 1.1.2 实现方式

使用一个私有构造函数、一个私有静态变量以及一个公有静态函数来实现。

私有构造函数保证了不能通过构造函数来创建对象实例，只能通过公有静态函数返回唯一的私有静态变量。

![](http://pk85c13xg.bkt.clouddn.com/201919092243-j.png)

**懒汉式-线程不安全**

以下实现中，私有静态变量 uniqueInstance 被延迟实例化（把对象的创建延迟到使用的时候创建，而不是对象实例化的时候创建 ），这样做的好处是，如果没有用到该类，那么就不会实例化 uniqueInstance，从而节约资源。

这个实现在多线程环境下是不安全的，如果多个线程能够同时进入 `if (uniqueInstance == null)` ，并且此时 uniqueInstance 为 null，那么会有多个线程执行 `uniqueInstance = new Singleton();` 语句，这将导致实例化多次 uniqueInstance。

```java
package com.design.pattern.singleton;

/**
 * @Author: 98050
 * @Time: 2019-01-09 22:39
 * @Feature:
 */
public class Singleton {

    private static Singleton uniqueInstance;

    private Singleton(){
         System.out.println("运行");
    }

    public static Singleton getUniqueInstance() {
        if (uniqueInstance == null){
            uniqueInstance = new Singleton();
        }
        return uniqueInstance;
    }
}

```

**饿汉式-线程安全**

线程不安全问题主要是由于 uniqueInstance 被实例化多次，采取直接实例化 uniqueInstance 的方式就不会产生线程不安全问题。但是直接实例化的方式也丢失了延迟实例化带来的节约资源的好处。

```java
package com.design.pattern.singleton;

/**
 * @Author: 98050
 * @Time: 2019-01-09 23:03
 * @Feature: 饿汉式-线程安全
 */
public class Singleton2 {

    private static Singleton2 uniqueInstance = new Singleton2();

    private Singleton2(){
        System.out.println("运行");
    }

    public static Singleton2 getUniqueInstance() {
        return uniqueInstance;
    }
}

```

**懒汉式-线程安全**

只需要对 getUniqueInstance() 方法加锁，那么在一个时间点只能有一个线程能够进入该方法，从而避免了实例化多次 uniqueInstance。但是当一个线程进入该方法之后，其它试图进入该方法的线程都必须等待，即使 uniqueInstance 已经被实例化了。这会让线程阻塞时间过长，因此该方法有性能问题，不推荐使用。

```java
package com.design.pattern.singleton;

/**
 * @Author: 98050
 * @Time: 2019-01-09 23:03
 * @Feature: 懒汉式-线程安全
 */
public class Singleton3 {

    private static Singleton3 uniqueInstance;

    private Singleton3(){
        System.out.println("运行");
    }

    public static synchronized Singleton3 getUniqueInstance() {
        if (uniqueInstance == null){
            uniqueInstance = new Singleton3();
        }
        return uniqueInstance;
    }
}

```

**双重校验锁-线程安全**

uniqueInstance 只需要被实例化一次，之后就可以直接使用了。加锁操作只需要对实例化那部分的代码进行，只有当 uniqueInstance 没有被实例化时，才需要进行加锁。双重校验锁先判断 uniqueInstance 是否已经被实例化，如果没有被实例化，那么才对实例化语句进行加锁。

```java
package com.design.pattern.singleton;

/**
 * @Author: 98050
 * @Time: 2019-01-09 23:03
 * @Feature: 双重校验锁-线程安全
 */
public class Singleton4 {
    private static volatile Singleton4 uniqueInstance;

    private Singleton4(){
        System.out.println("运行");
    }

    public static Singleton4 getUniqueInstance() {
        if (uniqueInstance == null){
            synchronized (Singleton4.class) {
                if (uniqueInstance == null) {
                    uniqueInstance = new Singleton4();
                }
            }
        }
        return uniqueInstance;
    }
}

```

如果上述代码中只使用外部一个if语句话，那么就有可能两个线程都进入到if语句内部，这样的话uniqueInstance就会被实例化两次了，因此必须使用双重校验锁。

> ==uniqueInstance 采用 volatile 关键字修饰也是很有必要的， `uniqueInstance = new Singleton();` 这段代码其实是分为三步执行：==
>
> 1. ==为 uniqueInstance 分配内存空间==
> 2. ==初始化 uniqueInstance==
> 3. ==将 uniqueInstance 指向分配的内存地址==
>
> ==但是由于 JVM 具有指令重排的特性，执行顺序有可能变成 1>3>2。指令重排在单线程环境下不会出现问题，但是在多线程环境下会导致一个线程获得还没有初始化的实例。例如，线程 T1 执行了 1 和 3，此时 T2 调用 getUniqueInstance() 后发现 uniqueInstance 不为空，因此返回 uniqueInstance，但此时 uniqueInstance 还未被初始化。==
>
> ==使用 volatile 可以禁止 JVM 的指令重排，保证在多线程环境下也能正常运行。==

**静态内部类实现**

当 Singleton5 类加载时，静态内部类 Singleton5Holder 没有被加载进内存。只有当调用 `getUniqueInstance()` 方法从而触发 `SingletonHolder5.uniqueInstance` 时 Singleton5Holder 才会被加载，此时初始化uniqueInstance 实例，并且 JVM 能确保 uniqueInstance 只被实例化一次。

这种方式不仅具有延迟初始化的好处，而且由 JVM 提供了对线程安全的支持。

```java
package com.design.pattern.singleton;

/**
 * @Author: 98050
 * @Time: 2019-01-09 23:04
 * @Feature: 静态内部类实现
 */
public class Singleton5 {

    private Singleton5(){
        System.out.println("运行");
    }
    private static class Singleton5Holder{
        private static final Singleton5 uniqueInstance = new Singleton5();
    }

    public static Singleton5 getUniqueInstance() {
        return Singleton5Holder.uniqueInstance;
    }
}

```

### 1.1.3 JDK

- [java.lang.Runtime#getRuntime()](http://docs.oracle.com/javase/8/docs/api/java/lang/Runtime.html#getRuntime%28%29)
- [java.awt.Desktop#getDesktop()](http://docs.oracle.com/javase/8/docs/api/java/awt/Desktop.html#getDesktop--)
- [java.lang.System#getSecurityManager()](http://docs.oracle.com/javase/8/docs/api/java/lang/System.html#getSecurityManager--)

## 1.2 简单工厂（Simple Factory）

当你需要什么，只需要传入一个正确的参数，就可以获取你所需要的对象，而无需知道其创建的细节。

### 1.2.1 介绍

在创建一个对象时不向客户暴露内部细节，并提供一个创建对象的通用接口。 

### 1.2.2 实现方式

简单工厂把实例化的操作单独放到一个类中，这个类就成为简单工厂类，让简单工厂类来决定应该用哪个具体子类来实例化。

![](http://pk85c13xg.bkt.clouddn.com/201919101232-m.png)

这样做能把客户类和具体子类的实现解耦，客户类不再需要知道有哪些子类以及应当实例化哪个子类。客户类往往有多个，如果不使用简单工厂，那么所有的客户类都要知道所有子类的细节。而且一旦子类发生改变，例如增加子类，那么所有的客户类都要进行修改。

```java
package com.design.pattern.simplefactory;

/**
 * @Author: 98050
 * @Time: 2019-01-10 11:55
 * @Feature: 产品接口
 */
public interface Product {
}
```

```java
package com.design.pattern.simplefactory;

/**
 * @Author: 98050
 * @Time: 2019-01-10 11:56
 * @Feature:
 */
public class ConcreteProduct implements Product {
}
```

```java
package com.design.pattern.simplefactory;

/**
 * @Author: 98050
 * @Time: 2019-01-10 11:56
 * @Feature:
 */
public class ConcreteProduct2 implements Product {
}
```

```java
package com.design.pattern.simplefactory;

/**
 * @Author: 98050
 * @Time: 2019-01-10 11:56
 * @Feature:
 */
public class ConcreteProduct3 implements Product {
}
```

以下的 Client 类包含了实例化的代码，这是一种错误的实现。如果在客户类中存在这种实例化代码，就需要考虑将代码放到简单工厂中。 

```java
package com.design.pattern.simplefactory;

/**
 * @Author: 98050
 * @Time: 2019-01-10 11:56
 * @Feature:
 */
public class Client {

    public static void main(String[] args) {
        Product product;
        int type = 1;
        switch (type){
            case 1:
                product = new ConcreteProduct();
                break;
            case 2:
                product = new ConcreteProduct();
                break;
            case 3:
                product = new ConcreteProduct();
                default:
        }
    }
}

```

以下的 SimpleFactory 是简单工厂实现，它被所有需要进行实例化的客户类调用。 

```java
package com.design.pattern.simplefactory;

/**
 * @Author: 98050
 * @Time: 2019-01-10 12:00
 * @Feature: 简单工厂
 */
public class SimpleFactory {

    public Product createProduct(int type){
        if (type == 1){
            return new ConcreteProduct();
        }else if (type == 2){
            return new ConcreteProduct2();
        }else {
            return new ConcreteProduct3();
        }
    }
}
```

Client类调用：

```java
package com.design.pattern.factorymethod;

/**
 * @Author: 98050
 * @Time: 2019-01-10 13:08
 * @Feature: 客户
 */
public class Client {
    public static void main(String[] args) {

        ConcreteFactory concreteFactory = new ConcreteFactory();
        concreteFactory.doSomething();
    }
}

```

## 1.3 工厂方法（Factory Method）

### 1.3.1 介绍

定义了一个创建对象的接口，但由子类决定要实例化哪个类。工厂方法把实例化操作推迟到子类。 

**意图：**定义一个创建对象的接口，让其子类自己决定实例化哪一个工厂类，工厂模式使其创建过程延迟到子类进行。

**主要解决：**主要解决接口选择的问题。

**何时使用：**明确地计划不同条件下创建不同实例时。

**如何解决：**让其子类实现工厂接口，返回的也是一个抽象的产品。

**关键代码：**创建过程在其子类执行。

**应用实例：** 1、您需要一辆汽车，可以直接从工厂里面提货，而不用去管这辆汽车是怎么做出来的，以及这个汽车里面的具体实现。 2、Hibernate 换数据库只需换方言和驱动就可以。

**优点：** 

1、一个调用者想创建一个对象，只要知道其名称就可以了。 

2、扩展性高，如果想增加一个产品，只要扩展一个工厂类就可以。 

3、屏蔽产品的具体实现，调用者只关心产品的接口。

**缺点：**每次增加一个产品时，都需要增加一个具体类和对象实现工厂，使得系统中类的个数成倍增加，在一定程度上增加了系统的复杂度，同时也增加了系统具体类的依赖。这并不是什么好事。 

**使用场景：** 

1、日志记录器：记录可能记录到本地硬盘、系统事件、远程服务器等，用户可以选择记录日志到什么地方。 2、数据库访问，当用户不知道最后系统采用哪一类数据库，以及数据库可能有变化时。 

3、设计一个连接服务器的框架，需要三个协议，"POP3"、"IMAP"、"HTTP"，可以把这三个作为产品类，共同实现一个接口。

**注意事项：**作为一种创建类模式，在任何需要生成复杂对象的地方，都可以使用工厂方法模式。有一点需要注意的地方就是复杂对象适合使用工厂模式，而简单对象，特别是只需要通过 new 就可以完成创建的对象，无需使用工厂模式。如果使用工厂模式，就需要引入一个工厂类，会增加系统的复杂度。

**主要作用：**将类的实例化（具体产品的创建）延迟到工厂类的子类（具体工厂）中完成，即由子类来决定应该实例化（创建）哪一个类。 

**解决问题：**之所以可以解决简单工厂的问题，是因为工厂方法模式把具体产品的创建推迟到工厂类的子类（具体工厂）中，此时工厂类不再负责所有产品的创建，而只是给出具体工厂必须实现的接口，这样工厂方法模式在添加新产品的时候就不修改工厂类逻辑而是添加新的工厂子类，符合开放封闭原则，克服了简单工厂模式中缺点

### 1.3.2 实现方式

> **UML类图**

![](http://pk85c13xg.bkt.clouddn.com/201919101343-u.png)

**模式组成**

| 组成（角色）                 | 关系                             | 作用                                                  |
| ---------------------------- | -------------------------------- | ----------------------------------------------------- |
| 产品接口（Product）          | 具体产品的父类                   | 描述具体产品的公共接口                                |
| 具体产品（Concrete Product） | 实现产品接口；工厂类创建的目标类 | 描述生产的具体产品                                    |
| 抽象工厂（Factory）          | 具体工厂的父类                   | 描述具体工厂类的公共接口                              |
| 具体工厂（Concrete Factory） | 抽象工厂的子类；被外界调用       | 描述具体工厂；实现factoryMethod工厂方法创建产品的实例 |

**实现步骤**

**步骤1**：创建产品接口

```java
package com.design.pattern.factorymethod;

/**
 * @Author: 98050
 * @Time: 2019-01-10 12:45
 * @Feature:
 */
public interface Product {

    /**
     * 产品描述
     */
    void show();
}
```

**步骤2**：创建具体产品，实现产品接口

```java
package com.design.pattern.factorymethod;

/**
 * @Author: 98050
 * @Time: 2019-01-10 12:46
 * @Feature:
 */
public class ConcreteProduct implements Product {
    public void show() {
        System.out.println("产品A");
    }
}
```

```java
package com.design.pattern.factorymethod;

/**
 * @Author: 98050
 * @Time: 2019-01-10 12:46
 * @Feature:
 */
public class ConcreteProduct2 implements Product {
    public void show() {
        System.out.println("产品B");
    }
}
```

```java
package com.design.pattern.factorymethod;

/**
 * @Author: 98050
 * @Time: 2019-01-10 12:46
 * @Feature:
 */
public class ConcreteProduct3 implements Product {
    public void show() {
        System.out.println("产品C");
    }
}
```

**步骤3**：创建抽象工厂

```Java
package com.design.pattern.factorymethod;

/**
 * @Author: 98050
 * @Time: 2019-01-10 12:48
 * @Feature:
 */
public abstract class Factory {
    /**
     * 创建产品对象
     * @return
     */
    abstract public Product factoryMethod();

    public void doSomething(){
    }
}
```

**步骤4**：创建具体工厂类，继承抽象工厂，重写factoryMethod方法创建具体的产品实例

```java
package com.design.pattern.factorymethod;

/**
 * @Author: 98050
 * @Time: 2019-01-10 12:52
 * @Feature:
 */
public class ConcreteFactory extends Factory {

    @Override
    public Product factoryMethod() {
        return new ConcreteProduct();
    }

    @Override
    public void doSomething() {
        factoryMethod().show();
    }
}
```

```java
package com.design.pattern.factorymethod;

/**
 * @Author: 98050
 * @Time: 2019-01-10 12:52
 * @Feature:
 */
public class ConcreteFactory2 extends Factory {

    @Override
    public Product factoryMethod() {
        return new ConcreteProduct2();
    }

    @Override
    public void doSomething() {
        factoryMethod().show();
    }
}
```

```java
package com.design.pattern.factorymethod;

/**
 * @Author: 98050
 * @Time: 2019-01-10 12:52
 * @Feature:
 */
public class ConcreteFactory3 extends Factory {

    @Override
    public Product factoryMethod() {
        return new ConcreteProduct2();
    }

    @Override
    public void doSomething() {
        factoryMethod().show();
    }
}
```

**步骤5**：外界调用

```java
package com.design.pattern.factorymethod;

/**
 * @Author: 98050
 * @Time: 2019-01-10 13:08
 * @Feature: 客户
 */
public class Client {
    public static void main(String[] args) {
        ConcreteFactory concreteFactory = new ConcreteFactory();
        concreteFactory.doSomething();
    }
}
```

### 1.3.3 JDK

- [java.util.Calendar](http://docs.oracle.com/javase/8/docs/api/java/util/Calendar.html#getInstance--)

  ```java
  Calendar calendar = Calendar.getInstance(); //不是单例模式
  ```

- [java.util.ResourceBundle](http://docs.oracle.com/javase/8/docs/api/java/util/ResourceBundle.html#getBundle-java.lang.String-)

- [java.text.NumberFormat](http://docs.oracle.com/javase/8/docs/api/java/text/NumberFormat.html#getInstance--)

- [java.nio.charset.Charset](http://docs.oracle.com/javase/8/docs/api/java/nio/charset/Charset.html#forName-java.lang.String-)

- [java.net.URLStreamHandlerFactory](http://docs.oracle.com/javase/8/docs/api/java/net/URLStreamHandlerFactory.html#createURLStreamHandler-java.lang.String-)

- [java.util.EnumSet](https://docs.oracle.com/javase/8/docs/api/java/util/EnumSet.html#of-E-)

- [javax.xml.bind.JAXBContext](https://docs.oracle.com/javase/8/docs/api/javax/xml/bind/JAXBContext.html#createMarshaller--)

## 1.4 抽象工厂（Abstract Factory）

抽象工厂模式（Abstract Factory Pattern）是围绕一个超级工厂创建其他工厂。该超级工厂又称为其他工厂的工厂。这种类型的设计模式属于创建型模式，它提供了一种创建对象的最佳方式。

在抽象工厂模式中，接口是负责创建一个相关对象的工厂，不需要显式指定它们的类。每个生成的工厂都能按照工厂模式提供对象。

### 1.4.1 介绍

**意图：**提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类。

**主要解决：**主要解决接口选择的问题。

**何时使用：**系统的产品有多于一个的产品族，而系统只消费其中某一族的产品。

**如何解决：**在一个产品族里面，定义多个产品。

**关键代码：**在一个工厂里聚合多个同类产品。

**应用实例：**工作了，为了参加一些聚会，肯定有两套或多套衣服吧，比如说有商务装（成套，一系列具体产品）、时尚装（成套，一系列具体产品），甚至对于一个家庭来说，可能有商务女装、商务男装、时尚女装、时尚男装，这些也都是成套的，即一系列具体产品。假设一种情况，在您的家中，某一个衣柜（具体工厂）只能存放某一种这样的衣服（成套，一系列具体产品），每次拿这种成套的衣服时也自然要从这个衣柜中取出了。用 OO 的思想去理解，所有的衣柜（具体工厂）都是衣柜类的（抽象工厂）某一个，而每一件成套的衣服又包括具体的上衣（某一具体产品），裤子（某一具体产品），这些具体的上衣其实也都是上衣（抽象产品），具体的裤子也都是裤子（另一个抽象产品）。

**优点：**当一个产品族中的多个对象被设计成一起工作时，它能保证客户端始终只使用同一个产品族中的对象。

**缺点：**产品族扩展非常困难，要增加一个系列的某一产品，既要在抽象的 Creator 里加代码，又要在具体的里面加代码。

**使用场景：** 1、QQ 换皮肤，一整套一起换。 2、生成不同操作系统的程序。

**注意事项：**产品族难扩展，产品等级易扩展。

### 1.4.2 实现方式

**UML类图**

![](http://pk85c13xg.bkt.clouddn.com/201919101541-A.png)

**实现步骤**

**步骤1：**创建材料A接口

```java
package com.design.pattern.abstractfactory;

/**
 * @Author: 98050
 * @Time: 2019-01-10 14:51
 * @Feature: 材料A
 */
public interface IngredientA {
    /**
     * 显示材料
     */
    void show();
}
```

**步骤2：**创建实现材料A接口的实体类

```java
package com.design.pattern.abstractfactory;

/**
 * @Author: 98050
 * @Time: 2019-01-10 14:55
 * @Feature: 具体材料A1
 */
public class IngredientA1Impl implements IngredientA {
    public void show() {
        System.out.println("材料A1");
    }
}
```

```java
package com.design.pattern.abstractfactory;

/**
 * @Author: 98050
 * @Time: 2019-01-10 14:55
 * @Feature: 具体材料A2
 */
public class IngredientA2Impl implements IngredientA {
    public void show() {
        System.out.println("材料A2");
    }
}
```

**步骤3：**创建材料B接口

```java
package com.design.pattern.abstractfactory;

/**
 * @Author: 98050
 * @Time: 2019-01-10 14:51
 * @Feature: 材料B
 */
public interface IngredientB {
    /**
     * 显示材料
     */
    void show();
}
```

**步骤4：**创建实现材料B的实体类

```java
package com.design.pattern.abstractfactory;

/**
 * @Author: 98050
 * @Time: 2019-01-10 14:55
 * @Feature: 具体材料B1
 */
public class IngredientB1Impl implements IngredientB {

    public void show() {
        System.out.println("材料B1");
    }
}
```

```java
package com.design.pattern.abstractfactory;

/**
 * @Author: 98050
 * @Time: 2019-01-10 14:55
 * @Feature: 具体材料B2
 */
public class IngredientB2Impl implements IngredientB {

    public void show() {
        System.out.println("材料B2");
    }
}
```

**步骤5：**为材料A和材料B创建抽象工厂类

```java
package com.design.pattern.abstractfactory;

/**
 * @Author: 98050
 * @Time: 2019-01-10 14:50
 * @Feature: 原材料工厂，需要材料A,B
 */
public abstract class AbstractIngredientFactory {
    /**
     * 创建材料A
     * @return
     */
    abstract IngredientA createIngredientA();

    /**
     * 创建材料B
     * @return
     */
    abstract IngredientB createIngredientB();
}
```

**步骤6：**创建继承了抽象工厂类的子类

用于获得材料A1和材料B1：

```java
package com.design.pattern.abstractfactory;

/**
 * @Author: 98050
 * @Time: 2019-01-10 14:57
 * @Feature: 具体工厂1
 */
public class AbstractIngredientFactory1Impl extends AbstractIngredientFactory {

    @Override
    public IngredientA createIngredientA() {
        return new IngredientA1Impl();
    }

    @Override
    public IngredientB createIngredientB() {
        return new IngredientB1Impl();
    }
}

```

用于获得材料A2和材料B2：

```java
package com.design.pattern.abstractfactory;

/**
 * @Author: 98050
 * @Time: 2019-01-10 14:57
 * @Feature: 具体工厂2
 */
public class AbstractIngredientFactory2Impl extends AbstractIngredientFactory {

    @Override
    public IngredientA createIngredientA() {
        return new IngredientA2Impl();
    }

    @Override
    public IngredientB createIngredientB() {
        return new IngredientB2Impl();
    }
}

```

**步骤7：**创建一个工厂创造器/生成器类，通过传递信息来获取工厂。 

```java
package com.design.pattern.abstractfactory;

/**
 * @Author: 98050
 * @Time: 2019-01-10 15:35
 * @Feature: 获取工厂
 */
public class FactoryProducer {

    public static AbstractIngredientFactory getFactory(int type){
        if (type == 1){
            return new AbstractIngredientFactory1Impl();
        }else {
            return new AbstractIngredientFactory2Impl();
        }
    }
}

```

**步骤8：**使用 FactoryProducer 来获取 AbstractIngredientFactory，通过传递类型信息来获取实体类的对象。 

```java
package com.design.pattern.abstractfactory;

/**
 * @Author: 98050
 * @Time: 2019-01-10 14:59
 * @Feature: 获取材料
 */
public class Client {

    public static void main(String[] args) {
        AbstractIngredientFactory abstractIngredientFactory = FactoryProducer.getFactory(1);
        abstractIngredientFactory.createIngredientA().show();
        abstractIngredientFactory.createIngredientB().show();

        AbstractIngredientFactory abstractIngredientFactory2 = FactoryProducer.getFactory(2);
        abstractIngredientFactory2.createIngredientA().show();
        abstractIngredientFactory2.createIngredientB().show();

    }
}

```

### 1.4.3 JDK

- [javax.xml.parsers.DocumentBuilderFactory](http://docs.oracle.com/javase/8/docs/api/javax/xml/parsers/DocumentBuilderFactory.html)
- [javax.xml.transform.TransformerFactory](http://docs.oracle.com/javase/8/docs/api/javax/xml/transform/TransformerFactory.html#newInstance--)
- [javax.xml.xpath.XPathFactory](http://docs.oracle.com/javase/8/docs/api/javax/xml/xpath/XPathFactory.html#newInstance--)

## 1.5 小结

总结一下简单工厂、工厂方法（工厂模式）、抽象工厂。

**简单工厂模式不是23种设计模式里的一种，其主要作用就是专门生产某一类产品。比如说鼠标工厂，传入参数1生产惠普鼠标，传入参数2生产联想鼠标。**

**工厂方法就是生产鼠标的工厂是一个父类，它的下边有生产惠普鼠标的子类和生产联想鼠标的子类，然后通过具体的子类生产对应品牌的鼠标。**

抽象工厂就是不仅仅要生产鼠标，还要生产键盘。这样就会有一个PC生产厂，它是一个父类，有两个接口，一个用来生产鼠标，一个用来生产键盘。那么惠普工厂就继承这个父类，生产自己的鼠标和键盘；同理联想工厂也继承这个父类，生产自己的鼠标和键盘。所以抽象工厂模式就是提供一个创建一系列相关或者互相依赖对象的接口，而无需指定具体的对象类。

**==当产品只有一个的时候，抽象工厂就变成了工厂方法了；当工厂方法中生产的产品不止一个的时候，那么工厂方法就变成了抽象工厂。==**

> 如果在抽象工厂中增加一个工厂戴尔，那么需要做的就是戴尔工厂继承PC生产厂，然后别创建戴尔鼠标和戴尔键盘类分别继承鼠标父类和键盘父类。
>
> 如果在抽象工厂中增加一个产品，那么此时PC生产厂就有三个接口了：鼠标、键盘、耳麦。那么我们就要创建耳麦父类，以及联想耳麦和惠普耳麦两个子类。然后在PC生产厂增加耳麦接口，惠普工厂和联想工厂分别实现耳麦接口，生产耳麦。