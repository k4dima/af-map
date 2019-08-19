fun search(data: Map<String, Any>, key: String): Any? =
        data[key] ?: data.values
                .filterIsInstance<Map<String, Any>>()
                .mapNotNull { search(it, key) }
                .first()