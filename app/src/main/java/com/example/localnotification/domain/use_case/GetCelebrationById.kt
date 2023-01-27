package com.example.localnotification.domain.use_case

import com.example.localnotification.domain.model.Celebration
import com.example.localnotification.domain.repository.CelebrationRepository

class GetCelebrationById(
    private val repository: CelebrationRepository){
    suspend operator fun invoke(id:Int):Celebration?{
        return repository.getCelebrationById(id=id)

    }

}