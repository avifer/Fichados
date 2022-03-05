package es.avifer.fichados.data.remote.blockchain.datasource

import es.avifer.fichados.data.remote.blockchain.api.ExchangeApi
import es.avifer.fichados.data.remote.blockchain.model.toBo
import es.avifer.fichados.data.utils.BaseRepository
import es.avifer.fichados.data.utils.safeRemoteCall
import es.avifer.fichados.domain.entities.blockchain.CryptoBo
import es.avifer.fichados.domain.entities.response.Response

class BlockchainRemoteDataSourceImpl(private val exchangeApi: ExchangeApi) :
    BlockchainRemoteDataSource, BaseRepository() {

    override suspend fun getDataOfCryptoOnline(value: String): Response<CryptoBo?> {
        return safeRemoteCall { exchangeApi.getData(value).toBo() }
    }

}