========================
nf-registry-microservice
========================
.. image:: https://travis-ci.org/sven1103/nf-registry-microservice.svg?branch=master
  :target: https://travis-ci.org/sven1103/nf-registry-microservice

A microservice consuming JSON objects emitted by Nextflows weblog feature and puts it into a MongoDB.

**In development!**
This microservice is still experimental!

.. contents:: Table of Contents

Description
~~~~~~~~~~~
This microservice is implemented with micronaut_: *"A modern, JVM-based, full-stack framework for building modular, easily testable microservice applications."*.

The target database is expected to be MongoDB_, and we are using `MongoDB's reactive stream java driver`__ for asynchronous request handling.

.. _micronaut: http://micronaut.io/
.. _MongoDB: https://www.mongodb.com/
.. _reactive: http://mongodb.github.io/mongo-java-driver-reactivestreams/
__ reactive_

This microservice provides a RESTful API (*API desscription coming soon*) in order to consume trace objects emitted from Nexftlow_, using the `weblog`_ feature available since release 0.31.0. Moreover, workflow trace and status information can be requested via the API and therefore this microservice integrates as useful little addition in monitoring workflows submitted with Nextflow.

.. _Nexftlow: https://www.nextflow.io/
.. _weblog: https://www.nextflow.io/docs/latest/tracing.html?highlight=weblog#weblog-via-http

Test
~~~~~~~
To perform the tests, simply execute this from this repo's root directory:

.. code-block:: bash
  
  ./gradlew test


Configure 
~~~~~~~~~~~~

Run
~~~~~~

To run the microservices locally, just run:

.. code-block:: bash
  
  ./gradlew run


Deploy 
~~~~~~~

If you want to deploy the microservice as executable jar, just execute:


.. code-block:: bash
  
  ./gradlew assemble
  
This will create distributions of the microservice as **zip** and **tar** archives under `./build/distributions`.





