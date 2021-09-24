/*
 * Copyright (c) 2020 WildFireChat. All rights reserved.
 */

package cn.rjx.chat.kit.settings.blacklist;

import cn.rjx.chat.kit.R;
import cn.rjx.chat.kit.WfcBaseActivity;

public class BlacklistListActivity extends WfcBaseActivity {


    @Override
    protected int contentLayout() {
        return R.layout.fragment_container_activity;
    }

    @Override
    protected void afterViews() {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.containerFrameLayout, new BlacklistListFragment())
                .commit();
    }
}
