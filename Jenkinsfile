
pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh '''
                    git clone https://github.com/m3jv/cdrw.git 
	            docker build - < $WORKSPACE/cdrw/Dockerfile
	            mvn package
		    java -jar cdrw/src/main/java/cloud/s3.jar cdrw/src/main/java/cloud/iam.jar cdrw/src/main/java/cloud/kmsencrpt.jar
                '''
            }
        }
    }
}
