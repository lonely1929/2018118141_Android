###  实验要求：展示生命周期的回调函数在不同条件下的触发条件和运行机制
### 实验目的：掌握并深入理解活动的生命周期
### 实验内容：
MainActivity第一次被创建时会一次执行onCreate()、onStart()和onResume()方法。

![图片1](2-Homework.assets/图片1-1600836332410.png)

![图片2](2-Homework.assets/图片2-1600836339216.png)

![图片3](2-Homework.assets/图片3-1600836396949.png)

点击第一个按钮，启动NomalActivity，NomalActivity会将MainActivity完全遮挡，并执行onPause()和onStop()方法，此时MainActivity进入了停止状态。

![图片4](2-Homework.assets/图片4-1600837486778.png)

![图片5](2-Homework.assets/图片5-1600837493776.png)

![图片6](2-Homework.assets/图片6.png)

按下Back键返回MainActivity，执行onRestart()方法，然后依次执行onStart()和onResume()方法，onCreat()方法则不会被执行，因为MainActivity没有被重新创建。

![图片7](2-Homework.assets/图片7.png)

点击第二个按钮，启动DialogActivity

![图片8](2-Homework.assets/图片8.png)

只有onPause()方法执行了，onStop()方法并没有执行，因为DialogActivity没有完全遮挡住MainActivity，MainActivity只是进入了暂停状态，按下Back键返回MainActivity也只有onResume()方法执行了。

![图片9](2-Homework.assets/图片9.png)

![图片10](2-Homework.assets/图片10-1600838139271.png)

最后在MainActivity按下Back键退出程序，会依次执行onPause()、onStop()和onDestroy()方法。

![图片11](2-Homework.assets/图片11.png)
### 实验总结：
#### 评价：了解到活动的4种状态以及7个回调方法，还有3种生存期
#### 心得收获：通过编写程序更好地理解活动的生命周期，这样才能鞋出更加流畅的程序，合理管理应用资源，希望能给用户更好的体验。