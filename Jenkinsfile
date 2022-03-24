
pipeline {
    agent maître

    stages {
        stage('Build') {
            steps {
			    git clone https://github.com/m3jv/cdrw.git
			    sh 'docker build - < $WORKSPACE/cdrw/Dockerfile'
			    sh 'mvn package'
			    sh 'java -jar cdrw/src/main/java/cloud/s3.jar cdrw/src/main/java/cloud/iam.jar cdrw/src/main/java/cloud/kmsencrpt.jar'  
            }
        }
    }
}
