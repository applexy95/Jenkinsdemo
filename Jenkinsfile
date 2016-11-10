node {
    stage('SCM') {
        git 'https://github.com/jankjn/jenkinsdemo.git'
    }
    stage('QA') {
        sh 'sonar-scanner'
    }
    stage('build') {
        def mvnHome = tool 'M3'
        sh "${mvnHome}/bin/mvn -B clean package"
    }
    stage('deploy') {
        sh "docker stop demo || true"
        sh "docker rm demo || true"
        sh "docker run --name demo -p 8088:8080 -d tomcat:8.5"
        sh "docker cp target/jenkins-demo.war demo:/usr/local/tomcat/webapps"
    }
    stage('results') {
        archiveArtifacts artifacts: '**/target/*.war', fingerprint: true
    }
}
