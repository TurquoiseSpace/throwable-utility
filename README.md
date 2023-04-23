

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



## GPG Keys

- Check existing GPG Keys

```
gpg --list-secret-keys --keyid-format LONG
```

- Generate GPG Key

```
gpg --gen-key
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


## Package

```
mvn -B package --file pom.xml
```


## Deploy Artifact

- Staging

```
mvn nexus-staging:release --settings /home/mafia/.m2/setting.xml --global-settings /space/tools/apache-maven-3.6.3/conf/settings.xml -DstagingRepositoryId=ossrh
```

- Prod

```
mvn deploy --settings /home/mafia/.m2/setting.xml --global-settings /space/tools/apache-maven-3.6.3/conf/settings.xml
```


