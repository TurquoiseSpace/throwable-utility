

# Throwable Utility


Throwable JSON Transformer Module

[![Maven Central](https://img.shields.io/maven-central/v/com.github.TurquoiseSpace/throwable-utility.svg?label=Maven%20Central)](https://repo1.maven.org/maven2/com/github/TurquoiseSpace/throwable-utility/)

[![Java Doc](https://javadoc.io/badge2/com.github.TurquoiseSpace/throwable-utility/javadoc.svg)](https://javadoc.io/doc/com.github.TurquoiseSpace/throwable-utility)

[Sonatype](https://search.maven.org/artifact/com.github.TurquoiseSpace/throwable-utility)

[MVN Repository](https://mvnrepository.com/artifact/com.github.TurquoiseSpace/throwable-utility)

[Maven Central Search](https://search.maven.org/search?q=g:%22com.github.TurquoiseSpace%22%20AND%20a:%22throwable-utility%22)



## Description

utility classes for :

1) json mapper of any class (JsonUtil.java / GenericJsonUtil.java)
->
convert Object to JsonString, or JsonString to Object

2) logging Exception in json format (ExceptionLogUtil.java)
->
this provides better readibilty in AWS Cloud Watch, and easy to search, by providing whole paragraph of Exception log in one single line, just search for "exceptionTraceHeirarchy" or "exceptionMeta"



## GPG Keys

- Check existing GPG Keys

```
gpg --list-secret-keys --keyid-format LONG
```

- Generate GPG Key

```
gpg --gen-key
```

- Receive GPG Key from Servers

```
gpg --keyserver hkp://keyserver.ubuntu.com --recv-keys 876A6DD3FB3573F1
gpg --keyserver hkp://keys.openpgp.org --recv-keys 876A6DD3FB3573F1
gpg --keyserver hkp://pgp.mit.edu --recv-keys 876A6DD3FB3573F1
```

- Send GPG Key to Servers

```
gpg --keyserver hkp://keyserver.ubuntu.com --send-keys 876A6DD3FB3573F1
gpg --keyserver hkp://keys.openpgp.org --send-keys 876A6DD3FB3573F1
gpg --keyserver hkp://pgp.mit.edu --send-keys 876A6DD3FB3573F1
```


## Build

- Normal Sanity

```
mvn -Dmaven.artifact.threads=25 clean eclipse:eclipse -DdownloadSources=true dependency:go-offline dependency:resolve-plugins install -e
```

- With OSSRH Sonatype

```
mvn -Dmaven.artifact.threads=25 clean eclipse:eclipse -DdownloadSources=true dependency:go-offline install --settings /home/mafia/.m2/setting.xml --global-settings /space/tools/apache-maven-3.6.3/conf/settings.xml
```


## Deploy Artifact

```
mvn deploy --settings /home/mafia/.m2/setting.xml --global-settings /space/tools/apache-maven-3.6.3/conf/settings.xml
```


