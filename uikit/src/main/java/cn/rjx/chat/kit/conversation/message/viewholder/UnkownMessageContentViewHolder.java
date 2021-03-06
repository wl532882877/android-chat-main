/*
 * Copyright (c) 2020 WildFireChat. All rights reserved.
 */

package cn.rjx.chat.kit.conversation.message.viewholder;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import butterknife.BindView;
import cn.rjx.chat.kit.R2;
import cn.rjx.chat.kit.annotation.EnableContextMenu;
import cn.rjx.chat.kit.annotation.MessageContentType;
import cn.rjx.chat.kit.conversation.ConversationFragment;
import cn.rjx.chat.kit.conversation.message.model.UiMessage;
import cn.wildfirechat.message.UnknownMessageContent;

@MessageContentType(UnknownMessageContent.class)
@EnableContextMenu
public class UnkownMessageContentViewHolder extends NormalMessageContentViewHolder {
    @BindView(R2.id.contentTextView)
    TextView contentTextView;

    public UnkownMessageContentViewHolder(ConversationFragment fragment, RecyclerView.Adapter adapter, View itemView) {
        super(fragment, adapter, itemView);
    }

    @Override
    public void onBind(UiMessage message) {
        contentTextView.setText("暂不支持此消息，请升级最新版本!");
    }

}
