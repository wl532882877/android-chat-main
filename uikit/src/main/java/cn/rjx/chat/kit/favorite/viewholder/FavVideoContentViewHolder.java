/*
 * Copyright (c) 2020 WildFireChat. All rights reserved.
 */

package cn.rjx.chat.kit.favorite.viewholder;

import android.view.View;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import butterknife.BindView;
import butterknife.OnClick;
import cn.rjx.chat.kit.GlideApp;
import cn.rjx.chat.kit.R2;
import cn.rjx.chat.kit.favorite.FavoriteItem;
import cn.rjx.chat.kit.mm.MMPreviewActivity;

public class FavVideoContentViewHolder extends FavContentViewHolder {
    @BindView(R2.id.favImageContentImageView)
    ImageView imageView;

    public FavVideoContentViewHolder(@NonNull View itemView) {
        super(itemView);
    }

    @Override
    public void bind(Fragment fragment, FavoriteItem item) {
        super.bind(fragment, item);
        GlideApp.with(itemView)
            .load(item.getUrl()).into(imageView);
    }

    @OnClick(R2.id.favImageContentImageView)
    void showFavImage() {
        MMPreviewActivity.previewVideo(fragment.getActivity(), favoriteItem.getUrl());
    }
}
