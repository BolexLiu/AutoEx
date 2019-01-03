# AutoEx
帮助Android开发者，让项目在崩溃时从异常堆栈中，自动寻找Stack Overflow的回答。

[![AutoEx][AutoExsvg]][AutoEx] [![api+svg][api+svg]][api+svg] [![sizesvg][sizesvg]][sizesvg]  [![stackoverflow][stackoverflowsvg]][stackoverflow]



<!-- [![api+][]][api+]![size][size]![https://stackoverflow.com][stackoverflow] -->

项目崩溃后，你的LogCat日志会出现来自Stack Overflow的回答。

 **像下面这样：**

```
┌—————————————————————AutoEx——————————————————————
├ 错误类型:android.content.res.Resources$NotFoundException: Resource ID #0x7f0b0056 type #0x12 is not valid。↑详细异常请往上滚动查看↑
├ 推荐参考Stack Overflow上4条同类问题。↓点击下方连接查看↓
├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄
├ 标题:Android Resources$NotFoundException: Resource ID #0x7f030027
├ 链接:https://stackoverflow.com/questions/21269502/android-resourcesnotfoundexception-resource-id-0x7f030027
├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄
├ 标题:android.content.res.Resources$NotFoundException: Resource ID #0x7f07007e
├ 链接:https://stackoverflow.com/questions/48161713/android-content-res-resourcesnotfoundexception-resource-id-0x7f07007e
├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄
├ 标题:App crashes when adding an ImageView?
├ 链接:https://stackoverflow.com/questions/47600747/app-crashes-when-adding-an-imageview
├┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄
├ 标题:XML Android app will not load on phone
├ 链接:https://stackoverflow.com/questions/48310838/xml-android-app-will-not-load-on-phone
└—————————————————————AutoEx——————————————————————
```

**AutoEx**不足10kb，无脏依赖关系。请保持手机是联网方便查询api。

## 用法

 - root build.gradle:
```
allprojects {
    repositories {maven { url 'https://jitpack.io' }}
}
  ```

 - dependency （low version gradle: debugCompile releaseCompile）

```
dependencies {
     debugImplementation 'com.github.BolexLiu.AutoEx:AutoEx-Lib:v1.0.8'
     releaseImplementation 'com.github.BolexLiu.AutoEx:AutoEx-Lib-No-Op:v1.0.8' //release为空实现
}
```

 - 初始化方式(Application)

```java
 AutoEx.apply();//一行即可
```
或者
```java
 AutoEx.apply( mApp, maxSize, tag, isDebug)//Applicatin 答案数目 日志TAG 是否调试
```


## android support:
 - minSdkVersion 14
 - maxSdkVersion 26+


---

## 更新描述

- 1.0.5 修复小米等手机直接被Kill，添加多进程（感谢静心同学的测试）
- 1.0.6 最大提示数目、增加日志过滤、调试模式选择
- 1.0.7 增加无参构造、增加release空包支持（感谢巴神）
- 1.0.8 对无法反射获取Context的机型给出日志提示
- 增加AutoEx-Gradle插件版，对编译时报错支持提示，不过这个没什么太大用处

## 后续需求

- 基于搜索引擎扩展结果，避免精准匹配的异常有时候出不来的问题。要考虑墙的问题(google? bing?)







[AutoExsvg]:http://img.shields.io/badge/AutoEx-v1.0.8-brightgreen.svg
[AutoEx]:https://github.com/BolexLiu/AutoEx

[api+svg]:http://img.shields.io/badge/API-14+-brightgreen.svg
[sizesvg]:http://img.shields.io/badge/size-9kb-brightgreen.svg

[stackoverflowsvg]:http://img.shields.io/badge/stackoverflow-+-brightgreen.svg
[stackoverflow]:https://stackoverflow.com


