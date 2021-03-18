## ORIGHT

#### 1.项目概述

当用户使用我们的网站时，首先需要注册身份，有作家和公司两种不同的身份，注册完后可进行登录。登录时，网站需要对用户进行分类选择不同的角色登录至不同的界面。用户数据用户名和密码进行登录，登录成功则跳转到对应角色的操作界面，否则保持登录界面，并输出“用户名或密码错误”的提示信息。当作家登录时，系统跳转到作家首页界面，作家可以发布文章，收藏文章，关注其他作家，查看自己粉丝，根据关键字搜索相关文章。当公司登录时，系统跳转到公司用户首页界面，公司可收藏文章，关注作家，根据关键字搜索相关文章。

项目采用经典的MVVM设计模式：Model+View+ViewModel。View的变化会自动更新到ViewModel , ViewModel的变化也会自动同步到View上显示。这种自动同步是因为ViewModel中的属性实现了Observer，当属性变更时都能触发对应的操作。

#### 2.项目展示

##### 1.数据库

（1）用户信息表

![](F:\夏季小学期\pics\user.PNG)

（2）作家信息表

![](F:\夏季小学期\pics\author.PNG)

（3）公司信息表

![](F:\夏季小学期\pics\firm.PNG)

（4）作家关注信息表

![](F:\夏季小学期\pics\concern.PNG)

（5）公司关注信息表

![](F:\夏季小学期\pics\concern2.PNG)

（6）作家收藏信息表

![](F:\夏季小学期\pics\favourite.PNG)

（7）公司收藏信息表

![](F:\夏季小学期\pics\favourite2.PNG)

（8）作家文章信息表

![passage](F:\夏季小学期\pics\passage.PNG)

##### 2.功能模块

![功能设计](F:\夏季小学期\pics\功能设计.jpg)



##### 3.界面展示

###### 1.登录注册模块  

该模块实现注册登录功能。用户可注册成为作家或者公司，注册之后可登录。包含以下页面：  

（1）作家注册页面   

该页面实现注册功能。前端设计如下图：

<img src="F:\夏季小学期\pics\register_a.PNG" alt="register_a" style="zoom: 42%;" />

（2）公司注册页面

该页面实现注册功能。前端设计如下图：

<img src="F:\夏季小学期\pics\register_f.PNG" alt="register_f" style="zoom: 42%;" />

（3）登录页面 

该页面实现登录功能。前端设计如下图：

<img src="F:\夏季小学期\pics\login.PNG" alt="login" style="zoom: 42%;" />

###### 2.作家模块  

该模块作家可发表文章、关注其他作家、收藏文章和修改个人信息。包含以下页面：  

（1）首页页面

该页面作家可查看实时文章，对文章进行收藏，对其他作家进行关注。前端设计如下图：

<img src="F:\夏季小学期\pics\aindex.PNG" alt="index_a" style="zoom: 42%;" />

（2）我的关注页面

该页面作家可查看自己关注的作家。前端设计如下图：

<img src="F:\夏季小学期\pics\guanzhu_a.PNG" alt="concern_a" style="zoom: 42%;" />

（3）我的粉丝页面

该页面作家可查看自己的粉丝。前端设计如下图：

​                         <img src="F:\夏季小学期\pics\fans_a.PNG" alt="ans_a" style="zoom: 42%;" /> 

（4）发布文章页面

  该页面作家可发布文章。前端设计如下图：

<img src="F:\夏季小学期\pics\post.PNG" alt="post_a" style="zoom: 42%;" />

（5）我的发布页面

该页面作家可查看其发布的文章。前端设计如下图：

<img src="F:\夏季小学期\pics\past_a.PNG" alt="passage_a" style="zoom: 42%;" />

（6）我的收藏页面

该页面作家可查看其收藏的文章。前端设计如下图：

<img src="F:\夏季小学期\pics\shou_a.PNG" alt="favourite_a" style="zoom: 42%;" />

（7）个人信息

该页面实现个人信息的展示和修改。前端设计如下图：

<img src="F:\夏季小学期\pics\ainfo.PNG" alt="info_a" style="zoom: 42%;" />

（5）修改密码

该页面实现密码的修改。前端设计如下图：

<img src="F:\夏季小学期\pics\apwd.PNG" alt="pwd_a" style="zoom: 42%;" />

 

###### 3.公司模块

（1）  首页页面     

该页公司用户可查看文章，收藏文章，关注作家。前端设计如下图：

<img src="F:\夏季小学期\pics\finfo.PNG" alt="index_f" style="zoom: 42%;" />

（2）我的关注页面 

该页面公司用户可查看其关注的作家。前端设计如下图：

<img src="F:\夏季小学期\pics\guanzhu_f.PNG" alt="concern_f" style="zoom: 42%;" />

（3）我的收藏页面

该页面公司用户可查看其收藏的文章。前端设计如下图：

<img src="F:\夏季小学期\pics\shou_f.PNG" alt="favourite_f" style="zoom: 42%;" />

（4）个人信息页面

该页面可查看和修改个人信息。前端设计如下图：

<img src="F:\夏季小学期\pics\finfo2.PNG" alt="info_f" style="zoom: 42%;" />

（5）修改密码页面

该页面实现密码的修改。前端设计如下图：

<img src="F:\夏季小学期\pics\fpwd.PNG" alt="pwd_f" style="zoom: 42%;" />
