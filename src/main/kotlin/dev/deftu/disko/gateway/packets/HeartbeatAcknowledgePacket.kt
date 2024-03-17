package dev.deftu.disko.gateway.packets

import com.google.gson.JsonElement
import dev.deftu.disko.gateway.DiskoGateway

public class HeartbeatAcknowledgePacket : BasePacket {
    override fun createSendJson(
        listener: DiskoGateway
    ): JsonElement? = null

    override fun handleDataReceived(
        listener: DiskoGateway,
        data: JsonElement?,
        seq: Int
    ) {
        listener.heart.beat()
    }
}
