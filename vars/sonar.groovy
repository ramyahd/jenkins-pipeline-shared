def call(String msg = 'SONAR'){
  echo "${msg}"
 
  environment{
    scannerHome=tool 'sonarScanner'  
  }
  withSonarQubeEnv('Sonarqube'){
                     sh 'mvn sonar:sonar'
                }
}
