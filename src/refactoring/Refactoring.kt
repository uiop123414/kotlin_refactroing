package refactoring

class PhotosInteractor(private val photosRepository: IPhotosRepository) {
    private val cachedPhotos: MutableList<PhotoItem> = mutableListOf()

    fun loadPhotosAndMakeFavourite(): List<PhotoItem> {
        val photos = photosRepository.loadPhotosAsync() ?: emptyList()
        println("Loading photos")
        val updatedPhotos = photos.map { it.copy(isFavourite = true) }.filterMediaType()
        cachedPhotos.addAll(updatedPhotos)
        return updatedPhotos
    }

    fun loadPhotosOnCall(): List<PhotoItem> {
        val photos = photosRepository.loadPhotosOnCall()
        return photos.filterMediaType()
    }

    fun getFavouritePhotos(): List<PhotoItem> {
        return photosRepository.getFavouritePhotosFromCache().map { it.copy(isFavourite = true) }
    }

    private fun List<PhotoItem>.filterMediaType(): List<PhotoItem> {
        return this.filter { it.mediaType == "image" }
    }
}

data class PhotoItem(
    var title: String?,
    var date: String? = null,
    var image: String? = null,
    var isFavourite: Boolean = false,
    var mediaType: String? = null
)

interface IPhotosRepository {
    fun loadPhotosAsync(): List<PhotoItem>?
    fun loadPhotosOnCall(): List<PhotoItem>
    fun getFavouritePhotosFromCache(): List<PhotoItem>
}
