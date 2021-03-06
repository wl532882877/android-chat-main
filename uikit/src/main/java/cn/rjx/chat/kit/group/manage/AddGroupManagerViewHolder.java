/*
 * Copyright (c) 2020 WildFireChat. All rights reserved.
 */

package cn.rjx.chat.kit.group.manage;

import android.view.View;

import androidx.fragment.app.Fragment;

import cn.rjx.chat.kit.contact.UserListAdapter;
import cn.rjx.chat.kit.contact.model.FooterValue;
import cn.rjx.chat.kit.contact.viewholder.footer.FooterViewHolder;

public class AddGroupManagerViewHolder extends FooterViewHolder<FooterValue> {

    public AddGroupManagerViewHolder(Fragment fragment, UserListAdapter adapter, View itemView) {
        super(fragment, adapter, itemView);
    }

    @Override
    public void onBind(FooterValue footerValue) {
        // do nothing
    }
}
