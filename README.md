# ComposeGo

## Introduce
Android Compose Template Project, More suitable for the development habits of Chinese android developers! :)
Compose模板项目，更适合国内的风水！（开发中)

## 技术栈
1. 用`.gradle.kts`文件来代替`.gradle`文件
2. 用`Compose`来写UI
3. 用`Hilt`进行依赖注入
4. 用`Room`做本地化数据库存储
5. 用`Retrofit`和`OkHttp`来进行网络请求
6. 用`Moshi`来进行Json解析
7. 用`Coil`代替`Glide`来进行图像加载
8. 用`Timber`来进行日志记录
9. 用`LeakCanary`进行内存泄露监测
10. 用`Splashscreen API`作为首屏加载（官方推荐）
11. 用`build-logic`来代替`buildSrc`作为构建（来自Google官方的 [nowinandroid](https://github.com/android/nowinandroid)） 
12. 用`Coroutines`+`Flow`来代替`RxJava`进行异步操作
13. 用`ksp`代替`kapt`进行注解处理


## 三方库
1. 用`AndroidUtilCode`来用作常用的工具类集合
2. 用`X5WebView`进行H5页面加载
3. 用`Bugly`进行崩溃上报
4. 用`XXPermissions`进行权限请求
5. 用`EventBus`来作为事件总线
6. 用`MMKV`做本地K-V存储

## 架构 Architecture

项目整体采用`MVI`的架构，**没有**采用`组件化`和`插件化`。

## 待完成 TODO
- [ ] Retrofit网络层封装
- [ ] 日志记录到文件
- [ ] 登录功能 + 主页