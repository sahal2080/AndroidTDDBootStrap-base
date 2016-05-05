/*
 * The MIT License (MIT)
 *
 * Copyright (c) 2016 Piasy
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.github.piasy.base.model.provider;

import com.facebook.stetho.okhttp3.StethoInterceptor;
import com.google.auto.value.AutoValue;
import com.moczul.ok2curl.CurlInterceptor;
import com.moczul.ok2curl.logger.Loggable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import timber.log.Timber;

/**
 * Created by Piasy{github.com/Piasy} on 15/7/23.
 *
 * A singleton provider providing {@link OkHttpClient}.
 */
@SuppressWarnings("PMD.NonThreadSafeSingleton")
public final class HttpClientProvider {

    private static volatile OkHttpClient sOkHttpClient;

    private HttpClientProvider() {
        // singleton
    }

    /**
     * Provide the {@link OkHttpClient} singleton instance. Should be only called in test cases,
     * besides {@link ProviderModule}.
     *
     * @return the singleton {@link OkHttpClient}.
     */
    @SuppressWarnings("PMD.AvoidDeeplyNestedIfStmts")
    static OkHttpClient provideHttpClient(final Config config) {
        if (sOkHttpClient == null) {
            synchronized (HttpClientProvider.class) {
                if (sOkHttpClient == null) {
                    final OkHttpClient.Builder builder = new OkHttpClient.Builder();
                    if (config.enableLog()) {
                        builder.addNetworkInterceptor(new StethoInterceptor())
                                .addInterceptor(new HttpLoggingInterceptor(
                                        new HttpLoggingInterceptor.Logger() {
                                            @Override
                                            public void log(final String message) {
                                                Timber.tag("OkHttp").d(message);
                                            }
                                        }).setLevel(HttpLoggingInterceptor.Level.BODY))
                                .addInterceptor(new CurlInterceptor(new Loggable() {
                                    @Override
                                    public void log(String message) {
                                        Timber.tag("Ok2Curl").d(message);
                                    }
                                }));
                    }
                    sOkHttpClient = builder.build();
                }
            }
        }
        return sOkHttpClient;
    }

    @AutoValue
    public abstract static class Config {
        public static Builder builder() {
            return new AutoValue_HttpClientProvider_Config.Builder();
        }

        public abstract boolean enableLog();

        @AutoValue.Builder
        public abstract static class Builder {
            public abstract Builder enableLog(final boolean enableLog);

            public abstract Config build();
        }
    }
}
