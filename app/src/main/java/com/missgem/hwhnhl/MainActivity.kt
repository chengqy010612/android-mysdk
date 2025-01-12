package com.missgem.hwhnhl

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.ViewGroup
import android.widget.Button
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.bytedance.sdk.openadsdk.AdSlot
import com.bytedance.sdk.openadsdk.CSJAdError
import com.bytedance.sdk.openadsdk.CSJSplashAd
import com.bytedance.sdk.openadsdk.TTAdConfig
import com.bytedance.sdk.openadsdk.TTAdConstant
import com.bytedance.sdk.openadsdk.TTAdNative
import com.bytedance.sdk.openadsdk.TTAdSdk
import com.bytedance.sdk.openadsdk.TTNativeExpressAd
import com.example.clientapp.R
import com.missgem.hwhnhl.activity.TestActivity
import com.missgem.hwhnhl.feature.splash.SplashRoute
import com.missgem.hwhnhl.ui.MyApp
import com.missgem.hwhnhl.ui.theme.ClientAppTheme
import com.missgem.hwhnhl.util.TTAdManagerHolder
import com.missgem.hwhnhl.util.UIUtils
import com.tencent.mm.opensdk.modelmsg.SendAuth
import com.tencent.mm.opensdk.openapi.WXAPIFactory


val LocalNavController = compositionLocalOf<NavHostController> {
    error("No NavController provided")
}

class MainActivity : ComponentActivity() {
    val TAG = "TTAdManagerHolder"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
//            statusBarStyle = SystemBarStyle.dark(Color.Transparent)
            enableEdgeToEdge()
            val navController = rememberNavController()
            ClientAppTheme {
                CompositionLocalProvider(LocalNavController provides navController) {
                    MyApp(navController = navController)
                    Text("123")
                    Button(onClick = {
                        val intent = Intent(this, TestActivity::class.java)
                        startActivity(intent)
                    }) {
                        Text(text =  "测试")
                    }
//                    Button(onClick = {
//////                    wcLogin()
//                        val intent = Intent(this, TestActivity::class.java)
//                        startActivity(intent)
//                    }) {
//                        Text(text =  "测试")
//                    }
                }


            }
        }
//
//        setContentView(R.layout.activity_one);
////        Log.e(TAG, "初始化广告")
//        TTAdManagerHolder.init(this);
//        TTAdManagerHolder.start(this)
//        findViewById<Button>(R.id.Button_1).setOnClickListener {
//            TTAdManagerHolder.init(this);
////            TTAdConfig()
////            startAdSdk()
////            Log.e(TAG, "点击")
////            Toast.makeText(this, "按钮被点击了！", Toast.LENGTH_SHORT).show()
//        }
//        findViewById<Button>(R.id.Button_2).setOnClickListener {
//            TTAdManagerHolder.start(this)
//        }
//
//        findViewById<Button>(R.id.Button_3).setOnClickListener {
////            val intent = Intent(this, CSJSplashActivity::class.java)
////            startActivity(intent)
//            loadAd2()
//            Log.e(TAG, "点击")
//            Toast.makeText(this, "按钮被点击了！", Toast.LENGTH_SHORT).show()
//            val mContentViewRootView = LinearLayout(this)
//            val mTitleView = TextView(this)
//            mContentViewRootView.addView(mTitleView)
//
////            addContentView(mContentViewRootView)
//
//
//            addContentView(
//                mContentViewRootView, FrameLayout.LayoutParams(
//                    ViewGroup.LayoutParams.MATCH_PARENT,
//                    ViewGroup.LayoutParams.WRAP_CONTENT
//                )
//            )

//
//        }
//
//        findViewById<Button>(R.id.Button_4).setOnClickListener {

            // 获取当前 Activity 的根布局
//            val rootLayout = findViewById<LinearLayout>(android.R.id.content)
//// 创建新的 TextView
//            val newTextView = TextView(this)
//            newTextView.text = "这是动态添加的 TextView"
//            newTextView.textSize = 18f
////            newTextView.setTextColor(Color.Red)
//// 设置布局参数（位置）
//            val params = LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.WRAP_CONTENT,
//                LinearLayout.LayoutParams.WRAP_CONTENT
//            )
//            params.topMargin = 20 // 设置上边距
//            params.leftMargin = 20 // 设置左边距
//            newTextView.layoutParams = params
//// 将 TextView 添加到布局中
//            addView(newTextView)


//            loadAdBanner()
        }


//
//        val intent = Intent(this, TestActivity::class.java)
////        intent.putExtra("KEY_NAME", "Hello, Second Activity!")
//        startActivity(intent)
//        setContentView(R.layout.activity_test);


//        val dataset = arrayOf("January", "February", "March")
//        val customAdapter = CustomAdapter(dataset)
//        val recyclerView: RecyclerView = findViewById(R.id.recycler_view)
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        recyclerView.adapter = customAdapter
//    }

//    var mBannerAd: TTNativeExpressAd? = null
//    fun loadAdBanner() {
//        val mTTAdNative = TTAdSdk.getAdManager().createAdNative(this);
//        val adSlot = AdSlot.Builder()
//            .setCodeId("962822923") //聚合广告位
//            .setImageAcceptedSize(
//                UIUtils.getScreenWidthInPx(this),
//                UIUtils.dp2px(this, 340f)
//            ) // 自渲染尺寸，单位px
//            .setExpressViewAcceptedSize(UIUtils.getScreenWidthDp(this), 0f) // 模板广告尺寸，单位dp
//            .setAdCount(1) // 请求广告数量为1到3条 （优先采用平台配置的数量）
//            .build()
//
//        mTTAdNative.loadBannerExpressAd(adSlot, object : NativeExpressAdListener {
//            override fun onError(i: Int, s: String) {
//                Log.d(TAG, "banner load fail: errCode: $i, errMsg: $s")
//            }
//
//            override fun onNativeExpressAdLoad(list: List<TTNativeExpressAd>) {
//                //建议在该回调后进行广告展示
//                if (list != null && list.size > 0) {
//                    Log.d(TAG, "banner load success")
//                    mBannerAd = list[0]
//                    showBannerAd()
//                } else {
//                    Log.d(TAG, "banner load success, but list is null")
//                }
//            }
//        })
//    }

//    private fun showBannerAd() {
//        if (mBannerAd != null) {
//            mBannerAd.setExpressInteractionListener(object : ExpressAdInteractionListener {
//                override fun onAdClicked(view: View, i: Int) {
//                    Log.d(TAG, "banner clicked")
//                }
//
//                override fun onAdShow(view: View, i: Int) {
//                    Log.d(TAG, "banner showed")
//                }
//
//                override fun onRenderFail(view: View, s: String, i: Int) {
//                    Log.d(TAG, "banner renderFail, errCode$i, errMsg: $s")
//                }
//
//                override fun onRenderSuccess(view: View, v: Float, v1: Float) {
//                    Log.d(TAG, "banner render success")
//                }
//            })
//            mBannerAd.setDislikeCallback(this, object : DislikeInteractionCallback {
//                override fun onShow() {}
//
//                override fun onSelected(i: Int, s: String, b: Boolean) {
//                    Log.d(TAG, "banner closed")
//                }
//
//                override fun onCancel() {}
//            })
//            val bannerView: View = mBannerAd!!.getExpressAdView()
//
//
//            if (bannerView != null && mBannerContainer != null) {
//                mBannerContainer.removeAllViews()
//                mBannerContainer.addView(bannerView)
//            }
//        } else {
//            Log.d(TAG, "请先加载广告或等待广告加载完毕后再展示广告")
//        }
//    }

    fun wcLogin() {
        Log.e(TAG, "点击")
        //发起登陆请求前先注册微信api
        val api = WXAPIFactory.createWXAPI(this, "wxb831fa507033254e", true);
        api.registerApp("wxb831fa507033254e");
        if (!api.isWXAppInstalled()) {
            //todo 提醒未安装微信
            return;
        }
        //开始发起登陆请求
        val req = SendAuth.Req().apply {
            scope = "snsapi_userinfo";
            state = "自定义state";
        }
        api.sendReq(req);
    }

    /*初始化穿山甲SDK*/
    private fun TTAdConfig() {
        Log.e(TAG, "初始化广告")
        TTAdSdk.getAdManager().requestPermissionIfNecessary(this);

        val config: TTAdConfig = TTAdConfig.Builder()
            .appId("5001121") // 5639900  CsjSDK
//            .useTextureView(false)
            .appName("APP测试媒体")
            .titleBarTheme(TTAdConstant.TITLE_BAR_THEME_DARK)
            .allowShowNotify(true)
//            .allowShowPageWhenScreenLock(true)
            .debug(true)
            .directDownloadNetworkType(
                TTAdConstant.NETWORK_STATE_WIFI,
                TTAdConstant.NETWORK_STATE_3G
            )
            .supportMultiProcess(false)
            .build();
        TTAdSdk.init(this, config);

    }


    fun startAdSdk() {
        TTAdSdk.start(object : TTAdSdk.Callback {
            override fun success() {
//                Log.i(TAG, "success: " + TTAdSdk.isSdkReady());
            }

            override fun fail(p0: Int, p1: String?) {
                Log.i(TAG, "fail:  code = " + Int.toString() + " msg = " + String);
            }

//            private fun buildConfig(context: Context): TTAdConfig {
//                return TTAdConfig.Builder()
//                    .appId("xxxxxx") //应用ID
//                    .supportMultiProcess(true) //开启多进程
//                    .build()
//            }
        })
    }


    fun loadAd2() {
        val statusBarHeightPx = UIUtils.getStatusBarHeight(this).toInt()
        val splashWidthDp = UIUtils.getScreenWidthDp(this)
        val splashWidthPx = UIUtils.getScreenWidthInPx(this)
        val screenHeightPx: Int = UIUtils.getScreenHeight(this) + statusBarHeightPx
        val screenHeightDp = UIUtils.px2dip(this, screenHeightPx.toFloat()).toFloat()
        val splashHeightDp: kotlin.Float = screenHeightDp
        val splashHeightPx: kotlin.Int = screenHeightPx

        val mTTAdNative = TTAdSdk.getAdManager().createAdNative(this);
        val adSlot = AdSlot.Builder()
            .setCodeId("890555185")
            //不区分渲染方式，要求开发者同时设置setImageAcceptedSize（单位：px）和setExpressViewAcceptedSize（单位：dp ）接口，不同时设置可能会导致展示异常。
//            .setExpressViewAcceptedSize(splashWidthDp, splashHeightDp)
//            .setImageAcceptedSize(splashWidthPx, splashHeightPx)
//            .setAdLoadType(TTAdLoadType.PRELOAD)//推荐使用，用于标注此次的广告请求用途为预加载（当做缓存）还是实时加载，方便后续为开发者优化相关策略
            .build()

        mTTAdNative.loadSplashAd(adSlot, object : TTAdNative.CSJSplashAdListener {
            //开屏素材加载成功
            override fun onSplashLoadSuccess() {
                Log.d(TAG, "onSplashLoadSuccess")
            }

            //加载开屏素材失败
            override fun onSplashLoadFail(p0: CSJAdError?) {
                Log.d(TAG, "onSplashLoadFail=${p0?.msg}${p0?.code}")
                //开发者处理跳转到APP主页面逻辑
//                gotoMain()
            }

            //开屏渲染成功，可以展示开屏
            override fun onSplashRenderSuccess(ad: CSJSplashAd?) {
                Log.d(TAG, "onSplashRenderSuccess")
//                ad?.let {
//                    findViewById<LinearLayout>(R.id.splash_container).addView(it.splashView)
//                    return
//                }

                ad!!.showSplashView(findViewById(R.id.splash_container))
                //开发者处理跳转到APP主页面逻辑
//                gotoMain()
            }

            override fun onSplashRenderFail(ad: CSJSplashAd?, err: CSJAdError?) {
                Log.d(TAG, "onSplashRenderFail=${err?.msg}")
                //开发者处理跳转到APP主页面逻辑
//                gotoMain()
            }
        }, 3500)
    }


    fun loadAd() {
        //创建TTAdNative对象，createAdNative(Context context) context需要传入Activity对象
        val mTTAdNative = TTAdSdk.getAdManager().createAdNative(this);

        val adSlot = AdSlot.Builder()
            .setCodeId("801121648")
            //不区分渲染方式，要求开发者同时设置setImageAcceptedSize（单位：px）和setExpressViewAcceptedSize（单位：dp ）接口，不同时设置可能会导致展示异常。
            .setImageAcceptedSize(100, 100)
            .setExpressViewAcceptedSize(100F, 100F)
//            .setAdLoadType(TTAdLoadType.PRELOAD)//推荐使用，用于标注此次的广告请求用途为预加载（当做缓存）还是实时加载，方便后续为开发者优化相关策略
            .build()

        mTTAdNative.loadSplashAd(adSlot, object : TTAdNative.CSJSplashAdListener {
            //开屏素材加载成功
            override fun onSplashLoadSuccess() {
                Log.d(TAG, "onSplashLoadSuccess")
            }

            //加载开屏素材失败
            override fun onSplashLoadFail(p0: CSJAdError?) {
                Log.d(TAG, "onSplashLoadFail=${p0?.msg}${p0?.code}")
                //开发者处理跳转到APP主页面逻辑
//                gotoMain()
            }

            //开屏渲染成功，可以展示开屏
            override fun onSplashRenderSuccess(ad: CSJSplashAd?) {
                Log.d(TAG, "onSplashRenderSuccess")
                ad?.let {
                    findViewById<LinearLayout>(R.id.splash_container).addView(it.splashView)
                    return
                }
                //开发者处理跳转到APP主页面逻辑
//                gotoMain()
            }

            override fun onSplashRenderFail(ad: CSJSplashAd?, err: CSJAdError?) {
                Log.d(TAG, "onSplashRenderFail=${err?.msg}")
                //开发者处理跳转到APP主页面逻辑
//                gotoMain()
            }
        }, 3000)
    }

}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
    SplashRoute()
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ClientAppTheme {
        Greeting("Android")
    }
}