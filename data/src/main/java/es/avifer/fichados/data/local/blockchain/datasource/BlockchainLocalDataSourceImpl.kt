package es.avifer.fichados.data.local.blockchain.datasource

import es.avifer.fichados.data.local.blockchain.dao.BlockchainDao
import es.avifer.fichados.data.local.blockchain.model.toBo
import es.avifer.fichados.data.local.blockchain.model.toDbo
import es.avifer.fichados.data.utils.BaseRepository
import es.avifer.fichados.data.utils.safeLocalCall
import es.avifer.fichados.domain.entities.blockchain.CryptoBo
import es.avifer.fichados.domain.entities.response.Response

class BlockchainLocalDataSourceImpl(private val blockchainDao: BlockchainDao) :
    BlockchainLocalDataSource, BaseRepository() {
    override suspend fun getLastDataOfCrypto(value: String): Response<CryptoBo?> {
        return safeLocalCall { blockchainDao.getCrypto(value)?.toBo() }
    }

    override suspend fun saveLastDataOfCrypto(value: CryptoBo): Response<List<Long>> {
        return safeLocalCall { blockchainDao.insert(value.toDbo()) }
    }

    override suspend fun updateLastDataOfCrypto(value: CryptoBo): Response<Int> {
        return safeLocalCall { blockchainDao.update(value.toDbo()) }
    }
}