package com.kotlearn.minesweeperk.data.core.storage

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.doublePreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map

class DataStoreStorage(
    private val dataStore: DataStore<Preferences>,
) : Storage {

    override fun <T> getAsFlow(key: Storage.Key<T>): Flow<T?> = dataStore.data
        .map { preferences ->
            preferences[getDataStoreKey(key)] ?: key.defaultValue
        }

    override suspend fun <T> get(key: Storage.Key<T>): T? =
        getAsFlow(key).firstOrNull() ?: key.defaultValue

    override suspend fun <T> writeValue(key: Storage.Key<T>, value: T?) {
        dataStore.edit { preferences ->
            val dataStoreKey = getDataStoreKey(key)
            if (value == null) {
                preferences.remove(dataStoreKey)
            } else {
                preferences[dataStoreKey] = value
            }
        }
    }

    @Suppress("UNCHECKED_CAST")
    private fun <T> getDataStoreKey(key: Storage.Key<T>): Preferences.Key<T> = when (key) {
        is Storage.Key.BooleanKey -> booleanPreferencesKey(key.name)
        is Storage.Key.DoubleKey -> doublePreferencesKey(key.name)
        is Storage.Key.FloatKey -> floatPreferencesKey(key.name)
        is Storage.Key.IntKey -> intPreferencesKey(key.name)
        is Storage.Key.LongKey -> longPreferencesKey(key.name)
        is Storage.Key.StringKey -> stringPreferencesKey(key.name)
    } as Preferences.Key<T>

}