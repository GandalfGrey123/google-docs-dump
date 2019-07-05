# Google Docs Dump

#### Technology Stack

* Google Docs / Drive API 
* MediaWiki REST API
* Java JDK 12
* Gradle 5.5

<hr>

### Program Summary:

This program will get wiki article data from the MediaWiki Rest Endpoint, 

create a new Google Document and store it in a Google Drive


<hr>

### How to Run Program:

run: `gradle run` 
> Google Docs Requires gradle version 2.3 or greater

<hr>


### Program Implementation:

#### packages:
* GoogleServices
* WikiServices

## WikiServices

##### Request 
`abstract class Request`

<br>

##### Response
`class Response`

<br>

##### Get
`class Get`

<br>

##### WikiService
`public class WikiService`

<br>


## GoogleServices

##### GoogleService
`class GoogleService`

<br>

##### GoogleDocsService
`public class GoogleDocsService`

<br>

<hr>
