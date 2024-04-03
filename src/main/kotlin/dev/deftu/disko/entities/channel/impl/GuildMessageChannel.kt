/*
 * Copyright (C) 2024 Deftu and the Disko contributors
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */

package dev.deftu.disko.entities.channel.impl

import dev.deftu.disko.Disko
import dev.deftu.disko.entities.channel.ChannelType
import dev.deftu.disko.entities.channel.GuildChannel
import dev.deftu.disko.entities.channel.MessageChannel
import dev.deftu.disko.entities.channel.PermissionOverwrite
import dev.deftu.disko.entities.guild.Guild
import dev.deftu.disko.entities.message.Message
import dev.deftu.disko.utils.Snowflake
import java.time.Instant

public open class GuildMessageChannel(
    override val disko: Disko,
    override val shardId: Int,
    override val id: Snowflake,
    override val type: ChannelType,
    override val guild: Guild,
    override val position: Int?,
    override val permissionOverwrites: List<PermissionOverwrite>,
    override val topic: String,
    override val nsfw: Boolean,
    override val rateLimitPerUser: Int,
    override val parent: GuildChannel?,
    override val name: String,
    override var lastMessageId: Snowflake?,
    override val lastPinTimestamp: Instant?
) : MessageChannel, GuildChannel {
    override fun getMessageById(id: Snowflake): Message? {
        TODO("Not yet implemented")
    }

    override fun getMessageHistory(limit: Int): List<Message> {
        TODO("Not yet implemented")
    }

    override fun getMessageHistoryBefore(message: Message, limit: Int): List<Message> {
        TODO("Not yet implemented")
    }

    override fun getMessageHistoryBefore(id: Snowflake, limit: Int): List<Message> {
        TODO("Not yet implemented")
    }

    override fun getMessageHistoryAfter(message: Message, limit: Int): List<Message> {
        TODO("Not yet implemented")
    }

    override fun getMessageHistoryAfter(id: Snowflake, limit: Int): List<Message> {
        TODO("Not yet implemented")
    }
}
