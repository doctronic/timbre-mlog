package de.doctronic.log.timbre;

import com.mchange.v2.log.MLog;
import com.mchange.v2.log.MLogger;

import clojure.java.api.Clojure;
import clojure.lang.IFn;

public class TimbreMlog extends MLog {
    protected final static String ns = "de.doctronic.log.timbre.mlogger";
    protected final static IFn require = Clojure.var("clojure.core", "require");
    protected final static IFn mlogger = Clojure.var(ns, "timbre-mlogger");

    public TimbreMlog() {
        require.invoke(Clojure.read(ns));
    }

    @Override
    public MLogger getMLogger() {
        return (MLogger) mlogger.invoke("");
    }

    @Override
    public MLogger getMLogger(String classname) {
        return (MLogger) mlogger.invoke(classname);
    }

    @SuppressWarnings("rawtypes")
    public MLogger getMLogger(Class clazz) {
        return (MLogger) mlogger.invoke(clazz.getName());
    }

}
