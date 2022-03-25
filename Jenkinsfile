
pipeline {
    agent any
   
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
                sh '''
                cd cdrw/initial
                mvn install
                '''
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
}
