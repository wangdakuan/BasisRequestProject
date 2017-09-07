# 介绍
```
 根据OKGO请求框架编写一个简易的项目结构，用于新项目使用，不需要每次都搭建只需要把项目下载下来，更改下包名在把测试类删除就可以使用了。
 网络请求使用了github上优秀的请求框架okhttp-OkGo。
 工具类是在网上找来的，希望大家见谅，主要是积累在项目中能用到的工具类。
 页面加载使用GitHub上的MaterialPageStateLayout
 一个项目会使用很多其它资源，把这些资源使用整合完成的，如果涉及什么的问题。请联系我。我会做出相应修改
```

## 项目
#### dodata 层下主要是处理请求，数据处理、封装，缓存等
#### common 层下主要是公共的类，比如工具类、不与业务相关的自定义控件等
#### app    层这个就不用质疑了是项目的页面了，比如activity、fragment等（这个包下只有页面没有实体对象什么的）
#### [dodata关联common、app关联dodata] dodata已接口的形式回调到app层，app层进行展示dodata过来的服务器数据

## 内容包含：
### dodata层：
```
####com.dodata.net包下面的
* JsonConvert 类是请求服务器数据处理，判断是否是正常的数据并进行解析成所需的对象
* DataResponse 类是服务器数据返回基础对象，需要根据自己公司的进行相应的修改
* SimpleResponse 类是没有任何数据返回时用到的
* RequestCallback 类请求接口回调类
* SucceedCallback 成功回调到页面层的接口（只回调页面相应的数据实体）
* ViewPresenter 这是页面与请求管理接口，页面在销毁时请求也相应的进行销毁
* MFunction 数据转换类，这是rxJava实现的，可在网上搜索学习
* MObserver 回调监听，这是rxJava实现的，可在网上搜索学习
* StartSubscribe 监听开始请求，这是rxJava实现的，可在网上搜索学习
* JsonUtils json解析，这个是封装Gson类
####com.dodata.appnet包下面的（这是写的实例，基类都可以使用的不需要更改）
* com.dodata.appnet.model 这个包下面是服务器返回的数据model对象 （这个需要创建自己项目的model）
* com.dodata.appnet.user  这个包下面写的用户相关的接口实现（这个需要按照自己的项目来，看着弄好了...）

* BasePresenterIml 这个类是Presenter的基类，这里实现RequestCallback、ViewPresenter接口
* BaseUrl 这个类是请求url，根据自己项目修改
* UserUrl 这个类是请求url，根据自己项目修改
###### 包名什么的都可以按照自己想法来，随自己心意来就好，开开心心敲码才好（^_^）
```

### common层：
```
#### AppUtils 工具类的初始化类，主要是记录activity，记录context
* init()  //需要在Application的onCreate调用该方法

#### ActivityUtils   //Activity相关帮助类,主要是页面之间的跳转，销毁，获取当前页面的实例
* getTopActivity() //获取栈顶Activity
* navigateTo()  //启动Activity
* isActivityExists() //判断是否存在Activity
* removerActivity()  //销毁指定页面
* finishAllActivities()  //结束所有activity


```
