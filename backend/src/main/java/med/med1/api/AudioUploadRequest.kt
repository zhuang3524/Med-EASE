// src/main/java/com/example/myapp/api/AudioUploadRequest.kt
package med.med1.api

data class AudioUploadRequest(
    val requestId: String,
    val audio: ByteArray
)
