# timbre-mlog

Route [c3p0](https://github.com/swaldman/c3p0) connection pool logging 
through [timbre](https://github.com/ptaoussanis/timbre) logger.


## Usage

Depends on `[com.taoensso/timbre "4.3.0-RC1"]` or higher.

Include the following dependency in your project dependencies:

```clojure
[de.doctronic/timbre-mlog "1.0.0"]
```


Add or edit a file `resources/c3p0.properties` file to contain

```
com.mchange.v2.log.MLog=de.doctronic.log.timbre.TimbreMlog
```

Enjoy.