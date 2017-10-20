package ir.oveissi.daggersample.di.module;

import com.google.gson.Gson;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import ir.oveissi.daggersample.data.remote.Api;
import ir.oveissi.daggersample.data.remote.ApiService;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by abbas on 9/5/17.
 */
@Module
public class NetworkModule {

    @Provides
    @Singleton
    public static Converter.Factory provideGsonConverterFactory(Gson gson) {
        return GsonConverterFactory.create(gson);
    }

    @Singleton
    @Provides
    public static Gson provideGson() {
        return new Gson();
    }

    @Singleton
    @Provides
    public static HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.HEADERS);
        return logging;

    }

    @Singleton
    @Provides
    public static OkHttpClient provideOkHttpClient(HttpLoggingInterceptor loggingInterceptor,
                                                   @Named("networkTimeoutInSeconds") int networkTimeoutInSeconds,
                                                   @Named("isDebug") boolean isDebug) {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder()
                .readTimeout(networkTimeoutInSeconds, TimeUnit.SECONDS)
                .connectTimeout(networkTimeoutInSeconds, TimeUnit.SECONDS);
        if (isDebug)
            okHttpClient.addInterceptor(loggingInterceptor);
        return okHttpClient.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(@Named("BaseUrl") String baseUrl, Converter.Factory converterFactory, OkHttpClient okHttpClient) {
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(converterFactory)
                .client(okHttpClient)
                .build();
    }

    @Provides
    public ApiService provideApiService(Retrofit retrofit)
    {
        return new ApiService(retrofit.create(Api.class));

    }

}
