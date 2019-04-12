## Mybatis 架构
    1，mybatis配置
        SqlMapConfig.xml，此文件作为mybatis的全局配置文件，配置了mybatis的运行环境等信息，mapper.xml文件
        即sql映射文件，配置了操作数据库的失去了语句。此文件需要在SqlMapConfig.xml中加载
    2，通过mybatis环境等信息构造SqlSessionFactory即回话工厂
    3，由会话工厂创建sqlSession即会话，操作数据库需要通过sqlSession进行
    4，mybatis底层自定义了Executor执行器接口操作数据库，Executor接口有两个实现。一个是基本执行器，一个是
       缓存执行器
    5，MappedStatement也是mybatis底层的对象封装，他包括了mybatis配置信息及sql映射信息。mapper.xml文件中一
       个sql对应一个MappedStatement，sql的id就是MappedStatement的id
    6，MappedStatement对sql执行输入参数进行定义，包括Hashmap、基本类型、pojo，Executor通过Mapped Statement
       在执行sql前将输入的java对象映射至sql中，输入参数映射就是jdbc编程中对preparedStatement设置参数
    7，Mapped Statement对sql执行输出结果进行定义，包括HashMap、基本类型、pojo，Executor通过Mapped Statement
       在执行sql后将输出结果映射至java对象中，输出结果映射过程相当于jdbc编程中对结果的解析处理过程
    
    注意：
        #{}表示一个占位符号，通过#{}可以实现preparedStatement向占位符中设置值，自动进行java类型和jdbc类型转换。
        #{}可以有效防止sql注入。 #{}可以接收简单类型值或pojo属性值。 如果parameterType传输单个简单类型值，#{}括
        号中可以是value或其它名称。
        
        ${}表示拼接sql串，通过${}可以将parameterType 传入的内容拼接在sql中且不进行jdbc类型转换， ${}可以接收简单
        类型值或pojo属性值，如果parameterType传输单个简单类型值，${}括号中只能是value。