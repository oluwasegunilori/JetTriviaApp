package com.shegz.jettriviaapp.repository

import com.shegz.jettriviaapp.data.DataOrException
import com.shegz.jettriviaapp.model.QuestionItem
import com.shegz.jettriviaapp.network.QuestionApi
import java.lang.Exception
import javax.inject.Inject

class QuestionRepository @Inject constructor(private val api: QuestionApi){

    private val dataOrException =
        DataOrException<ArrayList<
                QuestionItem>,
                Boolean,
                Exception>()

    suspend fun getAllQuestions(): DataOrException<ArrayList<QuestionItem>,Boolean, Exception> {
        try{
            dataOrException.loading = true
            dataOrException.data = api.getAllQuestions()
            if(dataOrException.data.toString().isNotEmpty())    dataOrException.loading = false
        }
        catch (e: Exception){
            dataOrException.e = e
        }
        return dataOrException
    }


}