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
> run this command in the root folder
> Google Docs Requires gradle version 2.3 or greater

<hr>


### Program Implementation:

#### packages:
* GoogleServices
* WikiServices

## WikiServices

#### Request  [link](https://www.google.com)
##### Class name: `abstract class Request`

##### Methods:
* Request(String uri)
* execute()
* setRequiredHeaders()

````
Request(String uri)
  constructor will make the HTTP connection using java.net.HttpURLConnection
  the constructor will also set the HTTP headers
  
execute()
  abstract method overriden by Request child class , used to make the HTTP request
  
setRequiredHeaders() 
  called in constructor to set http request headers

````


<br>

##### Response [link](https://www.google.com)
`class Response`

<br>

##### Get [link](https://www.google.com)
`class Get`

<br>

##### WikiService [link](https://www.google.com)
`public class WikiService`

<br>


## GoogleServices

##### GoogleService [link](https://www.google.com)
`class GoogleService`

<br>

##### GoogleDocsService [link](https://www.google.com)
`public class GoogleDocsService`

<br>

<hr>
