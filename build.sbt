name := "AkkaHttpServiceBusProducer"

fork := true
javaOptions in test ++= Seq(
  "-Xms512M", "-Xmx2048M",
  "-XX:MaxPermSize=2048M",
  "-XX:+CMSClassUnloadingEnabled"
)

parallelExecution in test := false

version := "1.0"

scalaVersion := "2.12.3"
val akkaVersion = "2.5.4"
val akkaHttpVersion = "10.0.9"

libraryDependencies ++=
  Seq(
    "com.microsoft.azure" % "azure-servicebus" % "1.0.0",

    "ch.megard" %% "akka-http-cors" % "0.2.1",

    "com.typesafe.scala-logging" %% "scala-logging" % "3.7.2",
    "ch.qos.logback" % "logback-classic" % "1.1.7",

    "com.typesafe" % "config" % "1.2.1",

    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-stream" % akkaVersion,
    "com.typesafe.akka" %% "akka-cluster" % akkaVersion,
    "com.typesafe.akka" %% "akka-http" % akkaHttpVersion,
    "com.typesafe.akka" %% "akka-http-spray-json" % akkaHttpVersion,

    "org.json4s" %% "json4s-native" % "3.5.3"
    //"com.github.nscala-time" %% "nscala-time" % "2.16.0",

    //"org.scalatest" %% "scalatest" % "3.0.1" % "test"

  )

dependencyOverrides ++= Set(
  "com.typesafe.akka" %% "akka-actor"  % akkaVersion,
  "com.typesafe.akka" %% "akka-stream" % akkaVersion
)

mainClass in assembly := Some("onextent.http.servicebus.producer.Main")
assemblyJarName in assembly := "AkkaHttpServiceBusProducer.jar"

