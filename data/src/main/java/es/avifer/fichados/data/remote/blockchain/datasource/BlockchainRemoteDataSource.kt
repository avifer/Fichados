package es.avifer.fichados.data.remote.blockchain.datasource

import es.avifer.fichados.domain.entities.blockchain.CryptoBo
import es.avifer.fichados.domain.entities.response.Response

interface BlockchainRemoteDataSource {

    suspend fun getDataOfCryptoOnline(value: String): Response<CryptoBo?>

}