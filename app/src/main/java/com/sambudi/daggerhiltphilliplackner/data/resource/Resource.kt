package com.direku.cuanamansambilrebahan.data.source.responsestatus

class Resource<T>(val status: Status, val body: T? = null, val throwable: Throwable? = null) {
    companion object {
        fun <T> loading(): Resource<T> = Resource(Status.STATUS_API_LOADING)

        fun <T> success(body: T): Resource<T> = Resource(Status.STATUS_API_SUCCESS, body)

        fun <T> errorBody(body: T): Resource<T> = Resource(Status.STATUS_API_ERROR_BODY, body)

        fun <T> throwable(throwable: Throwable?): Resource<T> = Resource(status = Status.STATUS_API_FAILURE, throwable = throwable)

        fun <T> unknownError(body: T): Resource<T> = Resource(Status.STATUS_API_UNKNOWN_ERROR, body)
    }
}