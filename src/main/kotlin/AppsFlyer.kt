class AppsFlyer {
    companion object {
        fun rollPushNotificationPayload(data: Map<String, Any>, key: String): Any? =
            data[key] ?: data.values
                .filter { it is Map<*, *> }
                .map {
                    @Suppress("UNCHECKED_CAST")
                    it as Map<String, Any>
                }
                .mapNotNull { rollPushNotificationPayload(it, key) }
                .first()
    }
}