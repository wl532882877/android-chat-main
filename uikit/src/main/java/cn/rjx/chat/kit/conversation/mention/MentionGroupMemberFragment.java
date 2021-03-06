/*
 * Copyright (c) 2020 WildFireChat. All rights reserved.
 */

package cn.rjx.chat.kit.conversation.mention;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.lifecycle.ViewModelProviders;

import cn.rjx.chat.kit.R;
import cn.rjx.chat.kit.contact.BaseUserListFragment;
import cn.rjx.chat.kit.contact.UserListAdapter;
import cn.rjx.chat.kit.contact.model.HeaderValue;
import cn.rjx.chat.kit.contact.model.UIUserInfo;
import cn.rjx.chat.kit.group.GroupViewModel;
import cn.wildfirechat.model.GroupInfo;
import cn.wildfirechat.model.GroupMember;
import cn.wildfirechat.remote.ChatManager;

public class MentionGroupMemberFragment extends BaseUserListFragment {
    private GroupInfo groupInfo;
    private GroupMember groupMember;
    private GroupViewModel groupViewModel;

    public static MentionGroupMemberFragment newInstance(GroupInfo groupInfo) {
        Bundle args = new Bundle();
        args.putParcelable("groupInfo", groupInfo);
        MentionGroupMemberFragment fragment = new MentionGroupMemberFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        showQuickIndexBar(true);
        groupInfo = getArguments().getParcelable("groupInfo");
        groupViewModel = ViewModelProviders.of(getActivity()).get(GroupViewModel.class);
        groupMember = groupViewModel.getGroupMember(groupInfo.target, ChatManager.Instance().getUserId());
    }

    @Override
    protected void afterViews(View view) {
        super.afterViews(view);
        groupViewModel.getGroupMemberUIUserInfosLiveData(groupInfo.target, false).observe(this, uiUserInfos -> {
            showContent();
            userListAdapter.setUsers(uiUserInfos);
        });
    }

    @Override
    public UserListAdapter onCreateUserListAdapter() {
        return new UserListAdapter(this);
    }

    @Override
    public void initHeaderViewHolders() {
        if (groupMember != null) {
            if (groupMember.type == GroupMember.GroupMemberType.Manager || groupMember.type == GroupMember.GroupMemberType.Owner) {
                addHeaderViewHolder(MentionAllHeaderViewHolder.class, R.layout.conversation_header_mention_all, new HeaderValue());
            }
        }
    }

    @Override
    public void onHeaderClick(int index) {
        Intent intent = new Intent();
        intent.putExtra("mentionAll", true);
        getActivity().setResult(Activity.RESULT_OK, intent);
        getActivity().finish();
    }

    @Override
    public void onUserClick(UIUserInfo userInfo) {
        Intent intent = new Intent();
        intent.putExtra("userId", userInfo.getUserInfo().uid);
        getActivity().setResult(Activity.RESULT_OK, intent);
        getActivity().finish();
    }
}
