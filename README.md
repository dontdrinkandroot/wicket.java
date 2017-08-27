Wicket extensions and Twitter Bootstrap bindings
================================================

[![Build Status](https://travis-ci.org/dontdrinkandroot/wicket.java.svg?branch=master)](https://travis-ci.org/dontdrinkandroot/wicket.java)
[![Coverage Status](https://coveralls.io/repos/github/dontdrinkandroot/wicket.java/badge.svg?branch=master)](https://coveralls.io/github/dontdrinkandroot/wicket.java?branch=master)
[![Donate](https://img.shields.io/badge/Donate-PayPal-green.svg)](https://www.paypal.com/cgi-bin/webscr?cmd=_donations&business=W9NAXW8YAZ4D6&item_name=wicket.java%20Donation&currency_code=EUR) 

About
-----

Useful [Apache Wicket](https://wicket.apache.org/) core extensions and easy to
use [Twitter Bootstrap](https://getbootstrap.com) bindings.

* Wicket Version: 7.*
* Bootstrap Version: 3.3.*

Versioning
----------

This project uses semantic versioning. For more information, please visit
http://semver.org/.

Maven
-----

This project is not yet available via Maven Central. In the meantime you can
include the sonatype open source repository:

```xml
<repository>
    <id>oss-sonatype</id>
    <name>oss-sonatype</name>
    <url>https://oss.sonatype.org/content/repositories/snapshots/</url>
    <snapshots>
        <enabled>true</enabled>
    </snapshots>
    <releases>
        <enabled>false</enabled>
    </releases>
</repository>
```

Demo
----

You can find the demo [here](http://wicket.dontdrinkandroot.net).

To run the demo locally, do the following:


```
git clone https://github.com/dontdrinkandroot/wicket.java
cd wicket.java
mvn clean install
cd example
mvn spring-boot:run
```

Now you can point your browser to http://localhost:8080
 

Copyright and license
---------------------

Copyright (C) 2012-2016 [Philip Washington Sorst](https://sorst.net)
and individual contributors as indicated
by the @authors tag.
 
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
 
  http://www.apache.org/licenses/LICENSE-2.0
 
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
