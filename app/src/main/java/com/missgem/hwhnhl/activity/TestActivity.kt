package com.missgem.hwhnhl.activity

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.widget.MediaController
import android.widget.VideoView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.media3.common.C
import androidx.media3.common.MediaItem
import androidx.media3.common.MediaMetadata
import androidx.media3.common.MimeTypes
import androidx.media3.exoplayer.ExoPlayer
import androidx.media3.exoplayer.analytics.AnalyticsListener
import androidx.media3.ui.PlayerView
import com.example.clientapp.R
import io.sanghun.compose.video.RepeatMode
import io.sanghun.compose.video.VideoPlayer
import io.sanghun.compose.video.controller.VideoPlayerControllerConfig
import io.sanghun.compose.video.uri.VideoPlayerMediaItem

class TestActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Text("2eeee")
            val context = LocalContext.current


            VideoPlayer(
                mediaItems = listOf(
                    VideoPlayerMediaItem.RawResourceMediaItem(
                        resourceId = R.raw.mov_bbb,
                    ),
//                    VideoPlayerMediaItem.AssetFileMediaItem(
//                        assetPath = "videos/test.mp4"
//                    ),
//                    VideoPlayerMediaItem.StorageMediaItem(
//                        storageUri = "content://xxxxx"
//                    ),
                    VideoPlayerMediaItem.NetworkMediaItem(
                        url = "http://www.w3school.com.cn/example/html5/mov_bbb.mp4",
//                        mediaMetadata = MediaMetadata.Builder().setTitle("Widevine DASH cbcs: Tears").build(),
//                        mimeType = MimeTypes.APPLICATION_MPD,
//                        drmConfiguration = MediaItem.DrmConfiguration.Builder(C.WIDEVINE_UUID)
//                            .setLicenseUri("https://proxy.uat.widevine.com/proxy?provider=widevine_test")
//                            .build(),
                    )
                ),
                handleLifecycle = true,
                autoPlay = true,
                usePlayerController = true,
                enablePip = true,
                handleAudioFocus = true,
                controllerConfig = VideoPlayerControllerConfig(
                    showSpeedAndPitchOverlay = true,
                    showSubtitleButton = false,
                    showCurrentTimeAndTotalTime = true,
                    showBufferingProgress = false,
                    showForwardIncrementButton = true,
                    showBackwardIncrementButton = true,
                    showBackTrackButton = true,
                    showNextTrackButton = true,
                    showRepeatModeButton = true,
                    controllerShowTimeMilliSeconds = 5_000,
                    controllerAutoShow = true,
                    showFullScreenButton = true
                ),
                volume = 0.5f,  // 音量范围：0.0f 至 1.0f
                repeatMode = RepeatMode.NONE,       // 或 RepeatMode.ALL, RepeatMode.ONE
//                onCurrentTimeChanged = { // long类型，当前播放时间（毫秒）
//                    Log.e("CurrentTime", it.toString())
//                },
//                playerInstance = { // ExoPlayer实例（实验性）
//                    addAnalyticsListener(
//                        object : AnalyticsListener {
//                            // 播放器日志记录
//                        }
//                    )
//                },
//                modifier = Modifier
//                    .fillMaxSize()
//                    .align(Alignment.Center),
            )

            // 视频的 URI，可以是本地文件或网络视频
//            val videoUri = remember {
//                Uri.parse("android.resource://${context.packageName}/${R.raw.sample_video}")
//            }
//            val videoUri = "https://www.w3school.com.cn/example/html5/mov_bbb.mp4"
//            val exoPlayer = remember {
//                ExoPlayer.Builder(context).build().apply {
//                    setMediaItem(MediaItem.fromUri("https://www.w3school.com.cn/example/html5/mov_bbb.mp4"))
//                    prepare()
//                    playWhenReady = true
//                }
//            }
//            DisposableEffect(exoPlayer) {
//                onDispose {
//                    exoPlayer.release()
//                }
//            }
//            AndroidView(factory = { context ->
//                PlayerView(context).apply {
//                    player = exoPlayer
//                }
//            })




            // 使用 AndroidView 嵌入 VideoView
//            AndroidView(
//                factory = { ctx ->
//                    VideoView(ctx).apply {
//                        // 设置视频 URI
////                        setVideoURI(videoUri)
//                        setVideoPath(videoUri);
////                        requestFocus();
//                        // 添加播放控制器
//                        val mediaController = MediaController(ctx)
//                        mediaController.setAnchorView(this)
//                        setMediaController(mediaController)
//
//                        // 自动开始播放
//                        setOnPreparedListener { start() }
//                    }
//                },
//                modifier = Modifier
//            )


        }
    }}