class AppsFlyer {
    companion object {
        fun rollPushNotificationPayload(data: Map<String, Any>, key: String): Any? =
            data[key] ?: data.values
                .filter { it is Map<*, *> }
                .mapNotNull {
                    @Suppress("UNCHECKED_CAST")
                    rollPushNotificationPayload(it as Map<String, Any>, key)
                }
                .first()
    }
}