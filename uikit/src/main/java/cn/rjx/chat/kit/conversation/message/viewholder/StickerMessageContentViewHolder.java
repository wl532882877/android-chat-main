/*
 * Copyright (c) 2020 WildFireChat. All rights reserved.
 */

package cn.rjx.chat.kit.conversation.message.viewholder;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.CircularProgressDrawable;

import butterknife.BindView;
import cn.rjx.chat.kit.GlideApp;
import cn.rjx.chat.kit.R2;
import cn.rjx.chat.kit.annotation.EnableContextMenu;
import cn.rjx.chat.kit.annotation.MessageContentType;
import cn.rjx.chat.kit.conversation.ConversationFragment;
import cn.rjx.chat.kit.conversation.message.model.UiMessage;
import cn.rjx.chat.kit.third.utils.UIUtils;
import cn.wildfirechat.message.StickerMessageContent;

@MessageContentType(StickerMessageContent.class)
@EnableContextMenu
public class StickerMessageContentViewHolder extends NormalMessageContentViewHolder {
    private String path;
    @BindView(R2.id.stickerImageView)
    ImageView imageView;

    public StickerMessageContentViewHolder(ConversationFragment fragment, RecyclerView.Adapter adapter, View itemView) {
        super(fragment, adapter, itemView);
    }

    @Override
    public void onBind(UiMessage message) {
        StickerMessageContent stickerMessage = (StickerMessageContent) message.message.content;
        imageView.getLayoutParams().width = UIUtils.dip2Px(stickerMessage.width > 150 ? 150 : stickerMessage.width);
        imageView.getLayoutParams().height = UIUtils.dip2Px(stickerMessage.height > 150 ? 150 : stickerMessage.height);

        if (!TextUtils.isEmpty(stickerMessage.localPath)) {
            if (stickerMessage.localPath.equals(path)) {
                return;
            }
            GlideApp.with(fragment).load(stickerMessage.localPath)
                .into(imageView);
            path = stickerMessage.localPath;
        } else {
            CircularProgressDrawable progressDrawable = new CircularProgressDrawable(fragment.getContext());
            progressDrawable.setStyle(CircularProgressDrawable.DEFAULT);
            progressDrawable.start();
            GlideApp.with(fragment)
                .load(stickerMessage.remoteUrl)
                .placeholder(progressDrawable)
                .into(imageView);
        }
    }

    // ????????????????????????itemView??????????????????setXXXListener???, ??????????????????????????????setXXXListener
    // ??????????????????????????????????????????????????????????????????itemView????????????listener???
    public void onClick(View view) {
        // TODO
    }

}
