package com.accenture.concrete.data.datasource

interface TaskResponseMapper<Response, Model> {

    abstract fun mapFromResponse(response: Response) : Model
}