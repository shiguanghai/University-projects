# Student-management-system
## 学生成绩管理系统(Mysql)

步骤1、登录界面的静态实现
步骤2：实现界面的切换
步骤3：使用数据库来验证用户名和密码
步骤4：对代码进行优化。增加专门用来与数据库进行连接的类
步骤5：优化代码，增加判断条件。
步骤6：使用数据库进行查询时，优化查询方法和判断条件。数据库的表中可有多个数据。引入不同的表来查询。
步骤7：教师界面实现了查询某个学生信息和某教师信息的功能以及修改学生成绩。
步骤8：学生界面实现显示当前登录用户信息及查询功能
步骤9：优化UI界面，并保证程序的稳定运行


项目可以以稳定运行已解决各种交互方面的问题，不存在不擅操作导致程序运行错误。由于使用本程序基于IDEA实现与MYSQL数据库连接，提交代码包括JAVA源代码、MYSQL-java- jar文件以及.sql文件 非本机可能无法完整实现功能，故提供运行截图及简述如下：

### 登陆主界面：可实现教师学生的切换，重置，退出等，登陆用户名密码由SQL表格info表提供，可实现动态连接数据库并返回匹配结果。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20201029185349129.png#pic_center)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201029185509245.png#pic_center)
![在这里插入图片描述](https://img-blog.csdnimg.cn/2020102918551826.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ1MTQ5MjU2,size_16,color_FFFFFF,t_70#pic_center)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201029185520489.png#pic_center)

登陆成功后，教师会进入教师界面，教师界面可实现：
输入学号可以通过连接数据库访问info_stu表查询学生成绩，学生成绩将显示在学生信息表中，当表中数据超过三个会提示重置以继续查询；

![在这里插入图片描述](https://img-blog.csdnimg.cn/20201029185603905.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ1MTQ5MjU2,size_16,color_FFFFFF,t_70#pic_center)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201029185623500.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ1MTQ5MjU2,size_16,color_FFFFFF,t_70#pic_center)

当输入学号并点击修改成绩则会进入成绩修改界面，成绩必须全部填写才可以修改，修改成功可再次查询发现成绩以发生变化，数据库中数据会同步修改。

![在这里插入图片描述](https://img-blog.csdnimg.cn/2020102918574558.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ1MTQ5MjU2,size_16,color_FFFFFF,t_70#pic_center)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201029185748660.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ1MTQ5MjU2,size_16,color_FFFFFF,t_70#pic_center)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201029185751783.png#pic_center)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201029185753671.png#pic_center)

教师信息表访问info_tea 原理同学生表类似不再赘述，以下是info_stu和info_tea数据库数据：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20201029185854386.png#pic_center)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201029185856666.png#pic_center)

以上是教师登录界面，实现了数据的查询和修改，下面位学生登陆后的简述：
学生界面主要实现个人成绩的查询和教务通知提醒，可以根据登陆用户名动态获取数据库个人信息，当点击“成绩查询”可获取个人成绩。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20201029185920427.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ1MTQ5MjU2,size_16,color_FFFFFF,t_70#pic_center)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201029185923406.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ1MTQ5MjU2,size_16,color_FFFFFF,t_70#pic_center)
