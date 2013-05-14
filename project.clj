(defproject gcm-clj "0.1.0-SNAPSHOT"
  :description "GCM Util"
  :url "http://github.com/seymores/gcm-clj"
  :repositories [["google" "https://github.com/slorber/gcm-server-repository/raw/master/releases"]]
  :dependencies [[org.clojure/clojure "1.5.1"]
                [com.google.android.gcm/gcm-server "1.0.2"]]
  :main gcm-clj.core)
