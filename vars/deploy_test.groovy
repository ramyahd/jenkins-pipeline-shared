def call(String msg = 'deploy_test') {
echo "${msg}"
               withCredentials([string(credentialsId: 'tomcat_dev', variable: 'password')]){
    sh 'sshpass -p ${password} ssh -o StrictHostKeyChecking=no ansadmin@172.31.3.247 \"ansible-playbook opt/playbooks/test.yml\"'

}
}
