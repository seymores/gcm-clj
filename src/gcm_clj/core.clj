(ns gcm-clj.core
  (:import (com.google.android.gcm.server Sender Message Message$Builder MulticastResult))
  (:gen-class))

(def API_KEY "YOUR_KEY_HERE")
(def sender (Sender. API_KEY))

(defn buildMessage
    "Build message for notification"
    [k v]
    (-> (Message$Builder.) (.addData k v) .build))

(defn notify
    "Send notification with the given message to the specific device"
    [message deviceRegId retryCount]
    (.send sender message deviceRegId retryCount))

;;  Usage: 
;;  (def deviceId "APA91bG3VaT6IPhhVtDpoXDDOTTTD6-ssurIHjzjTft_TXSOHtieAnPO0hTQbI7iRasuUrRq1LZhdQgiFmSFVS5bSeR9-y8SLxuTrtHU6HxyMuLwSNmIZIvqC-u7JzQIUccSeQNQpLz1jGmalO_K9bPrprKlH4GTX9EtRDbCZDocdRR5qIB5kM8")
;;  (def m (-> (Message$Builder.) (.addData "key" "Updates") .build))
;;  (notify m deviceId 2)
;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(defn test-send [api-key device-id retry]
  (let [m (-> (Message$Builder.) (.addData "hello" "world") .build)
        sender (Sender. api-key)]
    (.send sender m device-id retry)))
