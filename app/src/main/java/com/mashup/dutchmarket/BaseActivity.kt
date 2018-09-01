package com.mashup.dutchmarket

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject


internal abstract class BaseActivity<VM> : AppCompatActivity() where VM : BaseViewModel {



    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    protected lateinit var viewModel: VM

    private val compositeDisposable: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModel())
        viewModel.intent(intent)

        //TODO: Question?? let->inline?
//        viewModel.let {
//            if(it is BaseViewModel) {
//                it.onCreate(this, savedInstanceState)
//                it.intent(intent)
//            }
//        }
    }

    override fun onDestroy() {
        compositeDisposable.clear()

        super.onDestroy()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        viewModel.onActivityResult(requestCode, resultCode, data)
    }

    @LayoutRes
    protected abstract fun getLayoutRes(): Int

    protected abstract fun getViewModel(): Class<VM>

    fun addDisposables(vararg disposables: Disposable) {
        compositeDisposable.addAll(*disposables)
    }
}