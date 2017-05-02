# IPFS Gateway for Maven

A web gateway to a decentralised Maven repository. Let us break it down for you.

[IPFS](ipfs.io) is a distributed, content-addressed file system. 
[Maven](maven.apache.org) is a package manager and build tool for JVM languages. Maven
also defines a repository format, so that anyone can implement a private repository.

We provide a gateway, so that your jar files can be hosted on IPFS.

## Why would you want to use it?

Because a private (or even public) repository is a single point of failure in your
 build chain. By hosting your repository on IPFS, you decentralise storage of artifacts,
 thus removing single points of failure. 
 
As long as one developer's PC is still running, your artifacts will be available to
download, so that developers can keep developing and build servers can keep building.
This is unlike the common situation, where a centralised repository server going down
prevents builds from running.

## Usage

It's your standard maven project. Create an executable jar with

    mvn package

and run it with

    java -jar target/ipfs-gateway-*.jar

The gateway listens on port 5002 by default. 

(Also, don't forget to run the `ipfs daemon`).

## Publishing

At the moment this is a manual process (but it could be scripted).

