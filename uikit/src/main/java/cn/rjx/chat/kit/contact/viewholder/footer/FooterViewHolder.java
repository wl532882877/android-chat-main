/*
 * Copyright (c) 2020 WildFireChat. All rights reserved.
 */

package cn.rjx.chat.kit.contact.viewholder.footer;

import android.view.View;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import cn.rjx.chat.kit.contact.ContactViewModel;
import cn.rjx.chat.kit.contact.UserListAdapter;
import cn.rjx.chat.kit.contact.model.FooterValue;

public abstract class FooterViewHolder<T extends FooterValue> extends RecyclerView.ViewHolder {
    protected Fragment fragment;
    protected UserListAdapter adapter;
    protected ContactViewModel contactViewModel;

    public FooterViewHolder(Fragment fragment, UserListAdapter adapter, View itemView) {
        super(itemView);
        this.fragment = fragment;
        this.adapter = adapter;
        contactViewModel = ViewModelProviders.of(fragment).get(ContactViewModel.class);
    }


    public abstract void onBind(T t);

}
