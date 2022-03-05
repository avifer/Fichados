package es.avifer.fichados.data.local.blockchain.datasource

import es.avifer.fichados.domain.entities.blockchain.CryptoBo
import es.avifer.fichados.domain.entities.response.Response

interface BlockchainLocalDataSource {

    suspend fun getLastDataOfCrypto(value: String): Response<CryptoBo?>

    suspend fun saveLastDataOfCrypto(value: CryptoBo): Response<List<Long>>

    suspend fun updateLastDataOfCrypto(value: CryptoBo): Response<Int>

}