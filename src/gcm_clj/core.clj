(ns gcm-clj.core
  (:import (com.google.android.gcm.server Sender Message Message$Builder MulticastResult))
  (:gen-class))

(def API_KEY "AIzaSyBzuaY-jffGkvzUcOIrBwv5QEtZuMeLF58")
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

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  ;; work around dangerous default behaviour in Clojure
  (alter-var-root #'*read-eval* (constantly false))
  (println "Hello, World!"))
