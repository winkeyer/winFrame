package com.winkey.commonlib.constant;

import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.winkey.commonlib.R;

/**
 * Glide默认配置项
 *
 * @author xiongz
 * @date 2019-07-18
 */
public class GlideOptions {

    private static final class Holder {
        private static final GlideOptions INSTANCE = new GlideOptions();
    }

    public static GlideOptions getInstance() {
        return GlideOptions.Holder.INSTANCE;
    }

    /**
     * 获取默认的图片
     *
     * @return
     */
    public RequestOptions getDefaultOption() {
        RequestOptions options = new RequestOptions()
                .placeholder(R.mipmap.ic_img_default)
                .error(R.mipmap.ic_img_default);
        return options;
    }

    /**
     * 获取默认的图片
     *
     * @return
     */
    public RequestOptions getDefaultOption(int resId) {
        RequestOptions options = new RequestOptions()
                .placeholder(resId)
                .error(resId);
        return options;
    }

    /**
     * 获取默认头像的图片
     *
     * @return
     */
    public RequestOptions getDefaultAvatarOption() {
        RequestOptions options = new RequestOptions()
                .placeholder(R.mipmap.ic_avatar_default)
                .error(R.mipmap.ic_avatar_default);
        return options;
    }

    /**
     * 不要缓存
     *
     * @return
     */
    public RequestOptions getNoCacheOption() {
        RequestOptions options = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.NONE);
        return options;
    }


}
