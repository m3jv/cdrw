
pipeline {
    agent any
    environment {
        EMAIL_TO = 'info@fsys.biz'
    }
    stages {
        stage('SCM') {
            steps {
                sh 'git clone https://github.com/m3jv/cdrw.git'
            }
        }
        stage('BuildDocker') {
            steps {
                sh 'docker build - < $WORKSPACE/cdrw/Dockerfile'
            }
        }
        stage('StartdDocker') {
            steps {
                sh 'docker run -i alpine:3.14'
            }
        }
        stage('BuildArtefacts') {
            steps {
                sh 'cd cdrw/initial && mvn install'
            }
        }
        stage('BuildArtefactsCheck') {
            steps {
                sh 'java -jar target/client-0.1.0.jar'
            }
        }
        stage('MoveArtefact2Image') {
            steps {
                sh 'docker cp target/client-0.1.0.jar loving_galileo:/tmp'
            }
        }
        
    }
post {
        failure {
            emailext body: 'Check console output at $BUILD_URL to view the results. \n\n ${CHANGES} \n\n -------------------------------------------------- \n${BUILD_LOG, maxLines=100, escapeHtml=false}', 
                    to: "${EMAIL_TO}", 
                    subject: 'Build failed in Jenkins: $PROJECT_NAME - #$BUILD_NUMBER'
        }
        unstable {
            emailext body: 'Check console output at $BUILD_URL to view the results. \n\n ${CHANGES} \n\n -------------------------------------------------- \n${BUILD_LOG, maxLines=100, escapeHtml=false}', 
                    to: "${EMAIL_TO}", 
                    subject: 'Unstable build in Jenkins: $PROJECT_NAME - #$BUILD_NUMBER'
        }
        changed {
            emailext body: 'Check console output at $BUILD_URL to view the results.', 
                    to: "${EMAIL_TO}", 
                    subject: 'Jenkins build is back to normal: $PROJECT_NAME - #$BUILD_NUMBER'
        }
    }

}
