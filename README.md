

# Throwable Utility

Throwable JSON Transformer Module



## Description

utility classes for :

1) json mapper of any class (JsonUtil.java / GenericJsonUtil.java)
->
convert Object to JsonString, or JsonString to Object

2) logging Exception in json format (ExceptionLogUtil.java)
->
this provides better readibilty in AWS Cloud Watch, and easy to search, by providing whole paragraph of Exception log in one single line, just search for "exceptionTraceHeirarchy" or "exceptionMeta"



## Build

```
mvn -Dmaven.artifact.threads=25 clean eclipse:eclipse -DdownloadSources=true dependency:go-offline dependency:resolve-plugins install -e
```


## Package

```
mvn -B package --file pom.xml
```


## Deploy Artifact

```
mvn deploy --settings /home/mafia/.m2/setting.xml --global-settings /space/tools/apache-maven-3.6.3/conf/settings.xml
```


