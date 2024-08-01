package med.med1.repo

import org.springframework.data.jpa.repository.JpaRepository

interface RecommendationRepository : JpaRepository<Recommendation, Long> {
    fun findByRequestId(requestId: String): Recommendation?
}
