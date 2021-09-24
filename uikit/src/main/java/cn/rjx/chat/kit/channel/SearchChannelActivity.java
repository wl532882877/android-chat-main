/*
 * Copyright (c) 2020 WildFireChat. All rights reserved.
 */

package cn.rjx.chat.kit.channel;

import java.util.List;

import cn.rjx.chat.kit.search.SearchActivity;
import cn.rjx.chat.kit.search.SearchableModule;
import cn.rjx.chat.kit.search.module.ChannelSearchModule;

public class SearchChannelActivity extends SearchActivity {
    @Override
    protected void initSearchModule(List<SearchableModule> modules) {
        modules.add(new ChannelSearchModule());
    }
}
