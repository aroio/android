package de.lennartegb.nsd.extensions

fun <T> List<T>.containsNot(element: T): Boolean = !this.contains(element)
