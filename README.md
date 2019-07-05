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

## Package - WikiServices

### Request  - [link](#)

##### Class name: 
`abstract class Request`

abstract class used to build HTTP classes  

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


### Response - [link](#)

##### Class name: 
`class Response`

package class used by the Request sub classes

##### Methods:
* Response(HttpURLConnection connection)
* getStatusCode()
* getBody()
* createReader()
* read()

````
Response()
  constructor takes a HTTP connection as param and reads the body from the response
  
getStatusCode() getBody()
  class getters
  return the status code as int and body as String

createReader()
  private method used to read HTTP input stream
  creates an java.io.InputStreamReader for the incomming data from the HTTP connection 
  
read()
  private method read() will read all the data from the HTTP connection response body
  
````
<br>


### Get - [link](#)

##### Class name: 
`class Get`

package sub class created from Request class 
implements a HTTP GET request to URI endpoint

##### Methods:
* Get(String uri)
* execute()

````
Get()
  constructor uses super class constructor to make new HTTP connection
  sets the Request method to get
  throws exception IOException and MalformedURLException
  
execute()
  makes a new Response object from the get request
  disconnects the HTTP connection
  returns response body in JSON String
  throws exception IOException
````
<br>

### WikiService - [link](#)

##### Class name: 
`public class WikiService`

public class used to provide access to MediaWiki REST API

##### Methods:
* getArticle()

````
getArticle()
  static method getAritcle()
  takes String as param to build uri search query
  uses Get(uri).execute() to make an HTTP get request to MediaWiki REST endpoint
  returns response body as JSON string
````
<br>

## Package - GoogleServices

### GoogleService - [link](#)
`class GoogleService`

<br>

### GoogleDocsService - [link](#)
`public class GoogleDocsService`

<br>

<hr>
