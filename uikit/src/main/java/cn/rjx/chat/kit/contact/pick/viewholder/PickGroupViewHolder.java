/*
 * Copyright (c) 2020 WildFireChat. All rights reserved.
 */

package cn.rjx.chat.kit.contact.pick.viewholder;

import android.view.View;

import androidx.fragment.app.Fragment;

import cn.rjx.chat.kit.contact.UserListAdapter;
import cn.rjx.chat.kit.contact.model.GroupValue;
import cn.rjx.chat.kit.contact.viewholder.header.HeaderViewHolder;

@SuppressWarnings("unused")
public class PickGroupViewHolder extends HeaderViewHolder<GroupValue> {

    public PickGroupViewHolder(Fragment fragment, UserListAdapter adapter, View itemView) {
        super(fragment, adapter, itemView);
    }

    @Override
    public void onBind(GroupValue groupValue) {

    }
}
