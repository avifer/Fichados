package es.avifer.fichados.feature.splash.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import es.avifer.fichados.common.view.BaseFragment
import es.avifer.fichados.common.view.getVersionName
import es.avifer.fichados.common.view.openAppInGooglePlay
import es.avifer.fichados.feature.splash.databinding.FragmentSplashBinding
import es.avifer.fichados.feature.splash.ui.viewmodel.SplashFragmentViewModel

class SplashFragment : BaseFragment() {

    override val viewModel by viewModels<SplashFragmentViewModel>()

    override fun getBindingCast() = binding as? FragmentSplashBinding

    override fun getInflateBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentSplashBinding.inflate(inflater, container, false)

    override fun onViewReady(savedInstanceState: Bundle?) {
        viewModel.goToBlockchain(getVersionName()) { openAppInGooglePlay() }
    }

}