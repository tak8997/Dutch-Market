package com.mashup.dutchmarket

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v4.app.DialogFragment
import android.support.v7.app.AppCompatActivity
import com.mashup.dutchmarket.extension.showDialogFragment
import dagger.android.AndroidInjection
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject


internal abstract class BaseActivity<VM> : AppCompatActivity() where VM : BaseViewModel {

    companion object {
        private const val LOADING_DIALOG = "loading_dialog"
    }

    @Inject lateinit var viewModelFactory: ViewModelProvider.Factory

    protected lateinit var viewModel: VM

    private val compositeDisposable: CompositeDisposable by lazy {
        CompositeDisposable()
    }

    protected var loadingFragment: DialogFragment? = null

    @LayoutRes
    protected abstract fun getLayoutRes(): Int

    protected abstract fun getViewModel(): Class<VM>

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(getLayoutRes())

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(getViewModel())
        viewModel.intent(intent)
    }

    protected fun showLoadingDialog() {
        if(loadingFragment == null) {
            loadingFragment = LoadingDialogFragment()

            showDialogFragment(loadingFragment!!, LOADING_DIALOG)
        }
    }

    protected fun hideLoadingDialog() {
        loadingFragment?.let {
            it.dismissAllowingStateLoss()

            null
        }
    }

    protected fun addDisposables(vararg disposables: Disposable) {
        compositeDisposable.addAll(*disposables)
    }

    override fun onDestroy() {
        compositeDisposable.clear()

        super.onDestroy()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        viewModel.onActivityResult(requestCode, resultCode, data)
    }

}