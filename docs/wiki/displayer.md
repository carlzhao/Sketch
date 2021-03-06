#### 简介

ImageDisplayer是最后用来显示图片的，目前Sketch内置了以下五种ImageDisplayer：
>* DefaultImageDisplayer： 默认的图片显示器，没有任何动画效果；
>* ZoomInImageDisplayer：由小到大的显示图片，缩放比例是从0.5f到1.0f；
>* ZoomOutImageDisplayer：由大到小的显示图片，缩放比例是从1.5f到1.0f；
>* TransitionImageDisplayer： 过渡效果显示器，如果SketchImageView当前显示的有图片，就会用已有的图片和新的图片生成一个TransitionDrawable，以过渡渐变的方式显示。如果当前没有显示图片的话就用一张透明的ColorDrawable作为旧图片和新的图片生成一个TransitionDrawable，以过渡渐变的方式显示。
>* ColorTransitionImageDisplayer：颜色过渡显示器，你可以指定一种颜色作为过渡效果的起始色。

#### TransitionImageDisplayer
在使用TransitionDrawable的时候，当两张图片的比例不一致，TransitionDrawable会依照尺寸比较大的图片强行将另一张图片拉伸，这样最终显示出来的效果就是变形的。

为了解决这个问题，在使用TransitionImageDisplayer的时候如果Sketch检测到SketchImageView的layout_width和layout_height是写死的，
并且scaleType是CENTER_CROP的话就会自动对占位图和最终的图片开启fixedSize功能。
开启了fixedSize功能后会修正BitmapDrawable的尺寸以及srcRect，使其同SketchImageView的layout size比例一致，这样就可以保证在使用TransitionDrawable的时候不会变形

所以在使用TransitionImageDisplayer的时候，有一定的限制：
>* SketchImageView宽高固定的时候，如果使用了loadingImage那么ScaleType就必须是CENTER_CROP
>* SketchImageView宽高未知的时候，不能使用loadingImage

触犯了以上任何一条规则都将抛出运行时异常

####自定义
你还可以自定义ImageDisplayer，用你喜欢的方式显示图片，有以下几点需要注意：

1. 要先过滤一下bitmap为null以及已经回收的情况
2. 调用startAnimation()执行动画之前要下调用clearAnimation()清理一下
3. 尽量使用ImageDisplayer.DEFAULT_ANIMATION_DURATION作为动画持续时间