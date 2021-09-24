/*
 * Copyright (c) 2020 WildFireChat. All rights reserved.
 */

package cn.rjx.chat.kit.conversationlist.notification.viewholder;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import butterknife.BindView;
import butterknife.OnClick;
import cn.rjx.chat.kit.R2;
import cn.rjx.chat.kit.annotation.StatusNotificationType;
import cn.rjx.chat.kit.conversationlist.notification.PCOnlineStatusNotification;
import cn.rjx.chat.kit.conversationlist.notification.StatusNotification;
import cn.rjx.chat.kit.pc.PCSessionActivity;
import cn.wildfirechat.model.PCOnlineInfo;
import cn.wildfirechat.remote.ChatManager;

@StatusNotificationType(PCOnlineStatusNotification.class)
public class PCOnlineNotificationViewHolder extends StatusNotificationViewHolder {
    @BindView(R2.id.statusTextView)
    TextView statusTextView;
    PCOnlineInfo pcOnlineInfo;

    public PCOnlineNotificationViewHolder(Fragment fragment) {
        super(fragment);
    }

    @Override
    public void onBind(View view, StatusNotification notification) {
        PCOnlineStatusNotification pcOnlineStatusNotification = (PCOnlineStatusNotification) notification;
        pcOnlineInfo = pcOnlineStatusNotification.getPcOnlineInfo();
        String desc = "";
        switch (pcOnlineStatusNotification.getPcOnlineInfo().getType()) {
            case PC_Online:
                desc = "PC 在线";
                break;
            case Web_Online:
                desc = "Web 在线";
                break;
            case WX_Online:
                desc = "微信小程序 在线";
                break;
            default:
                break;
        }
        if(ChatManager.Instance().isMuteNotificationWhenPcOnline()){
            desc += "，手机通知已关闭";
        }

        statusTextView.setText(desc);
    }

    @OnClick(R2.id.statusTextView)
    public void showPCSessionInfo() {
        Intent intent = new Intent(fragment.getActivity(), PCSessionActivity.class);
        intent.putExtra("pcOnlineInfo", pcOnlineInfo);
        fragment.startActivity(intent);
    }
}
