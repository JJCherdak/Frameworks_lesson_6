package ru.geekbrains.mvpuser

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import ru.geekbrains.data.GitHubApi
import ru.geekbrains.data.GitHubUserRepository
import ru.geekbrains.navigation.CustomRouter

class UserPresenter(
    private val userLogin: String,
    private val userRepository: GitHubUserRepository,
    private val router: CustomRouter
) : MvpPresenter<UserView>() {

    override fun onFirstViewAttach() {
      updateContent()
    }

    fun updateContent() {
        userRepository.getUserByLogin("mojombo")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.showUser(it)
            },{
                val errorMessage = it.message
                //DisplayErro
            })
    }
}