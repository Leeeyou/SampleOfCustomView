# SampleOfCustomView

## Demo1

use the Path

![DemoCustomView1.gif](asset/demo1/DemoCustomView1.gif)

## Demo2

use the Paint：ColorMatrix、PorterDuffXfermode

踉踉跄跄中，终于完成了对Paint各种效果的练习。

收获非常多，对于Paint的各种过滤和混合效果，不再那么含糊和模棱两可，同时加深了对于矩阵的理解。

Demo中的各种示例均是在练习【aige】写的[文章](http://blog.csdn.net/aigestudio/article/details/41316141)。下面简单罗列下Demo中涉及到的知识点：<br>

### 矩阵

关于矩阵不清楚的童鞋可以转到[wiki](https://zh.wikipedia.org/wiki/%E7%9F%A9%E9%98%B5)

### ColorMatrixColorFilter

色彩矩阵过滤器，利用它可以实现很多美图秀秀中的效果，比如：变灰、变暗、颜色反转、老照片、高度对比等
![colormatrix_变暗.png](asset/demo2/colormatrix_变暗.png)
![colormatrix_变灰.png](asset/demo2/colormatrix_变灰.png)
![colormatrix_反相.png](asset/demo2/colormatrix_反相.png)
![colormatrix_红蓝色互相变换.png](asset/demo2/colormatrix_红蓝色互相变换.png)
![colormatrix_老照片.png](asset/demo2/colormatrix_老照片.png)
![colormatrix_去色后高度对比.png](asset/demo2/colormatrix_去色后高度对比.png)
![colormatrix_饱和度对比度加强.png](asset/demo2/colormatrix_饱和度对比度加强.png)

### LightingColorFilter

`光照颜色过滤器，利用它可以实现的效果就像有色光照在物体上染色一样`

过滤掉绿色：<br>
mPaint.setColorFilter(new LightingColorFilter(0xFFFF00FF, 0x00000000));
![lightcolorfilter.png](asset/demo2/lightcolorfilter.png)

### PorterDuffColorFilter

`混合颜色过滤器，可以通过指定一个颜色和一种模式，进行混合从而产生相应的效果`

红色+加深 混合：<br>
mPaint.setColorFilter(new PorterDuffColorFilter(Color.RED, PorterDuff.Mode.DARKEN));
![porterduffcolorfilter.png](asset/demo2/porterduffcolorfilter.png)

### PorterDuffXfermode

这个是`最重量级 最重量级 最重量级`的东东了。ProterDuff是两个人名的组合: Tomas Proter和 Tom Duff. 他们是最早在SIGGRAPH上提出图形混合概念的大神级人物.有兴趣的童靴们可以自己查下并深入了解，在此不再做过多描述.

PorterDuffXfermode是一个非常强大的转换模式，通过它，可以使用图像合成的16条Porter-Duff规则的任意一条来控制Paint如何与已有的Canvas图像进行交互。

![porterduffxfermode2.jpg](asset/demo2/porterduffxfermode2.jpg)

Demo中花了大量的篇幅练习和体会PorterDuffXfermode的强大，包括如下自定义view:
>
    PorterDuffView :基本练习
    DstInView：抠出美女轮廓
    DstOutView：挖出美女轮廓
    EraserView：橡皮擦练习

基本练习

![porterduffxfermode.png](asset/demo2/porterduffxfermode.png)

使用DST_IN抠出美女图像，去掉了周围的黄色和顶部的文字

![dst_in_美女练习_前.png](asset/demo2/dst_in_美女练习_前.png)
![dst_in_美女练习_后.png](asset/demo2/dst_in_美女练习_后.png)

利用Path绘制路径，采用DST_IN混合模式，完成橡皮擦效果

![eraserview.png](asset/demo2/eraserview.png)

## Demo3

use the Paint：Font、Shadow、MaskFilter

![font1.png](asset/demo3/font1.png)
![font2.png](asset/demo3/font2.png)
![font3.png](asset/demo3/font3.png)
![font4.png](asset/demo3/font4.png)

# Demo4

use the Paint：BitmapShader、LinearGradient、RadialGradient

![brick_view.png](asset/demo4/brick_view.png)
![dream_view.png](asset/demo4/dream_view.png)
![reflect_view.png](asset/demo4/reflect_view.png)
![matrix_imageview.png](asset/demo4/matrix_imageview.png)

# Demo5

use the Matrix：TextPaint、Path、PathMeasure

![paintview.png](asset/demo5/paintview.png)
![polyview.png](asset/demo5/polyview.png)
![RadarView.jpg](asset/demo5/RadarView.jpg)
![SecondBezier.jpg](asset/demo5/SecondBezier.jpg)
![ThirdBezierView.jpg](asset/demo5/ThirdBezierView.jpg)

# Demo6

use the Canvas

![layer_basic.png](asset/demo6/layer_basic.png)
![layer_save_restore.jpg](asset/demo6/layer_save_restore.jpg)
![layer_transfer.png](asset/demo6/layer_transfer.png)
![pieView.jpg](asset/demo6/pieView.jpg)
![pre_post.jpg](asset/demo6/pre_post.jpg)

# Demo7

use the OnMeasure

![mainactivity.png](asset/demo7/mainactivity.png)
![imgview.png](asset/demo7/imgview.png)
![iconview.png](asset/demo7/iconview.png)
![customlayout.png](asset/demo7/customlayout.png)

# Demo8

use the onMeasure

![demoCustomView8.jpg](asset/demo8/demoCustomView8.jpg)

# Demo9

By combining a custom view

![DemoCustomView9.jpg](asset/demo9/DemoCustomView9.jpg)

