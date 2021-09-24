/*
 * Copyright (c) 2020 WildFireChat. All rights reserved.
 */

package cn.rjx.chat.kit.contact.viewholder.header;

import android.view.View;

import androidx.fragment.app.Fragment;

import cn.rjx.chat.kit.contact.UserListAdapter;
import cn.rjx.chat.kit.contact.model.GroupValue;

@SuppressWarnings("unused")
public class GroupViewHolder extends HeaderViewHolder<GroupValue> {

    public GroupViewHolder(Fragment fragment, UserListAdapter adapter, View itemView) {
        super(fragment, adapter, itemView);
    }

    @Override
    public void onBind(GroupValue groupValue) {

    }
}
