/*
 * Copyright (C) 2013 Chen Hui <calmer91@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package tv.light.danmaku.loader.android;

import tv.light.danmaku.loader.ILoader;
import tv.light.danmaku.parser.IDataSource;
import tv.light.danmaku.parser.android.AndroidFileSource;

import android.net.Uri;

import java.io.InputStream;

public class BiliDanmakuLoader implements ILoader {

    private static BiliDanmakuLoader _instance;

    private AndroidFileSource dataSource;

    private Uri uri;

    public BiliDanmakuLoader() {

    }

    public static BiliDanmakuLoader instance() {
        if (_instance == null) {
            _instance = new BiliDanmakuLoader();
        }
        return _instance;
    }

    /**
     * @param uri 弹幕文件地址(http:// file://)
     * @return
     */
    public void load(String uri) {
        try {
            this.uri = Uri.parse(uri);
            dataSource = new AndroidFileSource(uri);
        } catch (Exception e) {

        }
    }

    public void load(InputStream stream) {
        dataSource = new AndroidFileSource(stream);
    }

    @Override
    public IDataSource getDataSource() {
        return dataSource;
    }
}
