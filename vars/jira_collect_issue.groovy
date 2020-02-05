import groovy.json.JsonSlurper 

@NonCPS
collectissues(String data){
def jsonSlurper = new JsonSlurper() 
def resultJson = jsonSlurper.parseText(data)
def projectName = resultJson.key
echo "$projectName"
 httpRequest authentication: 'jira_password',
  customHeaders: [[maskValue: false, name: 'Accept', value: 'application/json']], 
     httpMode: 'GET', url:"http://ec2-18-191-16-16.us-east-2.compute.amazonaws.com:8080/rest/api/2/search?jql=project%3D${projectName}&fields=key%2Csummary%2Cdescription&maxResults=1000&startAt=0"
     def connection = url.toURL().openConnection()
 echo "sh '''
 curl -X GET \
  'http://ec2-18-191-16-16.us-east-2.compute.amazonaws.com:8080/rest/api/2/search?jql=project%3DAVR&fields=key%2Csummary%2Cdescription&maxResults=1000&startAt=0' \
  -H 'accept: application/json' \
  -H 'authorization: Basic cmlnOmRpZ2l0YWxyaWdAMTIz' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: c1a72319-7788-9398-41a5-6901d8ea91fd'
 '''"
 }
 try {
      connection.connect()
     def line = new BufferedReader(new InputStreamReader(connection.getInputStream())).readLine()
     return jsonSlurper.parseText(line)
  } finally {
        connection.disconnect();
    } 
}
def call(){
 def request = libraryResource 'jira.json'
 collectissues(request)
}
