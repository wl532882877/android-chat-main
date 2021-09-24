/*
 * Copyright (c) 2020 WildFireChat. All rights reserved.
 */

package cn.rjx.chat.app.setting;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.OnClick;
import cn.rjx.chat.R;
import cn.rjx.chat.app.AppService;
import cn.rjx.chat.kit.Config;
import cn.rjx.chat.kit.WfcBaseActivity;
import cn.rjx.chat.kit.WfcWebViewActivity;

public class AboutActivity extends WfcBaseActivity {

    @BindView(R.id.infoTextView)
    TextView infoTextView;

    @Override
    protected int contentLayout() {
        return R.layout.activity_about;
    }

    @Override
    protected void afterViews() {
        PackageManager packageManager = getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(getPackageName(), PackageManager.GET_CONFIGURATIONS);
            String info = packageInfo.packageName + "\n"
                + packageInfo.versionCode + " " + packageInfo.versionName + "\n"
                + Config.IM_SERVER_HOST + "\n"
                + AppService.APP_SERVER_ADDRESS + "\n";

            for (String[] ice : Config.ICE_SERVERS) {
                info += ice[0] + " " + ice[1] + " " + ice[2] + "\n";
            }
            infoTextView.setText(info);

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    @OnClick(R.id.introOptionItemView)
    public void intro() {
        WfcWebViewActivity.loadUrl(this, "野火IM功能介绍", "http://docs.wildfirechat.cn/");
    }

    @OnClick(R.id.agreementOptionItemView)
    public void agreement() {
        WfcWebViewActivity.loadUrl(this, "野火IM用户协议", "http://www.wildfirechat.cn/firechat_user_agreement.html");
    }

    @OnClick(R.id.privacyOptionItemView)
    public void privacy() {
        WfcWebViewActivity.loadUrl(this, "野火IM个人信息保护政策", "http://www.wildfirechat.cn/firechat_user_privacy.html");
    }
}
