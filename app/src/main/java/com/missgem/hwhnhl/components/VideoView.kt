package com.missgem.hwhnhl.components


import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.tencent.rtmp.TXVodPlayer


@Composable
fun VideoView(vodPlayer:TXVodPlayer) {
    Text("qerer1")
//    AndroidView(factory = {context ->
////        (LayoutInflater.from(context).inflate(R.layout.video,null,false)
////            .findViewById<TXCloudVideoView>(R.id.video_view)!!).apply {
//        TXCloudVideoView(context).apply {
//            vodPlayer.setPlayerView(this);
//        }
//    })


//    AndroidView(factory = { context ->
//        (LayoutInflater.from(context).inflate(R.layout.video, null, false)
//            .findViewById(R.id.video_view) as TXCloudVideoView).apply {
//            vodPlayer.setPlayerView(this)
//        }
//    })

//    Text("qerer2")

//    AndroidView(factory = { ctx ->
//        VideoView(ctx).apply {
//            // 设置视频 URI
//            setVideoURI(videoUri)
//
//            // 添加播放控制器
//            val mediaController = MediaController(ctx)
//            mediaController.setAnchorView(this)
//            setMediaController(mediaController)
//
//            // 自动开始播放
//            setOnPreparedListener { start() }
//        }
//    })
}

@Preview
@Composable
fun VideoViewPreview() {
//    VideoView()
}

