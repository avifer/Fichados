package es.avifer.fichados.feature.home.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.StringRes
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import es.avifer.fichados.common.extensions.toFormatTwoDecimal
import es.avifer.fichados.common.view.BaseFragment
import es.avifer.fichados.common.view.toast
import es.avifer.fichados.domain.entities.blockchain.CryptoBo
import es.avifer.fichados.domain.entities.response.getStringError
import es.avifer.fichados.feature.home.ui.viewmodel.HomeFragmentViewModel
import es.avifer.fichados.feature.home.R
import es.avifer.fichados.feature.home.databinding.FragmentHomeBinding

@AndroidEntryPoint
class HomeFragment : BaseFragment() {

    companion object {
        private const val BTC_USD = "BTC-USD"
    }

    override val viewModel by viewModels<HomeFragmentViewModel>()

    override fun getBindingCast() = binding as? FragmentHomeBinding

    override fun getInflateBinding(inflater: LayoutInflater, container: ViewGroup?) =
        FragmentHomeBinding.inflate(inflater, container, false)

    override fun onViewReady(savedInstanceState: Bundle?) {
        getPriceBtc()
        configureSwipeRefresh()
    }

    private fun configureSwipeRefresh() {
        getBindingCast()?.fragmentHomeSwipeRefresh?.setOnRefreshListener {
            viewModel.getDataCryptoListeners(
                cryptoPair = BTC_USD,
                successful = { it?.let { crypto -> getBindingCast()?.setDataCrypto(crypto) } },
                error = { toast(it.getStringError()) },
                loading = { getBindingCast()?.fragmentHomeSwipeRefresh?.isRefreshing = it }
            )
        }
    }

    private fun getPriceBtc() {
        viewModel.getDataCrypto(BTC_USD).observe(viewLifecycleOwner) { result ->
            result?.let { crypto ->
                getBindingCast()?.setDataCrypto(crypto)
            }
        }
    }

    private fun FragmentHomeBinding.setDataCrypto(cryptoBo: CryptoBo) {
        setNameCrypto(cryptoBo.name)
        setRemotePrice(cryptoBo.priceOnline, R.string.icon_dolar)
        setLocalPrice(cryptoBo.priceOffline, R.string.icon_dolar)
    }

    private fun FragmentHomeBinding.setLocalPrice(price: Double?, @StringRes idIconMoney: Int) {
        fragmentHomeLabelLocalPriceEdit.text =
            getString(idIconMoney, price?.toFormatTwoDecimal())
    }

    private fun FragmentHomeBinding.setRemotePrice(price: Double?, @StringRes idIconMoney: Int) {
        fragmentHomeLabelOnlinePriceEdit.text =
            getString(idIconMoney, price?.toFormatTwoDecimal())
    }

    private fun FragmentHomeBinding.setNameCrypto(name: String) {
        fragmentHomeLabelNameCrypto.text = name
    }

}