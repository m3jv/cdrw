
pipeline {
    agent linuxmvn

    stages {
        stage('Build') {
            steps {
			    git clone https://github.com/m3jv/cdrw.git
				sh 'mvn package'
				sh 'java -jar src/main/java/cloud/s3.jar src/main/java/cloud/iam.jar src/main/java/cloud/kmsencrpt.jar'  
            }
        }
    }
}
