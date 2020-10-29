# Voice-of-dimension
## 次元之声(Android)

本项目安卓端结构主要包括fragment、model、util等几个部分，其中fragment定义了主页所需要的fragment，包括首页、版块、消息、我 等页面。Model中定义了项目所需的实体文件。Util中定义了项目所需要的工具类，包括okhttp网络工具类和Picasso图片工具类。

|技术点  | 用途 |
|--|--|
|Drawable+viewpager	|主页四个导航，版块内若干个标签
|Scrollview	|版块标签内作品展示，帖子内容展示
|Onclicklistener	|各种点击事件
|Intent|	跳转及传值
|Fragmentmanager|	轮播图适配器
|Simpleongesturelistner|	轮播图手势
|继承viewpager|	自定义新的viewpager方便fragment内轮播图使用ontouchevent
|Onresume	|接收点击事件跳转传参设置fragment
|getwindow getdecorview|	释放模拟器顶部空间
新技术1 |	重写view pager 为slideviewpager 实现fragment中的轮播图可以调用activity的ontpuchevent函数。排除法判断轮播图获取焦点为止从而解决轮播图手势和viewpager框架手势的冲突
新技术2|	通过运用onclick点击事件和xml标签记录组建状态 以及动态调整按钮或图片背景以及文字内容 配合传值来实现 主页加号漂浮 标签的弹出和点赞关注等的实现
新技术3 |	viewpager双层嵌套 以及scrollview的xml中的使用解决本该在activity中出新的问题 放在了fragment解决 从而实现 板块内嵌入标签栏动态获取相应标签的内容
新技术4	|通过向互联网网站shiguanghai.top发送请求，服务器返回Json串动态获取存储在服务器的数据

## （1）登录页面实现
	
该页面实现用户登录功能，获取用户名、密码内容，向Web服务器发送请求，服务器返回Json串从而进行判定登录信息。（web端发布到互联网故不需要启动tomcat）

![在这里插入图片描述](https://img-blog.csdnimg.cn/20201029214708232.png#pic_center)

## （2）首页论坛详情界面

使用了嵌套fragment完成首页轮播图等，同时点击页面中的条目时进行页面跳转。可为其点赞收藏

![在这里插入图片描述](https://img-blog.csdnimg.cn/20201029214732134.png#pic_center)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20201029214737737.png#pic_center)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20201029214745601.png#pic_center)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20201029214750873.png#pic_center)

此界面的功能是用来展示视频信息，通过不同的标签获取不同的视频信息，以及用户可以点击视频进入详情界面。

## （4）点击视频

![在这里插入图片描述](https://img-blog.csdnimg.cn/20201029214813816.png#pic_center)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20201029214820925.png#pic_center)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20201029214828765.png#pic_center)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20201029214833842.png#pic_center)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20201029214839259.png#pic_center)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20201029214845245.png#pic_center)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20201029214850620.png#pic_center)

