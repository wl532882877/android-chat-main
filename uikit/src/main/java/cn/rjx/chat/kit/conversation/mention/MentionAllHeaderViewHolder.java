/*
 * Copyright (c) 2020 WildFireChat. All rights reserved.
 */

package cn.rjx.chat.kit.conversation.mention;

import android.view.View;

import androidx.fragment.app.Fragment;

import cn.rjx.chat.kit.contact.UserListAdapter;
import cn.rjx.chat.kit.contact.model.HeaderValue;
import cn.rjx.chat.kit.contact.viewholder.header.HeaderViewHolder;

public class MentionAllHeaderViewHolder extends HeaderViewHolder<HeaderValue> {
    public MentionAllHeaderViewHolder(Fragment fragment, UserListAdapter adapter, View itemView) {
        super(fragment, adapter, itemView);
    }

    @Override
    public void onBind(HeaderValue value) {

    }
}
