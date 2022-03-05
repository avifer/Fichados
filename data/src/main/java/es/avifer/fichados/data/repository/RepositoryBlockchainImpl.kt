package es.avifer.fichados.data.repository

import es.avifer.fichados.data.local.blockchain.datasource.BlockchainLocalDataSource
import es.avifer.fichados.data.remote.blockchain.datasource.BlockchainRemoteDataSource
import es.avifer.fichados.data.utils.BaseRepository
import es.avifer.fichados.domain.blockchain.repository.RepositoryBlockchain
import es.avifer.fichados.domain.entities.blockchain.CryptoBo
import es.avifer.fichados.domain.entities.response.Response


class RepositoryBlockchainImpl(
    private val blockchainRemoteDataSource: BlockchainRemoteDataSource,
    private val blockchainLocalDataSource: BlockchainLocalDataSource
) : RepositoryBlockchain, BaseRepository() {
    override suspend fun getDataOnlineOfCrypto(value: String): Response<CryptoBo?> {
        return blockchainRemoteDataSource.getDataOfCryptoOnline(value)
    }

    override suspend fun getDataOfflineOfCrypto(value: String): Response<CryptoBo?> {
        return blockchainLocalDataSource.getLastDataOfCrypto(value)
    }

    override suspend fun saveDataOfflineOfCrypto(value: CryptoBo): Response<List<Long>> {
        return blockchainLocalDataSource.saveLastDataOfCrypto(value)
    }

    override suspend fun updateDataOfflineOfCrypto(value: CryptoBo): Response<Int> {
        return blockchainLocalDataSource.updateLastDataOfCrypto(value)
    }
}