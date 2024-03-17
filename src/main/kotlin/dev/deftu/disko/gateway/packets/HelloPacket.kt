package dev.deftu.disko.gateway.packets

import com.google.gson.JsonElement
import dev.deftu.disko.gateway.DiskoGateway

public class HelloPacket : BasePacket {
    override fun createSendJson(
        listener: DiskoGateway
    ): JsonElement? = null

    override fun handleDataReceived(
        listener: DiskoGateway,
        data: JsonElement?,
        seq: Int
    ) {
        if (data == null || !data.isJsonObject) return
        listener.heart.hello(data.asJsonObject)
    }
}
