package ru.geekbrains.mvpuser

import android.widget.ImageView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import moxy.MvpPresenter
import ru.geekbrains.data.GitHubApi
import ru.geekbrains.data.GitHubUserRepository
import ru.geekbrains.data.room.GitHubUserDao
import ru.geekbrains.navigation.CustomRouter
import javax.inject.Inject

class UserPresenter: MvpPresenter<UserView>() {

    @Inject
    lateinit var glideWrapper: GlideWrapper

    @Inject
    lateinit var repository: GitHubUserRepository

    private lateinit var userLogin: String


    fun init(userLogin: String) {
        this.userLogin = userLogin
    }
//    private val userRepository: GitHubUserRepository,
//    private val router: CustomRouter


    override fun onFirstViewAttach() {
        repository.getUserByLogin(userLogin)
            .subscribeOn(Schedulers.io())
            .doOnSubscribe {
                viewState.setProgressBarVisibility(true)
            }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                viewState.setProgressBarVisibility(false)
                viewState.showError(false)
                viewState.showName(it.login!!)
                viewState.showPhoto(it.avatarUrl!!)
            },{
                viewState.setProgressBarVisibility(false)
                viewState.showError(false)
            })

    }

    fun loadPhoto(url: String, imageView: ImageView){
        glideWrapper.loadImage(url, imageView)
    }
}