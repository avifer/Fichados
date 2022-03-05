package es.avifer.fichados.data.local.blockchain.model

import es.avifer.fichados.domain.entities.blockchain.CryptoBo

fun CryptoDbo.toBo() = CryptoBo(
    keyCrypto,
    0.0,
    lastPrice
)

fun CryptoBo.toDbo() = CryptoDbo(
    name,
    priceOnline ?: 0.0
)