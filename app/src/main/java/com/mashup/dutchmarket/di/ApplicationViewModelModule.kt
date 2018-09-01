package com.mashup.dutchmarket.di

import android.arch.lifecycle.ViewModel
import com.mashup.dutchmarket.di.key.ViewModelKey
import com.mashup.dutchmarket.ui.signup.SignUpViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap


@Module
internal abstract class ApplicationViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(SignUpViewModel.ViewModel::class)
    abstract fun bindSignUpViewModel(signUpViewModel: SignUpViewModel.ViewModel) : ViewModel

}
