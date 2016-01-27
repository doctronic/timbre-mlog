(defproject de.doctronic/timbre-mlog "1.0.0"
  :description "MLog implementation for redirecting c3p0 logging to timbre."
  :url "https://github.com/doctronic/timbre-mlog"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [com.taoensso/timbre "4.3.0-RC1"]
                 [com.mchange/mchange-commons-java "0.2.11"]]
  :java-source-paths ["src"]
  :javac-options ["-target" "1.7" "-source" "1.7" "-Xlint:-options"]
  :scm {:name "git"
        :url "https://github.com/doctronic/timbre-mlog"}
  :repositories [["clojars" {:url "https://clojars.org/repo"
                             :creds :gpg}]])
