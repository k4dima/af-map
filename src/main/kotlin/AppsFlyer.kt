class AppsFlyer {
    companion object {
        fun rollPushNotificationPayload(data: Map<String, Any>, searchKey: String): Any? =
            data[searchKey] ?: data.values
                .filter { it is Map<*, *> }
                .mapNotNull {
                    @Suppress("UNCHECKED_CAST")
                    rollPushNotificationPayload(it as Map<String, Any>, searchKey)
                }
                .first()
    }
}