#在Spring Boot中验证
> [Markdown 入门参考](http://xianbai.me/learn-md/index.html )
##1.概述
当涉及到验证用户输入时，Spring Boot为开箱即用的常见但关键的任务提供了强大的支持。

尽管[Spring Boot](https://www.baeldung.com/spring-boot-bean-validation )支持与自定义验证器的无缝集成，但事实上，执行验证的标准是Hibernate Validator，它是Bean Validation框架的参考实现。

##2. Maven依赖
控制器将首先获取一个域对象，然后使用Hibernate Validator对其进行验证，最后，将其持久保存到内存中的H2数据库中。  
项目的依赖关系是相当标准的：
        
     <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency> 
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-data-jpa</artifactId>
    </dependency> 
    <dependency> 
        <groupId>com.h2database</groupId> 
        <artifactId>h2</artifactId>
        <version>1.4.197</version> 
        <scope>runtime</scope>
    </dependency>