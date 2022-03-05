package es.avifer.fichados.data.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import es.avifer.fichados.data.local.blockchain.dao.BlockchainDao
import es.avifer.fichados.data.local.blockchain.datasource.BlockchainLocalDataSource
import es.avifer.fichados.data.local.blockchain.datasource.BlockchainLocalDataSourceImpl
import es.avifer.fichados.data.repository.RepositoryBlockchainImpl
import es.avifer.fichados.domain.blockchain.repository.RepositoryBlockchain
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class RepositoryModule {

    @Provides
    fun getBlockchainLocalDataSource(blockchainDao: BlockchainDao): BlockchainLocalDataSource {
        return BlockchainLocalDataSourceImpl(blockchainDao)
    }

    @Singleton
    @Provides
    fun getRepositoryBlockchainImpl(
        blockchainLocalDataSource: BlockchainLocalDataSource
    ): RepositoryBlockchain {
        return RepositoryBlockchainImpl(blockchainLocalDataSource)
    }

}