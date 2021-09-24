/*
 * Copyright (c) 2020 WildFireChat. All rights reserved.
 */

package cn.rjx.chat.kit.conversation.file;

import cn.rjx.chat.kit.R;
import cn.rjx.chat.kit.WfcBaseActivity;
import cn.wildfirechat.model.Conversation;

public class FileRecordActivity extends WfcBaseActivity {

    @Override
    protected int contentLayout() {
        return R.layout.fragment_container_activity;
    }

    @Override
    protected void afterViews() {
        if (!isDarkTheme()) {
            setTitleBackgroundResource(R.color.white, false);
        }
        Conversation conversation = getIntent().getParcelableExtra("conversation");
        boolean isMyFiles = getIntent().getBooleanExtra("isMyFiles", false);
        String fromUser = getIntent().getStringExtra("fromUser");
        getSupportFragmentManager().beginTransaction()
            .replace(R.id.containerFrameLayout, FileRecordFragment.newInstance(conversation, fromUser, isMyFiles))
            .commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
