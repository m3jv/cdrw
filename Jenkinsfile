
pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                sh '''
                    git clone https://github.com/m3jv/cdrw.git 
	            docker build - < $WORKSPACE/cdrw/Dockerfile
		    docker run -i alpine:3.14
		    cd cdrw/initial
		    mvn install 
		    java -jar target/client-0.1.0.jar
		    docker cp target/gs-maven-0.1.0.jar tender_wescoff:/tmp
                '''
            }
        }
    }
}
