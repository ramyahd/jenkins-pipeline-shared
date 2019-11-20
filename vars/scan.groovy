def call(String msg = 'SCAN') {
echo "${msg}"
appscan application: 'd11469cd-f2c6-4521-b809-41eb44012c0f', credentials: 'Security', failBuild: true, failureConditions: [failure_condition(failureType: 'high', threshold: 10000)], name: 'security', scanner: static_analyzer(hasOptions: false, target: '/var/lib/jenkins/workspace/'), type: 'Static Analyzer', wait: true
}
