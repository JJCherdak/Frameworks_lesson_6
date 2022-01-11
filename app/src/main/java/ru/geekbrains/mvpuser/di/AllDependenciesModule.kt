package ru.geekbrains.mvpuser.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.geekbrains.mvpuser.GlideWrapper

@Module
    class AllDependenciesModule {

        @FragmentScope
        @Provides
        fun provideGlideWrapper(context: Context): GlideWrapper {
            return GlideWrapper(context)
        }

    }