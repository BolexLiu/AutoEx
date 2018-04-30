# AutoEx
帮助Android开发者从项目异常堆栈中，自动寻找Stack Overflow的回答。


只需要添加一行代码，即可让你的项目在崩溃时，根据Log错误自动去Stack Overflow中寻找可供参考的答案。

 **就像下面这样：**

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


### 用法

 - 1.根build.gradle添加仓库:
```
	allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  ```

 - 2.添加dependency依赖

  ```
  	dependencies {
	        implementation 'com.github.BolexLiu:AutoEx:v1.0.0'
	}
  ```

 - 3.Application初始化一行搞定

  ```java
    AutoEx.apply(this);
  ```




## android support:
 - minSdkVersion 14
 - maxSdkVersion 26+



---

特别说明：
为了保持精简干净不给开发者添麻烦，这个库没有依赖任何第三方库。(比如OKHttp、Gson等)纯粹的原生JAVA。
AutoEx仅不到9kb的大小，希望能给开发者提升工作效率。

