def call(String msg = 'NEXUS') {
echo "${msg}"
       withCredentials([usernamePassword(credentialsId: 'nexus_credentials', passwordVariable: 'password', usernameVariable:'username')]) {
              sh 'curl -u ${username}:${password} --upload-file target/springboot-0.0.1-SNAPSHOT.war http://ec2-18-224-155-110.us-east-2.compute.amazonaws.com:8081/nexus/content/repositories/devopstraining/hexagon6/springboot-0.0.1-SNAPSHOT-$BUILD_NUMBER.war'
         }
}
