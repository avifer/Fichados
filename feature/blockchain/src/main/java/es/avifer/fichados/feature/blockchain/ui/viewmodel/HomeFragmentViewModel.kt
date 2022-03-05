package es.avifer.fichados.feature.blockchain.ui.viewmodel

import androidx.lifecycle.LiveData
import dagger.hilt.android.lifecycle.HiltViewModel
import es.avifer.fichados.common.viewmodel.BaseViewModel
import es.avifer.fichados.common.viewmodel.defaultResponse
import es.avifer.fichados.common.viewmodel.executeWithListeners
import es.avifer.fichados.domain.blockchain.usecases.GetAndSaveAllDataOfCrypto
import es.avifer.fichados.domain.entities.blockchain.CryptoBo
import es.avifer.fichados.domain.entities.response.ExceptionInfo
import javax.inject.Inject

@HiltViewModel
class HomeFragmentViewModel @Inject constructor(
    private val getAndSaveAllDataOfCrypto: GetAndSaveAllDataOfCrypto,
) : BaseViewModel() {

    fun getDataCrypto(cryptoPair: String): LiveData<CryptoBo?> {
        return defaultResponse { getAndSaveAllDataOfCrypto(cryptoPair) }
    }

    fun getDataCryptoListeners(
        cryptoPair: String,
        successful: suspend (successful: CryptoBo?) -> Unit,
        error: suspend (error: ExceptionInfo) -> Unit,
        loading: suspend (loading: Boolean) -> Unit
    ) {
        return executeWithListeners(successful, error, loading) {
            getAndSaveAllDataOfCrypto(cryptoPair)
        }
    }

}