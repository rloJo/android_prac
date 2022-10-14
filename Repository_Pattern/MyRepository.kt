package com.example.repository_pattern

import android.content.Context
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MyRepository(context: Context) {
    private val baseURL = "https://api.github.com/"
    private val api = retrofitInit(baseURL)
    private val myDao = MyDatabase.getDatabase(context).myDao

    val repos = myDao.getAll() // LiveData<List<ReposD>>

    suspend fun refreshData(username : String ) {
        withContext(Dispatchers.IO) {
            val repos = api.listRepos(username)
            // convert Repo to RepoD
            val repoDs = repos.map {
                RepoD(it.name, it.owner.login)
            }
            myDao.insertAll(repoDs)
        }
    }
}
