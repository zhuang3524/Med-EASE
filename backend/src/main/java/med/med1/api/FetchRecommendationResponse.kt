// src/main/java/com/example/myapp/api/FetchRecommendationResponse.kt
package med.med1.api

data class FetchRecommendationResponse(
    val status: String,
    val recommendationText: String? = null
)
