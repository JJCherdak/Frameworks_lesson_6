package ru.geekbrains.mvpuser.di

import dagger.Subcomponent
import ru.geekbrains.mvpuser.UserPresenter
import javax.inject.Scope

@FragmentScope
@Subcomponent(
    modules = [AllDependenciesModule::class]
)
interface UserComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): UserComponent
    }

    fun inject(activity: UserPresenter)
}

@Scope
annotation class FragmentScope