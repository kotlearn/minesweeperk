package com.kotlearn.minesweeperk.data.core.storage

import kotlinx.coroutines.flow.Flow

interface Storage {

    fun <T> getAsFlow(key: Key<T>): Flow<T?>

    suspend fun <T> get(key: Key<T>): T?

    suspend fun <T> writeValue(key: Key<T>, value: T?)

    suspend fun <T> clearValue(key: Key<T>) {
        writeValue(key, null)
    }

    sealed class Key<T>(
        val name: String,
        val defaultValue: T?,
    ) {

        open class StringKey(name: String, defaultValue: String?): Key<String>(name, defaultValue)
        open class IntKey(name: String, defaultValue: Int?): Key<Int>(name, defaultValue)
        open class LongKey(name: String, defaultValue: Long?): Key<Long>(name, defaultValue)
        open class FloatKey(name: String, defaultValue: Float?): Key<Float>(name, defaultValue)
        open class DoubleKey(name: String, defaultValue: Double?): Key<Double>(name, defaultValue)
        open class BooleanKey(name: String, defaultValue: Boolean?): Key<Boolean>(name, defaultValue)

    }

}