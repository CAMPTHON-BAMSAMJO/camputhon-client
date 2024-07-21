package com.dgu.camputhon.data.datasource

import androidx.datastore.core.Serializer
import com.dgu.camputhon.domain.entity.UserID
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json
import java.io.InputStream
import java.io.OutputStream
import javax.inject.Inject

class UserDataSource @Inject constructor() : Serializer<UserID> {

    override val defaultValue: UserID
        get() = UserID()


    override suspend fun readFrom(input: InputStream): UserID {
        return input.reader().use {
            try {
                Json.decodeFromString(UserID.serializer(), it.readText())
            } catch (e: SerializationException) {
                e.printStackTrace()
                defaultValue
            }
        }
    }

    override suspend fun writeTo(t: UserID, output: OutputStream) {
        output.writer().use { writer ->
            Json.encodeToString(UserID.serializer(), t).also { json ->
                writer.write(json)
            }
        }
    }
}