def call(body)
{
sh '''
 curl --request POST \
--url 'https://ramyabhat97.atlassian.net/rest/api/2/project' \
--user 'bhatramya974@gmail.com:jSDddzt0Fk5NqqzOvmhS647F' \
--header 'Accept: application/json' \
--header 'Content-Type: application/json' \
--data '{"projectTemplateKey":"com.atlassian.jira-core-project-templates:jira-core-simplified-project-management","notificationScheme":10000,"name":"Test Create Project REST","permissionScheme":0,"assigneeType":"UNASSIGNED","projectTypeKey":"business","key":"TCPR","leadAccountId":"5e292a946a53170ca0c07d6a"}'
'''  
}
