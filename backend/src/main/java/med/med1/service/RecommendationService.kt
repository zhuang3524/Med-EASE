// src/main/java/com/example/myapp/service/RecommendationService.kt
package med.med1.service

import com.example.myapp.repo.Recommendation
import com.example.myapp.repo.RecommendationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile

@Service
class RecommendationService(
    private val recommendationRepository: RecommendationRepository
) {

    suspend fun uploadAudio(requestId: String, audio: MultipartFile): String {
        val recommendation = Recommendation(
            requestId = requestId,
            audio = audio.bytes,
            status = "PENDING"
        )
        recommendationRepository.save(recommendation)

        // 模拟调用 OpenAI API 和处理音频
        withContext(Dispatchers.IO) {
            // 调用 OpenAI Whisper API 和 ChatGPT API 的逻辑
            // 省略具体实现，假设获取了推荐文本 recommendationText
            val recommendationText = "Generated recommendation text"

            recommendationRepository.save(
                recommendation.copy(
                    status = "COMPLETED",
                    recommendationText = recommendationText
                )
            )
        }

        return recommendation.requestId
    }

    fun getRecommendation(referenceId: String): String? {
        val recommendation = recommendationRepository.findByRequestId(referenceId)
        return recommendation?.recommendationText
    }
}