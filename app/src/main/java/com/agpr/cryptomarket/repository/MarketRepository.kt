package com.agpr.cryptomarket.repository

import com.agpr.cryptomarket.network.MarketApi
import com.agpr.cryptomarket.network.model.ListCoinApiModel
import com.agpr.cryptomarket.network.model.ResponseApi
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.http.path

class MarketRepository(
    private val client: HttpClient
) : MarketApi {
    override suspend fun getListCoins(): ResponseApi<List<ListCoinApiModel>> {
        return client.get {
            url {
                path("assets")
            }
        }.body()
    }

}