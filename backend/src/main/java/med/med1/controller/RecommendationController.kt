// src/main/java/com/example/myapp/controller/RecommendationController.kt
package med.med1.controller

import med.med1.api.AudioUploadRequest
import med.med1.api.FetchRecommendationRequest
import med.med1.api.FetchRecommendationResponse
import med.med1.service.RecommendationService
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import kotlinx.coroutines.runBlocking

@RestController
@RequestMapping("/api")
class RecommendationController(
    private val recommendationService: RecommendationService
) {

    @PostMapping("/uploadAudio")
    fun uploadAudio(
        @RequestParam requestId: String,
        @RequestParam audio: MultipartFile
    ): String = runBlocking {
        recommendationService.uploadAudio(requestId, audio)
    }

    @PostMapping("/fetchRecommendation")
    fun fetchRecommendation(
        @RequestBody request: FetchRecommendationRequest
    ): FetchRecommendationResponse {
        val recommendationText = recommendationService.getRecommendation(request.referenceId)
        return if (recommendationText != null) {
            FetchRecommendationResponse(status = "COMPLETED", recommendationText = recommendationText)
        } else {
            FetchRecommendationResponse(status = "PENDING")
        }
    }
}