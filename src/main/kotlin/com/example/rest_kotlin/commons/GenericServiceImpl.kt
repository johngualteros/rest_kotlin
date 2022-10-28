package com.example.rest_kotlin.commons

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Service
import java.io.Serializable
import java.util.Optional
import java.util.function.Consumer

@Service
abstract class GenericServiceImpl<T, ID : Serializable?> : GenericServiceAPI<T, ID> {
    override fun save(entity: T): T {
        return dao.save(entity)
    }

    override fun delete(id: ID) {
        dao.deleteById(id)
    }

    override fun get(id: ID): T? {
        val obj = dao.findById(id)
        return if (obj.isPresent) {
            obj.get()
        } else null
    }

    override val all: MutableList<T>
        get() {
            val returnList: MutableList<T> = ArrayList()
            dao.findAll().forEach(Consumer { obj: T -> returnList.add(obj) })
            return returnList
        }
    abstract val dao: CrudRepository<T, ID>
}