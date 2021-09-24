/*
 * Copyright (c) 2020 WildFireChat. All rights reserved.
 */

package cn.rjx.chat.kit.settings;

import android.content.Intent;

import butterknife.OnClick;
import cn.rjx.chat.kit.R;
import cn.rjx.chat.kit.R2;
import cn.rjx.chat.kit.WfcBaseActivity;
import cn.rjx.chat.kit.settings.blacklist.BlacklistListActivity;

public class PrivacySettingActivity extends WfcBaseActivity {

    @Override
    protected int contentLayout() {
        return R.layout.privacy_setting_activity;
    }

    @OnClick(R2.id.blacklistOptionItemView)
    void blacklistSettings() {
        Intent intent = new Intent(this, BlacklistListActivity.class);
        startActivity(intent);
    }

    @OnClick(R2.id.momentsPrivacyOptionItemView)
    void mementsSettings() {

    }
}
