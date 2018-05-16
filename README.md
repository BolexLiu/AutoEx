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


## 用法

 - 根build.gradle:
```
allprojects {
    repositories {maven { url 'https://jitpack.io' }}
}
  ```

 - dependency （低版本Gradle使用 debugCompile releaseCompile）

```
dependencies {
     debugImplementation 'com.github.BolexLiu.AutoEx:AutoEx-Lib:v1.0.8'
     releaseImplementation 'com.github.BolexLiu.AutoEx:AutoEx-Lib-No-Op:v1.0.8'
}
```

 - 初始化方式(选一种即可，建议放在Application中)

```java
 AutoEx.apply();//一行即可
```

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
- 1.0.7 增加无参构造、增加Rlease空包支持（感谢巴神）
- 1.0.8 对无法反射获取Context的机型给出日志提示

## 后续需求

- 基于搜索引擎扩展结果，避免精准匹配的异常有时候出不来的问题。要考虑墙的问题(google? bing?)
- 编译时gradle异常提示，目前只是运行时的，gradle取error的日志我试了一下是没问题的，做成插件就可以用了。等有空再折腾




**AutoEx**只有9kb的大小。为了保持精简干净不给开发者添麻烦，**AutoEx**没有依赖第三方库。(比如OKHttp、Gson等)。
所以你不用担心依赖冲突等问题。另外请保持手机是联网状态的。希望能给你带来方便。




[AutoExsvg]:http://img.shields.io/badge/AutoEx-v1.0.8-brightgreen.svg
[AutoEx]:https://github.com/BolexLiu/AutoEx

[api+svg]:http://img.shields.io/badge/API-14+-brightgreen.svg
[sizesvg]:http://img.shields.io/badge/size-9kb-brightgreen.svg

[stackoverflowsvg]:http://img.shields.io/badge/stackoverflow-+-brightgreen.svg
[stackoverflow]:https://stackoverflow.com


