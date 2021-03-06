/*
 * Copyright (C) 2013 Peng fei Pan <sky@xiaopan.me>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.xiaopan.sketch.request;

import android.graphics.Bitmap;

import me.xiaopan.sketch.drawable.RecycleGifDrawable;

public class LoadResult {
    private Bitmap bitmap;
    private RecycleGifDrawable gifDrawable;
    private String mimeType;
    private ImageFrom imageFrom;

    public LoadResult(Bitmap bitmap, ImageFrom imageFrom, String mimeType) {
        this.bitmap = bitmap;
        this.imageFrom = imageFrom;
        this.mimeType = mimeType;
    }

    public LoadResult(RecycleGifDrawable gifDrawable, ImageFrom imageFrom, String mimeType) {
        this.gifDrawable = gifDrawable;
        this.imageFrom = imageFrom;
        this.mimeType = mimeType;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public RecycleGifDrawable getGifDrawable() {
        return gifDrawable;
    }

    public ImageFrom getImageFrom() {
        return imageFrom;
    }

    public String getMimeType() {
        return mimeType;
    }
}
