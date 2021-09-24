/*
 * Copyright (c) 2020 WildFireChat. All rights reserved.
 */

package cn.rjx.chat.kit.favorite;

import cn.rjx.chat.kit.R;
import cn.rjx.chat.kit.WfcBaseActivity;

public class FavoriteListActivity extends WfcBaseActivity {

    @Override
    protected int contentLayout() {
        return R.layout.fragment_container_activity;
    }

    @Override
    protected void afterViews() {
        if (!isDarkTheme()) {
            setTitleBackgroundResource(R.color.white, false);
        }
        getSupportFragmentManager().beginTransaction()
            .replace(R.id.containerFrameLayout, new FavoriteListFragment())
            .commit();
    }
}
