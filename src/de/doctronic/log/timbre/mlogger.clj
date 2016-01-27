(ns de.doctronic.log.timbre.mlogger
  (:require [taoensso.timbre :as t])
  (:import [com.mchange.v2.log MLevel MLogger]))


(defn ml->tl
  [ml]
  (let [n (.intValue ml)]
    (get {(.intValue MLevel/TRACE)   :trace
          (.intValue MLevel/DEBUG)   :debug
          (.intValue MLevel/INFO)    :info
          (.intValue MLevel/WARNING) :warn
          (.intValue MLevel/SEVERE)  :error
          (.intValue MLevel/CONFIG)  :info }
         n
         :info)))

(defn timbre-mlogger
  [classname]
  (reify MLogger
    (getName [_]
      "de.doctronic.log.timbre.mlogger")

    (^void log [_ ^MLevel l ^String msg]
     (t/log! (ml->tl l) :p [msg] {:?ns-str classname}))
    (^void log [_ ^MLevel l ^String msg ^Object param]
     (t/log! (ml->tl l) :p [msg param] {:?ns-str classname}))
    (^void log [_ ^MLevel l ^String msg #^"[Ljava.lang.Object;" params]
     (t/log! (ml->tl l) :p (into [classname msg] params) {:?ns-str classname}))
    (^void log [_ ^MLevel l ^String msg ^Throwable throwable]
     (t/log! (ml->tl l) :p [msg throwable] {:?ns-str classname}))

    (^void logp [_ ^MLevel l ^String cn ^String mn ^String msg]
     (t/log! (ml->tl l) :p [msg] {:?ns-str (str cn "::" mn)}))
    (^void logp [_ ^MLevel l ^String cn ^String mn ^String msg ^Object param]
     (t/log! (ml->tl l) :p [msg param] {:?ns-str (str cn "::" mn)}))
    (^void logp [_ ^MLevel l ^String cn ^String mn ^String msg #^"[Ljava.lang.Object;" params]
     (t/log! (ml->tl l) :p (into [cn mn msg] params) {:?ns-str (str cn "::" mn)}))
    (^void logp [_ ^MLevel l ^String cn ^String mn ^String msg ^Throwable throwable]
     (t/log! (ml->tl l) :p [msg throwable] {:?ns-str (str cn "::" mn)}))

    (^void logrb [_ ^MLevel l ^String cn ^String mn ^String rb ^String msg]
     (t/log! (ml->tl l) :p [rb msg] {:?ns-str (str cn "::" mn)}))
    (^void logrb [_ ^MLevel l ^String cn ^String mn ^String rb ^String msg ^Object param]
     (t/log! (ml->tl l) :p [msg rb param] {:?ns-str (str cn "::" mn)}))
    (^void logrb [_ ^MLevel l ^String cn ^String mn ^String rb ^String msg #^"[Ljava.lang.Object;" params]
     (t/log! (ml->tl l):p (into [cn mn rb msg] params) {:?ns-str (str cn "::" mn)}))
    (^void logrb [_ ^MLevel l ^String cn ^String mn ^String rb ^String msg ^Throwable throwable]
     (t/log! (ml->tl l) :p [rb msg throwable] {:?ns-str (str cn "::" mn)}))

    (^void entering [_ ^String cn ^String mn]
     (t/log! :trace :p ["Enter"] {:?ns-str (str cn "::" mn)}))
    (^void entering [_ ^String cn ^String mn ^Object param]
     (t/log! :trace :p ["Enter with param" param] {:?ns-str (str cn "::" mn)}))
    (^void entering [_ ^String cn ^String mn #^"[Ljava.lang.Object;" params]
     (t/log! :trace :p (into ["Enter with params"] params) {:?ns-str (str cn "::" mn)}))

    (^void exiting [_ ^String cn ^String mn]
     (t/log! :trace :p ["Exit"] {:?ns-str (str cn "::" mn)}))
    (^void exiting [_ ^String cn ^String mn ^Object result]
     (t/log! :trace :p ["Exit with result" result] {:?ns-str (str cn "::" mn)}))

    (^void throwing [_ ^String cn ^String mn ^Throwable throwable]
     (t/log! :trace :p ["Exception thrown" throwable] {:?ns-str (str cn "::" mn)}))

    (^void severe [_ ^String msg]
     (t/log! (ml->tl MLevel/SEVERE) :p [msg] {:?ns-str classname}))
    (^void warning [_ ^String msg]
     (t/log! (ml->tl MLevel/WARNING) :p [msg] {:?ns-str classname}))
    (^void info [_ ^String msg]
     (t/log! (ml->tl MLevel/INFO) :p [msg] {:?ns-str classname}))
    (^void config [_ ^String msg]
     (t/log! (ml->tl MLevel/CONFIG) :p [msg] {:?ns-str classname}))
    (^void fine [_ ^String msg]
     (t/log! (ml->tl MLevel/FINE) :p [msg] {:?ns-str classname}))
    (^void finer [_ ^String msg]
     (t/log! (ml->tl MLevel/FINER) :p [msg] {:?ns-str classname}))
    (^void finest [_ ^String msg]
     (t/log! (ml->tl MLevel/FINEST) :p [msg] {:?ns-str classname}))

    (^boolean isLoggable [_ ^MLevel l]
     (t/log? (ml->tl l)))))



(comment
  (do
    (def logger (.getMLogger (de.doctronic.log.timbre.TimbreMlog.) "foo.bar"))
    (.severe logger "Hum"))
  ,,,)
