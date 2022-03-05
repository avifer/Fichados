package es.avifer.fichados.data.remote.blockchain.api

import es.avifer.fichados.data.remote.blockchain.model.CryptoTickersDto
import retrofit2.http.GET
import retrofit2.http.Path


interface ExchangeApi {
    @GET("tickers/{value_crypto}")
    suspend fun getData(@Path("value_crypto") value_crypto: String): CryptoTickersDto
}