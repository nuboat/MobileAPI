THJUG Training.
===================
Mobile Backend API with JavaEE

Requirement
-----
 1. Java 8 (http://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html)
 -  Netbeans 8 (Free, 210 MB) (https://netbeans.org/downloads/)
 -  Github App (https://help.github.com/articles/set-up-git)
 -  Glassfish 4.0

Setup
-----
$ cd /Library/Java/JavaVirtualMachines/jdk1.8.0.jdk/Contents/Home/jre/lib/security
$ sudo vi java.policy

grant {
    permission java.net.SocketPermission "localhost:1527", "listen";

	.
	.
	.
};