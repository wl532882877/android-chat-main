/*
 * Copyright (c) 2020 WildFireChat. All rights reserved.
 */

package cn.rjx.chat.kit.contact.newfriend;

import java.util.List;

import cn.rjx.chat.kit.search.SearchActivity;
import cn.rjx.chat.kit.search.SearchableModule;

public class SearchUserActivity extends SearchActivity {

    @Override
    protected void beforeViews() {
    }

    @Override
    protected void initSearchModule(List<SearchableModule> modules) {
        modules.add(new UserSearchModule());
    }
}
