
pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh '''
                    git clone https://github.com/m3jv/cdrw.git 
	            docker build - < $WORKSPACE/cdrw/Dockerfile
		    docker run -i alpine:3.14
                '''
            }
        }
    }
}
