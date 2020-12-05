# Resource-sharing-website
## 个人资源分享网站(MVC架构)

>一个基于已存在资源网站的综合性信息资源分享网站，偏向于冷门，新颖的人群市场，使得用户可以通过网站提供的资源信息获取更多平时并不接触的信息及资源，同时减少在各大网站寻找资源的苦恼。

本软件Web端采用了MVC结构，分为dao包、controller、model、service等部分。

其中dao包中定义数据库连接工具类DBUtil，model定义了项目实体对象，service定义了与后台交互查询逻辑并在controller中返回给JSP页面。

- 本项目使用到Web端Bootstrap、JSP、Ajax、Es6、Jdbc、Jquery、Script等，数据库端使用了MySQL数据库、安卓端完成了基本布局、逻辑以及网络请求功能。
- 因此对计算机前后台交互有了更深刻的认识。通过不断的查漏补缺让我学会了如何高效的编程以及解决问题，也为我以后的学习打下了坚实的基础。

- Web端使用的技术

| 技术点 | 用途 |
|--|--|
| Bootstrap、JSP |  实现首页页面的自适应原型设计|
|MVC框架	|数据库和网站均发布存储在云端服务器并进行了国内备案 可通过域名shiguanghai.top进行访问,对移动端做了简单的优化，功能均可实现 整体代码模块化 易修改
|CSS动画|	顶部导航栏做了定位和动画效果
|登录/注册|	使用ajax不刷新页面进行用户名和密码的简单验证。登录失败光标的运用 回车键的判断。登陆后点击视频会开放收藏功能|
|模态框	|使用模态框实现外部链接的引用，登陆注册等 关闭视频时后台取消链接防止声音继续播放
|搜索框|	动态获取输入相关内容并以下拉形式显示，且显示数据个数随ajax json获取而不刷新异步的方式增加 数据获取方式使用了es6最新的箭头函数频率自调用 然后获取json参数拼接字符串送入显示的下拉菜单内
|下拉菜单内的预测数据均可前往|	也可通过搜索按钮模糊查找 为避免光标移除搜索框和搜索的点击事件冲突 使用延迟隐藏下拉菜单的方式解决
|搜索界面	|首次加载搜索内容为jsp的方式显示参数，通过点击标签ajax动态获取数据库相应数据重新加载到相应位置 对于为空的数据做出相应ui显示 且数据内容均为可交互状态
|SQL、MySQL数据库|	实现数据库数据存储、查询、显示
|json|	为安卓端提供数据接口
|Servlet、Session技术	|数据的逻辑处理、存储技术


## （1）登录&注册界面
	该页面实现用户登录功能，输入用户名密码等信息登录程序，使用ajax不刷新页面进行用户名和密码的简单验证。登录失败光标自动归为到删除的密码栏，回车键的判断增加交互体验来登录注册。登陆后点击视频会开放收藏功能。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201029170438835.png#pic_center)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20201029170444198.png#pic_center)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20201029170449454.png#pic_center)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20201029170458280.png#pic_center)


## （2）主页界面

本业主实现主要视频、摄影的展示、推荐视频轮播、搜索等功能，所有图片及文字信息是由后台数据库读取的。

![在这里插入图片描述](https://img-blog.csdnimg.cn/20201029170529401.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ1MTQ5MjU2,size_16,color_FFFFFF,t_70#pic_center)
## （3）搜索界面

![在这里插入图片描述](https://img-blog.csdnimg.cn/20201029170547882.png#pic_center)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201029170552888.png#pic_center)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201029170558833.png#pic_center)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201029170603221.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ1MTQ5MjU2,size_16,color_FFFFFF,t_70#pic_center)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20201029170623322.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ1MTQ5MjU2,size_16,color_FFFFFF,t_70#pic_center)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20201029170628631.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ1MTQ5MjU2,size_16,color_FFFFFF,t_70#pic_center)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20201029170702408.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ1MTQ5MjU2,size_16,color_FFFFFF,t_70#pic_center)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20201029170707576.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ1MTQ5MjU2,size_16,color_FFFFFF,t_70#pic_center)

## （4）视频界面

![在这里插入图片描述](https://img-blog.csdnimg.cn/20201029170724769.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ1MTQ5MjU2,size_16,color_FFFFFF,t_70#pic_center)

