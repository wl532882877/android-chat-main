/*
 * Copyright (c) 2020 WildFireChat. All rights reserved.
 */

package cn.rjx.chat.kit.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import cn.rjx.chat.kit.conversationlist.notification.StatusNotification;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface StatusNotificationType {
    Class<? extends StatusNotification> value();
}
