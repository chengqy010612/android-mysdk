package com.missgem.hwhnhl;

import android.app.Activity;

import androidx.appcompat.app.AppCompatActivity;


import com.tencent.mm.opensdk.modelbase.BaseReq;
import com.tencent.mm.opensdk.modelbase.BaseResp;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.IWXAPIEventHandler;


public class WXEntryActivity extends Activity implements IWXAPIEventHandler {


    @Override
    public void onReq(BaseReq baseReq) {

    }

    @Override
    public void onResp(BaseResp baseResp) {
        switch (baseResp.errCode){
            case BaseResp.ErrCode.ERR_OK:
                //拉起微信成功
                break;
            case BaseResp.ErrCode.ERR_AUTH_DENIED:

                //("授权出错");
                break;
            case BaseResp.ErrCode.ERR_USER_CANCEL:
                //"用户取消登陆"
                break;
            default:
                break;
        }
    }

}