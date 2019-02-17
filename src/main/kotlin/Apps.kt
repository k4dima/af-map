class Apps {
    companion object {
        fun search(data: Map<String, Any>, key: String): Any? =
            data[key] ?: data.values
                .filter { it is Map<*, *> }
                .map { @Suppress("UNCHECKED_CAST") (it as Map<String, Any>) }
                .mapNotNull { search(it, key) }
                .first()
    }
}