# 项目
根据OKGO请求框架编写一个简易的项目结构，用于新项目使用，不需要每次都搭建只需要把项目下载下来，更改下包名在把测试类删除就可以使用了。
这个使用了github上优秀的请求框架okhttp-OkGo。
工具类是在网上找来的，希望大家见谅，主要是积累在项目中能用到的工具类。
页面加载使用GitHub上的MaterialPageStateLayout
一个项目会使用很多其它资源，把这些资源使用整合完成的，如果涉及什么的问题。请联系我。我会做出相应修改

# 内容包含：
## 一、工具类：
#### ActivityUtils   //Activity相关帮助类,主要是页面之间的跳转，销毁，获取当前页面的实例
* getTopActivity() //获取栈顶Activity
* navigateTo()  //启动Activity
* isActivityExists() //判断是否存在Activity
* removerActivity()  //销毁指定页面
* finishAllActivities()  //结束所有activity
