package med.med1.repo

import jakarta.persistence.Entity
import javax.persistence.*

@Entity
@Table(name = "recommendations")
data class Recommendation(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @Column(nullable = false)
    val requestId: String,

    @Lob
    val audio: ByteArray,

    val status: String,

    @Lob
    val recommendationText: String? = null
)