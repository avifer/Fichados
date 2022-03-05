package es.avifer.fichados.domain.entities.blockchain

data class CryptoBo(
    val name: String,
    val priceOnline: Double? = null,
    val priceOffline: Double? = null,
)