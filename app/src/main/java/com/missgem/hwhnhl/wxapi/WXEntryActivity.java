package com.missgem.hwhnhl.wxapi;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;


import androidx.appcompat.app.AppCompatActivity;

import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;


public class WXEntryActivity extends AppCompatActivity implements IWXAPIEventHandler {
    private static final String TAG = WXEntryActivity.class.getName();
    private static final String APPID = "wxb831fa507033254e";
    private static final String SECRET = "77143a8e56fd5c7d39384ab50695ad32";

    private IWXAPI api;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        api = WXAPIFactory.createWXAPI(this, APPID, false);
        try {
            Intent intent = getIntent();
            api.handleIntent(intent, this);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onNewIntent(Intent intent) {
        //微信 sdk必须
        super.onNewIntent(intent);
        setIntent(intent);
        api.handleIntent(intent, this);
    }

    private void done() {
        //微信 sdk完成之后关闭该activity
        this.finish();

    }

    @Override
    public void onReq(BaseReq baseReq) {
        this.done();
    }

    @Override
    public void onResp(BaseResp baseResp) {
        switch (baseResp.errCode) {
            //ERR_OK = 0(用户同意) ERR_AUTH_DENIED = -4（用户拒绝授权） ERR_USER_CANCEL = -2（用户取消）
            case BaseResp.ErrCode.ERR_OK:
                Toast.makeText(this, "用户同意微信授权", Toast.LENGTH_SHORT).show();
                SendAuth.Resp authResp = (SendAuth.Resp) baseResp;
                DoGetRequestToGetAccessTokenAndOpenId(APPID, SECRET, authResp.code);//Get请求获取AccessToken和OpenId
                break;
            case BaseResp.ErrCode.ERR_USER_CANCEL:
                Toast.makeText(this, "用户取消微信登陆", Toast.LENGTH_SHORT).show();
                break;
            case BaseResp.ErrCode.ERR_AUTH_DENIED:
                Toast.makeText(this, "用户拒绝微信授权", Toast.LENGTH_SHORT).show();
                break;

            default:
                break;
        }
        this.done();
    }

    /**
     * Get请求获取AccessToken和OpenId。这两个信息最好从后端获取，在这里只做演示。
     *
     * @param appId
     * @param secret 因为secret写在前端有被人反编译出来的风险，破坏安全性。
     * @param code
     */
    private void DoGetRequestToGetAccessTokenAndOpenId(String appId, String secret, String code) {
        //用Get网络请求调下面的url连接即可，不过获取AccessToken和OpenId最好从后端获取。
        String getUrl_accessToken_unionId = "https://api.weixin.qq.com/sns/oauth2/access_token?"
                + "appid=" + appId
                + "&secret=" + secret
                + "&code=" + code
                + "&grant_type=authorization_code";

        //当Get成功后，在用拿到的 accessToken 和 OpenId 去获取微信用户信息。
//        DoGetRequestWeChatUserInfo(accessToken,OpenId);
    }

    private void DoGetRequestWeChatUserInfo(String accessToken, String OpenId) {
        //用Get网络请求调下面的url连接即可
        String getUrl_WeChatUserInfo = "https://api.weixin.qq.com/sns/userinfo?"
                + "access_token=" + accessToken
                + "&openid=" + OpenId;
        //写个Get请求集合。请求成功后就可以拿到微信用户的信息啦。里面有头像url，昵称，等信息。
    }
}