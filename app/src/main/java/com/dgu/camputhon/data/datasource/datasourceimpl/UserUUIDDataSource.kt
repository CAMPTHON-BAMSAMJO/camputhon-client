package com.dgu.camputhon.data.datasource.datasourceimpl

import androidx.datastore.core.Serializer
import com.dgu.camputhon.domain.entity.UserUUID
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream
import javax.inject.Inject

class UserUUIDDataSource @Inject constructor() : Serializer<UserUUID> {

    override val defaultValue: UserUUID
        get() = UserUUID()

    override suspend fun readFrom(input: InputStream): UserUUID {
        return input.reader().use {
            try {
                Json.decodeFromString(UserUUID.serializer(), it.readText())
            } catch (e: SerializationException) {
                e.printStackTrace()
                defaultValue
            }
        }
    }

    override suspend fun writeTo(t: UserUUID, output: OutputStream) {
        output.writer().use { writer ->
            Json.encodeToString(UserUUID.serializer(), t).also { json ->
                writer.write(json)
            }
        }
    }
}