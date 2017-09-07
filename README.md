# BasisRequestProject
根据OKGO请求框架编写一个简易的项目结构，用于新项目使用，里面包含标题栏，页面加载。

# 内容包含：
## 一、工具类：
#### ActivityUtils   //Activity相关帮助类,主要是页面之间的跳转，销毁，获取当前页面的实例
* getTopActivity() //获取栈顶Activity
* navigateTo()  //启动Activity
* isActivityExists() //判断是否存在Activity
* removerActivity()  //销毁指定页面
* finishAllActivities()  //结束所有activity
