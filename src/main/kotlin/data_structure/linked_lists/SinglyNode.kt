package com.samad_talukder.data_structure.linked_lists

/**
 * Represents a Singly node in a LinkedList
 * @param T
 * @property value which stored in the node
 * @property next reference the next node in the list
 * @constructor Create empty Singly node
 */
data class SinglyNode<T>(var value: T, var next: SinglyNode<T>? = null) {
    override fun toString(): String {
        return if (next != null) {
            "$value-> ${next.toString()}"
        } else {
            "$value"
        }
    }
}
