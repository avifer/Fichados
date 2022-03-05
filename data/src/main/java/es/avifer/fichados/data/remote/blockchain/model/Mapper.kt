package es.avifer.fichados.data.remote.blockchain.model

import es.avifer.fichados.domain.entities.blockchain.CryptoBo

fun CryptoTickersDto.toBo() = CryptoBo(
    symbol ?: "NO_DATA",
    lastTradePrice ?: 0.0,
)