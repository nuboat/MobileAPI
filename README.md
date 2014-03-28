THJUG Training.
===================
Mobile Backend API with JavaEE

Requirement
-----
 1. Java 8
 -  Netbeans 8
 -  Glassfish 4.0
 -  Github App

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
