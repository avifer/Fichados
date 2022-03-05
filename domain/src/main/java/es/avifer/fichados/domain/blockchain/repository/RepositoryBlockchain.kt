package es.avifer.fichados.domain.blockchain.repository

import es.avifer.fichados.domain.entities.blockchain.CryptoBo
import es.avifer.fichados.domain.entities.response.Response

interface RepositoryBlockchain {

    suspend fun getDataOfflineOfCrypto(value: String): Response<CryptoBo?>

    suspend fun saveDataOfflineOfCrypto(value: CryptoBo): Response<List<Long>>

    suspend fun updateDataOfflineOfCrypto(value: CryptoBo): Response<Int>

}